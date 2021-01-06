package tech.tongyu.entrance.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tech.tongyu.core.dto.common.AttachmentConfigDTO;
import tech.tongyu.core.dto.common.JsonRequest;
import tech.tongyu.core.service.config.AttachmentConfigService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author xiayulin
 * - mailto: xiayulin@tongyu.tech
 * @description 上传下载附件相关API
 **/
@RestController
@RequestMapping("/attachment")
public class UpAndDownloadApi {

    private final AttachmentConfigService attachmentConfigService;

    @Autowired
    public UpAndDownloadApi(AttachmentConfigService attachmentConfigService) {
        this.attachmentConfigService = attachmentConfigService;
    }

    /**
     * 文件上传
     *
     * @param file 文件
     * @param code 编码
     */
    @PostMapping(value = "/upload")
    public void uploadFile(
            @RequestParam("file") MultipartFile file,
            @RequestParam("code") String code) {
        attachmentConfigService.uploadFile(code, file);
    }

    /**
     * 文件上传
     *
     * @param files 文件s
     * @param code 编码
     */
    @PostMapping(value = "/upload_files")
    public void uploadFiles(
            @RequestParam("files") MultipartFile[] files,
            @RequestParam("code") String code) {
        attachmentConfigService.uploadFiles(code, files);
    }

    /**
     * 文件下载
     *
     * @param id 唯一编码
     */
    @PostMapping(value = "/download")
    public void downloadFile(
            @RequestParam("id") String id) {
        attachmentConfigService.downloadFile(id);
    }

    /**
     * 查询附件
     *
     * @return AttachmentConfigDTO
     */
    @GetMapping(value = "search")
    public AttachmentConfigDTO getAttachment(@RequestParam("code") String code) {
        return attachmentConfigService.getAttachment(code);
    }

    /**
     * 更新附件
     * @param jsonRequest
     */
    @PutMapping(value = "update", produces = APPLICATION_JSON_VALUE)
    public void updateAttachment(@RequestBody JsonRequest jsonRequest){
        attachmentConfigService.updateAttachment(jsonRequest.getId(), jsonRequest.getParams());
    }

    @GetMapping(value = "delete/{id}")
    public void deleteAttachment(@PathVariable String id) {
        attachmentConfigService.deleteAttachment(id);
    }
}
