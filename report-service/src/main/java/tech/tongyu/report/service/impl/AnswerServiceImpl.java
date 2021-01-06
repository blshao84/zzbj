package tech.tongyu.report.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.dto.common.ResponseData;
import tech.tongyu.core.dto.common.ResponseHeaderCommon;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.exceptions.DocumentCommonException;
import tech.tongyu.core.exceptions.ErrorMessageAndTemolateDef;
import tech.tongyu.core.service.answer.AnswerService;
import tech.tongyu.core.service.base.AgreementService;
import tech.tongyu.core.utils.FileUtils;
import tech.tongyu.core.utils.ZipUtil;
import tech.tongyu.external.analyze.XmlAnalyzeManager;
import tech.tongyu.model.dao.ReceiveHistoryRepo;
import tech.tongyu.model.dao.history.ReceiveHistoryDbo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 应答文件解析与归档
 **/
@Service
public class AnswerServiceImpl implements AnswerService {

    Map<String, AgreementService> calculateTypeMap = new HashMap<>();

    @Value("${spring.answer.location}")
    private String answerPath;

    private ReceiveHistoryRepo receiveHistoryRepo;

    @Autowired
    public AnswerServiceImpl(List<AgreementService> agreements, ReceiveHistoryRepo receiveHistoryRepo) {
        for (AgreementService service : agreements) {
            calculateTypeMap.put(service.getServiceType(),service);
        }
        this.receiveHistoryRepo = receiveHistoryRepo;
    }

    @Override
    public String saveReceiveHistory(MultipartFile file) {
        //创建文件夹
        LocalDate now = LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String dir = answerPath + File.separator + now.format(fmt);
        FileUtils.createDir(dir);
        //记录zip
        ReceiveHistoryDbo history = new ReceiveHistoryDbo(file.getOriginalFilename(), false);
        String path = dir + File.separator + file.getOriginalFilename();
        try {
            if (!new File(path).exists()) {
                FileUtils.createFile(path);
            }
            FileOutputStream writer = new FileOutputStream(path);
            writer.write(file.getBytes());
            writer.close();
        } catch (Exception e) {
            throw new DocumentCommonException(ErrorMessageAndTemolateDef.Errors.FILE_UPLOAD_ERROR);
        }
        receiveHistoryRepo.save(history);
        return path;
    }

    @Override
    public String unZipAnswer(String zipPath) {
        //创建临时目录
        String dir = answerPath + File.separator + UUID.randomUUID().toString().replace("-", "");
        File zipFile = new File(zipPath);
        try {
            return ZipUtil.unzip(zipFile, dir);
        } catch (Exception e) {
            throw new CustomException("解压文件失败,失败原因:" + e.getMessage());
        }
    }

    @Override
    public ResponseCommon analyzeXml(String filePath) {
        return XmlAnalyzeManager.analyzeXml(filePath);
    }

    @Override
    public ResponseData archiveCommonData(ResponseCommon response) {
        ResponseHeaderCommon header = response.getHeader();
        ResponseData responseData = new ResponseData();
        if (Objects.isNull(header.getBusiDataType())) {
            //总体应答文件
            responseData.setHeaderMessage(header.getRetMsg());
            return responseData;
        } else {
            AgreementService agreementService = calculateTypeMap.get(header.getBusiDataType());
            return agreementService.archiveData(response);
        }
    }
}
