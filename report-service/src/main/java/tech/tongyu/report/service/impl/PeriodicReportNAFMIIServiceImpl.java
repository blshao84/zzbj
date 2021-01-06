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
import tech.tongyu.core.dto.nafmii.PeriodicReportNAFMIIDTO;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.service.base.PeriodicReportNAFMIIService;
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
import tech.tongyu.transform.dao.history.NafmiiHistoryDbo;
import tech.tongyu.transform.dao.repo.history.NafmiiHistoryRepo;
import tech.tongyu.transform.dao.repo.source.PeriodicReportNAFMIIRepo;
import tech.tongyu.transform.dao.source.PeriodicReportNAFMIIDbo;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description NAFMII
 */
@Service
public class PeriodicReportNAFMIIServiceImpl implements PeriodicReportNAFMIIService {

    @Value("${spring.upload.location}")
    private String filePath;

    private final BaseElementRepo baseElementRepo;
    private final PeriodicReportNAFMIIRepo periodicReportNAFMIIRepo;
    private final CheckAndSupplementService checkAndSupplementService;
    private final ReportBaseConfigRepo reportBaseConfigRepo;
    private final SendHistoryRepo sendHistoryRepo;
    private final NafmiiHistoryRepo nafmiiHistoryRepo;
    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public PeriodicReportNAFMIIServiceImpl(BaseElementRepo baseElementRepo,
                                           PeriodicReportNAFMIIRepo periodicReportNAFMIIRepo,
                                           CheckAndSupplementService checkAndSupplementService,
                                           ReportBaseConfigRepo reportBaseConfigRepo,
                                           SendHistoryRepo sendHistoryRepo,
                                           NafmiiHistoryRepo nafmiiHistoryRepo,
                                           AttachmentConfigService attachmentConfigService) {
        this.baseElementRepo = baseElementRepo;
        this.periodicReportNAFMIIRepo = periodicReportNAFMIIRepo;
        this.checkAndSupplementService = checkAndSupplementService;
        this.reportBaseConfigRepo = reportBaseConfigRepo;
        this.sendHistoryRepo = sendHistoryRepo;
        this.nafmiiHistoryRepo = nafmiiHistoryRepo;
        this.attachmentConfigService = attachmentConfigService;
    }

    @Override
    public List<PeriodicReportNAFMIIDTO> listPeriodicReportNAFMII() {
        List<PeriodicReportNAFMIIDbo> products = periodicReportNAFMIIRepo.getReport();
        return products.stream()
                .map(product -> PeriodicReportNAFMIIDTO.fromJson(product.getNafmii()))
                .collect(Collectors.toList());
    }

    @Override
    public String getServiceType() {
        return InterfaceInfoEnum.NAFMII_TEMPLATE.code();
    }

