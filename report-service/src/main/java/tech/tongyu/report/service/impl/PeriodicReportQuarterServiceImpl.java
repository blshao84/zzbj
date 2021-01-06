package tech.tongyu.report.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tech.tongyu.core.dto.common.ResponseBodyCommon;
import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.dto.common.ResponseData;
import tech.tongyu.core.dto.common.ResponseDetail;
import tech.tongyu.core.dto.quarter.PeriodicReportQuarterDTO;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.service.base.PeriodicReportQuarterService;
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
import tech.tongyu.model.dao.config.ReportBaseConfigDbo;
import tech.tongyu.model.dao.history.SendHistoryDbo;
import tech.tongyu.transform.dao.history.QuarterHistoryDbo;
import tech.tongyu.transform.dao.repo.history.QuarterHistoryRepo;
import tech.tongyu.transform.dao.source.PeriodicReportQuarterDbo;
import tech.tongyu.transform.dao.repo.source.PeriodicReportQuarterRepo;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description Quarter
 */
@Service
public class PeriodicReportQuarterServiceImpl implements PeriodicReportQuarterService {

    @Value("${spring.upload.location}")
    private String filePath;

    private final BaseElementRepo baseElementRepo;
    private final PeriodicReportQuarterRepo periodicReportQuarterRepo;
    private final CheckAndSupplementService checkAndSupplementService;
    private final ReportBaseConfigRepo reportBaseConfigRepo;
    private final SendHistoryRepo sendHistoryRepo;
    private final QuarterHistoryRepo quarterHistoryRepo;
    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public PeriodicReportQuarterServiceImpl(BaseElementRepo baseElementRepo,
                                            PeriodicReportQuarterRepo periodicReportQuarterRepo,
                                            CheckAndSupplementService checkAndSupplementService,
                                            ReportBaseConfigRepo reportBaseConfigRepo,
                                            SendHistoryRepo sendHistoryRepo,
                                            QuarterHistoryRepo quarterHistoryRepo,
                                            AttachmentConfigService attachmentConfigService) {
        this.baseElementRepo = baseElementRepo;
        this.periodicReportQuarterRepo = periodicReportQuarterRepo;
        this.checkAndSupplementService = checkAndSupplementService;
        this.reportBaseConfigRepo = reportBaseConfigRepo;
        this.sendHistoryRepo = sendHistoryRepo;
        this.quarterHistoryRepo = quarterHistoryRepo;
        this.attachmentConfigService = attachmentConfigService;
    }

    @Override
    public List<PeriodicReportQuarterDTO> listPeriodicReportQuarter() {
        List<PeriodicReportQuarterDbo> products = periodicReportQuarterRepo.getReport();
        return products.stream()
                .map(product -> PeriodicReportQuarterDTO.fromJson(product.getQuarter()))
                .collect(Collectors.toList());
    }

    @Override
    public String getServiceType() {
        return InterfaceInfoEnum.QUARTER_TEMPLATE.code();
    }

