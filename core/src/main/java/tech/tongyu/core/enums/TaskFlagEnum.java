package tech.tongyu.core.enums;

public enum TaskFlagEnum implements BaseEnumeration {

    S("SINGLE", "单一任务"),
    B("BEGIN", "头任务"),
    E("END", "结束任务"),
    M("MIDDLE", "中间任务")
    ;

    private String code;
    private String description;

    TaskFlagEnum(String code, String description) {
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

