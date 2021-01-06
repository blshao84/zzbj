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
import tech.tongyu.core.dto.swapconfirmation.SwapConfirmationDTO;
import tech.tongyu.core.dto.swaptermination.SwapTerminationDTO;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.service.base.SwapTerminationService;
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
import tech.tongyu.transform.dao.history.SwapConfirmationHistoryDbo;
import tech.tongyu.transform.dao.history.SwapTerminationHistoryDbo;
import tech.tongyu.transform.dao.repo.history.SwapConfirmationHistoryRepo;
import tech.tongyu.transform.dao.repo.history.SwapTerminationHistoryRepo;
import tech.tongyu.transform.dao.source.SwapConfirmationDbo;
import tech.tongyu.transform.dao.source.SwapTerminationDbo;
import tech.tongyu.transform.dao.repo.source.SwapTerminationRepo;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易存续期管理
 */
@Service
public class SwapTerminationServiceImpl implements SwapTerminationService {

    @Value("${spring.upload.location}")
    private String filePath;

    private final BaseElementRepo baseElementRepo;
    private final SwapTerminationRepo swapTerminationRepo;
    private final CheckAndSupplementService checkAndSupplementService;
    private final ReportBaseConfigRepo reportBaseConfigRepo;
    private final SendHistoryRepo sendHistoryRepo;
    private final SwapTerminationHistoryRepo swapTerminationHistoryRepo;
    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public SwapTerminationServiceImpl(BaseElementRepo baseElementRepo,
                                      SwapTerminationRepo swapTerminationRepo,
                                      CheckAndSupplementService checkAndSupplementService,
                                      ReportBaseConfigRepo reportBaseConfigRepo,
                                      SendHistoryRepo sendHistoryRepo,
                                      SwapTerminationHistoryRepo swapTerminationHistoryRepo,
                                      AttachmentConfigService attachmentConfigService) {
        this.baseElementRepo = baseElementRepo;
        this.swapTerminationRepo = swapTerminationRepo;
        this.checkAndSupplementService = checkAndSupplementService;
        this.reportBaseConfigRepo = reportBaseConfigRepo;
        this.sendHistoryRepo = sendHistoryRepo;
        this.swapTerminationHistoryRepo = swapTerminationHistoryRepo;
        this.attachmentConfigService = attachmentConfigService;
    }

    @Override
    public List<SwapTerminationDTO> listSwapTermination() {
        List<SwapTerminationDbo> products = swapTerminationRepo.getReport();
        return products.stream()
                .map(product -> SwapTerminationDTO.fromJson(product.getSwap()))
                .collect(Collectors.toList());
    }

    @Override
    public String getServiceType() {
        return InterfaceInfoEnum.TERMINATION_OF_SWAP.code();
    }

