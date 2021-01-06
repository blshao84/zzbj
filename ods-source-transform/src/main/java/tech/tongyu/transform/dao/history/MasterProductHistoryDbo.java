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
import static tech.tongyu.core.constant.ServiceConstant.MASTER_PRODUCT_HISTORY;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 主协议关联产品列表-历史归档表
 **/
@Entity
@Table(schema = HISTORY_DATA, name = MASTER_PRODUCT_HISTORY)
@TypeDef(name = "JsonNodeType", typeClass = JsonNodeType.class)
public class MasterProductHistoryDbo extends BaseEntity {

    @Column(nullable = false, columnDefinition = "jsonb")
    @Type(type = "JsonNodeType")
    private JsonNode product;

    @Column
    private String bizId;

    public MasterProductHistoryDbo() {
    }

    public MasterProductHistoryDbo(JsonNode product, String bizId) {
        this.product = product;
        this.bizId = bizId;
    }

    public JsonNode getProduct() {
        return product;
    }

    public void setProduct(JsonNode product) {
        this.product = product;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }
}
