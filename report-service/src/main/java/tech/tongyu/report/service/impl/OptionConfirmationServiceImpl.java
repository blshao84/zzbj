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
import tech.tongyu.core.dto.optionconfirmation.OptionConfirmationDTO;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.service.base.OptionConfirmationService;
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
import tech.tongyu.transform.dao.history.OptionConfirmationHistoryDbo;
import tech.tongyu.transform.dao.repo.history.OptionConfirmationHistoryRepo;
import tech.tongyu.transform.dao.repo.source.OptionConfirmationRepo;
import tech.tongyu.transform.dao.source.OptionConfirmationDbo;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易确认书
 */
@Service
public class OptionConfirmationServiceImpl implements OptionConfirmationService {

    @Value("${spring.upload.location}")
    private String filePath;

    private final BaseElementRepo baseElementRepo;
    private final OptionConfirmationRepo optionConfirmationRepo;
    private final CheckAndSupplementService checkAndSupplementService;
    private final ReportBaseConfigRepo reportBaseConfigRepo;
    private final SendHistoryRepo sendHistoryRepo;
    private final OptionConfirmationHistoryRepo optionConfirmationHistoryRepo;
    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public OptionConfirmationServiceImpl(BaseElementRepo baseElementRepo,
                                         OptionConfirmationRepo optionConfirmationRepo,
                                         CheckAndSupplementService checkAndSupplementService,
                                         ReportBaseConfigRepo reportBaseConfigRepo,
                                         SendHistoryRepo sendHistoryRepo,
                                         OptionConfirmationHistoryRepo optionConfirmationHistoryRepo,
                                         AttachmentConfigService attachmentConfigService) {
        this.baseElementRepo = baseElementRepo;
        this.optionConfirmationRepo = optionConfirmationRepo;
        this.checkAndSupplementService = checkAndSupplementService;
        this.reportBaseConfigRepo = reportBaseConfigRepo;
        this.sendHistoryRepo = sendHistoryRepo;
        this.optionConfirmationHistoryRepo = optionConfirmationHistoryRepo;
        this.attachmentConfigService = attachmentConfigService;
    }

    @Override
    public List<OptionConfirmationDTO> listOptionConfirmation() {
        List<OptionConfirmationDbo> products = optionConfirmationRepo.getReport();
        return products.stream()
                .map(product -> OptionConfirmationDTO.fromJson(product.getOptionconfirm()))
                .collect(Collectors.toList());
    }

    @Override
    public String getServiceType() {
        return InterfaceInfoEnum.OPTION_TRADE.code();
    }