    @Override
    public Boolean executeTransTask() {
        List<BaseElementDbo> elements = baseElementRepo.findAllByCode(InterfaceInfoEnum.OPTION_TRADE.code());
        List<PeriodicReportQuarterDbo> reports = periodicReportQuarterRepo.getReport();
        List<Map<String, Object>> collect = reports.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getQuarter(), Map.class))
                .collect(Collectors.toList());
        List<Map<String, Object>> standardValues = checkAndSupplementService.getStandardValue(collect, elements);
        for (int i = 0; i < reports.size(); i++) {
            PeriodicReportQuarterDbo report = reports.get(i);
            Map<String, Object> map = standardValues.get(i);
            report.setQuarter(JsonUtils.mapper.valueToTree(map));
        }
        periodicReportQuarterRepo.saveAll(reports);
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
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
                , InterfaceInfoEnum.QUARTER_TEMPLATE.code()
                , operation);
        //获取草稿箱数据
        List<PeriodicReportQuarterDbo> reports = periodicReportQuarterRepo.getReport();
        if (CollectionUtils.isEmpty(reports)) {
            throw new CustomException("此次报送中内容无数据,请重新确认报送信息");
        }
        //填充数据结构
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < reports.size(); i++) {
            PeriodicReportQuarterDbo report = reports.get(i);
            PeriodicReportQuarterDTO reportData = PeriodicReportQuarterDTO.fromJson(report.getQuarter(), Optional.of(operation));
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
                version, InterfaceInfoEnum.QUARTER_TEMPLATE.code(), operation);
        String parentDir = filePath + File.separator + now.format(fmt);
        FileUtils.createDir(parentDir);
        String currentDir = parentDir + File.separator + UUID.randomUUID().toString();
        FileUtils.createDir(currentDir);
        String xmlPath = currentDir + File.separator + xmlName;
        Dom4jXmlManager.createXml(xmlPath, requestHeader, data, InterfaceInfoEnum.QUARTER_TEMPLATE);
        //复制附件到指定目录
        attachmentConfigService.copyAttachmentToCompress(InterfaceInfoEnum.QUARTER_TEMPLATE.code(), currentDir);
        //打包zip
        String zipName = StringForReportUtils.generateZipName(config.getSenderCode(), config.getReceiverCode(), now, version);
        String zipDir = filePath + File.separator + now.format(fmt) + "-zip";
        FileUtils.createDir(zipDir);
        String zipPath = zipDir + File.separator + zipName;
        ZipUtil.compress(currentDir, zipPath);
        //保存记录
        sendHistoryRepo.save(new SendHistoryDbo(zipPath, true, now, version + 1));
        //保存记录
        periodicReportQuarterRepo.saveAll(reports);
        return currentDir;
    }

    @Override
    public List<Map<String, Object>> listReportMap() {
        List<PeriodicReportQuarterDbo> products = periodicReportQuarterRepo.findAll();
        return products.stream()
                .map(product -> (Map<String, Object>) JsonUtils.mapper.convertValue(product, Map.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveReport(List<Map<String, Object>> data) {
        periodicReportQuarterRepo.deleteReportList();
        List<PeriodicReportQuarterDbo> list = data.stream().map(agreement -> {
            JsonNode node = JsonUtils.mapper.valueToTree(agreement);
            String bizId = null;
            if (node.has(bizId_field)) {
                bizId = node.get(bizId_field).textValue();
            }
            return new PeriodicReportQuarterDbo(node, bizId, false);
        }).collect(Collectors.toList());
        periodicReportQuarterRepo.saveAll(list);
        return true;
    }

    @Override
    public Boolean updateReport(String bizId, Map<String, Object> data) {
        Optional<PeriodicReportQuarterDbo> report = periodicReportQuarterRepo.getReportByBizID(bizId);
        if (report.isPresent()) {
            PeriodicReportQuarterDbo product = report.get();
            product.setQuarter(JsonUtils.mapper.valueToTree(data));
            periodicReportQuarterRepo.save(product);
            return true;
        } else {
            throw new CustomException("未查找到该BizID的数据");
        }
    }

    @Override
    public Boolean deleteReport(String bizId) {
        periodicReportQuarterRepo.deleteByBizId(bizId);
        return true;
    }

    @Override
    public ResponseData archiveData(ResponseCommon response) {
        ResponseData responseData = new ResponseData();
        responseData.setInterfaceInfo("定期报告-季报");
        List<ResponseBodyCommon> bodyCommons = response.getBody();
        List<PeriodicReportQuarterDbo> reportList = new ArrayList<>();
        List<ResponseDetail> details = new ArrayList<>();
        for (ResponseBodyCommon bodyCommon : bodyCommons) {
            ResponseDetail responseDetail = new ResponseDetail();
            Optional<PeriodicReportQuarterDbo> reportOptional = periodicReportQuarterRepo.getReportByExecID(bodyCommon.getExecID());
            if (reportOptional.isPresent()) {
                PeriodicReportQuarterDbo report = reportOptional.get();
                PeriodicReportQuarterDTO reportData = PeriodicReportQuarterDTO.fromJson(report.getQuarter());
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
                QuarterHistoryDbo history;
                Optional<QuarterHistoryDbo> historyOptional = quarterHistoryRepo.getReportByBizID(bodyCommon.getBizID());
                if (historyOptional.isPresent()) {
                    history = historyOptional.get();
                    history.setQuarter(data);
                } else {
                    history = new QuarterHistoryDbo(data, bodyCommon.getBizID());
                }
                quarterHistoryRepo.save(history);
            } else {
                responseDetail.setMessage("根据execId未找到绑定的数据");
            }
            details.add(responseDetail);
        }
        responseData.setData(details);
        periodicReportQuarterRepo.saveAll(reportList);
        return responseData;
    }
}