    @Override
    public Boolean executeTransTask() {
        List<BaseElementDbo> elements = baseElementRepo.findAllByCode(InterfaceInfoEnum.OPTION_TRADE.code());
        List<SwapTerminationDbo> reports = swapTerminationRepo.getReport();
        List<Map<String, Object>> collect = reports.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getSwap(), Map.class))
                .collect(Collectors.toList());
        List<Map<String, Object>> standardValues = checkAndSupplementService.getStandardValue(collect, elements);
        for (int i = 0; i < reports.size(); i++) {
            SwapTerminationDbo report = reports.get(i);
            Map<String, Object> map = standardValues.get(i);
            report.setSwap(JsonUtils.mapper.valueToTree(map));
        }
        swapTerminationRepo.saveAll(reports);
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
                , InterfaceInfoEnum.TERMINATION_OF_SWAP.code()
                , operation);
        //获取草稿箱数据
        List<SwapTerminationDbo> reports = swapTerminationRepo.getReport();
        if (CollectionUtils.isEmpty(reports)) {
            throw new CustomException("此次报送中内容无数据,请重新确认报送信息");
        }
        //填充数据结构
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < reports.size(); i++) {
            SwapTerminationDbo report = reports.get(i);
            SwapTerminationDTO reportData = SwapTerminationDTO.fromJson(report.getSwap(), Optional.of(operation));
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
                version, InterfaceInfoEnum.TERMINATION_OF_SWAP.code(), operation);
        String parentDir = filePath + File.separator + now.format(fmt);
        FileUtils.createDir(parentDir);
        String currentDir = parentDir + File.separator + UUID.randomUUID().toString();
        FileUtils.createDir(currentDir);
        String xmlPath = currentDir + File.separator + xmlName;
        Dom4jXmlManager.createXml(xmlPath, requestHeader, data, InterfaceInfoEnum.TERMINATION_OF_SWAP);
        //复制附件到指定目录
        attachmentConfigService.copyAttachmentToCompress(InterfaceInfoEnum.TERMINATION_OF_SWAP.code(), currentDir);
        //打包zip
        String zipName = StringForReportUtils.generateZipName(config.getSenderCode(), config.getReceiverCode(), now, version);
        String zipDir = filePath + File.separator + now.format(fmt) + "-zip";
        FileUtils.createDir(zipDir);
        String zipPath = zipDir + File.separator + zipName;
        ZipUtil.compress(currentDir, zipPath);
        //保存记录
        sendHistoryRepo.save(new SendHistoryDbo(zipPath, true, now, version + 1));
        //保存记录
        swapTerminationRepo.saveAll(reports);
        return currentDir;
    }

    @Override
    public List<Map<String, Object>> listReportMap() {
        List<SwapTerminationDbo> products = swapTerminationRepo.findAll();
        return products.stream()
                .map(product -> (Map<String, Object>) JsonUtils.mapper.convertValue(product, Map.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveReport(List<Map<String, Object>> data) {
        swapTerminationRepo.deleteReportList();
        List<SwapTerminationDbo> list = data.stream().map(agreement -> {
            JsonNode node = JsonUtils.mapper.valueToTree(agreement);
            String bizId = null;
            if (node.has(bizId_field)) {
                bizId = node.get(bizId_field).textValue();
            }
            return new SwapTerminationDbo(node, bizId, false);
        }).collect(Collectors.toList());
        swapTerminationRepo.saveAll(list);
        return true;
    }

    @Override
    public Boolean updateReport(String bizId, Map<String, Object> data) {
        Optional<SwapTerminationDbo> report = swapTerminationRepo.getReportByBizID(bizId);
        if (report.isPresent()) {
            SwapTerminationDbo product = report.get();
            product.setSwap(JsonUtils.mapper.valueToTree(data));
            swapTerminationRepo.save(product);
            return true;
        } else {
            throw new CustomException("未查找到该BizID的数据");
        }
    }

    @Override
    public Boolean deleteReport(String bizId) {
        swapTerminationRepo.deleteByBizId(bizId);
        return true;
    }

    @Override
    public ResponseData archiveData(ResponseCommon response) {
        ResponseData responseData = new ResponseData();
        responseData.setInterfaceInfo("互换终止");
        List<ResponseBodyCommon> bodyCommons = response.getBody();
        List<SwapTerminationDbo> reportList = new ArrayList<>();
        List<ResponseDetail> details = new ArrayList<>();
        for (ResponseBodyCommon bodyCommon : bodyCommons) {
            ResponseDetail responseDetail = new ResponseDetail();
            Optional<SwapTerminationDbo> reportOptional = swapTerminationRepo.getReportByExecID(bodyCommon.getExecID());
            if (reportOptional.isPresent()) {
                SwapTerminationDbo report = reportOptional.get();
                SwapTerminationDTO reportData = SwapTerminationDTO.fromJson(report.getSwap());
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
                SwapTerminationHistoryDbo history;
                Optional<SwapTerminationHistoryDbo> historyOptional = swapTerminationHistoryRepo.getReportByBizID(bodyCommon.getBizID());
                if (historyOptional.isPresent()) {
                    history = historyOptional.get();
                    history.setSwap(data);
                } else {
                    history = new SwapTerminationHistoryDbo(data, bodyCommon.getBizID());
                }
                swapTerminationHistoryRepo.save(history);
            } else {
                responseDetail.setMessage("根据execId未找到绑定的数据");
            }
            details.add(responseDetail);
        }
        responseData.setData(details);
        swapTerminationRepo.saveAll(reportList);
        return responseData;
    }
}
