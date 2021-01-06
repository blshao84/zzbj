package tech.tongyu.core.enums;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 交易对手类别
 **/
public enum PartyTypeEnum implements BaseEnumeration{

    SECURITIES_COMPANY("0","证券公司"),
    FUND_COMPANY("1","基金公司"),
    FUTURES_COMPANY("2","期货公司"),
    SUBSIDIARY_OF_SECURITIES_COMPANY("3","证券公司子公司"),
    SUBSIDIARY_OF_FUND_COMPANY("4","基金公司子公司"),
    FUTURES_RISK_MANAGEMENT_COMPANY("5","期货公司风险管理公司"),
    COMMERCIAL_BANK("6","商业银行"),
    INSURANCE_COMPANY("7","保险公司"),
    INSURANCE_SUBSIDIARY("8","保险子公司"),
    TRUST_COMPANY("9","信托公司"),
    FINANCE_COMPANY("10","财务公司"),
    PRIVATE_EQUITY("11","私募基金"),
    OTHER_FINANCIAL_INSTITUTIONS("12","其他金融机构"),
    DOMESTIC_NON_FINANCIAL_INSTITUTIONS("13","境内非金融机构"),
    FOREIGN_FINANCIAL_INSTITUTIONS("14","境外金融机构"),
    FOREIGN_NON_FINANCIAL_INSTITUTIONS("15","境外非金融机构"),
    COMMERCIAL_BANK_SUBSIDIARY("16","商业银行子公司")
    ;

    PartyTypeEnum(String code, String description) {
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
