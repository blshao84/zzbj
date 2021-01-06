package tech.tongyu.core.enums;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 接口类型
 **/
public enum  InterfaceInfoEnum implements BaseEnumeration {

    MASTER("A1001","主协议", "MasterAgrmt"),
    MASTER_PRODUCT_LIST("A1002", "主协议产品列表", "MasterAgrmtProduct"),
    SUPPLEMENTARY("A1003", "补充协议", "SupAgrmt"),
    OPTION_TRADE("A1004", "期权交易确认书", "OptionConfirmation"),
    CONFIRMATION_OF_SWAP("A1005", "互换交易确认书", "SwapConfirmation"),
    TERMINATION_OF_SWAP("A1006", "互换终止", "SwapTermination"),
    OPTION_TERMINATION("A1007", "期权终止", "OptionTermination"),
    PERFORMANCE_GUARANTEE("A1008", "履约担保", "PerformanceGuaranteeAgrmt"),
    MAJOR_EVENT_REPORT("A1009", "重大事项报告", "EventReport"),
    OTHER_MATTER_REPORT("A1010", "其他事项报告", "OtherReport"),
    SAC_TEMPLATE("A1011","定期报告-SAC模板", "PeriodicReportSAC"),
    NAFMII_TEMPLATE("A1012","定期报告-NAFMII模板", "PeriodicReportNAFMII"),
    ISDA_TEMPLATE("A1013","定期报告-ISDA模板", "PeriodicReportISDA"),
    QUARTER_TEMPLATE("A1014","定期报告-季报","PeriodicReportQuarter"),
    CONTRACT_NUMBER_PROCESS("A1015","双方约定编号数据处理","ContractNumberProcess"),
    ;


    private String code;
    private String description;
    private String tag;

    InterfaceInfoEnum(String code, String description, String tag) {
        this.code = code;
        this.description = description;
        this.tag = tag;
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

    public String tag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
