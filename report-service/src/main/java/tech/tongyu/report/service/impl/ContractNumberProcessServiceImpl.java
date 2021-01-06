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
import tech.tongyu.core.dto.contract.ContractNumberProcessDTO;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.service.base.ContractNumberProcessService;
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
import tech.tongyu.transform.dao.history.ContractHistoryDbo;
import tech.tongyu.transform.dao.repo.history.ContractHistoryRepo;
import tech.tongyu.transform.dao.repo.source.ContractNumberProcessRepo;
import tech.tongyu.transform.dao.source.ContractNumberProcessDbo;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiayulin
 * - mailto: xiayulin@tongyu.tech
 * @description A1015
 **/
@Service
public class ContractNumberProcessServiceImpl implements ContractNumberProcessService {

    @Value("${spring.upload.location}")
    private String filePath;

    private final BaseElementRepo baseElementRepo;
    private final ContractNumberProcessRepo contractNumberProcessRepo;
    private final CheckAndSupplementService checkAndSupplementService;
    private final ReportBaseConfigRepo reportBaseConfigRepo;
    private final SendHistoryRepo sendHistoryRepo;
    private final ContractHistoryRepo contractHistoryRepo;
    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public ContractNumberProcessServiceImpl(BaseElementRepo baseElementRepo,
                                            ContractNumberProcessRepo contractNumberProcessRepo,
                                            CheckAndSupplementService checkAndSupplementService,
                                            ReportBaseConfigRepo reportBaseConfigRepo,
                                            SendHistoryRepo sendHistoryRepo,
                                            ContractHistoryRepo contractHistoryRepo,
                                            AttachmentConfigService attachmentConfigService) {
        this.baseElementRepo = baseElementRepo;
        this.contractNumberProcessRepo = contractNumberProcessRepo;
        this.checkAndSupplementService = checkAndSupplementService;
        this.reportBaseConfigRepo = reportBaseConfigRepo;
        this.sendHistoryRepo = sendHistoryRepo;
        this.contractHistoryRepo = contractHistoryRepo;
        this.attachmentConfigService = attachmentConfigService;
    }

    @Override
    public List<ContractNumberProcessDTO> listContractNumberProcess() {
        List<ContractNumberProcessDbo> contractNumberProcesses = contractNumberProcessRepo.getContractNumberProcessReport();
        return contractNumberProcesses.stream()
                .map(process -> ContractNumberProcessDTO.fromJson(process.getContract()))
                .collect(Collectors.toList());
    }

    @Override
    public String getServiceType() {
        return InterfaceInfoEnum.CONTRACT_NUMBER_PROCESS.code();
    }