    @Override
    public Boolean executeTransTask() {
        List<BaseElementDbo> elements = baseElementRepo.findAllByCode(InterfaceInfoEnum.OPTION_TRADE.code());
        List<OptionConfirmationDbo> optionConfirmations = optionConfirmationRepo.getReport();
        List<Map<String, Object>> collect = optionConfirmations.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getOptionconfirm(), Map.class))
                .collect(Collectors.toList());
        List<Map<String, Object>> standardValues = checkAndSupplementService.getStandardValue(collect, elements);
        for (int i = 0; i < optionConfirmations.size(); i++) {
            OptionConfirmationDbo optionConfirmationDbo = optionConfirmations.get(i);
            Map<String, Object> map = standardValues.get(i);
            optionConfirmationDbo.setOptionconfirm(JsonUtils.mapper.valueToTree(map));
        }
        optionConfirmationRepo.saveAll(optionConfirmations);
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
                , InterfaceInfoEnum.OPTION_TRADE.code()
                , operation);
        //获取草稿箱数据
        List<OptionConfirmationDbo> reports = optionConfirmationRepo.getReport();
        if (CollectionUtils.isEmpty(reports)) {
            throw new CustomException("此次报送中内容无数据,请重新确认报送信息");
        }
        //填充数据结构
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < reports.size(); i++) {
            OptionConfirmationDbo report = reports.get(i);
            OptionConfirmationDTO reportData = OptionConfirmationDTO.fromJson(report.getOptionconfirm(), Optional.of(operation));
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
                version, InterfaceInfoEnum.OPTION_TRADE.code(), operation);
        String parentDir = filePath + File.separator + now.format(fmt);
        FileUtils.createDir(parentDir);
        String currentDir = parentDir + File.separator + UUID.randomUUID().toString();
        FileUtils.createDir(currentDir);
        String xmlPath = currentDir + File.separator + xmlName;
        Dom4jXmlManager.createXml(xmlPath, requestHeader, data, InterfaceInfoEnum.OPTION_TRADE);
        //复制附件到指定目录
        attachmentConfigService.copyAttachmentToCompress(InterfaceInfoEnum.OPTION_TRADE.code(), currentDir);
        //打包zip
        String zipName = StringForReportUtils.generateZipName(config.getSenderCode(), config.getReceiverCode(), now, version);
        String zipDir = filePath + File.separator + now.format(fmt) + "-zip";
        FileUtils.createDir(zipDir);
        String zipPath = zipDir + File.separator + zipName;
        ZipUtil.compress(currentDir, zipPath);
        //保存记录
        sendHistoryRepo.save(new SendHistoryDbo(zipPath, true, now, version + 1));
        //保存记录
        optionConfirmationRepo.saveAll(reports);
        return currentDir;
    }

    @Override
    public List<Map<String, Object>> listReportMap() {
        List<OptionConfirmationDbo> products = optionConfirmationRepo.findAll();
        return products.stream()
                .map(product -> (Map<String, Object>) JsonUtils.mapper.convertValue(product, Map.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveReport(List<Map<String, Object>> data) {
        optionConfirmationRepo.deleteReportList();
        List<OptionConfirmationDbo> list = data.stream().map(agreement -> {
            JsonNode node = JsonUtils.mapper.valueToTree(agreement);
            String bizId = null;
            if (node.has(bizId_field)) {
                bizId = node.get(bizId_field).textValue();
            }
            return new OptionConfirmationDbo(node, bizId, false);
        }).collect(Collectors.toList());
        optionConfirmationRepo.saveAll(list);
        return true;
    }

    @Override
    public Boolean updateReport(String bizId, Map<String, Object> data) {
        Optional<OptionConfirmationDbo> report = optionConfirmationRepo.getReportByBizID(bizId);
        if (report.isPresent()) {
            OptionConfirmationDbo product = report.get();
            product.setOptionconfirm(JsonUtils.mapper.valueToTree(data));
            optionConfirmationRepo.save(product);
            return true;
        } else {
            throw new CustomException("未查找到该BizID的数据");
        }
    }

    @Override
    public Boolean deleteReport(String bizId) {
        optionConfirmationRepo.deleteByBizId(bizId);
        return true;
    }

    @Override
    public ResponseData archiveData(ResponseCommon response) {
        ResponseData responseData = new ResponseData();
        responseData.setInterfaceInfo("期权交易确认书");
        List<ResponseBodyCommon> bodyCommons = response.getBody();
        List<OptionConfirmationDbo> reportList = new ArrayList<>();
        List<ResponseDetail> details = new ArrayList<>();
        for (ResponseBodyCommon bodyCommon : bodyCommons) {
            ResponseDetail responseDetail = new ResponseDetail();
            Optional<OptionConfirmationDbo> reportOptional = optionConfirmationRepo.getReportByExecID(bodyCommon.getExecID());
            if (reportOptional.isPresent()) {
                OptionConfirmationDbo report = reportOptional.get();
                OptionConfirmationDTO reportData = OptionConfirmationDTO.fromJson(report.getOptionconfirm());
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
                OptionConfirmationHistoryDbo history;
                Optional<OptionConfirmationHistoryDbo> historyOptional = optionConfirmationHistoryRepo.getReportByBizID(bodyCommon.getBizID());
                if (historyOptional.isPresent()) {
                    history = historyOptional.get();
                    history.setReport(data);
                } else {
                    history = new OptionConfirmationHistoryDbo(data, bodyCommon.getBizID());
                }
                optionConfirmationHistoryRepo.save(history);
            } else {
                responseDetail.setMessage("根据execId未找到绑定的数据");
            }
            details.add(responseDetail);
        }
        responseData.setData(details);
        optionConfirmationRepo.saveAll(reportList);
        return responseData;
    }

}
