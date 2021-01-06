package tech.tongyu.core.enums;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 交易对手类别
 **/
public enum PartyMajorTypeEnum implements BaseEnumeration{

    NO_MAJOR("0","非专业"),
    MAJOR("1", "专业"),
    ;

    PartyMajorTypeEnum(String code, String description) {
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
