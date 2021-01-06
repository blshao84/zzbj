package tech.tongyu.core.enums;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 主协议版本
 **/
public enum MasterVersionEnum implements BaseEnumeration{

    SAC_2013("0","SAC2013版"),
    SAC_2014("1","SAC2014版"),
    NAFMII("2","NAFMII"),
    ISDA("3","ISDA"),
    CUSTOM("4","自定义"),
    SAC_2018("5","SAC(2018年12月发布)"),
    SAC_CREDIT("6","SAC信用保护合约专用版"),
    OTHER("99","其他"),
    ;

    MasterVersionEnum(String code, String description) {
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
