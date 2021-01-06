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
 * @description 互换交易存续期管理
 */
@Entity
@Table(schema = DATA_SOURCE, name = SWAP_TERMINATION)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class SwapTerminationDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode swap;

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

    public SwapTerminationDbo() {
    }

    public SwapTerminationDbo(JsonNode swap, String bizId, Boolean archive) {
        this.swap = swap;
        this.bizId = bizId;
        this.archive = archive;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }

    public JsonNode getSwap() {
        return swap;
    }

    public void setSwap(JsonNode swap) {
        this.swap = swap;
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
