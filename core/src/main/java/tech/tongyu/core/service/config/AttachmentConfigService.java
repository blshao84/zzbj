package tech.tongyu.core.service.config;

import org.dom4j.DocumentException;
import org.springframework.web.multipart.MultipartFile;
import tech.tongyu.core.dto.common.AttachmentConfigDTO;

import java.util.Map;

/**
 * @author xiayulin
 * - mailto: xiayulin@tongyu.tech
 * @description 上传下载附件
 **/
public interface AttachmentConfigService {

    /**
     * 上传附件
     * @param code
     * @param file
     */
    void uploadFile(String code, MultipartFile file);

    /**
     * 上传附件
     * @param code
     * @param files
     */
    void uploadFiles(String code, MultipartFile[] files);

    /**
     * 复制附件到打包路径
     * @param code 协议编码
     * @param compressPath 打包路径
     * @return 是否完成
     */
    Boolean copyAttachmentToCompress(String code, String compressPath);

    /**
     * 下载附件
     * @param id
     */
    void downloadFile(String id);

    /**
     * 根据code获取附件
     * @param code
     * @return
     */
    AttachmentConfigDTO getAttachment(String code);

    /**
     * 更新附件信息
     * @param id
     * @param data
     * @return
     */
    Boolean updateAttachment(String id, Map<String, Object> data);

    /**
     * 删除附件信息
     * @param id
     * @return
     */
    Boolean deleteAttachment(String id);


}
