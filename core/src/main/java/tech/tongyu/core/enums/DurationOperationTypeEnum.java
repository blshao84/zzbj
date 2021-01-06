package tech.tongyu.core.enums;

/**
 * 存续期操作类型
 *
 * 01展期,02终止,03违约终止
 */
public enum DurationOperationTypeEnum implements BaseEnumeration{

    ROLL("01", "展期"),
    TERMINATION("02", "终止"),
    DEFAULT_TERMINATION("03","违约终止"),
    ;

    private String code;
    private String description;

    DurationOperationTypeEnum(String code, String description) {
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
