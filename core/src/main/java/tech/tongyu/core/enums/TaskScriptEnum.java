package tech.tongyu.core.enums;


public enum TaskScriptEnum implements BaseEnumeration{

    CMD("CMD","SH命令"),
    SQL("SQL","SQL命令"),
    ;

    TaskScriptEnum(String code, String description){
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
