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
 * @description 双方约定编号数据处理
 */
@Entity
@Table(schema = HISTORY_DATA, name = CONTRACT_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class ContractHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode contract;

    @Column
    private String bizId;

    public ContractHistoryDbo() {
    }

    public ContractHistoryDbo(JsonNode contract, String bizId) {
        this.contract = contract;
        this.bizId = bizId;
    }

    public JsonNode getContract() {
        return contract;
    }

    public void setContract(JsonNode contract) {
        this.contract = contract;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
