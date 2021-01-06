package tech.tongyu.core.dto.isda;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description ISDA
 */
@JsonPropertyOrder({"SecurityCompany","SecurityCompanyCode","CounterpartyName",
        "CounterpartyAllographProduct","BusinessType","DataTypeForBusinessType",
        "TradingPlaces","TransactionConfirmationNumber","InitialNotionalPrincipalAmount",
        "InvestmentTargetType","InvestmentTarget","UnderlyingCode",
        "NumberOfTargets","StartingDay","DueDate","NumberOfSharesInCirculation",
        "OutstandingSharesAccountingForStock","SubjectType","TargetTradingPlaces",
        "UnderlyingName","InvestmentTargetCode","PositionQuantity",
        "HedgeRatio","NumberOfOutstandingSharesOfStockTarget","OutstandingSharesOfInvestmentTarget"})
public class TargetCaseAndHedgeTupleDTO {

    private String SecurityCompany;
    private String SecurityCompanyCode;
    private String CounterpartyName;
    private String CounterpartyAllographProduct;
    private String BusinessType;
    private String DataTypeForBusinessType;
    private String TradingPlaces;
    private String TransactionConfirmationNumber;
    private String InitialNotionalPrincipalAmount;
    private String InvestmentTargetType;
    private String InvestmentTarget;
    private String UnderlyingCode;
    private String NumberOfTargets;
    private String StartingDay;
    private String DueDate;
    private String NumberOfSharesInCirculation;
    private String OutstandingSharesAccountingForStock;
    private String SubjectType;
    private String TargetTradingPlaces;
    private String UnderlyingName;
    private String InvestmentTargetCode;
    private String PositionQuantity;
    private String HedgeRatio;
    private String NumberOfOutstandingSharesOfStockTarget;
    private String OutstandingSharesOfInvestmentTarget;

    public TargetCaseAndHedgeTupleDTO() {
    }

    public TargetCaseAndHedgeTupleDTO(String securityCompany, String securityCompanyCode, String counterpartyName, String counterpartyAllographProduct, String businessType, String dataTypeForBusinessType, String tradingPlaces, String transactionConfirmationNumber, String initialNotionalPrincipalAmount, String investmentTargetType, String investmentTarget, String underlyingCode, String numberOfTargets, String startingDay, String dueDate, String numberOfSharesInCirculation, String outstandingSharesAccountingForStock, String subjectType, String targetTradingPlaces, String underlyingName, String investmentTargetCode, String positionQuantity, String hedgeRatio, String numberOfOutstandingSharesOfStockTarget, String outstandingSharesOfInvestmentTarget) {
        SecurityCompany = securityCompany;
        SecurityCompanyCode = securityCompanyCode;
        CounterpartyName = counterpartyName;
        CounterpartyAllographProduct = counterpartyAllographProduct;
        BusinessType = businessType;
        DataTypeForBusinessType = dataTypeForBusinessType;
        TradingPlaces = tradingPlaces;
        TransactionConfirmationNumber = transactionConfirmationNumber;
        InitialNotionalPrincipalAmount = initialNotionalPrincipalAmount;
        InvestmentTargetType = investmentTargetType;
        InvestmentTarget = investmentTarget;
        UnderlyingCode = underlyingCode;
        NumberOfTargets = numberOfTargets;
        StartingDay = startingDay;
        DueDate = dueDate;
        NumberOfSharesInCirculation = numberOfSharesInCirculation;
        OutstandingSharesAccountingForStock = outstandingSharesAccountingForStock;
        SubjectType = subjectType;
        TargetTradingPlaces = targetTradingPlaces;
        UnderlyingName = underlyingName;
        InvestmentTargetCode = investmentTargetCode;
        PositionQuantity = positionQuantity;
        HedgeRatio = hedgeRatio;
        NumberOfOutstandingSharesOfStockTarget = numberOfOutstandingSharesOfStockTarget;
        OutstandingSharesOfInvestmentTarget = outstandingSharesOfInvestmentTarget;
    }

    @JsonProperty("SecurityCompany")
    public String getSecurityCompany() {
        return SecurityCompany;
    }

    public void setSecurityCompany(String securityCompany) {
        SecurityCompany = securityCompany;
    }

    @JsonProperty("SecurityCompanyCode")
    public String getSecurityCompanyCode() {
        return SecurityCompanyCode;
    }

    public void setSecurityCompanyCode(String securityCompanyCode) {
        SecurityCompanyCode = securityCompanyCode;
    }

    @JsonProperty("CounterpartyName")
    public String getCounterpartyName() {
        return CounterpartyName;
    }

