package tech.tongyu.transform.dao.source;

import com.fasterxml.jackson.databind.JsonNode;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import tech.tongyu.core.utils.jpa.JsonNodeType;
import tech.tongyu.transform.dao.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议
 */
import static tech.tongyu.core.constant.ServiceConstant.*;

@Entity
@Table(schema = DATA_SOURCE, name = MASTER_AGRMT)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class MasterAgrmtDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode master;

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

    public MasterAgrmtDbo() {}

    public MasterAgrmtDbo(JsonNode master) {
        this.master = master;
    }

    public MasterAgrmtDbo(JsonNode master, String bizId, Boolean archive) {
        this.master = master;
        this.bizId = bizId;
        this.archive = archive;
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

    public JsonNode getMaster() {
        return master;
    }

    public void setMaster(JsonNode master) {
        this.master = master;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public Boolean getArchive() {
        return archive;
    }

    public void setArchive(Boolean archive) {
        this.archive = archive;
    }
}
