package tech.tongyu.core.enums;

public enum TransStepEnum implements BaseEnumeration{

    ODS("ODS", "导入"),
    CHECK("CHECK", "检查"),
    TRANS("TRANS", "转换"),
    XML("XML", "生成XML"),
    ZIP("ZIP", "压缩"),
    SEND("SEND","发送"),
    RECEIVE("RECEIVE", "接收"),
    LOG("LOG", "日志")
    ;

    TransStepEnum(String code, String description) {
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
