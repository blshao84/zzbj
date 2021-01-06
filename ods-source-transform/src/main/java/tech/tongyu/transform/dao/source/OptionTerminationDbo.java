package tech.tongyu.transform.dao.source;

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
 * @description 期权交易存续期管理
 */
@Entity
@Table(schema = DATA_SOURCE, name = OPTION_TERMINATION)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class OptionTerminationDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode option;

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

    public OptionTerminationDbo() {}

    public OptionTerminationDbo(JsonNode option, String bizId, Boolean archive) {
        this.option = option;
        this.bizId = bizId;
        this.archive = archive;
    }

    public JsonNode getOption() {
        return option;
    }

    public void setOption(JsonNode option) {
        this.option = option;
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

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }
}
