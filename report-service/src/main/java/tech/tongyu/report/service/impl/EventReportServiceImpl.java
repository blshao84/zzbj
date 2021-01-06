package tech.tongyu.report.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tech.tongyu.core.dto.common.ResponseBodyCommon;
import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.dto.common.ResponseData;
import tech.tongyu.core.dto.common.ResponseDetail;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.service.config.AttachmentConfigService;
import tech.tongyu.core.utils.FileUtils;
import tech.tongyu.core.utils.StringForReportUtils;
import tech.tongyu.core.utils.ZipUtil;
import tech.tongyu.core.utils.common.JsonUtils;
import tech.tongyu.external.generate.Dom4jXmlManager;
import tech.tongyu.model.dao.BaseElementRepo;
import tech.tongyu.model.dao.ReportBaseConfigRepo;
import tech.tongyu.model.dao.SendHistoryRepo;
import tech.tongyu.model.dao.config.BaseElementDbo;
import tech.tongyu.core.dto.event.EventReportDTO;
import tech.tongyu.model.dao.config.ReportBaseConfigDbo;
import tech.tongyu.model.dao.history.SendHistoryDbo;
import tech.tongyu.transform.dao.history.EventReportHistoryDbo;
import tech.tongyu.transform.dao.repo.history.EventReportHistoryRepo;
import tech.tongyu.transform.dao.repo.source.EventReportRepo;
import tech.tongyu.transform.dao.source.EventReportDbo;
import tech.tongyu.core.service.base.EventReportService;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 重大事件报告
 **/
@Service
public class EventReportServiceImpl implements EventReportService {

    @Value("${spring.upload.location}")
    private String filePath;

    private final BaseElementRepo baseElementRepo;
    private final EventReportRepo eventReportRepo;
    private final CheckAndSupplementService checkAndSupplementService;
    private final ReportBaseConfigRepo reportBaseConfigRepo;
    private final SendHistoryRepo sendHistoryRepo;
    private final EventReportHistoryRepo eventReportHistoryRepo;
    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public EventReportServiceImpl(BaseElementRepo baseElementRepo,
                                  EventReportRepo eventReportRepo,
                                  CheckAndSupplementService checkAndSupplementService,
                                  ReportBaseConfigRepo reportBaseConfigRepo,
                                  SendHistoryRepo sendHistoryRepo,
                                  EventReportHistoryRepo eventReportHistoryRepo,
                                  AttachmentConfigService attachmentConfigService) {
        this.baseElementRepo = baseElementRepo;
        this.eventReportRepo = eventReportRepo;
        this.checkAndSupplementService = checkAndSupplementService;
        this.reportBaseConfigRepo = reportBaseConfigRepo;
        this.sendHistoryRepo = sendHistoryRepo;
        this.eventReportHistoryRepo = eventReportHistoryRepo;
        this.attachmentConfigService = attachmentConfigService;
    }

    @Override
    public List<EventReportDTO> listEventReport() {
        List<EventReportDbo> events = eventReportRepo.getEventReport();
        return events.stream()
                .map(event -> EventReportDTO.fromJson(event.getEvent()))
                .collect(Collectors.toList());
    }

    @Override
    public String getServiceType() {
        return InterfaceInfoEnum.MAJOR_EVENT_REPORT.code();
    }

