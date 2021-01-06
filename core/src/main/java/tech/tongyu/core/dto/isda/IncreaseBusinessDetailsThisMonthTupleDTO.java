package tech.tongyu.core.dto.isda;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.math.BigDecimal;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description ISDA
 */
@JsonPropertyOrder({"SecurityCompany", "CounterpartyName", "TransactionConfirmationNumber", "TradeConfirmationsType",
        "BusinessType", "NotionalPrincipalAmount", "StartingDay", "DueDate", "TradingPlaces", "InvestmentTargetType"})
public class IncreaseBusinessDetailsThisMonthTupleDTO {

    private String SecurityCompany;
    private String CounterpartyName;
    private String TransactionConfirmationNumber;
    private String TradeConfirmationsType;
    private String BusinessType;
    private String NotionalPrincipalAmount;
    private String StartingDay;
    private String DueDate;
    private String TradingPlaces;
    private String InvestmentTargetType;

    public IncreaseBusinessDetailsThisMonthTupleDTO() {
    }

    public IncreaseBusinessDetailsThisMonthTupleDTO(String securityCompany, String counterpartyName, String transactionConfirmationNumber, String tradeConfirmationsType, String businessType, String notionalPrincipalAmount, String startingDay, String dueDate, String tradingPlaces, String investmentTargetType) {
        SecurityCompany = securityCompany;
        CounterpartyName = counterpartyName;
        TransactionConfirmationNumber = transactionConfirmationNumber;
        TradeConfirmationsType = tradeConfirmationsType;
        BusinessType = businessType;
        NotionalPrincipalAmount = notionalPrincipalAmount;
        StartingDay = startingDay;
        DueDate = dueDate;
        TradingPlaces = tradingPlaces;
        InvestmentTargetType = investmentTargetType;
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

    @JsonProperty("TradingPlaces")
    public String getTradingPlaces() {
        return TradingPlaces;
    }

    public void setTradingPlaces(String tradingPlaces) {
        TradingPlaces = tradingPlaces;
    }

    @JsonProperty("InvestmentTargetType")
    public String getInvestmentTargetType() {
        return InvestmentTargetType;
    }

    public void setInvestmentTargetType(String investmentTargetType) {
        InvestmentTargetType = investmentTargetType;
    }
}
