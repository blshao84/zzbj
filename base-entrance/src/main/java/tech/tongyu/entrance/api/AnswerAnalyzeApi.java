package tech.tongyu.entrance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.dto.common.ResponseData;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.exceptions.JsonRpcResponse;
import tech.tongyu.core.service.answer.AnswerService;
import tech.tongyu.core.utils.FileUtils;
import tech.tongyu.core.utils.common.JsonUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 应答文件解析与归档
 **/
@RestController
@RequestMapping("/answer")
public class AnswerAnalyzeApi {

    private final AnswerService answerService;

    @Autowired
    public AnswerAnalyzeApi(AnswerService answerService) {
        this.answerService = answerService;
    }

    /**
     * 应答文件解析与归档
     * @param file 文件
     * @return 解析数据
     */
    @PostMapping(value = "/upload")
    public ResponseEntity<JsonRpcResponse> uploadAnswerZip(@RequestParam("file") MultipartFile file) {
        //将文件存储
        String zipPath = answerService.saveReceiveHistory(file);
        //文件解压到指定临时文件夹
        String zipDirectory = answerService.unZipAnswer(zipPath);
        //获取文件夹下所有的应答文件xml
        File xmlFile = new File(zipDirectory);
        File[] answers = xmlFile.listFiles();
        if (Objects.isNull(answers)) {
            throw new CustomException("解压路径下无数据请检查zip文件中是否拥有应答文件");
        }
        //解析总体应答文件xml信息
        List<ResponseData> dataList = new ArrayList<>();
        for (File answer : answers) {
            ResponseCommon responseCommon = answerService.analyzeXml(answer.getPath());
            ResponseData data = answerService.archiveCommonData(responseCommon);
            dataList.add(data);
        }
        //清除这个文件夹
        FileUtils.deleteFolder(xmlFile);
        return new ResponseEntity(JsonUtils.objectToJsonString(dataList), HttpStatus.OK);
    }

}
