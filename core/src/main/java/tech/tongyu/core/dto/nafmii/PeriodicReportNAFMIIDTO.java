package tech.tongyu.core.dto.nafmii;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description NAFMII
 */
@JsonPropertyOrder({"ExceID", "BizID", "Year", "Month",
        "MainAgreementLastMonthAccumulatedThisYear", "MainAgreementAddedThisMonth",
        "MainAgreementAccumulatedThisYear", "MainAgreementValidedAtEndOfThisMonth",
        "SupplementalAgreementLastMonthAccumulatedThisYear", "SupplementalAgreementAddedThisMonth",
        "SupplementalAgreementAccumulatedThisYear", "SupplementalAgreementValidedAtTheEndOfThisMonth",
        "PerformanceGuaranteeAgreementLastMonthAccumulatedThisYear", "PerformanceGuaranteeAgreementAddedThisMonth",
        "PerformanceGuaranteeAgreementAccumulatedThisYear", "PerformanceGuaranteeAgreementValidedAtEndOfThisMonth",
        "TransactionConfirmationLastMonthAccumulatedThisYear", "TransactionConfirmationAddedThisMonth",
        "TransactionConfirmationBookAccumulatedThisYear", "TransactionConfirmationValidedAtEndOfThisMonth",
        "NominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth", "NominalPrincipalRateIncreasesThisMonth",
        "NominalPrincipalRateIsSettledThisMonth", "NominalPrincipalRateRemainsTradedAtTheEndOfThisMonth",
        "NominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions", "ContractsInterestRateTradedAtTheBeginningOfThisMonth",
        "NumberOfContractedInterestRatesThisMonthToAddTransactions", "AmountOfInterestInTheContractIsSettledThisMonth",
        "ContractInterestRatesRemainTradedAtTheEndOfThisMonth", "ContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions",
        "NominalPrincipalGoldTradedAtTheBeginningOfThisMonth", "NominalGoldThisMonthToAddTransactions",
        "TheNominalGoldIsTradingThisMonth", "NominalPrincipalGoldIsTradedAtTheEndOfThisMonth",
        "NominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction", "TheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth",
        "TheNumberOfContractsGoldThisMonthToAddTransactions", "TheNumberOfContractsIsGoldThisMonth",
        "TheNumberOfContractsIsGoldAtTheEndOfThisMonth", "TheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction",
        "NominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth", "NominalPrincipalForeignExchangeThisMonthToAddTransactions",
        "TheNominalPrincipalForeignExchangeSettledThisMonth", "NominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth",
        "NominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction", "ContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth",
        "ContractNumberForeignExchangeThisMonthNewTransaction", "TheNumberOfContractsForForeignExchangeTransactionsThisMonth",
        "ContractsForeignExchangeIsTradedAtTheEndOfThisMonth", "NumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction",
        "TheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth", "NominalPrincipalOtherNewTransactionsThisMonth",
        "TheNameOfThePrincipalOtherTransactionsThisMonth", "NominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth",
        "NominalPrincipalOtherTransactionsUpToTheEndOfThisMonth", "TheNumberOfContractsIsTheBeginningOfThisMonth",
        "ContractNumberOtherNewTransactionsThisMonth", "TheNumberOfContractsOtherTransactionsThisMonth",
        "ContractsOthersRemainTradedAtTheEndOfThisMonth", "NumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth",
        "TheNominalPrincipalIsTradedAtTheBeginningOfThisMonth", "NominalPrincipalTotalNewTransactionsThisMonth",
        "NominalPrincipalTotalSettledThisMonth", "TheNominalPrincipalIsTradedAtTheEndOfThisMonth",
        "NominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth", "TheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth",
        "TheTotalNumberOfContractsIsAddedThisMonth", "TheTotalNumberOfContractsIsSettledThisMonth",
        "TheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth", "TheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction",
        "InterestRateSwapDetails", "ScheduleOfOtherTransactions"})
public class PeriodicReportNAFMIIDTO extends RequestCommon {

    private String Year;
    private String Month;
    private String MainAgreementLastMonthAccumulatedThisYear;
    private String MainAgreementAddedThisMonth;

    private String MainAgreementAccumulatedThisYear;
    private String MainAgreementValidedAtEndOfThisMonth;
    private String SupplementalAgreementLastMonthAccumulatedThisYear;
    private String SupplementalAgreementAddedThisMonth;
    private String SupplementalAgreementAccumulatedThisYear;

    private String SupplementalAgreementValidedAtTheEndOfThisMonth;
    private String PerformanceGuaranteeAgreementLastMonthAccumulatedThisYear;
    private String PerformanceGuaranteeAgreementAddedThisMonth;
    private String PerformanceGuaranteeAgreementAccumulatedThisYear;
    private String PerformanceGuaranteeAgreementValidedAtEndOfThisMonth;

    private String TransactionConfirmationLastMonthAccumulatedThisYear;
    private String TransactionConfirmationAddedThisMonth;
    private String TransactionConfirmationBookAccumulatedThisYear;
    private String TransactionConfirmationValidedAtEndOfThisMonth;
    private String NominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth;

    private String NominalPrincipalRateIncreasesThisMonth;
    private String NominalPrincipalRateIsSettledThisMonth;
    private String NominalPrincipalRateRemainsTradedAtTheEndOfThisMonth;
    private String NominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions;
    private String ContractsInterestRateTradedAtTheBeginningOfThisMonth;

    private String NumberOfContractedInterestRatesThisMonthToAddTransactions;
    private String AmountOfInterestInTheContractIsSettledThisMonth;
    private String ContractInterestRatesRemainTradedAtTheEndOfThisMonth;
    private String ContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions;
    private String NominalPrincipalGoldTradedAtTheBeginningOfThisMonth;

    private String NominalGoldThisMonthToAddTransactions;
    private String TheNominalGoldIsTradingThisMonth;
    private String NominalPrincipalGoldIsTradedAtTheEndOfThisMonth;
    private String NominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction;
    private String TheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth;

