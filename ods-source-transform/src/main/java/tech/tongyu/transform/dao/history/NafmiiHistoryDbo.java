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
 * @description NAFMII
 */
@Entity
@Table(schema = HISTORY_DATA, name = NAFMII_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class NafmiiHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode nafmii;

    @Column
    private String bizId;

    public NafmiiHistoryDbo() {
    }

    public NafmiiHistoryDbo(JsonNode nafmii, String bizId) {
        this.nafmii = nafmii;
        this.bizId = bizId;
    }

    public JsonNode getNafmii() {
        return nafmii;
    }

    public void setNafmii(JsonNode nafmii) {
        this.nafmii = nafmii;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
