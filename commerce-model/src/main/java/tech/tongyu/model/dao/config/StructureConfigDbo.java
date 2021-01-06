package tech.tongyu.model.dao.config;

import tech.tongyu.core.enums.InterfaceInfoEnum;
import tech.tongyu.model.dao.common.BaseEntity;

import javax.persistence.*;

import static tech.tongyu.core.constant.ServiceConstant.COMMERCE_MODEL;
import static tech.tongyu.core.constant.ServiceConstant.STRUCTURE;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 结构化报送信息
 **/
@Entity
@Table(schema = COMMERCE_MODEL, name = STRUCTURE)
public class StructureConfigDbo extends BaseEntity {

    @Column
    private String agreementName;

    @Column
    private String code;

    public String getAgreementName() {
        return agreementName;
    }

    public void setAgreementName(String agreementName) {
        this.agreementName = agreementName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
