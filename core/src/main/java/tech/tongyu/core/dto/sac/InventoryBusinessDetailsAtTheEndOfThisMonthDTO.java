package tech.tongyu.core.dto.sac;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description SAC
 */
@JsonPropertyOrder({"NameOfSecuritiesCompany", "CounterpartyName", "CounterpartyProductName",
        "TransactionConfirmationNumber", "TypeOfTransactionConfirmation", "BusinessType",
        "NotionalPrincipalAmount", "TotalAmountOfNominalPrincipalAmount", "StartingDay",
        "DueDate", "SumInvestmentTargetType", "OptionSumInvestmentTargetType", "ExchangeSumInvestmentTargetType",
        "OptionFee", "OptionType"})
public class InventoryBusinessDetailsAtTheEndOfThisMonthDTO {

    private String NameOfSecuritiesCompany;
    private String CounterpartyName;
    private String CounterpartyProductName;
    private String TransactionConfirmationNumber;
    private String TypeOfTransactionConfirmation;
    private String BusinessType;
    private String NotionalPrincipalAmount;
    private String TotalAmountOfNominalPrincipalAmount;
    private String StartingDay;
    private String DueDate;
    private String SumInvestmentTargetType;
    private String OptionSumInvestmentTargetType;
    private String ExchangeSumInvestmentTargetType;
    private String OptionFee;
    private String OptionType;

    public InventoryBusinessDetailsAtTheEndOfThisMonthDTO() {
    }

    public InventoryBusinessDetailsAtTheEndOfThisMonthDTO(String nameOfSecuritiesCompany, String counterpartyName, String counterpartyProductName, String transactionConfirmationNumber, String typeOfTransactionConfirmation, String businessType, String notionalPrincipalAmount, String totalAmountOfNominalPrincipalAmount, String startingDay, String dueDate, String sumInvestmentTargetType, String optionSumInvestmentTargetType, String exchangeSumInvestmentTargetType, String optionFee, String optionType) {
        NameOfSecuritiesCompany = nameOfSecuritiesCompany;
        CounterpartyName = counterpartyName;
        CounterpartyProductName = counterpartyProductName;
        TransactionConfirmationNumber = transactionConfirmationNumber;
        TypeOfTransactionConfirmation = typeOfTransactionConfirmation;
        BusinessType = businessType;
        NotionalPrincipalAmount = notionalPrincipalAmount;
        TotalAmountOfNominalPrincipalAmount = totalAmountOfNominalPrincipalAmount;
        StartingDay = startingDay;
        DueDate = dueDate;
        SumInvestmentTargetType = sumInvestmentTargetType;
        OptionSumInvestmentTargetType = optionSumInvestmentTargetType;
        ExchangeSumInvestmentTargetType = exchangeSumInvestmentTargetType;
        OptionFee = optionFee;
        OptionType = optionType;
    }

    @JsonProperty("NameOfSecuritiesCompany")
    public String getNameOfSecuritiesCompany() {
        return NameOfSecuritiesCompany;
    }

    public void setNameOfSecuritiesCompany(String nameOfSecuritiesCompany) {
        NameOfSecuritiesCompany = nameOfSecuritiesCompany;
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

    @JsonProperty("TypeOfTransactionConfirmation")
    public String getTypeOfTransactionConfirmation() {
        return TypeOfTransactionConfirmation;
    }

    public void setTypeOfTransactionConfirmation(String typeOfTransactionConfirmation) {
        TypeOfTransactionConfirmation = typeOfTransactionConfirmation;
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

    @JsonProperty("SumInvestmentTargetType")
    public String getSumInvestmentTargetType() {
        return SumInvestmentTargetType;
    }

    public void setSumInvestmentTargetType(String sumInvestmentTargetType) {
        SumInvestmentTargetType = sumInvestmentTargetType;
    }

    @JsonProperty("OptionSumInvestmentTargetType")
    public String getOptionSumInvestmentTargetType() {
        return OptionSumInvestmentTargetType;
    }

    public void setOptionSumInvestmentTargetType(String optionSumInvestmentTargetType) {
        OptionSumInvestmentTargetType = optionSumInvestmentTargetType;
    }

    @JsonProperty("ExchangeSumInvestmentTargetType")
    public String getExchangeSumInvestmentTargetType() {
        return ExchangeSumInvestmentTargetType;
    }

    public void setExchangeSumInvestmentTargetType(String exchangeSumInvestmentTargetType) {
        ExchangeSumInvestmentTargetType = exchangeSumInvestmentTargetType;
    }

    @JsonProperty("OptionFee")
    public String getOptionFee() {
        return OptionFee;
    }

    public void setOptionFee(String optionFee) {
        OptionFee = optionFee;
    }

    @JsonProperty("OptionType")
    public String getOptionType() {
        return OptionType;
    }

    public void setOptionType(String optionType) {
        OptionType = optionType;
    }
}
