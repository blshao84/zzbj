package tech.tongyu.core.enums;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 身份信息
 **/
public enum IdentityEnum implements BaseEnumeration {

    PRODUCT_MANAGER("1", "产品管理人"),
    SELF_EMPLOYED("2","自营"),
    ;

    IdentityEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    private String code;
    private String description;

    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
