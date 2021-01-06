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
 * @description 补充协议
 */
@Entity
@Table(schema = HISTORY_DATA, name = SUP_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class SupHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode sup;

    @Column
    private String bizId;

    public SupHistoryDbo(){}

    public SupHistoryDbo(JsonNode sup, String bizId) {
        this.sup = sup;
        this.bizId = bizId;
    }

    public JsonNode getSup() {
        return sup;
    }

    public void setSup(JsonNode sup) {
        this.sup = sup;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