    public void setCounterpartyName(String counterpartyName) {
        CounterpartyName = counterpartyName;
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

    @JsonProperty("DataTypeForBusinessType")
    public String getDataTypeForBusinessType() {
        return DataTypeForBusinessType;
    }

    public void setDataTypeForBusinessType(String dataTypeForBusinessType) {
        DataTypeForBusinessType = dataTypeForBusinessType;
    }

    @JsonProperty("TradingPlaces")
    public String getTradingPlaces() {
        return TradingPlaces;
    }

    public void setTradingPlaces(String tradingPlaces) {
        TradingPlaces = tradingPlaces;
    }

    @JsonProperty("TransactionConfirmationNumber")
    public String getTransactionConfirmationNumber() {
        return TransactionConfirmationNumber;
    }

    public void setTransactionConfirmationNumber(String transactionConfirmationNumber) {
        TransactionConfirmationNumber = transactionConfirmationNumber;
    }

    @JsonProperty("InitialNotionalPrincipalAmount")
    public String getInitialNotionalPrincipalAmount() {
        return InitialNotionalPrincipalAmount;
    }

    public void setInitialNotionalPrincipalAmount(String initialNotionalPrincipalAmount) {
        InitialNotionalPrincipalAmount = initialNotionalPrincipalAmount;
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

    @JsonProperty("UnderlyingCode")
    public String getUnderlyingCode() {
        return UnderlyingCode;
    }

    public void setUnderlyingCode(String underlyingCode) {
        UnderlyingCode = underlyingCode;
    }

    @JsonProperty("NumberOfTargets")
    public String getNumberOfTargets() {
        return NumberOfTargets;
    }

    public void setNumberOfTargets(String numberOfTargets) {
        NumberOfTargets = numberOfTargets;
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

    @JsonProperty("NumberOfSharesInCirculation")
    public String getNumberOfSharesInCirculation() {
        return NumberOfSharesInCirculation;
    }

    public void setNumberOfSharesInCirculation(String numberOfSharesInCirculation) {
        NumberOfSharesInCirculation = numberOfSharesInCirculation;
    }

    @JsonProperty("OutstandingSharesAccountingForStock")
    public String getOutstandingSharesAccountingForStock() {
        return OutstandingSharesAccountingForStock;
    }

    public void setOutstandingSharesAccountingForStock(String outstandingSharesAccountingForStock) {
        OutstandingSharesAccountingForStock = outstandingSharesAccountingForStock;
    }

    @JsonProperty("SubjectType")
    public String getSubjectType() {
        return SubjectType;
    }

    public void setSubjectType(String subjectType) {
        SubjectType = subjectType;
    }

    @JsonProperty("TargetTradingPlaces")
    public String getTargetTradingPlaces() {
        return TargetTradingPlaces;
    }

    public void setTargetTradingPlaces(String targetTradingPlaces) {
        TargetTradingPlaces = targetTradingPlaces;
    }

    @JsonProperty("UnderlyingName")
    public String getUnderlyingName() {
        return UnderlyingName;
    }

    public void setUnderlyingName(String underlyingName) {
        UnderlyingName = underlyingName;
    }

    @JsonProperty("InvestmentTargetCode")
    public String getInvestmentTargetCode() {
        return InvestmentTargetCode;
    }

    public void setInvestmentTargetCode(String investmentTargetCode) {
        InvestmentTargetCode = investmentTargetCode;
    }

    @JsonProperty("PositionQuantity")
    public String getPositionQuantity() {
        return PositionQuantity;
    }

    public void setPositionQuantity(String positionQuantity) {
        PositionQuantity = positionQuantity;
    }

    @JsonProperty("HedgeRatio")
    public String getHedgeRatio() {
        return HedgeRatio;
    }

    public void setHedgeRatio(String hedgeRatio) {
        HedgeRatio = hedgeRatio;
    }

    @JsonProperty("NumberOfOutstandingSharesOfStockTarget")
    public String getNumberOfOutstandingSharesOfStockTarget() {
        return NumberOfOutstandingSharesOfStockTarget;
    }

    public void setNumberOfOutstandingSharesOfStockTarget(String numberOfOutstandingSharesOfStockTarget) {
        NumberOfOutstandingSharesOfStockTarget = numberOfOutstandingSharesOfStockTarget;
    }

    @JsonProperty("OutstandingSharesOfInvestmentTarget")
    public String getOutstandingSharesOfInvestmentTarget() {
        return OutstandingSharesOfInvestmentTarget;
    }

    public void setOutstandingSharesOfInvestmentTarget(String outstandingSharesOfInvestmentTarget) {
        OutstandingSharesOfInvestmentTarget = outstandingSharesOfInvestmentTarget;
    }
}
