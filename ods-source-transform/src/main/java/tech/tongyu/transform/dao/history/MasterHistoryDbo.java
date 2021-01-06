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
import static tech.tongyu.core.constant.ServiceConstant.MASTER_HISTORY;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 主协议-历史归档表
 **/
@Entity
@Table(schema = HISTORY_DATA, name = MASTER_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class MasterHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode master;

    @Column
    private String bizId;

    public MasterHistoryDbo() {
    }

    public MasterHistoryDbo(JsonNode master, String bizId) {
        this.master = master;
        this.bizId = bizId;
    }

    public JsonNode getMaster() {
        return master;
    }

    public void setMaster(JsonNode master) {
        this.master = master;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