    @Override
    public Boolean executeTransTask() {
        List<BaseElementDbo> elements = baseElementRepo.findAllByCode(InterfaceInfoEnum.NAFMII_TEMPLATE.code());
        List<ContractNumberProcessDbo> reports = contractNumberProcessRepo.getContractNumberProcessReport();
        List<Map<String, Object>> collect = reports.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getContract(), Map.class))
                .collect(Collectors.toList());
        List<Map<String, Object>> standardValues = checkAndSupplementService.getStandardValue(collect, elements);
        for (int i = 0; i < reports.size(); i++) {
            ContractNumberProcessDbo contractNumberProcessDbo = reports.get(i);
            Map<String, Object> map = standardValues.get(i);
            contractNumberProcessDbo.setContract(JsonUtils.mapper.valueToTree(map));
        }
        contractNumberProcessRepo.saveAll(reports);
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
        LinkedHashMap<String, String> requestHeader = StringForReportUtils.buildRequestHeader(
                config.getSenderCode()
                , config.getReceiverCode()
                , now
                , version
                , InterfaceInfoEnum.CONTRACT_NUMBER_PROCESS.code()
                , operation);
        List<ContractNumberProcessDbo> reports = contractNumberProcessRepo.getContractNumberProcessReport();
        if (CollectionUtils.isEmpty(reports)) {
            throw new CustomException("此次报送中内容无数据,请重新确认报送信息");
        }
        //填充数据结构
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < reports.size(); i++) {
            ContractNumberProcessDbo report = reports.get(i);
            ContractNumberProcessDTO reportData = ContractNumberProcessDTO.fromJson(report.getContract(), Optional.of(operation));
            String execId = StringForReportUtils.buildExecID(config.getSenderCode(), config.getReceiverCode(), now, version, i);
            reportData.setExecID(execId);
            LinkedHashMap<String, Object> reportMap = checkAndSupplementService.validData(reportData.toLinkedHashMap(), operation);
            data.add(reportMap);
            report.setExecId(execId);
        }
        //生成xml
        String xmlName = StringForReportUtils.generateXmlName(config.getSenderCode(), config.getReceiverCode(), now,
                version, InterfaceInfoEnum.CONTRACT_NUMBER_PROCESS.code(), operation);
        String parentDir = filePath + File.separator + now.format(fmt);
        FileUtils.createDir(parentDir);
        String currentDir = parentDir + File.separator + UUID.randomUUID().toString();
        FileUtils.createDir(currentDir);
        String xmlPath = currentDir + File.separator + xmlName;
        Dom4jXmlManager.createXml(xmlPath, requestHeader, data, InterfaceInfoEnum.CONTRACT_NUMBER_PROCESS);
        //复制附件到指定目录
        attachmentConfigService.copyAttachmentToCompress(InterfaceInfoEnum.CONTRACT_NUMBER_PROCESS.code(), currentDir);
        //打包zip
        String zipName = StringForReportUtils.generateZipName(config.getSenderCode(), config.getReceiverCode(), now, version);
        String zipDir = filePath + File.separator + now.format(fmt) + "-zip";
        FileUtils.createDir(zipDir);
        String zipPath = zipDir + File.separator + zipName;
        ZipUtil.compress(currentDir, zipPath);
        //保存记录
        sendHistoryRepo.save(new SendHistoryDbo(zipPath, true, now, version + 1));
        //保存记录
        contractNumberProcessRepo.saveAll(reports);
        return currentDir;
    }

    @Override
    public List<Map<String, Object>> listReportMap() {
        List<ContractNumberProcessDbo> contractNumberProcesses = contractNumberProcessRepo.findAll();
        return contractNumberProcesses.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getContract(), Map.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveReport(List<Map<String, Object>> data) {
        contractNumberProcessRepo.deleteReportList();
        List<ContractNumberProcessDbo> list = data.stream()
                .map(agreement -> {
                    JsonNode node = JsonUtils.mapper.valueToTree(agreement);
                    String bizId = null;
                    if (node.has(bizId_field)) {
                        bizId = node.get(bizId_field).textValue();
                    }
                    return new ContractNumberProcessDbo(node, bizId, false);
                }).collect(Collectors.toList());
        contractNumberProcessRepo.saveAll(list);
        return true;
    }

    @Override
    public Boolean updateReport(String bizId, Map<String, Object> data) {
        Optional<ContractNumberProcessDbo> contract = contractNumberProcessRepo.getContractReportByBizID(bizId);
        if (contract.isPresent()) {
            ContractNumberProcessDbo report = contract.get();
            report.setContract(JsonUtils.mapper.valueToTree(data));
            contractNumberProcessRepo.save(report);
            return true;
        } else {
            throw new CustomException("未查找到该BizID的数据");
        }
    }

    @Override
    public Boolean deleteReport(String bizId) {
        contractNumberProcessRepo.deleteByBizId(bizId);
        return true;
    }

    @Override
    public ResponseData archiveData(ResponseCommon response) {
        ResponseData responseData = new ResponseData();
        responseData.setInterfaceInfo("双方约定编号数据处理");
        List<ResponseBodyCommon> bodyCommons = response.getBody();
        List<ContractNumberProcessDbo> reportList = new ArrayList<>();
        List<ResponseDetail> details = new ArrayList<>();
        for (ResponseBodyCommon bodyCommon : bodyCommons) {
            ResponseDetail responseDetail = new ResponseDetail();
            String execId = bodyCommon.getExecID();
            Optional<ContractNumberProcessDbo> reportOptional = contractNumberProcessRepo.getContractReportByExecID(execId);
            if (reportOptional.isPresent()) {
                ContractNumberProcessDbo report = reportOptional.get();
                ContractNumberProcessDTO reportData = ContractNumberProcessDTO.fromJson(report.getContract());
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
                ContractHistoryDbo history;
                Optional<ContractHistoryDbo> historyOptional = contractHistoryRepo.getReportByBizID(bodyCommon.getBizID());
                if (historyOptional.isPresent()) {
                    history = historyOptional.get();
                    history.setContract(data);
                } else {
                    history = new ContractHistoryDbo(data, bodyCommon.getBizID());
                }
                contractHistoryRepo.save(history);
            } else {
                responseDetail.setMessage("根据execId未找到绑定的数据");
            }
            details.add(responseDetail);
        }
        responseData.setData(details);
        contractNumberProcessRepo.saveAll(reportList);
        return responseData;
    }
}