    private String TheNumberOfContractsGoldThisMonthToAddTransactions;
    private String TheNumberOfContractsIsGoldThisMonth;
    private String TheNumberOfContractsIsGoldAtTheEndOfThisMonth;
    private String TheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction;
    private String NominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth;

    private String NominalPrincipalForeignExchangeThisMonthToAddTransactions;
    private String TheNominalPrincipalForeignExchangeSettledThisMonth;
    private String NominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth;
    private String NominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction;
    private String ContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth;

    private String ContractNumberForeignExchangeThisMonthNewTransaction;
    private String TheNumberOfContractsForForeignExchangeTransactionsThisMonth;
    private String ContractsForeignExchangeIsTradedAtTheEndOfThisMonth;
    private String NumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction;
    private String TheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth;

    private String NominalPrincipalOtherNewTransactionsThisMonth;
    private String TheNameOfThePrincipalOtherTransactionsThisMonth;
    private String NominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth;
    private String NominalPrincipalOtherTransactionsUpToTheEndOfThisMonth;
    private String TheNumberOfContractsIsTheBeginningOfThisMonth;

    private String ContractNumberOtherNewTransactionsThisMonth;
    private String TheNumberOfContractsOtherTransactionsThisMonth;
    private String ContractsOthersRemainTradedAtTheEndOfThisMonth;
    private String NumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth;
    private String TheNominalPrincipalIsTradedAtTheBeginningOfThisMonth;

    private String NominalPrincipalTotalNewTransactionsThisMonth;
    private String NominalPrincipalTotalSettledThisMonth;
    private String TheNominalPrincipalIsTradedAtTheEndOfThisMonth;
    private String NominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth;
    private String TheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth;

    private String TheTotalNumberOfContractsIsAddedThisMonth;
    private String TheTotalNumberOfContractsIsSettledThisMonth;
    private String TheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth;
    private String TheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction;
    private List<InterestRateSwapDetailsDTO> InterestRateSwapDetails;
    private List<ScheduleOfOtherTransactionsDTO> ScheduleOfOtherTransactions;

    public PeriodicReportNAFMIIDTO() {
    }

