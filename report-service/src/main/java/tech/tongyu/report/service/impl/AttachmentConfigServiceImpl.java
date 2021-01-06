package tech.tongyu.report.service.impl;

import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tech.tongyu.core.dto.common.AttachmentConfigDTO;
import tech.tongyu.core.exceptions.CustomCommonException;
import tech.tongyu.core.exceptions.CustomErrorMessage;
import tech.tongyu.core.exceptions.DocumentCommonException;
import tech.tongyu.core.exceptions.ErrorMessageAndTemolateDef;
import tech.tongyu.core.service.config.AttachmentConfigService;
import tech.tongyu.core.utils.FileUtils;
import tech.tongyu.core.utils.common.JsonUtils;
import tech.tongyu.external.generate.Dom4jXmlManager;
import tech.tongyu.model.dao.AttachmentConfigRepo;
import tech.tongyu.model.dao.config.AttachmentConfigDbo;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xiayulin
 * - mailto: xiayulin@tongyu.tech
 * @description 上传下载附件
 **/
@Service
public class AttachmentConfigServiceImpl implements AttachmentConfigService {

    private AttachmentConfigRepo attachmentConfigRepo;

    private static final Logger logger = LoggerFactory.getLogger(AttachmentConfigServiceImpl.class);

    @Autowired
    public AttachmentConfigServiceImpl(AttachmentConfigRepo attachmentConfigRepo) {
        this.attachmentConfigRepo = attachmentConfigRepo;
    }

    @Value("${spring.attachment.location}")
    private String filePath;

    @Override
    public void uploadFile(String code, MultipartFile file) {
        String path = filePath + File.separator + file.getOriginalFilename();
        try {
            if (!new File(path).exists()) {
                FileUtils.createFile(path);
            }
            FileOutputStream writer = new FileOutputStream(path);
            writer.write(file.getBytes());
            logger.info("为文档{}写入文件{}", code, path);
        } catch (Exception e) {
            throw new DocumentCommonException(ErrorMessageAndTemolateDef.Errors.FILE_UPLOAD_ERROR);
        }
        AttachmentConfigDbo attachment = new AttachmentConfigDbo();
        attachment.setAttachmentId(code);
        attachment.setAttachmentPath(path);
        attachment.setAttachmentName(file.getOriginalFilename());
        attachment.setStatus(false);
        attachment = attachmentConfigRepo.save(attachment);
        logger.info("为文档{}保存附件{}", code, attachment.getId());
    }

    @Override
    public void uploadFiles(String code, MultipartFile[] files) {
        int cnt = attachmentConfigRepo.deleteAllByAttachmentIdAndStatus(code, false);
        logger.info("为文档{}删除{}条attachment", code, cnt);
        Arrays.stream(files).forEach(file -> uploadFile(code, file));
    }

    @Override
    public Boolean copyAttachmentToCompress(String code, String compressPath) {
        List<AttachmentConfigDbo> attachments = attachmentConfigRepo.listAttachmentByCode(code);
        // 无附件时无需执行创建文件夹的操作
        // 因为如果无附件时执行创建文件夹的操作，由于无附件，压缩包内会出现0K的与文件夹同名的文件，而非文件夹
        if (!attachments.isEmpty()) {
            String attachmentDir = compressPath + File.separator + "ATTACHMENT";
            FileUtils.createDir(attachmentDir);
            for (AttachmentConfigDbo attachment : attachments) {
                String attachmentPath = attachmentDir + File.separator + attachment.getAttachmentName();
                FileUtils.copyFile(attachment.getAttachmentPath(), attachmentPath);
                attachment.setStatus(true);
            }
            attachmentConfigRepo.saveAll(attachments);
        } else {
            logger.info("报告类型[{}]在路径[{}]下无附件", code, compressPath);
        }
        return true;
    }

    @Override
    public void downloadFile(String id) {

    }

    @Override
    public AttachmentConfigDTO getAttachment(String id) {
        AttachmentConfigDbo attachment = attachmentConfigRepo.findById(id)
                .orElseThrow(() -> new CustomCommonException(CustomErrorMessage.Errors.NOT_FOUND_DATA));
        return JsonUtils.mapper.convertValue(attachment, AttachmentConfigDTO.class);
    }

    @Override
    public Boolean updateAttachment(String id, Map<String, Object> data) {
        AttachmentConfigDbo attachment = attachmentConfigRepo.findById(id)
                .orElseThrow(() -> new CustomCommonException(CustomErrorMessage.Errors.NOT_FOUND_DATA));
        attachment.setAttachmentId((String) data.get("attachment_id"));
        attachment.setUpdateTime(new Date(System.currentTimeMillis()));
        attachment.setAttachmentName((String) data.get("attachment_name"));
        attachment.setAttachmentPath((String) data.get("attachment_path"));
        attachment.setField((String) data.get("field"));
        attachment.setStatus((Boolean) data.get("status"));
        attachmentConfigRepo.save(attachment);
        return true;
    }

    @Override
    public Boolean deleteAttachment(String id) {
        attachmentConfigRepo.deleteById(id);
        return true;
    }


}
