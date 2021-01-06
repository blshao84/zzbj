package tech.tongyu.core.dto.nafmii;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description NAFMII-其他交易明细表
 */
@JsonPropertyOrder({"TradingDate", "FillInTheNameOfTheOrganization", "FillInTheNameOfTheAgency",
        "NameOfCounterparty", "CounterpartyAllographProduct", "BusinessType",
        "CounterpartyType", "CounterpartyIsProfessionalInstitutionsOrNot",
        "NotionalPrincipalAmount", "InvestmentTargetType",
        "InvestmentTarget", "ContractStartDate", "ContractExpirationDate"})
public class ScheduleOfOtherTransactionsDTO {

    private String TradingDate;
    private String FillInTheNameOfTheOrganization;
    private String FillInTheNameOfTheAgency;
    private String NameOfCounterparty;
    private String CounterpartyAllographProduct;

    private String BusinessType;
    private String CounterpartyType;
    private String CounterpartyIsProfessionalInstitutionsOrNot;
    private String NotionalPrincipalAmount;
    private String InvestmentTargetType;

    private String InvestmentTarget;
    private String ContractStartDate;
    private String ContractExpirationDate;

    public ScheduleOfOtherTransactionsDTO() {
    }

    public ScheduleOfOtherTransactionsDTO(String tradingDate, String fillInTheNameOfTheOrganization, String fillInTheNameOfTheAgency, String nameOfCounterparty, String counterpartyAllographProduct, String businessType, String counterpartyType, String counterpartyIsProfessionalInstitutionsOrNot, String notionalPrincipalAmount, String investmentTargetType, String investmentTarget, String contractStartDate, String contractExpirationDate) {
        TradingDate = tradingDate;
        FillInTheNameOfTheOrganization = fillInTheNameOfTheOrganization;
        FillInTheNameOfTheAgency = fillInTheNameOfTheAgency;
        NameOfCounterparty = nameOfCounterparty;
        CounterpartyAllographProduct = counterpartyAllographProduct;
        BusinessType = businessType;
        CounterpartyType = counterpartyType;
        CounterpartyIsProfessionalInstitutionsOrNot = counterpartyIsProfessionalInstitutionsOrNot;
        NotionalPrincipalAmount = notionalPrincipalAmount;
        InvestmentTargetType = investmentTargetType;
        InvestmentTarget = investmentTarget;
        ContractStartDate = contractStartDate;
        ContractExpirationDate = contractExpirationDate;
    }

    @JsonProperty("TradingDate")
    public String getTradingDate() {
        return TradingDate;
    }

    public void setTradingDate(String tradingDate) {
        TradingDate = tradingDate;
    }

    @JsonProperty("FillInTheNameOfTheOrganization")
    public String getFillInTheNameOfTheOrganization() {
        return FillInTheNameOfTheOrganization;
    }

    public void setFillInTheNameOfTheOrganization(String fillInTheNameOfTheOrganization) {
        FillInTheNameOfTheOrganization = fillInTheNameOfTheOrganization;
    }

    @JsonProperty("FillInTheNameOfTheAgency")
    public String getFillInTheNameOfTheAgency() {
        return FillInTheNameOfTheAgency;
    }

    public void setFillInTheNameOfTheAgency(String fillInTheNameOfTheAgency) {
        FillInTheNameOfTheAgency = fillInTheNameOfTheAgency;
    }

    @JsonProperty("NameOfCounterparty")
    public String getNameOfCounterparty() {
        return NameOfCounterparty;
    }

    public void setNameOfCounterparty(String nameOfCounterparty) {
        NameOfCounterparty = nameOfCounterparty;
    }

    @JsonProperty("CounterpartyAllographProduct")
    public String getCounterpartyAllographProduct() {
        return CounterpartyAllographProduct;
    }

    public void setCounterpartyAllographProduct(String counterpartyAllographProduct) {
        CounterpartyAllographProduct = counterpartyAllographProduct;
    }

    @JsonProperty("BusinessType")
    public String getBusinessType() {
        return BusinessType;
    }

    public void setBusinessType(String businessType) {
        BusinessType = businessType;
    }

    @JsonProperty("CounterpartyType")
    public String getCounterpartyType() {
        return CounterpartyType;
    }

    public void setCounterpartyType(String counterpartyType) {
        CounterpartyType = counterpartyType;
    }

    @JsonProperty("CounterpartyIsProfessionalInstitutionsOrNot")
    public String getCounterpartyIsProfessionalInstitutionsOrNot() {
        return CounterpartyIsProfessionalInstitutionsOrNot;
    }

    public void setCounterpartyIsProfessionalInstitutionsOrNot(String counterpartyIsProfessionalInstitutionsOrNot) {
        CounterpartyIsProfessionalInstitutionsOrNot = counterpartyIsProfessionalInstitutionsOrNot;
    }

    @JsonProperty("NotionalPrincipalAmount")
    public String getNotionalPrincipalAmount() {
        return NotionalPrincipalAmount;
    }

    public void setNotionalPrincipalAmount(String notionalPrincipalAmount) {
        NotionalPrincipalAmount = notionalPrincipalAmount;
    }

    @JsonProperty("InvestmentTargetType")
    public String getInvestmentTargetType() {
        return InvestmentTargetType;
    }

    public void setInvestmentTargetType(String investmentTargetType) {
        InvestmentTargetType = investmentTargetType;
    }

    @JsonProperty("InvestmentTarget")
    public String getInvestmentTarget() {
        return InvestmentTarget;
    }

    public void setInvestmentTarget(String investmentTarget) {
        InvestmentTarget = investmentTarget;
    }

    @JsonProperty("ContractStartDate")
    public String getContractStartDate() {
        return ContractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        ContractStartDate = contractStartDate;
    }

    @JsonProperty("ContractExpirationDate")
    public String getContractExpirationDate() {
        return ContractExpirationDate;
    }

    public void setContractExpirationDate(String contractExpirationDate) {
        ContractExpirationDate = contractExpirationDate;
    }
}
