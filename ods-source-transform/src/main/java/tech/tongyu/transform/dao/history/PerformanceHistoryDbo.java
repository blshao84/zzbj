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
 * @description 履约保证书
 */
@Entity
@Table(schema = HISTORY_DATA, name = PERFORMANCE_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class PerformanceHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode performance;

    @Column
    private String bizId;

    public PerformanceHistoryDbo() {
    }

    public PerformanceHistoryDbo(JsonNode performance, String bizId) {
        this.performance = performance;
        this.bizId = bizId;
    }

    public JsonNode getPerformance() {
        return performance;
    }

    public void setPerformance(JsonNode performance) {
        this.performance = performance;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
