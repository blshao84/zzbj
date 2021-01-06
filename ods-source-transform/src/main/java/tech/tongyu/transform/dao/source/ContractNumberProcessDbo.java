package tech.tongyu.transform.dao.source;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import tech.tongyu.core.utils.jpa.JsonNodeType;
import tech.tongyu.transform.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static tech.tongyu.core.constant.ServiceConstant.CONTRACT_NUMBER_PROCESS;
import static tech.tongyu.core.constant.ServiceConstant.DATA_SOURCE;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 双方约定编号数据处理
 */
@Entity
@Table(schema = DATA_SOURCE, name = CONTRACT_NUMBER_PROCESS)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class ContractNumberProcessDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode contract;

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

    public ContractNumberProcessDbo() {
    }

    public ContractNumberProcessDbo(JsonNode contract, String bizId, Boolean archive) {
        this.contract = contract;
        this.bizId = bizId;
        this.archive = archive;
    }

    public JsonNode getContract() {
        return contract;
    }

    public void setContract(JsonNode contract) {
        this.contract = contract;
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
