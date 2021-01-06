package tech.tongyu.core.dto.common;

import java.util.Date;

/**
 * @author xiayulin
 * - mailto: xiayulin@tongyu.tech
 * @description 附件DTO
 **/
public class AttachmentConfigDTO {

    private String id;
    private Date createTime;
    private Date updateTime;
    private String attachmentName;
    private String attachmentPath;
    private String attachmentId;
    private String field;
    private Boolean status;

    public AttachmentConfigDTO() {
    }

    public AttachmentConfigDTO(String id, Date createTime, Date updateTime, String attachmentName, String attachmentPath, String attachmentId, String field, Boolean status) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.attachmentName = attachmentName;
        this.attachmentPath = attachmentPath;
        this.attachmentId = attachmentId;
        this.field = field;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    public String getAttachmentPath() {
        return attachmentPath;
    }

    public void setAttachmentPath(String attachmentPath) {
        this.attachmentPath = attachmentPath;
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
