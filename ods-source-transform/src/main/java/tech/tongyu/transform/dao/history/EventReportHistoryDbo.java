package tech.tongyu.transform.dao.history;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import tech.tongyu.core.utils.jpa.JsonNodeType;
import tech.tongyu.transform.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.time.LocalDate;

import static tech.tongyu.core.constant.ServiceConstant.*;

@Entity
@Table(schema = HISTORY_DATA, name = EVENT_REPORT_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class EventReportHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode eventReport;

    @Column
    private String bizId;

    public EventReportHistoryDbo() {
    }

    public EventReportHistoryDbo(JsonNode eventReport, String bizId) {
        this.eventReport = eventReport;
        this.bizId = bizId;
    }

    public JsonNode getEventReport() {
        return eventReport;
    }

    public void setEventReport(JsonNode eventReport) {
        this.eventReport = eventReport;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
