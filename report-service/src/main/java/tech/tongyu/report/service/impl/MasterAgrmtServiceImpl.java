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
import tech.tongyu.core.dto.master.MasterAgrmtDTO;
import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.*;
import tech.tongyu.core.service.base.MasterAgreementService;
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
import tech.tongyu.transform.dao.history.MasterHistoryDbo;
import tech.tongyu.transform.dao.repo.history.MasterAgreementHistoryRepo;
import tech.tongyu.transform.dao.repo.source.MasterAgrmtRepo;
import tech.tongyu.transform.dao.source.MasterAgrmtDbo;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议
 */
@Service
public class MasterAgrmtServiceImpl implements MasterAgreementService {

    @Value("${spring.upload.location}")
    private String filePath;

    private final BaseElementRepo baseElementRepo;
    private final MasterAgrmtRepo masterAgrmtRepo;
    private final CheckAndSupplementService checkAndSupplementService;
    private final ReportBaseConfigRepo reportBaseConfigRepo;
    private final SendHistoryRepo sendHistoryRepo;
    private final MasterAgreementHistoryRepo masterAgreementHistoryRepo;
    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public MasterAgrmtServiceImpl(BaseElementRepo baseElementRepo,
                                  MasterAgrmtRepo masterAgrmtRepo,
                                  CheckAndSupplementService checkAndSupplementService,
                                  ReportBaseConfigRepo reportBaseConfigRepo,
                                  SendHistoryRepo sendHistoryRepo,
                                  MasterAgreementHistoryRepo masterAgreementHistoryRepo,
                                  AttachmentConfigService attachmentConfigService) {
        this.baseElementRepo = baseElementRepo;
        this.masterAgrmtRepo = masterAgrmtRepo;
        this.checkAndSupplementService = checkAndSupplementService;
        this.reportBaseConfigRepo = reportBaseConfigRepo;
        this.sendHistoryRepo = sendHistoryRepo;
        this.masterAgreementHistoryRepo = masterAgreementHistoryRepo;
        this.attachmentConfigService = attachmentConfigService;
    }

    @Override
    public List<MasterAgrmtDTO> listMasterAgreement() {
        List<MasterAgrmtDbo> products = masterAgrmtRepo.getReport();
        return products.stream()
                .map(product -> MasterAgrmtDTO.fromJson(product.getMaster()))
                .collect(Collectors.toList());
    }

    @Override
    public String getServiceType() {
        return InterfaceInfoEnum.MASTER.code();
    }

