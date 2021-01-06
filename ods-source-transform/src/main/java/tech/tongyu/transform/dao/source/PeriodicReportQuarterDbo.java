package tech.tongyu.transform.dao.source;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import tech.tongyu.core.utils.jpa.JsonNodeType;
import tech.tongyu.transform.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static tech.tongyu.core.constant.ServiceConstant.DATA_SOURCE;
import static tech.tongyu.core.constant.ServiceConstant.PERIODIC_REPORT_QUARTER;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 定期报告-季报
 */
@Entity
@Table(schema = DATA_SOURCE, name = PERIODIC_REPORT_QUARTER)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class PeriodicReportQuarterDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode quarter;

    /**
     * 抽取数据时填入的批次号
     */
    @Column
    private String processInstanceId;

    @Column
    private String execId;

    @Column
    private String bizId;

    @Column
    private Boolean archive;

    public PeriodicReportQuarterDbo() {
    }

    public PeriodicReportQuarterDbo(JsonNode quarter, String bizId, Boolean archive) {
        this.quarter = quarter;
        this.bizId = bizId;
        this.archive = archive;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public JsonNode getQuarter() {
        return quarter;
    }

    public void setQuarter(JsonNode quarter) {
        this.quarter = quarter;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public String getExecId() {
        return execId;
    }

    public void setExecId(String execId) {
        this.execId = execId;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
