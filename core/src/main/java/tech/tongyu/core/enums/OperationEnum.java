package tech.tongyu.core.enums;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 操作类型
 **/
public enum OperationEnum implements BaseEnumeration {

    ADD("A", "报送信息文件"),
    UPDATE("U","报送信息补正文件"),
    DELETE("D","报送信息废止文件")
    ;

    private String code;
    private String description;

    OperationEnum(String code, String description) {
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

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
