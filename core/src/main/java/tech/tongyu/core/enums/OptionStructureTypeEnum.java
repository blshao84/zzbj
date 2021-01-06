package tech.tongyu.core.enums;

/**
 * 期权结构类型
 *
 * 香草|0、二元|1、价差|2、鲨鱼鳍|4、障碍|5、区间累计|6、自动看涨（Auto Callable）|7、其他|99
 */
public enum OptionStructureTypeEnum implements BaseEnumeration{

    VANILLA("0", "香草"),
    DIGITAL("1", "二元"),
    VERTICAL_SPREAD("2","价差"),
    SHARK_FIN("4", "鲨鱼鳍"),
    BARRIER("5", "障碍"),
    RANGE_ACCRUALS("6","区间累计"),
    AUTOCALL("7","自动看涨（Auto Callable）"),
    OTHER("99","其他"),
    ;

    private String code;
    private String description;

    OptionStructureTypeEnum(String code, String description) {
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
