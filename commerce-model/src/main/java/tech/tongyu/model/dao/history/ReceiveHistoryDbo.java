package tech.tongyu.model.dao.history;

import tech.tongyu.model.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static tech.tongyu.core.constant.ServiceConstant.COMMERCE_MODEL;
import static tech.tongyu.core.constant.ServiceConstant.RECEIVE_HISTORY;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 报送信息接收历史
 **/
@Entity
@Table(schema = COMMERCE_MODEL, name = RECEIVE_HISTORY)
public class ReceiveHistoryDbo extends BaseEntity {

    @Column
    private String zipPath;
    @Column
    private Boolean result;

    public ReceiveHistoryDbo() {
    }

    public ReceiveHistoryDbo(String zipPath, Boolean result) {
        this.zipPath = zipPath;
        this.result = result;
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