    @Override
    public Boolean executeTransTask() {
        List<BaseElementDbo> elements = baseElementRepo.findAllByCode(InterfaceInfoEnum.OPTION_TRADE.code());
        List<PeriodicReportNAFMIIDbo> reports = periodicReportNAFMIIRepo.getReport();
        List<Map<String, Object>> collect = reports.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getNafmii(), Map.class))
                .collect(Collectors.toList());
        List<Map<String, Object>> standardValues = checkAndSupplementService.getStandardValue(collect, elements);
        for (int i = 0; i < reports.size(); i++) {
            PeriodicReportNAFMIIDbo report = reports.get(i);
            Map<String, Object> map = standardValues.get(i);
            report.setNafmii(JsonUtils.mapper.valueToTree(map));
        }
        periodicReportNAFMIIRepo.saveAll(reports);
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
                , InterfaceInfoEnum.NAFMII_TEMPLATE.code()
                , operation);
        //获取草稿箱数据
        List<PeriodicReportNAFMIIDbo> reports = periodicReportNAFMIIRepo.getReport();
        if (CollectionUtils.isEmpty(reports)) {
            throw new CustomException("此次报送中内容无数据,请重新确认报送信息");
        }
        //填充数据结构
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < reports.size(); i++) {
            PeriodicReportNAFMIIDbo report = reports.get(i);
            PeriodicReportNAFMIIDTO reportData = PeriodicReportNAFMIIDTO.fromJson(report.getNafmii(), Optional.of(operation));
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
                version, InterfaceInfoEnum.NAFMII_TEMPLATE.code(), operation);
        String parentDir = filePath + File.separator + now.format(fmt);
        FileUtils.createDir(parentDir);
        String currentDir = parentDir + File.separator + UUID.randomUUID().toString();
        FileUtils.createDir(currentDir);
        String xmlPath = currentDir + File.separator + xmlName;
        Dom4jXmlManager.createXml(xmlPath, requestHeader, data, InterfaceInfoEnum.NAFMII_TEMPLATE);
        //复制附件到指定目录
        attachmentConfigService.copyAttachmentToCompress(InterfaceInfoEnum.NAFMII_TEMPLATE.code(), currentDir);
        //打包zip
        String zipName = StringForReportUtils.generateZipName(config.getSenderCode(), config.getReceiverCode(), now, version);
        String zipDir = filePath + File.separator + now.format(fmt) + "-zip";
        FileUtils.createDir(zipDir);
        String zipPath = zipDir + File.separator + zipName;
        ZipUtil.compress(currentDir, zipPath);
        //保存记录
        sendHistoryRepo.save(new SendHistoryDbo(zipPath, true, now, version + 1));
        //保存记录
        periodicReportNAFMIIRepo.saveAll(reports);
        return currentDir;
    }

    @Override
    public List<Map<String, Object>> listReportMap() {
        List<PeriodicReportNAFMIIDbo> products = periodicReportNAFMIIRepo.findAll();
        return products.stream()
                .map(product -> (Map<String, Object>) JsonUtils.mapper.convertValue(product, Map.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveReport(List<Map<String, Object>> data) {
        periodicReportNAFMIIRepo.deleteReportList();
        List<PeriodicReportNAFMIIDbo> list = data.stream().map(agreement -> {
            JsonNode node = JsonUtils.mapper.valueToTree(agreement);
            String bizId = null;
            if (node.has(bizId_field)) {
                bizId = node.get(bizId_field).textValue();
            }
            return new PeriodicReportNAFMIIDbo(node, bizId, false);
        }).collect(Collectors.toList());
        periodicReportNAFMIIRepo.saveAll(list);
        return true;
    }

    @Override
    public Boolean updateReport(String bizId, Map<String, Object> data) {
        Optional<PeriodicReportNAFMIIDbo> report = periodicReportNAFMIIRepo.getReportByBizID(bizId);
        if (report.isPresent()) {
            PeriodicReportNAFMIIDbo product = report.get();
            product.setNafmii(JsonUtils.mapper.valueToTree(data));
            periodicReportNAFMIIRepo.save(product);
            return true;
        } else {
            throw new CustomException("未查找到该BizID的数据");
        }
    }

    @Override
    public Boolean deleteReport(String bizId) {
        periodicReportNAFMIIRepo.deleteByBizId(bizId);
        return true;
    }

    @Override
    public ResponseData archiveData(ResponseCommon response) {
        ResponseData responseData = new ResponseData();
        responseData.setInterfaceInfo("定期报告-NAFMII模板");
        List<ResponseBodyCommon> bodyCommons = response.getBody();
        List<PeriodicReportNAFMIIDbo> reportList = new ArrayList<>();
        List<ResponseDetail> details = new ArrayList<>();
        for (ResponseBodyCommon bodyCommon : bodyCommons) {
            ResponseDetail responseDetail = new ResponseDetail();
            Optional<PeriodicReportNAFMIIDbo> reportOptional = periodicReportNAFMIIRepo.getReportByExecID(bodyCommon.getExecID());
            if (reportOptional.isPresent()) {
                PeriodicReportNAFMIIDbo report = reportOptional.get();
                PeriodicReportNAFMIIDTO reportData = PeriodicReportNAFMIIDTO.fromJson(report.getNafmii());
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
                NafmiiHistoryDbo history;
                Optional<NafmiiHistoryDbo> historyOptional = nafmiiHistoryRepo.getReportByBizID(bodyCommon.getBizID());
                if (historyOptional.isPresent()) {
                    history = historyOptional.get();
                    history.setNafmii(data);
                } else {
                    history = new NafmiiHistoryDbo(data, bodyCommon.getBizID());
                }
                nafmiiHistoryRepo.save(history);
            } else {
                responseDetail.setMessage("根据execId未找到绑定的数据");
            }
            details.add(responseDetail);
        }
        responseData.setData(details);
        periodicReportNAFMIIRepo.saveAll(reportList);
        return responseData;
    }
}
