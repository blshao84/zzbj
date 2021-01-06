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
 * @description 期权交易确认书
 */
@Entity
@Table(schema = DATA_SOURCE, name = OPTION_CONFIRMATION)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class OptionConfirmationDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode optionconfirm;

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

    public OptionConfirmationDbo() {
    }

    public OptionConfirmationDbo(JsonNode optionconfirm, String bizId, Boolean archive) {
        this.optionconfirm = optionconfirm;
        this.bizId = bizId;
        this.archive = archive;
    }

    public JsonNode getOptionconfirm() {
        return optionconfirm;
    }

    public void setOptionconfirm(JsonNode optionconfirm) {
        this.optionconfirm = optionconfirm;
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
