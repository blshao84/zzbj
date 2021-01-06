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
 * @description ISDA
 */
@Entity
@Table(schema = HISTORY_DATA, name = ISDA_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class IsdaHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode isda;

    @Column
    private String bizId;

    public IsdaHistoryDbo() {
    }

    public IsdaHistoryDbo(JsonNode isda, String bizId) {
        this.isda = isda;
        this.bizId = bizId;
    }

    public JsonNode getIsda() {
        return isda;
    }

    public void setIsda(JsonNode isda) {
        this.isda = isda;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
