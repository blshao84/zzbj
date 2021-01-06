package tech.tongyu.core.service.answer;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.multipart.MultipartFile;
import tech.tongyu.core.dto.common.ResponseCommon;
import tech.tongyu.core.dto.common.ResponseData;

import java.io.File;
import java.util.List;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 应答文件解析与归档
 **/
public interface AnswerService {

    /**
     * zip文件存储
     * @param file zip文件
     * @return 文件路径
     */
    String saveReceiveHistory(MultipartFile file);

    /**
     * 解压文件
     * @param zipPath zip文件路径
     * @return 解压完成的文件夹路径
     */
    String unZipAnswer(String zipPath);

    /**
     * 解析应答文件
     * 注意:
     *   应答文件存在Header与Body
     *   根据Header中的Type获取对应协议的处理进行归档
     * @param filePath 应答文件
     * @return 解析数据
     */
    ResponseCommon analyzeXml(String filePath);

    /**
     * 归档数据
     * @param response 归档数据
     * @return 归档完成
     */
    ResponseData archiveCommonData(ResponseCommon response);
}
