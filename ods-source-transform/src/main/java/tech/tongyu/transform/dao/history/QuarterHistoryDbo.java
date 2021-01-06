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
 * @description 定期报告-季报
 */
@Entity
@Table(schema = HISTORY_DATA, name = QUARTER_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class QuarterHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode quarter;

    @Column
    private String bizId;

    public QuarterHistoryDbo() {
    }

    public QuarterHistoryDbo(JsonNode quarter, String bizId) {
        this.quarter = quarter;
        this.bizId = bizId;
    }

    public JsonNode getQuarter() {
        return quarter;
    }

    public void setQuarter(JsonNode quarter) {
        this.quarter = quarter;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
