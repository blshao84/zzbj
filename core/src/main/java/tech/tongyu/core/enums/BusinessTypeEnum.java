package tech.tongyu.core.enums;

/**
 * 业务类型
 *
 * 互换|01、期权|02、远期|03
 */
public enum BusinessTypeEnum implements BaseEnumeration{

    SWAP("01", "互换"),
    OPTION("02", "期权"),
    FORWARD("03","远期"),
    ;

    private String code;
    private String description;

    BusinessTypeEnum(String code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public String code() {
        return code;
    }

    @Override
    public String description() {
        return description;
    }
}
