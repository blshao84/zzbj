package tech.tongyu.model.dao.history;

import tech.tongyu.model.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

import static tech.tongyu.core.constant.ServiceConstant.COMMERCE_MODEL;
import static tech.tongyu.core.constant.ServiceConstant.SEND_HISTORY;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 报送信息接收历史
 **/
@Entity
@Table(schema = COMMERCE_MODEL, name = SEND_HISTORY)
public class SendHistoryDbo extends BaseEntity {

    /**
     * zip路径
     */
    @Column
    private String zipPath;
    /**
     * 是否发送
     */
    @Column
    private Boolean result;
    /**
     * zip生成日期
     */
    @Column
    private LocalDate operationDate;
    /**
     * 版本号
     * 注意: 未发送不会拥有版本号
     */
    @Column
    private Integer version;

    public SendHistoryDbo() {
    }

    public SendHistoryDbo(String zipPath, Boolean result, LocalDate operationDate, Integer version) {
        this.zipPath = zipPath;
        this.result = result;
        this.operationDate = operationDate;
        this.version = version;
    }

    public LocalDate getOperationDate() {
        return operationDate;
    }

    public void setOperationDate(LocalDate operationDate) {
        this.operationDate = operationDate;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getZipPath() {
        return zipPath;
    }

    public void setZipPath(String zipPath) {
        this.zipPath = zipPath;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }
}