    @Override
    public Boolean executeTransTask() {
        List<BaseElementDbo> elements = baseElementRepo.findAllByCode(InterfaceInfoEnum.MAJOR_EVENT_REPORT.code());
        List<EventReportDbo> events = eventReportRepo.getEventReport();
        List<Map<String, Object>> collect = events.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getEvent(), Map.class))
                .collect(Collectors.toList());
        List<Map<String, Object>> standardValues = checkAndSupplementService.getStandardValue(collect, elements);
        for (int i = 0; i < events.size(); i++) {
            EventReportDbo eventReportDbo = events.get(i);
            Map<String, Object> map = standardValues.get(i);
            eventReportDbo.setEvent(JsonUtils.mapper.valueToTree(map));
        }
        eventReportRepo.saveAll(events);
        return true;
    }

    @Override
    @Transactional(rollbackFor = CustomException.class)
    public String executeGenerateTask(OperationEnum operation) {
        LocalDate now = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        ReportBaseConfigDbo config = reportBaseConfigRepo.findAll().get(0);
        List<SendHistoryDbo> send = sendHistoryRepo.findAllByOperationDate(now);
        Integer version;
        if (CollectionUtils.isEmpty(send)) {
            version = 1;
        } else {
            Long count = send.stream()
                    .filter(SendHistoryDbo::getResult)
                    .count();
            version = count.intValue() + 1;
        }
        LinkedHashMap<String, String> requestHeader = StringForReportUtils.buildRequestHeader(config.getSenderCode()
                , config.getReceiverCode()
                , now
                , version
                , InterfaceInfoEnum.MAJOR_EVENT_REPORT.code()
                , operation);
        List<EventReportDbo> reports = eventReportRepo.getEventReport();
        if (CollectionUtils.isEmpty(reports)) {
            throw new CustomException("此次报送中内容无数据,请重新确认报送信息");
        }
        //填充数据结构
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < reports.size(); i++) {
            EventReportDbo report = reports.get(i);
            EventReportDTO reportData = EventReportDTO.fromJson(report.getEvent(), Optional.of(operation));
            String execId = StringForReportUtils.buildExecID(config.getSenderCode(), config.getReceiverCode(), now, version, i);
            reportData.setExecID(execId);
            //dto -> linkedHashMap
            LinkedHashMap<String, Object> reportMap = checkAndSupplementService.validData(reportData.toLinkedHashMap(), operation);
            data.add(reportMap);
            //更新ExecId
            report.setExecId(execId);
        }
        //生成xml
        String xmlName = StringForReportUtils.generateXmlName(config.getSenderCode(), config.getReceiverCode(), now,
                version, InterfaceInfoEnum.MAJOR_EVENT_REPORT.code(), operation);
        String parentDir = filePath + File.separator + now.format(fmt);
        FileUtils.createDir(parentDir);
        String currentDir = parentDir + File.separator + UUID.randomUUID().toString();
        FileUtils.createDir(currentDir);
        String xmlPath = currentDir + File.separator + xmlName;
        Dom4jXmlManager.createXml(xmlPath, requestHeader, data, InterfaceInfoEnum.MAJOR_EVENT_REPORT);
        //复制附件到指定目录
        attachmentConfigService.copyAttachmentToCompress(InterfaceInfoEnum.MAJOR_EVENT_REPORT.code(), currentDir);
        //打包zip
        String zipName = StringForReportUtils.generateZipName(config.getSenderCode(), config.getReceiverCode(), now, version);
        String zipDir = filePath + File.separator + now.format(fmt) + "-zip";
        FileUtils.createDir(zipDir);
        String zipPath = zipDir + File.separator + zipName;
        ZipUtil.compress(currentDir, zipPath);
        //保存记录
        sendHistoryRepo.save(new SendHistoryDbo(zipPath, true, now, version + 1));
        //保存记录
        eventReportRepo.saveAll(reports);
        return currentDir;
    }

    @Override
    public List<Map<String, Object>> listReportMap() {
        List<EventReportDbo> events = eventReportRepo.findAll();
        return events.stream()
                .map(event -> (Map<String, Object>) JsonUtils.mapper.convertValue(event, Map.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveReport(List<Map<String, Object>> data) {
        eventReportRepo.deleteReportList();
        List<EventReportDbo> list = data.stream().map(agreement -> {
            JsonNode node = JsonUtils.mapper.valueToTree(agreement);
            String bizID = null;
            if (node.has(bizId_field)) {
                bizID = node.get(bizId_field).textValue();
            }
            return new EventReportDbo(node, bizID, false);
        }).collect(Collectors.toList());
        eventReportRepo.saveAll(list);
        return true;
    }

    @Override
    public Boolean updateReport(String bizId, Map<String, Object> data) {
        Optional<EventReportDbo> report = eventReportRepo.getReportByBizID(bizId);
        if (report.isPresent()) {
            EventReportDbo event = report.get();
            event.setEvent(JsonUtils.mapper.valueToTree(data));
            eventReportRepo.save(event);
            return true;
        } else {
            throw new CustomException("未查找到该BizID的数据");
        }
    }

    @Override
    public Boolean deleteReport(String bizId) {
        eventReportRepo.deleteByBizId(bizId);
        return true;
    }

    @Override
    public ResponseData archiveData(ResponseCommon response) {
        ResponseData responseData = new ResponseData();
        responseData.setInterfaceInfo("主协议");
        List<ResponseBodyCommon> bodyCommons = response.getBody();
        List<EventReportDbo> reportList = new ArrayList<>();
        List<ResponseDetail> details = new ArrayList<>();
        for (ResponseBodyCommon bodyCommon : bodyCommons) {
            ResponseDetail responseDetail = new ResponseDetail();
            String execId = bodyCommon.getExecID();
            Optional<EventReportDbo> reportOptional = eventReportRepo.getReportByExecID(execId);
            if (reportOptional.isPresent()) {
                EventReportDbo report = reportOptional.get();
                EventReportDTO reportData = EventReportDTO.fromJson(report.getEvent());
                reportData.setBizID(bodyCommon.getBizID());
                //数据转换
                JsonNode data = JsonUtils.mapper.valueToTree(reportData);
                responseDetail.setData(data);
                responseDetail.setMessage(responseDetail.getMessage());
                //原始数据更新
                report.setBizId(bodyCommon.getBizID());
                report.setArchive(true);
                reportList.add(report);
                //数据归档
                EventReportHistoryDbo history;
                Optional<EventReportHistoryDbo> historyOptional = eventReportHistoryRepo.getReportByBizID(bodyCommon.getBizID());
                if (historyOptional.isPresent()) {
                    history = historyOptional.get();
                    history.setEventReport(data);
                } else {
                    history = new EventReportHistoryDbo(data, bodyCommon.getBizID());
                }
                eventReportHistoryRepo.save(history);
            } else {
                responseDetail.setMessage("根据execId未找到绑定的数据");
            }
            details.add(responseDetail);
        }
        responseData.setData(details);
        eventReportRepo.saveAll(reportList);
        return responseData;
    }
}
