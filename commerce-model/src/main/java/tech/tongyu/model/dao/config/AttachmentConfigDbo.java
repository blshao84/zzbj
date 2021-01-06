package tech.tongyu.model.dao.config;

import tech.tongyu.model.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static tech.tongyu.core.constant.ServiceConstant.ATTACHMENT;
import static tech.tongyu.core.constant.ServiceConstant.COMMERCE_MODEL;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 非结构化报送信息
 **/
@Entity
@Table(schema = COMMERCE_MODEL, name = ATTACHMENT)
public class AttachmentConfigDbo extends BaseEntity {

    @Column
    private String attachmentName;
    @Column
    private String attachmentPath;
    @Column
    private String attachmentId;
    @Column
    private String field;
    @Column
    private boolean status;

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