    public PeriodicReportNAFMIIDTO(String year, String month, String mainAgreementLastMonthAccumulatedThisYear, String mainAgreementAddedThisMonth, String mainAgreementAccumulatedThisYear, String mainAgreementValidedAtEndOfThisMonth, String supplementalAgreementLastMonthAccumulatedThisYear, String supplementalAgreementAddedThisMonth, String supplementalAgreementAccumulatedThisYear, String supplementalAgreementValidedAtTheEndOfThisMonth, String performanceGuaranteeAgreementLastMonthAccumulatedThisYear, String performanceGuaranteeAgreementAddedThisMonth, String performanceGuaranteeAgreementAccumulatedThisYear, String performanceGuaranteeAgreementValidedAtEndOfThisMonth, String transactionConfirmationLastMonthAccumulatedThisYear, String transactionConfirmationAddedThisMonth, String transactionConfirmationBookAccumulatedThisYear, String transactionConfirmationValidedAtEndOfThisMonth, String nominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth, String nominalPrincipalRateIncreasesThisMonth, String nominalPrincipalRateIsSettledThisMonth, String nominalPrincipalRateRemainsTradedAtTheEndOfThisMonth, String nominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions, String contractsInterestRateTradedAtTheBeginningOfThisMonth, String numberOfContractedInterestRatesThisMonthToAddTransactions, String amountOfInterestInTheContractIsSettledThisMonth, String contractInterestRatesRemainTradedAtTheEndOfThisMonth, String contractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions, String nominalPrincipalGoldTradedAtTheBeginningOfThisMonth, String nominalGoldThisMonthToAddTransactions, String theNominalGoldIsTradingThisMonth, String nominalPrincipalGoldIsTradedAtTheEndOfThisMonth, String nominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction, String theNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth, String theNumberOfContractsGoldThisMonthToAddTransactions, String theNumberOfContractsIsGoldThisMonth, String theNumberOfContractsIsGoldAtTheEndOfThisMonth, String theNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction, String nominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth, String nominalPrincipalForeignExchangeThisMonthToAddTransactions, String theNominalPrincipalForeignExchangeSettledThisMonth, String nominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth, String nominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction, String contractsForeignExchangeIsTradedAtTheBeginningOfThisMonth, String contractNumberForeignExchangeThisMonthNewTransaction, String theNumberOfContractsForForeignExchangeTransactionsThisMonth, String contractsForeignExchangeIsTradedAtTheEndOfThisMonth, String numberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction, String theNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth, String nominalPrincipalOtherNewTransactionsThisMonth, String theNameOfThePrincipalOtherTransactionsThisMonth, String nominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth, String nominalPrincipalOtherTransactionsUpToTheEndOfThisMonth, String theNumberOfContractsIsTheBeginningOfThisMonth, String contractNumberOtherNewTransactionsThisMonth, String theNumberOfContractsOtherTransactionsThisMonth, String contractsOthersRemainTradedAtTheEndOfThisMonth, String numberOfContractsOtherTransactionsAsOfTheEndOfThisMonth, String theNominalPrincipalIsTradedAtTheBeginningOfThisMonth, String nominalPrincipalTotalNewTransactionsThisMonth, String nominalPrincipalTotalSettledThisMonth, String theNominalPrincipalIsTradedAtTheEndOfThisMonth, String nominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth, String theTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth, String theTotalNumberOfContractsIsAddedThisMonth, String theTotalNumberOfContractsIsSettledThisMonth, String theTotalNumberOfContractsIsTradedAtTheEndOfThisMonth, String theTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction, List<InterestRateSwapDetailsDTO> interestRateSwapDetails, List<ScheduleOfOtherTransactionsDTO> scheduleOfOtherTransactions) {
        Year = year;
        Month = month;
        MainAgreementLastMonthAccumulatedThisYear = mainAgreementLastMonthAccumulatedThisYear;
        MainAgreementAddedThisMonth = mainAgreementAddedThisMonth;
        MainAgreementAccumulatedThisYear = mainAgreementAccumulatedThisYear;
        MainAgreementValidedAtEndOfThisMonth = mainAgreementValidedAtEndOfThisMonth;
        SupplementalAgreementLastMonthAccumulatedThisYear = supplementalAgreementLastMonthAccumulatedThisYear;
        SupplementalAgreementAddedThisMonth = supplementalAgreementAddedThisMonth;
        SupplementalAgreementAccumulatedThisYear = supplementalAgreementAccumulatedThisYear;
        SupplementalAgreementValidedAtTheEndOfThisMonth = supplementalAgreementValidedAtTheEndOfThisMonth;
        PerformanceGuaranteeAgreementLastMonthAccumulatedThisYear = performanceGuaranteeAgreementLastMonthAccumulatedThisYear;
        PerformanceGuaranteeAgreementAddedThisMonth = performanceGuaranteeAgreementAddedThisMonth;
        PerformanceGuaranteeAgreementAccumulatedThisYear = performanceGuaranteeAgreementAccumulatedThisYear;
        PerformanceGuaranteeAgreementValidedAtEndOfThisMonth = performanceGuaranteeAgreementValidedAtEndOfThisMonth;
        TransactionConfirmationLastMonthAccumulatedThisYear = transactionConfirmationLastMonthAccumulatedThisYear;
        TransactionConfirmationAddedThisMonth = transactionConfirmationAddedThisMonth;
        TransactionConfirmationBookAccumulatedThisYear = transactionConfirmationBookAccumulatedThisYear;
        TransactionConfirmationValidedAtEndOfThisMonth = transactionConfirmationValidedAtEndOfThisMonth;
        NominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth = nominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth;
        NominalPrincipalRateIncreasesThisMonth = nominalPrincipalRateIncreasesThisMonth;
        NominalPrincipalRateIsSettledThisMonth = nominalPrincipalRateIsSettledThisMonth;
        NominalPrincipalRateRemainsTradedAtTheEndOfThisMonth = nominalPrincipalRateRemainsTradedAtTheEndOfThisMonth;
        NominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions = nominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions;
        ContractsInterestRateTradedAtTheBeginningOfThisMonth = contractsInterestRateTradedAtTheBeginningOfThisMonth;
        NumberOfContractedInterestRatesThisMonthToAddTransactions = numberOfContractedInterestRatesThisMonthToAddTransactions;
        AmountOfInterestInTheContractIsSettledThisMonth = amountOfInterestInTheContractIsSettledThisMonth;
        ContractInterestRatesRemainTradedAtTheEndOfThisMonth = contractInterestRatesRemainTradedAtTheEndOfThisMonth;
        ContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions = contractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions;
        NominalPrincipalGoldTradedAtTheBeginningOfThisMonth = nominalPrincipalGoldTradedAtTheBeginningOfThisMonth;
        NominalGoldThisMonthToAddTransactions = nominalGoldThisMonthToAddTransactions;
        TheNominalGoldIsTradingThisMonth = theNominalGoldIsTradingThisMonth;
        NominalPrincipalGoldIsTradedAtTheEndOfThisMonth = nominalPrincipalGoldIsTradedAtTheEndOfThisMonth;
        NominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction = nominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction;
        TheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth = theNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth;
        TheNumberOfContractsGoldThisMonthToAddTransactions = theNumberOfContractsGoldThisMonthToAddTransactions;
        TheNumberOfContractsIsGoldThisMonth = theNumberOfContractsIsGoldThisMonth;
        TheNumberOfContractsIsGoldAtTheEndOfThisMonth = theNumberOfContractsIsGoldAtTheEndOfThisMonth;
        TheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction = theNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction;
        NominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth = nominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth;
        NominalPrincipalForeignExchangeThisMonthToAddTransactions = nominalPrincipalForeignExchangeThisMonthToAddTransactions;
        TheNominalPrincipalForeignExchangeSettledThisMonth = theNominalPrincipalForeignExchangeSettledThisMonth;
        NominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth = nominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth;
        NominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction = nominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction;
        ContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth = contractsForeignExchangeIsTradedAtTheBeginningOfThisMonth;
        ContractNumberForeignExchangeThisMonthNewTransaction = contractNumberForeignExchangeThisMonthNewTransaction;
        TheNumberOfContractsForForeignExchangeTransactionsThisMonth = theNumberOfContractsForForeignExchangeTransactionsThisMonth;
        ContractsForeignExchangeIsTradedAtTheEndOfThisMonth = contractsForeignExchangeIsTradedAtTheEndOfThisMonth;
        NumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction = numberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction;
        TheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth = theNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth;
        NominalPrincipalOtherNewTransactionsThisMonth = nominalPrincipalOtherNewTransactionsThisMonth;
        TheNameOfThePrincipalOtherTransactionsThisMonth = theNameOfThePrincipalOtherTransactionsThisMonth;
        NominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth = nominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth;
        NominalPrincipalOtherTransactionsUpToTheEndOfThisMonth = nominalPrincipalOtherTransactionsUpToTheEndOfThisMonth;
        TheNumberOfContractsIsTheBeginningOfThisMonth = theNumberOfContractsIsTheBeginningOfThisMonth;
        ContractNumberOtherNewTransactionsThisMonth = contractNumberOtherNewTransactionsThisMonth;
        TheNumberOfContractsOtherTransactionsThisMonth = theNumberOfContractsOtherTransactionsThisMonth;
        ContractsOthersRemainTradedAtTheEndOfThisMonth = contractsOthersRemainTradedAtTheEndOfThisMonth;
        NumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth = numberOfContractsOtherTransactionsAsOfTheEndOfThisMonth;
        TheNominalPrincipalIsTradedAtTheBeginningOfThisMonth = theNominalPrincipalIsTradedAtTheBeginningOfThisMonth;
        NominalPrincipalTotalNewTransactionsThisMonth = nominalPrincipalTotalNewTransactionsThisMonth;
        NominalPrincipalTotalSettledThisMonth = nominalPrincipalTotalSettledThisMonth;
        TheNominalPrincipalIsTradedAtTheEndOfThisMonth = theNominalPrincipalIsTradedAtTheEndOfThisMonth;
        NominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth = nominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth;
        TheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth = theTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth;
        TheTotalNumberOfContractsIsAddedThisMonth = theTotalNumberOfContractsIsAddedThisMonth;
        TheTotalNumberOfContractsIsSettledThisMonth = theTotalNumberOfContractsIsSettledThisMonth;
        TheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth = theTotalNumberOfContractsIsTradedAtTheEndOfThisMonth;
        TheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction = theTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction;
        InterestRateSwapDetails = interestRateSwapDetails;
        ScheduleOfOtherTransactions = scheduleOfOtherTransactions;
    }

    public static PeriodicReportNAFMIIDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static PeriodicReportNAFMIIDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        PeriodicReportNAFMIIDTO dto = JsonUtils.mapper.convertValue(json, PeriodicReportNAFMIIDTO.class);
        return dto;
    }

    public LinkedHashMap<String, Object> toLinkedHashMap() {
        return JsonUtils.fromJsonToLinkedHashMap(JsonUtils.toJson(this));
    }

    @JsonProperty("Year")
    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    @JsonProperty("Month")
    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    @JsonProperty("MainAgreementLastMonthAccumulatedThisYear")
    public String getMainAgreementLastMonthAccumulatedThisYear() {
        return MainAgreementLastMonthAccumulatedThisYear;
    }

    public void setMainAgreementLastMonthAccumulatedThisYear(String mainAgreementLastMonthAccumulatedThisYear) {
        MainAgreementLastMonthAccumulatedThisYear = mainAgreementLastMonthAccumulatedThisYear;
    }

    @JsonProperty("MainAgreementAddedThisMonth")
    public String getMainAgreementAddedThisMonth() {
        return MainAgreementAddedThisMonth;
    }

    public void setMainAgreementAddedThisMonth(String mainAgreementAddedThisMonth) {
        MainAgreementAddedThisMonth = mainAgreementAddedThisMonth;
    }

    @JsonProperty("MainAgreementAccumulatedThisYear")
    public String getMainAgreementAccumulatedThisYear() {
        return MainAgreementAccumulatedThisYear;
    }

    public void setMainAgreementAccumulatedThisYear(String mainAgreementAccumulatedThisYear) {
        MainAgreementAccumulatedThisYear = mainAgreementAccumulatedThisYear;
    }

    @JsonProperty("MainAgreementValidedAtEndOfThisMonth")
    public String getMainAgreementValidedAtEndOfThisMonth() {
        return MainAgreementValidedAtEndOfThisMonth;
    }

    public void setMainAgreementValidedAtEndOfThisMonth(String mainAgreementValidedAtEndOfThisMonth) {
        MainAgreementValidedAtEndOfThisMonth = mainAgreementValidedAtEndOfThisMonth;
    }

    @JsonProperty("SupplementalAgreementLastMonthAccumulatedThisYear")
    public String getSupplementalAgreementLastMonthAccumulatedThisYear() {
        return SupplementalAgreementLastMonthAccumulatedThisYear;
    }

    public void setSupplementalAgreementLastMonthAccumulatedThisYear(String supplementalAgreementLastMonthAccumulatedThisYear) {
        SupplementalAgreementLastMonthAccumulatedThisYear = supplementalAgreementLastMonthAccumulatedThisYear;
    }

    @JsonProperty("SupplementalAgreementAddedThisMonth")
    public String getSupplementalAgreementAddedThisMonth() {
        return SupplementalAgreementAddedThisMonth;
    }

    public void setSupplementalAgreementAddedThisMonth(String supplementalAgreementAddedThisMonth) {
        SupplementalAgreementAddedThisMonth = supplementalAgreementAddedThisMonth;
    }

    @JsonProperty("SupplementalAgreementAccumulatedThisYear")
    public String getSupplementalAgreementAccumulatedThisYear() {
        return SupplementalAgreementAccumulatedThisYear;
    }

    public void setSupplementalAgreementAccumulatedThisYear(String supplementalAgreementAccumulatedThisYear) {
        SupplementalAgreementAccumulatedThisYear = supplementalAgreementAccumulatedThisYear;
    }

    @JsonProperty("SupplementalAgreementValidedAtTheEndOfThisMonth")
    public String getSupplementalAgreementValidedAtTheEndOfThisMonth() {
        return SupplementalAgreementValidedAtTheEndOfThisMonth;
    }

    public void setSupplementalAgreementValidedAtTheEndOfThisMonth(String supplementalAgreementValidedAtTheEndOfThisMonth) {
        SupplementalAgreementValidedAtTheEndOfThisMonth = supplementalAgreementValidedAtTheEndOfThisMonth;
    }

    @JsonProperty("PerformanceGuaranteeAgreementLastMonthAccumulatedThisYear")
    public String getPerformanceGuaranteeAgreementLastMonthAccumulatedThisYear() {
        return PerformanceGuaranteeAgreementLastMonthAccumulatedThisYear;
    }

    public void setPerformanceGuaranteeAgreementLastMonthAccumulatedThisYear(String performanceGuaranteeAgreementLastMonthAccumulatedThisYear) {
        PerformanceGuaranteeAgreementLastMonthAccumulatedThisYear = performanceGuaranteeAgreementLastMonthAccumulatedThisYear;
    }

    @JsonProperty("PerformanceGuaranteeAgreementAddedThisMonth")
    public String getPerformanceGuaranteeAgreementAddedThisMonth() {
        return PerformanceGuaranteeAgreementAddedThisMonth;
    }

    public void setPerformanceGuaranteeAgreementAddedThisMonth(String performanceGuaranteeAgreementAddedThisMonth) {
        PerformanceGuaranteeAgreementAddedThisMonth = performanceGuaranteeAgreementAddedThisMonth;
    }

    @JsonProperty("PerformanceGuaranteeAgreementAccumulatedThisYear")
    public String getPerformanceGuaranteeAgreementAccumulatedThisYear() {
        return PerformanceGuaranteeAgreementAccumulatedThisYear;
    }

    public void setPerformanceGuaranteeAgreementAccumulatedThisYear(String performanceGuaranteeAgreementAccumulatedThisYear) {
        PerformanceGuaranteeAgreementAccumulatedThisYear = performanceGuaranteeAgreementAccumulatedThisYear;
    }

    @JsonProperty("PerformanceGuaranteeAgreementValidedAtEndOfThisMonth")
    public String getPerformanceGuaranteeAgreementValidedAtEndOfThisMonth() {
        return PerformanceGuaranteeAgreementValidedAtEndOfThisMonth;
    }

    public void setPerformanceGuaranteeAgreementValidedAtEndOfThisMonth(String performanceGuaranteeAgreementValidedAtEndOfThisMonth) {
        PerformanceGuaranteeAgreementValidedAtEndOfThisMonth = performanceGuaranteeAgreementValidedAtEndOfThisMonth;
    }

    @JsonProperty("TransactionConfirmationLastMonthAccumulatedThisYear")
    public String getTransactionConfirmationLastMonthAccumulatedThisYear() {
        return TransactionConfirmationLastMonthAccumulatedThisYear;
    }

    public void setTransactionConfirmationLastMonthAccumulatedThisYear(String transactionConfirmationLastMonthAccumulatedThisYear) {
        TransactionConfirmationLastMonthAccumulatedThisYear = transactionConfirmationLastMonthAccumulatedThisYear;
    }

    @JsonProperty("TransactionConfirmationAddedThisMonth")
    public String getTransactionConfirmationAddedThisMonth() {
        return TransactionConfirmationAddedThisMonth;
    }

    public void setTransactionConfirmationAddedThisMonth(String transactionConfirmationAddedThisMonth) {
        TransactionConfirmationAddedThisMonth = transactionConfirmationAddedThisMonth;
    }

    @JsonProperty("TransactionConfirmationBookAccumulatedThisYear")
    public String getTransactionConfirmationBookAccumulatedThisYear() {
        return TransactionConfirmationBookAccumulatedThisYear;
    }

    public void setTransactionConfirmationBookAccumulatedThisYear(String transactionConfirmationBookAccumulatedThisYear) {
        TransactionConfirmationBookAccumulatedThisYear = transactionConfirmationBookAccumulatedThisYear;
    }

    @JsonProperty("TransactionConfirmationValidedAtEndOfThisMonth")
    public String getTransactionConfirmationValidedAtEndOfThisMonth() {
        return TransactionConfirmationValidedAtEndOfThisMonth;
    }

    public void setTransactionConfirmationValidedAtEndOfThisMonth(String transactionConfirmationValidedAtEndOfThisMonth) {
        TransactionConfirmationValidedAtEndOfThisMonth = transactionConfirmationValidedAtEndOfThisMonth;
    }

    @JsonProperty("NominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth")
    public String getNominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth() {
        return NominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth;
    }

    public void setNominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth(String nominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth) {
        NominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth = nominalPrincipalInterestRateTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("NominalPrincipalRateIncreasesThisMonth")
    public String getNominalPrincipalRateIncreasesThisMonth() {
        return NominalPrincipalRateIncreasesThisMonth;
    }

    public void setNominalPrincipalRateIncreasesThisMonth(String nominalPrincipalRateIncreasesThisMonth) {
        NominalPrincipalRateIncreasesThisMonth = nominalPrincipalRateIncreasesThisMonth;
    }

    @JsonProperty("NominalPrincipalRateIsSettledThisMonth")
    public String getNominalPrincipalRateIsSettledThisMonth() {
        return NominalPrincipalRateIsSettledThisMonth;
    }

    public void setNominalPrincipalRateIsSettledThisMonth(String nominalPrincipalRateIsSettledThisMonth) {
        NominalPrincipalRateIsSettledThisMonth = nominalPrincipalRateIsSettledThisMonth;
    }

    @JsonProperty("NominalPrincipalRateRemainsTradedAtTheEndOfThisMonth")
    public String getNominalPrincipalRateRemainsTradedAtTheEndOfThisMonth() {
        return NominalPrincipalRateRemainsTradedAtTheEndOfThisMonth;
    }

    public void setNominalPrincipalRateRemainsTradedAtTheEndOfThisMonth(String nominalPrincipalRateRemainsTradedAtTheEndOfThisMonth) {
        NominalPrincipalRateRemainsTradedAtTheEndOfThisMonth = nominalPrincipalRateRemainsTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("NominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions")
    public String getNominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions() {
        return NominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions;
    }

    public void setNominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions(String nominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions) {
        NominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions = nominalPrincipalRateAsOfTheEndOfThisMonthToAddTransactions;
    }

    @JsonProperty("ContractsInterestRateTradedAtTheBeginningOfThisMonth")
    public String getContractsInterestRateTradedAtTheBeginningOfThisMonth() {
        return ContractsInterestRateTradedAtTheBeginningOfThisMonth;
    }

    public void setContractsInterestRateTradedAtTheBeginningOfThisMonth(String contractsInterestRateTradedAtTheBeginningOfThisMonth) {
        ContractsInterestRateTradedAtTheBeginningOfThisMonth = contractsInterestRateTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("NumberOfContractedInterestRatesThisMonthToAddTransactions")
    public String getNumberOfContractedInterestRatesThisMonthToAddTransactions() {
        return NumberOfContractedInterestRatesThisMonthToAddTransactions;
    }

    public void setNumberOfContractedInterestRatesThisMonthToAddTransactions(String numberOfContractedInterestRatesThisMonthToAddTransactions) {
        NumberOfContractedInterestRatesThisMonthToAddTransactions = numberOfContractedInterestRatesThisMonthToAddTransactions;
    }

    @JsonProperty("AmountOfInterestInTheContractIsSettledThisMonth")
    public String getAmountOfInterestInTheContractIsSettledThisMonth() {
        return AmountOfInterestInTheContractIsSettledThisMonth;
    }

    public void setAmountOfInterestInTheContractIsSettledThisMonth(String amountOfInterestInTheContractIsSettledThisMonth) {
        AmountOfInterestInTheContractIsSettledThisMonth = amountOfInterestInTheContractIsSettledThisMonth;
    }

    @JsonProperty("ContractInterestRatesRemainTradedAtTheEndOfThisMonth")
    public String getContractInterestRatesRemainTradedAtTheEndOfThisMonth() {
        return ContractInterestRatesRemainTradedAtTheEndOfThisMonth;
    }

    public void setContractInterestRatesRemainTradedAtTheEndOfThisMonth(String contractInterestRatesRemainTradedAtTheEndOfThisMonth) {
        ContractInterestRatesRemainTradedAtTheEndOfThisMonth = contractInterestRatesRemainTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("ContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions")
    public String getContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions() {
        return ContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions;
    }

    public void setContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions(String contractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions) {
        ContractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions = contractsInterestRateAsOfTheEndOfThisMonthAddNewTransactions;
    }

    @JsonProperty("NominalPrincipalGoldTradedAtTheBeginningOfThisMonth")
    public String getNominalPrincipalGoldTradedAtTheBeginningOfThisMonth() {
        return NominalPrincipalGoldTradedAtTheBeginningOfThisMonth;
    }

    public void setNominalPrincipalGoldTradedAtTheBeginningOfThisMonth(String nominalPrincipalGoldTradedAtTheBeginningOfThisMonth) {
        NominalPrincipalGoldTradedAtTheBeginningOfThisMonth = nominalPrincipalGoldTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("NominalGoldThisMonthToAddTransactions")
    public String getNominalGoldThisMonthToAddTransactions() {
        return NominalGoldThisMonthToAddTransactions;
    }

    public void setNominalGoldThisMonthToAddTransactions(String nominalGoldThisMonthToAddTransactions) {
        NominalGoldThisMonthToAddTransactions = nominalGoldThisMonthToAddTransactions;
    }

    @JsonProperty("TheNominalGoldIsTradingThisMonth")
    public String getTheNominalGoldIsTradingThisMonth() {
        return TheNominalGoldIsTradingThisMonth;
    }

    public void setTheNominalGoldIsTradingThisMonth(String theNominalGoldIsTradingThisMonth) {
        TheNominalGoldIsTradingThisMonth = theNominalGoldIsTradingThisMonth;
    }

    @JsonProperty("NominalPrincipalGoldIsTradedAtTheEndOfThisMonth")
    public String getNominalPrincipalGoldIsTradedAtTheEndOfThisMonth() {
        return NominalPrincipalGoldIsTradedAtTheEndOfThisMonth;
    }

    public void setNominalPrincipalGoldIsTradedAtTheEndOfThisMonth(String nominalPrincipalGoldIsTradedAtTheEndOfThisMonth) {
        NominalPrincipalGoldIsTradedAtTheEndOfThisMonth = nominalPrincipalGoldIsTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("NominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction")
    public String getNominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction() {
        return NominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction;
    }

    public void setNominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction(String nominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction) {
        NominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction = nominalPrincipalGoldAsOfTheEndOfThisYearTheNewTransaction;
    }

    @JsonProperty("TheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth")
    public String getTheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth() {
        return TheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth;
    }

    public void setTheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth(String theNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth) {
        TheNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth = theNumberOfContractsForGoldIsTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("TheNumberOfContractsGoldThisMonthToAddTransactions")
    public String getTheNumberOfContractsGoldThisMonthToAddTransactions() {
        return TheNumberOfContractsGoldThisMonthToAddTransactions;
    }

    public void setTheNumberOfContractsGoldThisMonthToAddTransactions(String theNumberOfContractsGoldThisMonthToAddTransactions) {
        TheNumberOfContractsGoldThisMonthToAddTransactions = theNumberOfContractsGoldThisMonthToAddTransactions;
    }

    @JsonProperty("TheNumberOfContractsIsGoldThisMonth")
    public String getTheNumberOfContractsIsGoldThisMonth() {
        return TheNumberOfContractsIsGoldThisMonth;
    }

    public void setTheNumberOfContractsIsGoldThisMonth(String theNumberOfContractsIsGoldThisMonth) {
        TheNumberOfContractsIsGoldThisMonth = theNumberOfContractsIsGoldThisMonth;
    }

    @JsonProperty("TheNumberOfContractsIsGoldAtTheEndOfThisMonth")
    public String getTheNumberOfContractsIsGoldAtTheEndOfThisMonth() {
        return TheNumberOfContractsIsGoldAtTheEndOfThisMonth;
    }

    public void setTheNumberOfContractsIsGoldAtTheEndOfThisMonth(String theNumberOfContractsIsGoldAtTheEndOfThisMonth) {
        TheNumberOfContractsIsGoldAtTheEndOfThisMonth = theNumberOfContractsIsGoldAtTheEndOfThisMonth;
    }

    @JsonProperty("TheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction")
    public String getTheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction() {
        return TheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction;
    }

    public void setTheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction(String theNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction) {
        TheNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction = theNumberOfContractsForTheGoldAsOfTheEndOfThisYearTheNewTransaction;
    }

    @JsonProperty("NominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth")
    public String getNominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth() {
        return NominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth;
    }

    public void setNominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth(String nominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth) {
        NominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth = nominalPrincipalForeignExchangeTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("NominalPrincipalForeignExchangeThisMonthToAddTransactions")
    public String getNominalPrincipalForeignExchangeThisMonthToAddTransactions() {
        return NominalPrincipalForeignExchangeThisMonthToAddTransactions;
    }

    public void setNominalPrincipalForeignExchangeThisMonthToAddTransactions(String nominalPrincipalForeignExchangeThisMonthToAddTransactions) {
        NominalPrincipalForeignExchangeThisMonthToAddTransactions = nominalPrincipalForeignExchangeThisMonthToAddTransactions;
    }

    @JsonProperty("TheNominalPrincipalForeignExchangeSettledThisMonth")
    public String getTheNominalPrincipalForeignExchangeSettledThisMonth() {
        return TheNominalPrincipalForeignExchangeSettledThisMonth;
    }

    public void setTheNominalPrincipalForeignExchangeSettledThisMonth(String theNominalPrincipalForeignExchangeSettledThisMonth) {
        TheNominalPrincipalForeignExchangeSettledThisMonth = theNominalPrincipalForeignExchangeSettledThisMonth;
    }

    @JsonProperty("NominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth")
    public String getNominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth() {
        return NominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth;
    }

    public void setNominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth(String nominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth) {
        NominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth = nominalPrincipalForeignExchangeTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("NominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction")
    public String getNominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction() {
        return NominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction;
    }

    public void setNominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction(String nominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction) {
        NominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction = nominalPrincipalForeignExchangeAsOfTheEndOfThisYearTheNewTransaction;
    }

    @JsonProperty("ContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth")
    public String getContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth() {
        return ContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth;
    }

    public void setContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth(String contractsForeignExchangeIsTradedAtTheBeginningOfThisMonth) {
        ContractsForeignExchangeIsTradedAtTheBeginningOfThisMonth = contractsForeignExchangeIsTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("ContractNumberForeignExchangeThisMonthNewTransaction")
    public String getContractNumberForeignExchangeThisMonthNewTransaction() {
        return ContractNumberForeignExchangeThisMonthNewTransaction;
    }

    public void setContractNumberForeignExchangeThisMonthNewTransaction(String contractNumberForeignExchangeThisMonthNewTransaction) {
        ContractNumberForeignExchangeThisMonthNewTransaction = contractNumberForeignExchangeThisMonthNewTransaction;
    }

    @JsonProperty("TheNumberOfContractsForForeignExchangeTransactionsThisMonth")
    public String getTheNumberOfContractsForForeignExchangeTransactionsThisMonth() {
        return TheNumberOfContractsForForeignExchangeTransactionsThisMonth;
    }

    public void setTheNumberOfContractsForForeignExchangeTransactionsThisMonth(String theNumberOfContractsForForeignExchangeTransactionsThisMonth) {
        TheNumberOfContractsForForeignExchangeTransactionsThisMonth = theNumberOfContractsForForeignExchangeTransactionsThisMonth;
    }

    @JsonProperty("ContractsForeignExchangeIsTradedAtTheEndOfThisMonth")
    public String getContractsForeignExchangeIsTradedAtTheEndOfThisMonth() {
        return ContractsForeignExchangeIsTradedAtTheEndOfThisMonth;
    }

    public void setContractsForeignExchangeIsTradedAtTheEndOfThisMonth(String contractsForeignExchangeIsTradedAtTheEndOfThisMonth) {
        ContractsForeignExchangeIsTradedAtTheEndOfThisMonth = contractsForeignExchangeIsTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("NumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction")
    public String getNumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction() {
        return NumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction;
    }

    public void setNumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction(String numberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction) {
        NumberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction = numberOfContractsForeignExchangeAsOfTheEndOfThisMonthTheNewTransaction;
    }

    @JsonProperty("TheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth")
    public String getTheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth() {
        return TheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth;
    }

    public void setTheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth(String theNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth) {
        TheNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth = theNameOfThePrincipalOtherTransactionsHeldEarlierThisMonth;
    }

    @JsonProperty("NominalPrincipalOtherNewTransactionsThisMonth")
    public String getNominalPrincipalOtherNewTransactionsThisMonth() {
        return NominalPrincipalOtherNewTransactionsThisMonth;
    }

    public void setNominalPrincipalOtherNewTransactionsThisMonth(String nominalPrincipalOtherNewTransactionsThisMonth) {
        NominalPrincipalOtherNewTransactionsThisMonth = nominalPrincipalOtherNewTransactionsThisMonth;
    }

    @JsonProperty("TheNameOfThePrincipalOtherTransactionsThisMonth")
    public String getTheNameOfThePrincipalOtherTransactionsThisMonth() {
        return TheNameOfThePrincipalOtherTransactionsThisMonth;
    }

    public void setTheNameOfThePrincipalOtherTransactionsThisMonth(String theNameOfThePrincipalOtherTransactionsThisMonth) {
        TheNameOfThePrincipalOtherTransactionsThisMonth = theNameOfThePrincipalOtherTransactionsThisMonth;
    }

    @JsonProperty("NominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth")
    public String getNominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth() {
        return NominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth;
    }

    public void setNominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth(String nominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth) {
        NominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth = nominalPrincipalOtherTransactionsRemainAtTheEndOfThisMonth;
    }

    @JsonProperty("NominalPrincipalOtherTransactionsUpToTheEndOfThisMonth")
    public String getNominalPrincipalOtherTransactionsUpToTheEndOfThisMonth() {
        return NominalPrincipalOtherTransactionsUpToTheEndOfThisMonth;
    }

    public void setNominalPrincipalOtherTransactionsUpToTheEndOfThisMonth(String nominalPrincipalOtherTransactionsUpToTheEndOfThisMonth) {
        NominalPrincipalOtherTransactionsUpToTheEndOfThisMonth = nominalPrincipalOtherTransactionsUpToTheEndOfThisMonth;
    }

    @JsonProperty("TheNumberOfContractsIsTheBeginningOfThisMonth")
    public String getTheNumberOfContractsIsTheBeginningOfThisMonth() {
        return TheNumberOfContractsIsTheBeginningOfThisMonth;
    }

    public void setTheNumberOfContractsIsTheBeginningOfThisMonth(String theNumberOfContractsIsTheBeginningOfThisMonth) {
        TheNumberOfContractsIsTheBeginningOfThisMonth = theNumberOfContractsIsTheBeginningOfThisMonth;
    }

    @JsonProperty("ContractNumberOtherNewTransactionsThisMonth")
    public String getContractNumberOtherNewTransactionsThisMonth() {
        return ContractNumberOtherNewTransactionsThisMonth;
    }

    public void setContractNumberOtherNewTransactionsThisMonth(String contractNumberOtherNewTransactionsThisMonth) {
        ContractNumberOtherNewTransactionsThisMonth = contractNumberOtherNewTransactionsThisMonth;
    }

    @JsonProperty("TheNumberOfContractsOtherTransactionsThisMonth")
    public String getTheNumberOfContractsOtherTransactionsThisMonth() {
        return TheNumberOfContractsOtherTransactionsThisMonth;
    }

    public void setTheNumberOfContractsOtherTransactionsThisMonth(String theNumberOfContractsOtherTransactionsThisMonth) {
        TheNumberOfContractsOtherTransactionsThisMonth = theNumberOfContractsOtherTransactionsThisMonth;
    }

    @JsonProperty("ContractsOthersRemainTradedAtTheEndOfThisMonth")
    public String getContractsOthersRemainTradedAtTheEndOfThisMonth() {
        return ContractsOthersRemainTradedAtTheEndOfThisMonth;
    }

    public void setContractsOthersRemainTradedAtTheEndOfThisMonth(String contractsOthersRemainTradedAtTheEndOfThisMonth) {
        ContractsOthersRemainTradedAtTheEndOfThisMonth = contractsOthersRemainTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("NumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth")
    public String getNumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth() {
        return NumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth;
    }

    public void setNumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth(String numberOfContractsOtherTransactionsAsOfTheEndOfThisMonth) {
        NumberOfContractsOtherTransactionsAsOfTheEndOfThisMonth = numberOfContractsOtherTransactionsAsOfTheEndOfThisMonth;
    }

    @JsonProperty("TheNominalPrincipalIsTradedAtTheBeginningOfThisMonth")
    public String getTheNominalPrincipalIsTradedAtTheBeginningOfThisMonth() {
        return TheNominalPrincipalIsTradedAtTheBeginningOfThisMonth;
    }

    public void setTheNominalPrincipalIsTradedAtTheBeginningOfThisMonth(String theNominalPrincipalIsTradedAtTheBeginningOfThisMonth) {
        TheNominalPrincipalIsTradedAtTheBeginningOfThisMonth = theNominalPrincipalIsTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("NominalPrincipalTotalNewTransactionsThisMonth")
    public String getNominalPrincipalTotalNewTransactionsThisMonth() {
        return NominalPrincipalTotalNewTransactionsThisMonth;
    }

    public void setNominalPrincipalTotalNewTransactionsThisMonth(String nominalPrincipalTotalNewTransactionsThisMonth) {
        NominalPrincipalTotalNewTransactionsThisMonth = nominalPrincipalTotalNewTransactionsThisMonth;
    }

    @JsonProperty("NominalPrincipalTotalSettledThisMonth")
    public String getNominalPrincipalTotalSettledThisMonth() {
        return NominalPrincipalTotalSettledThisMonth;
    }

    public void setNominalPrincipalTotalSettledThisMonth(String nominalPrincipalTotalSettledThisMonth) {
        NominalPrincipalTotalSettledThisMonth = nominalPrincipalTotalSettledThisMonth;
    }

    @JsonProperty("TheNominalPrincipalIsTradedAtTheEndOfThisMonth")
    public String getTheNominalPrincipalIsTradedAtTheEndOfThisMonth() {
        return TheNominalPrincipalIsTradedAtTheEndOfThisMonth;
    }

    public void setTheNominalPrincipalIsTradedAtTheEndOfThisMonth(String theNominalPrincipalIsTradedAtTheEndOfThisMonth) {
        TheNominalPrincipalIsTradedAtTheEndOfThisMonth = theNominalPrincipalIsTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("NominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth")
    public String getNominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth() {
        return NominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth;
    }

    public void setNominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth(String nominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth) {
        NominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth = nominalPrincipalTotalNewTransactionAsOfTheEndOfThisMonth;
    }

    @JsonProperty("TheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth")
    public String getTheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth() {
        return TheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth;
    }

    public void setTheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth(String theTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth) {
        TheTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth = theTotalNumberOfContractsIsTradedAtTheBeginningOfThisMonth;
    }

    @JsonProperty("TheTotalNumberOfContractsIsAddedThisMonth")
    public String getTheTotalNumberOfContractsIsAddedThisMonth() {
        return TheTotalNumberOfContractsIsAddedThisMonth;
    }

    public void setTheTotalNumberOfContractsIsAddedThisMonth(String theTotalNumberOfContractsIsAddedThisMonth) {
        TheTotalNumberOfContractsIsAddedThisMonth = theTotalNumberOfContractsIsAddedThisMonth;
    }

    @JsonProperty("TheTotalNumberOfContractsIsSettledThisMonth")
    public String getTheTotalNumberOfContractsIsSettledThisMonth() {
        return TheTotalNumberOfContractsIsSettledThisMonth;
    }

    public void setTheTotalNumberOfContractsIsSettledThisMonth(String theTotalNumberOfContractsIsSettledThisMonth) {
        TheTotalNumberOfContractsIsSettledThisMonth = theTotalNumberOfContractsIsSettledThisMonth;
    }

    @JsonProperty("TheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth")
    public String getTheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth() {
        return TheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth;
    }

    public void setTheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth(String theTotalNumberOfContractsIsTradedAtTheEndOfThisMonth) {
        TheTotalNumberOfContractsIsTradedAtTheEndOfThisMonth = theTotalNumberOfContractsIsTradedAtTheEndOfThisMonth;
    }

    @JsonProperty("TheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction")
    public String getTheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction() {
        return TheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction;
    }

    public void setTheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction(String theTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction) {
        TheTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction = theTotalNumberOfContractsAsOfTheEndOfThisYearAddTheNewTransaction;
    }

    @JsonProperty("InterestRateSwapDetails")
    public List<InterestRateSwapDetailsDTO> getInterestRateSwapDetails() {
        return InterestRateSwapDetails;
    }

    public void setInterestRateSwapDetails(List<InterestRateSwapDetailsDTO> interestRateSwapDetails) {
        InterestRateSwapDetails = interestRateSwapDetails;
    }

    @JsonProperty("ScheduleOfOtherTransactions")
    public List<ScheduleOfOtherTransactionsDTO> getScheduleOfOtherTransactions() {
        return ScheduleOfOtherTransactions;
    }

    public void setScheduleOfOtherTransactions(List<ScheduleOfOtherTransactionsDTO> scheduleOfOtherTransactions) {
        ScheduleOfOtherTransactions = scheduleOfOtherTransactions;
    }
}
