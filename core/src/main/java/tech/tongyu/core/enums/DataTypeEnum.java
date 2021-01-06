package tech.tongyu.core.enums;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 数据类型
 **/
public enum DataTypeEnum implements BaseEnumeration{

    STRING("string", "字符串"),
    UNKNOWN("unknown", "未知"),
    NUMBER("number","数字"),
    DATE_TIME("datetime", "时间"),
    DATE_CN("dateCN", "中文日期"),
    DATE("date","日期"),
    OBJECT("object","通用"),
    ARRAY("array","数组"),
    ORDINAL("oridinal","序数")
    ;

    private String code;
    private String description;

    DataTypeEnum(String code, String description) {
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
