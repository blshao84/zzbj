package tech.tongyu.model.dao.config;

import tech.tongyu.model.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static tech.tongyu.core.constant.ServiceConstant.*;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 报告基础信息
 * 此为必填项
 **/
@Entity
@Table(schema = COMMERCE_MODEL, name = REPORT_BASE_CONFIG)
public class ReportBaseConfigDbo extends BaseEntity {

    /**
     * 发送人编码
     */
    @Column
    private String senderCode;

    /**
     * 接受人编码
     */
    @Column
    private String receiverCode;

    public String getSenderCode() {
        return senderCode;
    }

    public void setSenderCode(String senderCode) {
        this.senderCode = senderCode;
    }

    public String getReceiverCode() {
        return receiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        this.receiverCode = receiverCode;
    }
}
