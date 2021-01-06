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
 * @description SAC
 */
@Entity
@Table(schema = HISTORY_DATA, name = SAC_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class SacHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode sac;

    @Column
    private String bizId;

    public SacHistoryDbo() {
    }

    public SacHistoryDbo(JsonNode sac, String bizId) {
        this.sac = sac;
        this.bizId = bizId;
    }

    public JsonNode getSac() {
        return sac;
    }

    public void setSac(JsonNode sac) {
        this.sac = sac;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