    @Override
    public Boolean executeTransTask() {
        List<BaseElementDbo> elements = baseElementRepo.findAllByCodeLike("%" + InterfaceInfoEnum.MASTER.code() + "%");
        List<MasterAgrmtDbo> masters = masterAgrmtRepo.getReport();
        List<Map<String, Object>> collect = masters.stream()
                .map(report -> (Map<String, Object>) JsonUtils.mapper.convertValue(report.getMaster(), Map.class))
                .collect(Collectors.toList());
        List<Map<String, Object>> standardValues = checkAndSupplementService.getStandardValue(collect, elements);
        for (int i = 0; i < masters.size(); i++) {
            MasterAgrmtDbo masterAgrmtDbo = masters.get(i);
            Map<String, Object> map = standardValues.get(i);
            masterAgrmtDbo.setMaster(JsonUtils.mapper.valueToTree(map));
        }
        masterAgrmtRepo.saveAll(masters);
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
                , InterfaceInfoEnum.MASTER.code()
                , operation);
        //获取草稿箱数据
        List<MasterAgrmtDbo> reports = masterAgrmtRepo.getReport();
        if (CollectionUtils.isEmpty(reports)) {
            throw new CustomException("此次报送中内容无数据,请重新确认报送信息");
        }
        //填充数据结构
        List<LinkedHashMap<String, Object>> data = new ArrayList<>();
        for (int i = 0; i < reports.size(); i++) {
            MasterAgrmtDbo report = reports.get(i);
            MasterAgrmtDTO reportData = MasterAgrmtDTO.fromJson(report.getMaster(), Optional.of(operation));
            String execId = StringForReportUtils.buildExecID(config.getSenderCode()
                    , config.getReceiverCode(), now, version, i);
            reportData.setExecID(execId);
            //dto -> linkedHashMap
            LinkedHashMap<String, Object> reportMap = checkAndSupplementService.validData(reportData.toLinkedHashMap(), operation);
            data.add(reportMap);
            //更新ExecId
            report.setExecId(execId);
        }
        //生成xml
        String xmlName = StringForReportUtils.generateXmlName(config.getSenderCode(), config.getReceiverCode(), now,
                version, InterfaceInfoEnum.MASTER.code(), operation);
        String parentDir = filePath + File.separator + now.format(fmt);
        FileUtils.createDir(parentDir);
        String currentDir = parentDir + File.separator + UUID.randomUUID().toString();
        FileUtils.createDir(currentDir);
        String xmlPath = currentDir + File.separator + xmlName;
        Dom4jXmlManager.createXml(xmlPath, requestHeader, data, InterfaceInfoEnum.MASTER);
        //复制附件到指定目录
        attachmentConfigService.copyAttachmentToCompress(InterfaceInfoEnum.MASTER.code(), currentDir);
        //打包zip
        String zipName = StringForReportUtils.generateZipName(config.getSenderCode(), config.getReceiverCode(), now, version);
        String zipDir = filePath + File.separator + now.format(fmt) + "-zip";
        FileUtils.createDir(zipDir);
        String zipPath = zipDir + File.separator + zipName;
        ZipUtil.compress(currentDir, zipPath);
        //保存记录
        sendHistoryRepo.save(new SendHistoryDbo(zipPath, true, now, version + 1));
        //保存记录
        masterAgrmtRepo.saveAll(reports);
        return currentDir;
    }

    @Override
    public List<Map<String, Object>> listReportMap() {
        List<MasterAgrmtDbo> products = masterAgrmtRepo.findAll();
        return products.stream()
                .map(product -> (Map<String, Object>) JsonUtils.mapper.convertValue(product, Map.class))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean saveReport(List<Map<String, Object>> data) {
        masterAgrmtRepo.deleteReportList();
        List<MasterAgrmtDbo> list = data.stream().map(agreement -> {
            JsonNode node = JsonUtils.mapper.valueToTree(agreement);
            String bizId = null;
            if (node.has(bizId_field)) {
                bizId = node.get(bizId_field).textValue();
            }
            return new MasterAgrmtDbo(node, bizId, false);
        }).collect(Collectors.toList());
        masterAgrmtRepo.saveAll(list);
        return true;
    }

    @Override
    public Boolean updateReport(String bizId, Map<String, Object> data) {
        Optional<MasterAgrmtDbo> report = masterAgrmtRepo.getReportByBizID(bizId);
        if (report.isPresent()) {
            MasterAgrmtDbo product = report.get();
            product.setMaster(JsonUtils.mapper.valueToTree(data));
            masterAgrmtRepo.save(product);
            return true;
        } else {
            throw new CustomException("未查找到该BizID的数据");
        }
    }

    @Override
    public Boolean deleteReport(String bizId) {
        masterAgrmtRepo.deleteByBizId(bizId);
        return true;
    }

    @Override
    public ResponseData archiveData(ResponseCommon response) {
        ResponseData responseData = new ResponseData();
        responseData.setInterfaceInfo("主协议");
        List<ResponseBodyCommon> bodyCommons = response.getBody();
        List<MasterAgrmtDbo> reportList = new ArrayList<>();
        List<ResponseDetail> details = new ArrayList<>();
        for (ResponseBodyCommon bodyCommon : bodyCommons) {
            ResponseDetail responseDetail = new ResponseDetail();
            Optional<MasterAgrmtDbo> reportOptional = masterAgrmtRepo.getReportByExecID(bodyCommon.getExecID());
            if (reportOptional.isPresent()) {
                MasterAgrmtDbo report = reportOptional.get();
                MasterAgrmtDTO reportData = MasterAgrmtDTO.fromJson(report.getMaster());
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
                MasterHistoryDbo history;
                Optional<MasterHistoryDbo> historyOptional = masterAgreementHistoryRepo.getReportByBizID(bodyCommon.getBizID());
                if (historyOptional.isPresent()) {
                    history = historyOptional.get();
                    history.setMaster(data);
                } else {
                    history = new MasterHistoryDbo(data, bodyCommon.getBizID());
                }
                masterAgreementHistoryRepo.save(history);
            } else {
                responseDetail.setMessage("根据execId未找到绑定的数据");
            }
            details.add(responseDetail);
        }
        responseData.setData(details);
        masterAgrmtRepo.saveAll(reportList);
        return responseData;
    }
}
