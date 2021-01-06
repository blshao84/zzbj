package tech.tongyu.transform.dao.history;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import tech.tongyu.core.utils.jpa.JsonNodeType;
import tech.tongyu.transform.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static tech.tongyu.core.constant.ServiceConstant.*;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书
 */
@Entity
@Table(schema = HISTORY_DATA, name = SWAP_CONFIRMATION_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class SwapConfirmationHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode swapconfirm;

    @Column
    private String bizId;


    public SwapConfirmationHistoryDbo() {
    }

    public SwapConfirmationHistoryDbo(JsonNode swapconfirm, String bizId) {
        this.swapconfirm = swapconfirm;
        this.bizId = bizId;
    }

    public JsonNode getSwapconfirm() {
        return swapconfirm;
    }

    public void setSwapconfirm(JsonNode swapconfirm) {
        this.swapconfirm = swapconfirm;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
