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
 * @description 互换交易存续期管理
 */
@Entity
@Table(schema = HISTORY_DATA, name = SWAP_TERMINATION_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class SwapTerminationHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode swap;

    @Column
    private String bizId;

    public SwapTerminationHistoryDbo() {
    }

    public SwapTerminationHistoryDbo(JsonNode swap, String bizId) {
        this.swap = swap;
        this.bizId = bizId;
    }

    public JsonNode getSwap() {
        return swap;
    }

    public void setSwap(JsonNode swap) {
        this.swap = swap;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
