package tech.tongyu.transform.dao.history;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import tech.tongyu.core.utils.jpa.JsonNodeType;
import tech.tongyu.transform.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static tech.tongyu.core.constant.ServiceConstant.HISTORY_DATA;
import static tech.tongyu.core.constant.ServiceConstant.OPTION_TERMINATION_HISTORY;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 历史归档表
 **/
@Entity
@Table(schema = HISTORY_DATA, name = OPTION_TERMINATION_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class OptionTerminationHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode report;

    @Column
    private String bizId;

    public OptionTerminationHistoryDbo() {
    }

    public OptionTerminationHistoryDbo(JsonNode report, String bizId) {
        this.report = report;
        this.bizId = bizId;
    }

    public JsonNode getReport() {
        return report;
    }

    public void setReport(JsonNode report) {
        this.report = report;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
