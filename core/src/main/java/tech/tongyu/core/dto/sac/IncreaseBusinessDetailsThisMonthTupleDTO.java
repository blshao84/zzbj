package tech.tongyu.core.dto.sac;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description SAC
 */
@JsonPropertyOrder({"SecurityCompany", "CounterpartyName", "CounterpartyProductName",
        "TransactionConfirmationNumber", "TradeConfirmationsType", "BusinessType",
        "NotionalPrincipalAmount", "TotalAmountOfNominalPrincipalAmount", "StartingDay",
        "DueDate", "InvestmentTargetType", "OptionObjectSecondClass", "ReturnSwapObjectSecondClass",
        "NonAnnualOptionFee", "OptionType"})
public class IncreaseBusinessDetailsThisMonthTupleDTO {

    private String SecurityCompany;
    private String CounterpartyName;
    private String CounterpartyProductName;
    private String TransactionConfirmationNumber;
    private String TradeConfirmationsType;
    private String BusinessType;
    private String NotionalPrincipalAmount;
    private String TotalAmountOfNominalPrincipalAmount;
    private String StartingDay;
    private String DueDate;
    private String InvestmentTargetType;
    private String OptionObjectSecondClass;
    private String ReturnSwapObjectSecondClass;
    private String NonAnnualOptionFee;
    private String OptionType;

    public IncreaseBusinessDetailsThisMonthTupleDTO() {
    }

    public IncreaseBusinessDetailsThisMonthTupleDTO(String securityCompany, String counterpartyName, String counterpartyProductName, String transactionConfirmationNumber, String tradeConfirmationsType, String businessType, String notionalPrincipalAmount, String totalAmountOfNominalPrincipalAmount, String startingDay, String dueDate, String investmentTargetType, String optionObjectSecondClass, String returnSwapObjectSecondClass, String nonAnnualOptionFee, String optionType) {
        SecurityCompany = securityCompany;
        CounterpartyName = counterpartyName;
        CounterpartyProductName = counterpartyProductName;
        TransactionConfirmationNumber = transactionConfirmationNumber;
        TradeConfirmationsType = tradeConfirmationsType;
        BusinessType = businessType;
        NotionalPrincipalAmount = notionalPrincipalAmount;
        TotalAmountOfNominalPrincipalAmount = totalAmountOfNominalPrincipalAmount;
        StartingDay = startingDay;
        DueDate = dueDate;
        InvestmentTargetType = investmentTargetType;
        OptionObjectSecondClass = optionObjectSecondClass;
        ReturnSwapObjectSecondClass = returnSwapObjectSecondClass;
        NonAnnualOptionFee = nonAnnualOptionFee;
        OptionType = optionType;
    }

    @JsonProperty("SecurityCompany")
    public String getSecurityCompany() {
        return SecurityCompany;
    }

    public void setSecurityCompany(String securityCompany) {
        SecurityCompany = securityCompany;
    }

    @JsonProperty("CounterpartyName")
    public String getCounterpartyName() {
        return CounterpartyName;
    }

    public void setCounterpartyName(String counterpartyName) {
        CounterpartyName = counterpartyName;
    }

    @JsonProperty("CounterpartyProductName")
    public String getCounterpartyProductName() {
        return CounterpartyProductName;
    }

    public void setCounterpartyProductName(String counterpartyProductName) {
        CounterpartyProductName = counterpartyProductName;
    }

    @JsonProperty("TransactionConfirmationNumber")
    public String getTransactionConfirmationNumber() {
        return TransactionConfirmationNumber;
    }

    public void setTransactionConfirmationNumber(String transactionConfirmationNumber) {
        TransactionConfirmationNumber = transactionConfirmationNumber;
    }

    @JsonProperty("TradeConfirmationsType")
    public String getTradeConfirmationsType() {
        return TradeConfirmationsType;
    }

    public void setTradeConfirmationsType(String tradeConfirmationsType) {
        TradeConfirmationsType = tradeConfirmationsType;
    }

    @JsonProperty("BusinessType")
    public String getBusinessType() {
        return BusinessType;
    }

    public void setBusinessType(String businessType) {
        BusinessType = businessType;
    }

    @JsonProperty("NotionalPrincipalAmount")
    public String getNotionalPrincipalAmount() {
        return NotionalPrincipalAmount;
    }

    public void setNotionalPrincipalAmount(String notionalPrincipalAmount) {
        NotionalPrincipalAmount = notionalPrincipalAmount;
    }

    @JsonProperty("TotalAmountOfNominalPrincipalAmount")
    public String getTotalAmountOfNominalPrincipalAmount() {
        return TotalAmountOfNominalPrincipalAmount;
    }

    public void setTotalAmountOfNominalPrincipalAmount(String totalAmountOfNominalPrincipalAmount) {
        TotalAmountOfNominalPrincipalAmount = totalAmountOfNominalPrincipalAmount;
    }

    @JsonProperty("StartingDay")
    public String getStartingDay() {
        return StartingDay;
    }

    public void setStartingDay(String startingDay) {
        StartingDay = startingDay;
    }

    @JsonProperty("DueDate")
    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    @JsonProperty("InvestmentTargetType")
    public String getInvestmentTargetType() {
        return InvestmentTargetType;
    }

    public void setInvestmentTargetType(String investmentTargetType) {
        InvestmentTargetType = investmentTargetType;
    }

    @JsonProperty("OptionObjectSecondClass")
    public String getOptionObjectSecondClass() {
        return OptionObjectSecondClass;
    }

    public void setOptionObjectSecondClass(String optionObjectSecondClass) {
        OptionObjectSecondClass = optionObjectSecondClass;
    }

    @JsonProperty("ReturnSwapObjectSecondClass")
    public String getReturnSwapObjectSecondClass() {
        return ReturnSwapObjectSecondClass;
    }

    public void setReturnSwapObjectSecondClass(String returnSwapObjectSecondClass) {
        ReturnSwapObjectSecondClass = returnSwapObjectSecondClass;
    }

    @JsonProperty("NonAnnualOptionFee")
    public String getNonAnnualOptionFee() {
        return NonAnnualOptionFee;
    }

    public void setNonAnnualOptionFee(String nonAnnualOptionFee) {
        NonAnnualOptionFee = nonAnnualOptionFee;
    }

    @JsonProperty("OptionType")
    public String getOptionType() {
        return OptionType;
    }

    public void setOptionType(String optionType) {
        OptionType = optionType;
    }
}
