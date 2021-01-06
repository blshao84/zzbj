package tech.tongyu.core.enums;

public enum PerformanceGuaranteeTypeEnum implements BaseEnumeration {
    NO("0", "否"),
    PARTIAL("1", "部分担保"),
    FULL("2", "全额担保")
    ;

    PerformanceGuaranteeTypeEnum(String code, String description) {
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
}
