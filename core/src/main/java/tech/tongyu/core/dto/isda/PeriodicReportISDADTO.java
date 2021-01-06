package tech.tongyu.core.dto.isda;

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
 * @description ISDA
 */
@JsonPropertyOrder({"ExceID", "BizID", "Year", "Month", "MainAgreementLastMonthAccumulatedThisYear",
        "MainAgreementAddedThisMonth", "MainAgreementAccumulatedThisYear", "MainAgreementValidedAtEndOfThisMonth",
        "SupplementalAgreementLastMonthAccumulatedThisYear", "SupplementalAgreementAddedThisMonth",
        "SupplementalAgreementAccumulatedThisYear", "SupplementalAgreementValidedAtTheEndOfThisMonth",
        "PerformanceGuaranteeAgreementLastMonthAccumulatedThisYear", "PerformanceGuaranteeAgreementAddedThisMonth",
        "PerformanceGuaranteeAgreementAccumulatedThisYear", "PerformanceGuaranteeAgreementValidedAtEndOfThisMonth",
        "TransactionConfirmationLastMonthAccumulatedThisYear", "TransactionConfirmationAddedThisMonth",
        "TransactionConfirmationBookAccumulatedThisYear", "TransactionConfirmationValidedAtEndOfThisMonth",
        "SWAPNominalCapitalStockAtBeginning", "SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth",
        "SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth", "SWAPNominalCapitalStockAtEnding",
        "SwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction", "OptionOfNotionalPrincipalStockAtBeginning",
        "OptionIncreasedOriginalTransactionNominalCapitalAtThisMonth", "OptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth",
        "OptionOfNotionalPrincipalStockAtEnding", "NominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction",
        "ForwardOfNotionalPrincipalStockAtBeginning", "ForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth",
        "ForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth", "ForwardOfNotionalPrincipalStockAtEnding",
        "LongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction", "StockOfSwapContractsAtBeginning",
        "NumberOfNewSwapInitialTradingContractsAtThisMonth", "NumberOfSwapContractsToTerminateAtThisMonth",
        "StockOfSwapContractsAtEnding", "NumberOfSwapContractsIncreasedByThisYear",
        "StockOfOptionContractsAtBeginning", "NumberOfNewOptionInitialTradingContractsAtThisMonth",
        "NumberOfOptionContractsToTerminateAtThisMonth", "StockOfOptionContractsAtEnding",
        "NumberOfOptionContractsHasIncreasedInitialTransaction", "StockOfForwardContractsAtBeginning",
        "NumberOfNewForwardInitialTradingContractsAtThisMonth", "NumberOfForwardContractsToTerminateAtThisMonth",
        "StockOfForwardContractsAtEnding", "NumberOfForwardContractsHasIncreasedInitialTransaction",
        "SwapSignedWithTheCustomerThisMonth", "NumberOfSwapTradingAccountsAtThisPeriodThisMonth",
        "NumberOfSwapTradingClientStockThisMonth", "SwapSignedWithTheCustomerLastMonth",
        "NumberOfSwapTradingAccountsLastMonth", "NumberOfSwapTradingClientStockLastMonth",
        "OptionSignedWithTheCustomerThisMonth", "NumberOfOptionTradingAccountsThisMonth",
        "NumberOfOptionTradingClientStockThisMonth", "OptionSignedWithTheCustomerLastMonth",
        "NumberOfOptionTradingAccountsLastMonth", "NumberOfOptionTradingClientStockLastMonth",
        "ForwardSignedWithTheCustomerThisMonth", "NumberOfForwardTradingAccountsThisMonth",
        "NumberOfForwardTradingClientStockThisMonth", "ForwardSignedWithTheCustomerLastMonth",
        "NumberOfForwardTradingAccountsLastMonth", "NumberOfForwardTradingClientStockLastMonth", "SignedTotalCustomer",
        "TotalNumberOfTradingAccountsAtThisPeriod", "TotalNumberOfTradingClientAccounts", "SignedTotalCustomerLastMonth",
        "TotalNumberOfTradingAccountsAtThisPeriodLastMonth", "TotalNumberOfTradingClientAccountsLastMonth", "TotalNominalPrincipalAmountOfSwapThisMonth",
        "TotalNominalPrincipalAmountOfSwapLastMonth", "TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth",
        "TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth", "SwapCashCollateralValueThisMonth",
        "SwapCashCollateralValueLastMonth", "SwapSecuritiesCollateralValueThisMonth", "SwapSecuritiesCollateralValueLastMonthThisMonth",
        "ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull", "ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull",
        "ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet", "ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet",
        "SwapNumberOfDefaultCustomersAtThisMonthThisMonth", "SwapNumberOfDefaultCustomersAtThisMonthLastMonth",
        "SwapDefaultTransactionNumberAtThisMonthThisMonth", "SwapDefaultTransactionNumberAtThisMonthLastMonth",
        "TotalSwapDefaultCustomerNumberInThisYearThisMonth", "TotalSwapDefaultCustomerNumberInThisYearLastMonth",
        "SwapNumberOfDefaultCustomersInThisYearThisMonth", "SwapNumberOfDefaultCustomersInThisYearLastMonth",
        "TotalNominalPrincipalAmountOfForwardThisMonth", "TotalNominalPrincipalAmountOfForwardLastMonth",
        "TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth", "TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth",
        "ForwardCashCollateralValueThisMonth", "ForwardCashCollateralValueLastMonth",
        "ForwardSecuritiesCollateralValueThisMonth", "ForwardSecuritiesCollateralValueLastMonth",
        "ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull", "ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull",
        "ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet", "ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet",
        "ForwardNumberOfDefaultCustomersAtThisMonthThisMonth", "ForwardNumberOfDefaultCustomersAtThisMonthLastMonth",
        "ForwardTransactionNumberAtThisMonthThisMonth", "ForwardTransactionNumberAtThisMonthLastMonth",
        "TotalForwardDefaultCustomerNumberInThisYearThisMonth", "TotalForwardDefaultCustomerNumberInThisYearLastMonth",
        "ForwardNumberOfDefaultCustomersInThisYearThisMonth", "ForwardNumberOfDefaultCustomersInThisYearLastMonth",
        "StockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth", "StockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth",
        "CashBalanceAtEndOfThisMonth", "CashBalanceAtEndOfLastMonth",
        "HoldStockMarketValueAtEndOfThisMonth", "HoldStockMarketValueAtEndOfLastMonth",
        "HoldMarketValueOfBondsAtTheEndOfThisMonth", "HoldMarketValueOfBondsAtTheEndOfLastMonth",
        "OwnedAssetManagementProductsAtTheEndOfThisMonth", "OwnedAssetManagementProductsAtTheEndOfLastMonth",
        "OwnedBankFinanceAtTheEndOfThisMonth", "OwnedBankFinanceAtTheEndOfLastMonth",
        "HoldTrustProductAtTheEndOfThisMonth", "HoldTrustProductAtTheEndOfLastMonth",
        "InsuranceProductsAreHeldAtTheEndOfThisMonth", "InsuranceProductsAreHeldAtTheEndOfLastMonth",
        "HoldOtherProductsAtTheEndOfThisMonth", "HoldOtherProductsAtTheEndOfLastMonth",
        "SettledSwapItemsAtThisMonth", "SettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth",
        "SwapIncomeCashFlow", "SwapExpensesCashFlow", "CashFlowCorrespondingToNetIncomeOnSwapMargin",
        "SwapHedgeCost", "SettledOptionItemsAtThisMonth", "SettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth",
        "OptionPremiumIncome", "OptionHedgeCost", "SettledForwardItemsAtThisMonth",
        "SettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth", "ForwardIncomeCashFlow", "ForwardExpensesCashFlow",
        "ForwardHedgeCost", "BalanceOfSwapRealizedGainsAndLossesAtThisMonth",
        "BalanceOfOptionRealizedGainsAndLossesAtThisMonth", "BalanceOfForwardRealizedGainsAndLossesAtThisMonth",
        "BalanceOfSwapRealizedGainsAndLossesAtThisYear", "BalanceOfOptionRealizedGainsAndLossesAtThisYear",
        "BalanceOfForwardRealizedGainsAndLossesAtThisYear", "BalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth",
        "BalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth", "BalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth",
        "BalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear", "BalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear",
        "BalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear", "BalanceOfSwapTotalGainsAndLossesAtThisMonth",
        "BalanceOfOptionTotalGainsAndLossesAtThisMonth", "BalanceOfForwardTotalGainsAndLossesAtThisMonth",
        "BalanceOfSwapTotalGainsAndLossesAtThisYear", "BalanceOfOptionTotalGainsAndLossesAtThisYear",
        "BalanceOfForwardTotalGainsAndLossesAtThisYear", "IncreaseBusinessDetailsThisMonthTuple", "TargetCaseAndHedgeTuple"})
public class PeriodicReportISDADTO extends RequestCommon {

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
    private String SWAPNominalCapitalStockAtBeginning;
    private String SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    private String SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    private String SWAPNominalCapitalStockAtEnding;
    private String SwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction;
    private String OptionOfNotionalPrincipalStockAtBeginning;
    private String OptionIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    private String OptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    private String OptionOfNotionalPrincipalStockAtEnding;
    private String NominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction;
    private String ForwardOfNotionalPrincipalStockAtBeginning;
    private String ForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    private String ForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    private String ForwardOfNotionalPrincipalStockAtEnding;
    private String LongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction;
    private String StockOfSwapContractsAtBeginning;
    private String NumberOfNewSwapInitialTradingContractsAtThisMonth;
    private String NumberOfSwapContractsToTerminateAtThisMonth;
    private String StockOfSwapContractsAtEnding;
    private String NumberOfSwapContractsIncreasedByThisYear;
    private String StockOfOptionContractsAtBeginning;
    private String NumberOfNewOptionInitialTradingContractsAtThisMonth;
    private String NumberOfOptionContractsToTerminateAtThisMonth;
    private String StockOfOptionContractsAtEnding;
    private String NumberOfOptionContractsHasIncreasedInitialTransaction;
    private String StockOfForwardContractsAtBeginning;
    private String NumberOfNewForwardInitialTradingContractsAtThisMonth;
    private String NumberOfForwardContractsToTerminateAtThisMonth;
    private String StockOfForwardContractsAtEnding;
    private String NumberOfForwardContractsHasIncreasedInitialTransaction;
    private String SwapSignedWithTheCustomerThisMonth;
    private String NumberOfSwapTradingAccountsAtThisPeriodThisMonth;
    private String NumberOfSwapTradingClientStockThisMonth;
    private String SwapSignedWithTheCustomerLastMonth;
    private String NumberOfSwapTradingAccountsLastMonth;
    private String NumberOfSwapTradingClientStockLastMonth;
    private String OptionSignedWithTheCustomerThisMonth;
    private String NumberOfOptionTradingAccountsThisMonth;
    private String NumberOfOptionTradingClientStockThisMonth;
    private String OptionSignedWithTheCustomerLastMonth;
    private String NumberOfOptionTradingAccountsLastMonth;
    private String NumberOfOptionTradingClientStockLastMonth;
    private String ForwardSignedWithTheCustomerThisMonth;
    private String NumberOfForwardTradingAccountsThisMonth;
    private String NumberOfForwardTradingClientStockThisMonth;
    private String ForwardSignedWithTheCustomerLastMonth;
    private String NumberOfForwardTradingAccountsLastMonth;
    private String NumberOfForwardTradingClientStockLastMonth;
    private String SignedTotalCustomer;
    private String TotalNumberOfTradingAccountsAtThisPeriod;
    private String TotalNumberOfTradingClientAccounts;
    private String SignedTotalCustomerLastMonth;
    private String TotalNumberOfTradingAccountsAtThisPeriodLastMonth;
    private String TotalNumberOfTradingClientAccountsLastMonth;
    private String TotalNominalPrincipalAmountOfSwapThisMonth;
    private String TotalNominalPrincipalAmountOfSwapLastMonth;
    private String TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth;
    private String TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth;
    private String SwapCashCollateralValueThisMonth;
    private String SwapCashCollateralValueLastMonth;
    private String SwapSecuritiesCollateralValueThisMonth;
    private String SwapSecuritiesCollateralValueLastMonthThisMonth;
    private String ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull;
    private String ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull;
    private String ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet;
    private String ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet;
    private String SwapNumberOfDefaultCustomersAtThisMonthThisMonth;
    private String SwapNumberOfDefaultCustomersAtThisMonthLastMonth;
    private String SwapDefaultTransactionNumberAtThisMonthThisMonth;
    private String SwapDefaultTransactionNumberAtThisMonthLastMonth;
    private String TotalSwapDefaultCustomerNumberInThisYearThisMonth;
    private String TotalSwapDefaultCustomerNumberInThisYearLastMonth;
    private String SwapNumberOfDefaultCustomersInThisYearThisMonth;
    private String SwapNumberOfDefaultCustomersInThisYearLastMonth;
    private String TotalNominalPrincipalAmountOfForwardThisMonth;
    private String TotalNominalPrincipalAmountOfForwardLastMonth;
    private String TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth;
    private String TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth;
    private String ForwardCashCollateralValueThisMonth;
    private String ForwardCashCollateralValueLastMonth;
    private String ForwardSecuritiesCollateralValueThisMonth;
    private String ForwardSecuritiesCollateralValueLastMonth;
    private String ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull;
    private String ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull;
    private String ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet;
    private String ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet;
    private String ForwardNumberOfDefaultCustomersAtThisMonthThisMonth;
    private String ForwardNumberOfDefaultCustomersAtThisMonthLastMonth;
    private String ForwardTransactionNumberAtThisMonthThisMonth;
    private String ForwardTransactionNumberAtThisMonthLastMonth;
    private String TotalForwardDefaultCustomerNumberInThisYearThisMonth;
    private String TotalForwardDefaultCustomerNumberInThisYearLastMonth;
    private String ForwardNumberOfDefaultCustomersInThisYearThisMonth;
    private String ForwardNumberOfDefaultCustomersInThisYearLastMonth;
    private String StockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth;
    private String StockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth;
    private String CashBalanceAtEndOfThisMonth;
    private String CashBalanceAtEndOfLastMonth;
    private String HoldStockMarketValueAtEndOfThisMonth;
    private String HoldStockMarketValueAtEndOfLastMonth;
    private String HoldMarketValueOfBondsAtTheEndOfThisMonth;
    private String HoldMarketValueOfBondsAtTheEndOfLastMonth;
    private String OwnedAssetManagementProductsAtTheEndOfThisMonth;
    private String OwnedAssetManagementProductsAtTheEndOfLastMonth;
    private String OwnedBankFinanceAtTheEndOfThisMonth;
    private String OwnedBankFinanceAtTheEndOfLastMonth;
    private String HoldTrustProductAtTheEndOfThisMonth;
    private String HoldTrustProductAtTheEndOfLastMonth;
    private String InsuranceProductsAreHeldAtTheEndOfThisMonth;
    private String InsuranceProductsAreHeldAtTheEndOfLastMonth;
    private String HoldOtherProductsAtTheEndOfThisMonth;
    private String HoldOtherProductsAtTheEndOfLastMonth;
    private String SettledSwapItemsAtThisMonth;
    private String SettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth;
    private String SwapIncomeCashFlow;
    private String SwapExpensesCashFlow;
    private String CashFlowCorrespondingToNetIncomeOnSwapMargin;
    private String SwapHedgeCost;
    private String SettledOptionItemsAtThisMonth;
    private String SettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth;
    private String OptionPremiumIncome;
    private String OptionHedgeCost;
    private String SettledForwardItemsAtThisMonth;
    private String SettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth;
    private String ForwardIncomeCashFlow;
    private String ForwardExpensesCashFlow;
    private String ForwardHedgeCost;
    private String BalanceOfSwapRealizedGainsAndLossesAtThisMonth;
    private String BalanceOfOptionRealizedGainsAndLossesAtThisMonth;
    private String BalanceOfForwardRealizedGainsAndLossesAtThisMonth;
    private String BalanceOfSwapRealizedGainsAndLossesAtThisYear;
    private String BalanceOfOptionRealizedGainsAndLossesAtThisYear;
    private String BalanceOfForwardRealizedGainsAndLossesAtThisYear;
    private String BalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth;
    private String BalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth;
    private String BalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth;
    private String BalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear;
    private String BalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear;
    private String BalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear;
    private String BalanceOfSwapTotalGainsAndLossesAtThisMonth;
    private String BalanceOfOptionTotalGainsAndLossesAtThisMonth;
    private String BalanceOfForwardTotalGainsAndLossesAtThisMonth;
    private String BalanceOfSwapTotalGainsAndLossesAtThisYear;
    private String BalanceOfOptionTotalGainsAndLossesAtThisYear;
    private String BalanceOfForwardTotalGainsAndLossesAtThisYear;
    private List<IncreaseBusinessDetailsThisMonthTupleDTO> IncreaseBusinessDetailsThisMonthTuple;
    private List<TargetCaseAndHedgeTupleDTO> TargetCaseAndHedgeTuple;

    public static PeriodicReportISDADTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static PeriodicReportISDADTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        PeriodicReportISDADTO dto = JsonUtils.mapper.convertValue(json, PeriodicReportISDADTO.class);
        return dto;
    }

    public PeriodicReportISDADTO() {
    }

    public PeriodicReportISDADTO(String year, String month, String mainAgreementLastMonthAccumulatedThisYear, String mainAgreementAddedThisMonth, String mainAgreementAccumulatedThisYear, String mainAgreementValidedAtEndOfThisMonth, String supplementalAgreementLastMonthAccumulatedThisYear, String supplementalAgreementAddedThisMonth, String supplementalAgreementAccumulatedThisYear, String supplementalAgreementValidedAtTheEndOfThisMonth, String performanceGuaranteeAgreementLastMonthAccumulatedThisYear, String performanceGuaranteeAgreementAddedThisMonth, String performanceGuaranteeAgreementAccumulatedThisYear, String performanceGuaranteeAgreementValidedAtEndOfThisMonth, String transactionConfirmationLastMonthAccumulatedThisYear, String transactionConfirmationAddedThisMonth, String transactionConfirmationBookAccumulatedThisYear, String transactionConfirmationValidedAtEndOfThisMonth, String SWAPNominalCapitalStockAtBeginning, String SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth, String SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth, String SWAPNominalCapitalStockAtEnding, String swapCategoryNominalPrincipalThisYearCumulativeInitialTransaction, String optionOfNotionalPrincipalStockAtBeginning, String optionIncreasedOriginalTransactionNominalCapitalAtThisMonth, String optionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth, String optionOfNotionalPrincipalStockAtEnding, String nominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction, String forwardOfNotionalPrincipalStockAtBeginning, String forwardIncreasedOriginalTransactionNominalCapitalAtThisMonth, String forwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth, String forwardOfNotionalPrincipalStockAtEnding, String longtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction, String stockOfSwapContractsAtBeginning, String numberOfNewSwapInitialTradingContractsAtThisMonth, String numberOfSwapContractsToTerminateAtThisMonth, String stockOfSwapContractsAtEnding, String numberOfSwapContractsIncreasedByThisYear, String stockOfOptionContractsAtBeginning, String numberOfNewOptionInitialTradingContractsAtThisMonth, String numberOfOptionContractsToTerminateAtThisMonth, String stockOfOptionContractsAtEnding, String numberOfOptionContractsHasIncreasedInitialTransaction, String stockOfForwardContractsAtBeginning, String numberOfNewForwardInitialTradingContractsAtThisMonth, String numberOfForwardContractsToTerminateAtThisMonth, String stockOfForwardContractsAtEnding, String numberOfForwardContractsHasIncreasedInitialTransaction, String swapSignedWithTheCustomerThisMonth, String numberOfSwapTradingAccountsAtThisPeriodThisMonth, String numberOfSwapTradingClientStockThisMonth, String swapSignedWithTheCustomerLastMonth, String numberOfSwapTradingAccountsLastMonth, String numberOfSwapTradingClientStockLastMonth, String optionSignedWithTheCustomerThisMonth, String numberOfOptionTradingAccountsThisMonth, String numberOfOptionTradingClientStockThisMonth, String optionSignedWithTheCustomerLastMonth, String numberOfOptionTradingAccountsLastMonth, String numberOfOptionTradingClientStockLastMonth, String forwardSignedWithTheCustomerThisMonth, String numberOfForwardTradingAccountsThisMonth, String numberOfForwardTradingClientStockThisMonth, String forwardSignedWithTheCustomerLastMonth, String numberOfForwardTradingAccountsLastMonth, String numberOfForwardTradingClientStockLastMonth, String signedTotalCustomer, String totalNumberOfTradingAccountsAtThisPeriod, String totalNumberOfTradingClientAccounts, String signedTotalCustomerLastMonth, String totalNumberOfTradingAccountsAtThisPeriodLastMonth, String totalNumberOfTradingClientAccountsLastMonth, String totalNominalPrincipalAmountOfSwapThisMonth, String totalNominalPrincipalAmountOfSwapLastMonth, String theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth, String theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth, String swapCashCollateralValueThisMonth, String swapCashCollateralValueLastMonth, String swapSecuritiesCollateralValueThisMonth, String swapSecuritiesCollateralValueLastMonthThisMonth, String proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull, String proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull, String proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet, String proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet, String swapNumberOfDefaultCustomersAtThisMonthThisMonth, String swapNumberOfDefaultCustomersAtThisMonthLastMonth, String swapDefaultTransactionNumberAtThisMonthThisMonth, String swapDefaultTransactionNumberAtThisMonthLastMonth, String totalSwapDefaultCustomerNumberInThisYearThisMonth, String totalSwapDefaultCustomerNumberInThisYearLastMonth, String swapNumberOfDefaultCustomersInThisYearThisMonth, String swapNumberOfDefaultCustomersInThisYearLastMonth, String totalNominalPrincipalAmountOfForwardThisMonth, String totalNominalPrincipalAmountOfForwardLastMonth, String theValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth, String theValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth, String forwardCashCollateralValueThisMonth, String forwardCashCollateralValueLastMonth, String forwardSecuritiesCollateralValueThisMonth, String forwardSecuritiesCollateralValueLastMonth, String proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull, String proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull, String proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet, String proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet, String forwardNumberOfDefaultCustomersAtThisMonthThisMonth, String forwardNumberOfDefaultCustomersAtThisMonthLastMonth, String forwardTransactionNumberAtThisMonthThisMonth, String forwardTransactionNumberAtThisMonthLastMonth, String totalForwardDefaultCustomerNumberInThisYearThisMonth, String totalForwardDefaultCustomerNumberInThisYearLastMonth, String forwardNumberOfDefaultCustomersInThisYearThisMonth, String forwardNumberOfDefaultCustomersInThisYearLastMonth, String stockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth, String stockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth, String cashBalanceAtEndOfThisMonth, String cashBalanceAtEndOfLastMonth, String holdStockMarketValueAtEndOfThisMonth, String holdStockMarketValueAtEndOfLastMonth, String holdMarketValueOfBondsAtTheEndOfThisMonth, String holdMarketValueOfBondsAtTheEndOfLastMonth, String ownedAssetManagementProductsAtTheEndOfThisMonth, String ownedAssetManagementProductsAtTheEndOfLastMonth, String ownedBankFinanceAtTheEndOfThisMonth, String ownedBankFinanceAtTheEndOfLastMonth, String holdTrustProductAtTheEndOfThisMonth, String holdTrustProductAtTheEndOfLastMonth, String insuranceProductsAreHeldAtTheEndOfThisMonth, String insuranceProductsAreHeldAtTheEndOfLastMonth, String holdOtherProductsAtTheEndOfThisMonth, String holdOtherProductsAtTheEndOfLastMonth, String settledSwapItemsAtThisMonth, String settledSwapTransactionInvolvesNotionalPrincipalAtThisMonth, String swapIncomeCashFlow, String swapExpensesCashFlow, String cashFlowCorrespondingToNetIncomeOnSwapMargin, String swapHedgeCost, String settledOptionItemsAtThisMonth, String settledOptionTransactionInvolvesNotionalPrincipalAtThisMonth, String optionPremiumIncome, String optionHedgeCost, String settledForwardItemsAtThisMonth, String settledForwardTransactionInvolvesNotionalPrincipalAtThisMonth, String forwardIncomeCashFlow, String forwardExpensesCashFlow, String forwardHedgeCost, String balanceOfSwapRealizedGainsAndLossesAtThisMonth, String balanceOfOptionRealizedGainsAndLossesAtThisMonth, String balanceOfForwardRealizedGainsAndLossesAtThisMonth, String balanceOfSwapRealizedGainsAndLossesAtThisYear, String balanceOfOptionRealizedGainsAndLossesAtThisYear, String balanceOfForwardRealizedGainsAndLossesAtThisYear, String balanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth, String balanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth, String balanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth, String balanceOfSwapChangedGainsAndLossesInFairValueAtThisYear, String balanceOfOptionChangedGainsAndLossesInFairValueAtThisYear, String balanceOfForwardChangedGainsAndLossesInFairValueAtThisYear, String balanceOfSwapTotalGainsAndLossesAtThisMonth, String balanceOfOptionTotalGainsAndLossesAtThisMonth, String balanceOfForwardTotalGainsAndLossesAtThisMonth, String balanceOfSwapTotalGainsAndLossesAtThisYear, String balanceOfOptionTotalGainsAndLossesAtThisYear, String balanceOfForwardTotalGainsAndLossesAtThisYear, List<IncreaseBusinessDetailsThisMonthTupleDTO> increaseBusinessDetailsThisMonthTuple, List<TargetCaseAndHedgeTupleDTO> targetCaseAndHedgeTuple) {
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
        this.SWAPNominalCapitalStockAtBeginning = SWAPNominalCapitalStockAtBeginning;
        this.SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth = SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth;
        this.SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth = SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
        this.SWAPNominalCapitalStockAtEnding = SWAPNominalCapitalStockAtEnding;
        SwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction = swapCategoryNominalPrincipalThisYearCumulativeInitialTransaction;
        OptionOfNotionalPrincipalStockAtBeginning = optionOfNotionalPrincipalStockAtBeginning;
        OptionIncreasedOriginalTransactionNominalCapitalAtThisMonth = optionIncreasedOriginalTransactionNominalCapitalAtThisMonth;
        OptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth = optionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
        OptionOfNotionalPrincipalStockAtEnding = optionOfNotionalPrincipalStockAtEnding;
        NominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction = nominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction;
        ForwardOfNotionalPrincipalStockAtBeginning = forwardOfNotionalPrincipalStockAtBeginning;
        ForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth = forwardIncreasedOriginalTransactionNominalCapitalAtThisMonth;
        ForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth = forwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
        ForwardOfNotionalPrincipalStockAtEnding = forwardOfNotionalPrincipalStockAtEnding;
        LongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction = longtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction;
        StockOfSwapContractsAtBeginning = stockOfSwapContractsAtBeginning;
        NumberOfNewSwapInitialTradingContractsAtThisMonth = numberOfNewSwapInitialTradingContractsAtThisMonth;
        NumberOfSwapContractsToTerminateAtThisMonth = numberOfSwapContractsToTerminateAtThisMonth;
        StockOfSwapContractsAtEnding = stockOfSwapContractsAtEnding;
        NumberOfSwapContractsIncreasedByThisYear = numberOfSwapContractsIncreasedByThisYear;
        StockOfOptionContractsAtBeginning = stockOfOptionContractsAtBeginning;
        NumberOfNewOptionInitialTradingContractsAtThisMonth = numberOfNewOptionInitialTradingContractsAtThisMonth;
        NumberOfOptionContractsToTerminateAtThisMonth = numberOfOptionContractsToTerminateAtThisMonth;
        StockOfOptionContractsAtEnding = stockOfOptionContractsAtEnding;
        NumberOfOptionContractsHasIncreasedInitialTransaction = numberOfOptionContractsHasIncreasedInitialTransaction;
        StockOfForwardContractsAtBeginning = stockOfForwardContractsAtBeginning;
        NumberOfNewForwardInitialTradingContractsAtThisMonth = numberOfNewForwardInitialTradingContractsAtThisMonth;
        NumberOfForwardContractsToTerminateAtThisMonth = numberOfForwardContractsToTerminateAtThisMonth;
        StockOfForwardContractsAtEnding = stockOfForwardContractsAtEnding;
        NumberOfForwardContractsHasIncreasedInitialTransaction = numberOfForwardContractsHasIncreasedInitialTransaction;
        SwapSignedWithTheCustomerThisMonth = swapSignedWithTheCustomerThisMonth;
        NumberOfSwapTradingAccountsAtThisPeriodThisMonth = numberOfSwapTradingAccountsAtThisPeriodThisMonth;
        NumberOfSwapTradingClientStockThisMonth = numberOfSwapTradingClientStockThisMonth;
        SwapSignedWithTheCustomerLastMonth = swapSignedWithTheCustomerLastMonth;
        NumberOfSwapTradingAccountsLastMonth = numberOfSwapTradingAccountsLastMonth;
        NumberOfSwapTradingClientStockLastMonth = numberOfSwapTradingClientStockLastMonth;
        OptionSignedWithTheCustomerThisMonth = optionSignedWithTheCustomerThisMonth;
        NumberOfOptionTradingAccountsThisMonth = numberOfOptionTradingAccountsThisMonth;
        NumberOfOptionTradingClientStockThisMonth = numberOfOptionTradingClientStockThisMonth;
        OptionSignedWithTheCustomerLastMonth = optionSignedWithTheCustomerLastMonth;
        NumberOfOptionTradingAccountsLastMonth = numberOfOptionTradingAccountsLastMonth;
        NumberOfOptionTradingClientStockLastMonth = numberOfOptionTradingClientStockLastMonth;
        ForwardSignedWithTheCustomerThisMonth = forwardSignedWithTheCustomerThisMonth;
        NumberOfForwardTradingAccountsThisMonth = numberOfForwardTradingAccountsThisMonth;
        NumberOfForwardTradingClientStockThisMonth = numberOfForwardTradingClientStockThisMonth;
        ForwardSignedWithTheCustomerLastMonth = forwardSignedWithTheCustomerLastMonth;
        NumberOfForwardTradingAccountsLastMonth = numberOfForwardTradingAccountsLastMonth;
        NumberOfForwardTradingClientStockLastMonth = numberOfForwardTradingClientStockLastMonth;
        SignedTotalCustomer = signedTotalCustomer;
        TotalNumberOfTradingAccountsAtThisPeriod = totalNumberOfTradingAccountsAtThisPeriod;
        TotalNumberOfTradingClientAccounts = totalNumberOfTradingClientAccounts;
        SignedTotalCustomerLastMonth = signedTotalCustomerLastMonth;
        TotalNumberOfTradingAccountsAtThisPeriodLastMonth = totalNumberOfTradingAccountsAtThisPeriodLastMonth;
        TotalNumberOfTradingClientAccountsLastMonth = totalNumberOfTradingClientAccountsLastMonth;
        TotalNominalPrincipalAmountOfSwapThisMonth = totalNominalPrincipalAmountOfSwapThisMonth;
        TotalNominalPrincipalAmountOfSwapLastMonth = totalNominalPrincipalAmountOfSwapLastMonth;
        TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth = theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth;
        TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth = theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth;
        SwapCashCollateralValueThisMonth = swapCashCollateralValueThisMonth;
        SwapCashCollateralValueLastMonth = swapCashCollateralValueLastMonth;
        SwapSecuritiesCollateralValueThisMonth = swapSecuritiesCollateralValueThisMonth;
        SwapSecuritiesCollateralValueLastMonthThisMonth = swapSecuritiesCollateralValueLastMonthThisMonth;
        ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull = proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull;
        ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull = proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull;
        ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet = proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet;
        ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet = proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet;
        SwapNumberOfDefaultCustomersAtThisMonthThisMonth = swapNumberOfDefaultCustomersAtThisMonthThisMonth;
        SwapNumberOfDefaultCustomersAtThisMonthLastMonth = swapNumberOfDefaultCustomersAtThisMonthLastMonth;
        SwapDefaultTransactionNumberAtThisMonthThisMonth = swapDefaultTransactionNumberAtThisMonthThisMonth;
        SwapDefaultTransactionNumberAtThisMonthLastMonth = swapDefaultTransactionNumberAtThisMonthLastMonth;
        TotalSwapDefaultCustomerNumberInThisYearThisMonth = totalSwapDefaultCustomerNumberInThisYearThisMonth;
        TotalSwapDefaultCustomerNumberInThisYearLastMonth = totalSwapDefaultCustomerNumberInThisYearLastMonth;
        SwapNumberOfDefaultCustomersInThisYearThisMonth = swapNumberOfDefaultCustomersInThisYearThisMonth;
        SwapNumberOfDefaultCustomersInThisYearLastMonth = swapNumberOfDefaultCustomersInThisYearLastMonth;
        TotalNominalPrincipalAmountOfForwardThisMonth = totalNominalPrincipalAmountOfForwardThisMonth;
        TotalNominalPrincipalAmountOfForwardLastMonth = totalNominalPrincipalAmountOfForwardLastMonth;
        TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth = theValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth;
        TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth = theValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth;
        ForwardCashCollateralValueThisMonth = forwardCashCollateralValueThisMonth;
        ForwardCashCollateralValueLastMonth = forwardCashCollateralValueLastMonth;
        ForwardSecuritiesCollateralValueThisMonth = forwardSecuritiesCollateralValueThisMonth;
        ForwardSecuritiesCollateralValueLastMonth = forwardSecuritiesCollateralValueLastMonth;
        ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull = proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull;
        ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull = proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull;
        ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet = proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet;
        ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet = proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet;
        ForwardNumberOfDefaultCustomersAtThisMonthThisMonth = forwardNumberOfDefaultCustomersAtThisMonthThisMonth;
        ForwardNumberOfDefaultCustomersAtThisMonthLastMonth = forwardNumberOfDefaultCustomersAtThisMonthLastMonth;
        ForwardTransactionNumberAtThisMonthThisMonth = forwardTransactionNumberAtThisMonthThisMonth;
        ForwardTransactionNumberAtThisMonthLastMonth = forwardTransactionNumberAtThisMonthLastMonth;
        TotalForwardDefaultCustomerNumberInThisYearThisMonth = totalForwardDefaultCustomerNumberInThisYearThisMonth;
        TotalForwardDefaultCustomerNumberInThisYearLastMonth = totalForwardDefaultCustomerNumberInThisYearLastMonth;
        ForwardNumberOfDefaultCustomersInThisYearThisMonth = forwardNumberOfDefaultCustomersInThisYearThisMonth;
        ForwardNumberOfDefaultCustomersInThisYearLastMonth = forwardNumberOfDefaultCustomersInThisYearLastMonth;
        StockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth = stockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth;
        StockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth = stockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth;
        CashBalanceAtEndOfThisMonth = cashBalanceAtEndOfThisMonth;
        CashBalanceAtEndOfLastMonth = cashBalanceAtEndOfLastMonth;
        HoldStockMarketValueAtEndOfThisMonth = holdStockMarketValueAtEndOfThisMonth;
        HoldStockMarketValueAtEndOfLastMonth = holdStockMarketValueAtEndOfLastMonth;
        HoldMarketValueOfBondsAtTheEndOfThisMonth = holdMarketValueOfBondsAtTheEndOfThisMonth;
        HoldMarketValueOfBondsAtTheEndOfLastMonth = holdMarketValueOfBondsAtTheEndOfLastMonth;
        OwnedAssetManagementProductsAtTheEndOfThisMonth = ownedAssetManagementProductsAtTheEndOfThisMonth;
        OwnedAssetManagementProductsAtTheEndOfLastMonth = ownedAssetManagementProductsAtTheEndOfLastMonth;
        OwnedBankFinanceAtTheEndOfThisMonth = ownedBankFinanceAtTheEndOfThisMonth;
        OwnedBankFinanceAtTheEndOfLastMonth = ownedBankFinanceAtTheEndOfLastMonth;
        HoldTrustProductAtTheEndOfThisMonth = holdTrustProductAtTheEndOfThisMonth;
        HoldTrustProductAtTheEndOfLastMonth = holdTrustProductAtTheEndOfLastMonth;
        InsuranceProductsAreHeldAtTheEndOfThisMonth = insuranceProductsAreHeldAtTheEndOfThisMonth;
        InsuranceProductsAreHeldAtTheEndOfLastMonth = insuranceProductsAreHeldAtTheEndOfLastMonth;
        HoldOtherProductsAtTheEndOfThisMonth = holdOtherProductsAtTheEndOfThisMonth;
        HoldOtherProductsAtTheEndOfLastMonth = holdOtherProductsAtTheEndOfLastMonth;
        SettledSwapItemsAtThisMonth = settledSwapItemsAtThisMonth;
        SettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth = settledSwapTransactionInvolvesNotionalPrincipalAtThisMonth;
        SwapIncomeCashFlow = swapIncomeCashFlow;
        SwapExpensesCashFlow = swapExpensesCashFlow;
        CashFlowCorrespondingToNetIncomeOnSwapMargin = cashFlowCorrespondingToNetIncomeOnSwapMargin;
        SwapHedgeCost = swapHedgeCost;
        SettledOptionItemsAtThisMonth = settledOptionItemsAtThisMonth;
        SettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth = settledOptionTransactionInvolvesNotionalPrincipalAtThisMonth;
        OptionPremiumIncome = optionPremiumIncome;
        OptionHedgeCost = optionHedgeCost;
        SettledForwardItemsAtThisMonth = settledForwardItemsAtThisMonth;
        SettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth = settledForwardTransactionInvolvesNotionalPrincipalAtThisMonth;
        ForwardIncomeCashFlow = forwardIncomeCashFlow;
        ForwardExpensesCashFlow = forwardExpensesCashFlow;
        ForwardHedgeCost = forwardHedgeCost;
        BalanceOfSwapRealizedGainsAndLossesAtThisMonth = balanceOfSwapRealizedGainsAndLossesAtThisMonth;
        BalanceOfOptionRealizedGainsAndLossesAtThisMonth = balanceOfOptionRealizedGainsAndLossesAtThisMonth;
        BalanceOfForwardRealizedGainsAndLossesAtThisMonth = balanceOfForwardRealizedGainsAndLossesAtThisMonth;
        BalanceOfSwapRealizedGainsAndLossesAtThisYear = balanceOfSwapRealizedGainsAndLossesAtThisYear;
        BalanceOfOptionRealizedGainsAndLossesAtThisYear = balanceOfOptionRealizedGainsAndLossesAtThisYear;
        BalanceOfForwardRealizedGainsAndLossesAtThisYear = balanceOfForwardRealizedGainsAndLossesAtThisYear;
        BalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth = balanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth;
        BalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth = balanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth;
        BalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth = balanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth;
        BalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear = balanceOfSwapChangedGainsAndLossesInFairValueAtThisYear;
        BalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear = balanceOfOptionChangedGainsAndLossesInFairValueAtThisYear;
        BalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear = balanceOfForwardChangedGainsAndLossesInFairValueAtThisYear;
        BalanceOfSwapTotalGainsAndLossesAtThisMonth = balanceOfSwapTotalGainsAndLossesAtThisMonth;
        BalanceOfOptionTotalGainsAndLossesAtThisMonth = balanceOfOptionTotalGainsAndLossesAtThisMonth;
        BalanceOfForwardTotalGainsAndLossesAtThisMonth = balanceOfForwardTotalGainsAndLossesAtThisMonth;
        BalanceOfSwapTotalGainsAndLossesAtThisYear = balanceOfSwapTotalGainsAndLossesAtThisYear;
        BalanceOfOptionTotalGainsAndLossesAtThisYear = balanceOfOptionTotalGainsAndLossesAtThisYear;
        BalanceOfForwardTotalGainsAndLossesAtThisYear = balanceOfForwardTotalGainsAndLossesAtThisYear;
        IncreaseBusinessDetailsThisMonthTuple = increaseBusinessDetailsThisMonthTuple;
        TargetCaseAndHedgeTuple = targetCaseAndHedgeTuple;
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

    @JsonProperty("SWAPNominalCapitalStockAtBeginning")
    public String getSWAPNominalCapitalStockAtBeginning() {
        return SWAPNominalCapitalStockAtBeginning;
    }

    public void setSWAPNominalCapitalStockAtBeginning(String SWAPNominalCapitalStockAtBeginning) {
        this.SWAPNominalCapitalStockAtBeginning = SWAPNominalCapitalStockAtBeginning;
    }

    @JsonProperty("SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth")
    public String getSWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth() {
        return SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    }

    public void setSWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth(String SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth) {
        this.SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth = SWAPIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    }

    @JsonProperty("SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth")
    public String getSWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth() {
        return SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    }

    public void setSWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth(String SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth) {
        this.SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth = SWAPNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    }

    @JsonProperty("SWAPNominalCapitalStockAtEnding")
    public String getSWAPNominalCapitalStockAtEnding() {
        return SWAPNominalCapitalStockAtEnding;
    }

    public void setSWAPNominalCapitalStockAtEnding(String SWAPNominalCapitalStockAtEnding) {
        this.SWAPNominalCapitalStockAtEnding = SWAPNominalCapitalStockAtEnding;
    }

    @JsonProperty("SwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction")
    public String getSwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction() {
        return SwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction;
    }

    public void setSwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction(String swapCategoryNominalPrincipalThisYearCumulativeInitialTransaction) {
        SwapCategoryNominalPrincipalThisYearCumulativeInitialTransaction = swapCategoryNominalPrincipalThisYearCumulativeInitialTransaction;
    }

    @JsonProperty("OptionOfNotionalPrincipalStockAtBeginning")
    public String getOptionOfNotionalPrincipalStockAtBeginning() {
        return OptionOfNotionalPrincipalStockAtBeginning;
    }

    public void setOptionOfNotionalPrincipalStockAtBeginning(String optionOfNotionalPrincipalStockAtBeginning) {
        OptionOfNotionalPrincipalStockAtBeginning = optionOfNotionalPrincipalStockAtBeginning;
    }

    @JsonProperty("OptionIncreasedOriginalTransactionNominalCapitalAtThisMonth")
    public String getOptionIncreasedOriginalTransactionNominalCapitalAtThisMonth() {
        return OptionIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    }

    public void setOptionIncreasedOriginalTransactionNominalCapitalAtThisMonth(String optionIncreasedOriginalTransactionNominalCapitalAtThisMonth) {
        OptionIncreasedOriginalTransactionNominalCapitalAtThisMonth = optionIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    }

    @JsonProperty("OptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth")
    public String getOptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth() {
        return OptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    }

    public void setOptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth(String optionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth) {
        OptionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth = optionNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    }

    @JsonProperty("OptionOfNotionalPrincipalStockAtEnding")
    public String getOptionOfNotionalPrincipalStockAtEnding() {
        return OptionOfNotionalPrincipalStockAtEnding;
    }

    public void setOptionOfNotionalPrincipalStockAtEnding(String optionOfNotionalPrincipalStockAtEnding) {
        OptionOfNotionalPrincipalStockAtEnding = optionOfNotionalPrincipalStockAtEnding;
    }

    @JsonProperty("NominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction")
    public String getNominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction() {
        return NominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction;
    }

    public void setNominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction(String nominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction) {
        NominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction = nominalPrincipalOfOptionClassHasBeenAddedToInitialTransaction;
    }

    @JsonProperty("ForwardOfNotionalPrincipalStockAtBeginning")
    public String getForwardOfNotionalPrincipalStockAtBeginning() {
        return ForwardOfNotionalPrincipalStockAtBeginning;
    }

    public void setForwardOfNotionalPrincipalStockAtBeginning(String forwardOfNotionalPrincipalStockAtBeginning) {
        ForwardOfNotionalPrincipalStockAtBeginning = forwardOfNotionalPrincipalStockAtBeginning;
    }

    @JsonProperty("ForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth")
    public String getForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth() {
        return ForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    }

    public void setForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth(String forwardIncreasedOriginalTransactionNominalCapitalAtThisMonth) {
        ForwardIncreasedOriginalTransactionNominalCapitalAtThisMonth = forwardIncreasedOriginalTransactionNominalCapitalAtThisMonth;
    }

    @JsonProperty("ForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth")
    public String getForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth() {
        return ForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    }

    public void setForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth(String forwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth) {
        ForwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth = forwardNotionalPrincipalAmountAllowedToBeTerminatedAtThisMonth;
    }

    @JsonProperty("ForwardOfNotionalPrincipalStockAtEnding")
    public String getForwardOfNotionalPrincipalStockAtEnding() {
        return ForwardOfNotionalPrincipalStockAtEnding;
    }

    public void setForwardOfNotionalPrincipalStockAtEnding(String forwardOfNotionalPrincipalStockAtEnding) {
        ForwardOfNotionalPrincipalStockAtEnding = forwardOfNotionalPrincipalStockAtEnding;
    }

    @JsonProperty("LongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction")
    public String getLongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction() {
        return LongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction;
    }

    public void setLongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction(String longtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction) {
        LongtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction = longtermNominalPrincipalOfYearHasBeenAddedToInitialTransaction;
    }

    @JsonProperty("StockOfSwapContractsAtBeginning")
    public String getStockOfSwapContractsAtBeginning() {
        return StockOfSwapContractsAtBeginning;
    }

    public void setStockOfSwapContractsAtBeginning(String stockOfSwapContractsAtBeginning) {
        StockOfSwapContractsAtBeginning = stockOfSwapContractsAtBeginning;
    }

    @JsonProperty("NumberOfNewSwapInitialTradingContractsAtThisMonth")
    public String getNumberOfNewSwapInitialTradingContractsAtThisMonth() {
        return NumberOfNewSwapInitialTradingContractsAtThisMonth;
    }

    public void setNumberOfNewSwapInitialTradingContractsAtThisMonth(String numberOfNewSwapInitialTradingContractsAtThisMonth) {
        NumberOfNewSwapInitialTradingContractsAtThisMonth = numberOfNewSwapInitialTradingContractsAtThisMonth;
    }

    @JsonProperty("NumberOfSwapContractsToTerminateAtThisMonth")
    public String getNumberOfSwapContractsToTerminateAtThisMonth() {
        return NumberOfSwapContractsToTerminateAtThisMonth;
    }

    public void setNumberOfSwapContractsToTerminateAtThisMonth(String numberOfSwapContractsToTerminateAtThisMonth) {
        NumberOfSwapContractsToTerminateAtThisMonth = numberOfSwapContractsToTerminateAtThisMonth;
    }

    @JsonProperty("StockOfSwapContractsAtEnding")
    public String getStockOfSwapContractsAtEnding() {
        return StockOfSwapContractsAtEnding;
    }

    public void setStockOfSwapContractsAtEnding(String stockOfSwapContractsAtEnding) {
        StockOfSwapContractsAtEnding = stockOfSwapContractsAtEnding;
    }

    @JsonProperty("NumberOfSwapContractsIncreasedByThisYear")
    public String getNumberOfSwapContractsIncreasedByThisYear() {
        return NumberOfSwapContractsIncreasedByThisYear;
    }

    public void setNumberOfSwapContractsIncreasedByThisYear(String numberOfSwapContractsIncreasedByThisYear) {
        NumberOfSwapContractsIncreasedByThisYear = numberOfSwapContractsIncreasedByThisYear;
    }

    @JsonProperty("StockOfOptionContractsAtBeginning")
    public String getStockOfOptionContractsAtBeginning() {
        return StockOfOptionContractsAtBeginning;
    }

    public void setStockOfOptionContractsAtBeginning(String stockOfOptionContractsAtBeginning) {
        StockOfOptionContractsAtBeginning = stockOfOptionContractsAtBeginning;
    }

    @JsonProperty("NumberOfNewOptionInitialTradingContractsAtThisMonth")
    public String getNumberOfNewOptionInitialTradingContractsAtThisMonth() {
        return NumberOfNewOptionInitialTradingContractsAtThisMonth;
    }

    public void setNumberOfNewOptionInitialTradingContractsAtThisMonth(String numberOfNewOptionInitialTradingContractsAtThisMonth) {
        NumberOfNewOptionInitialTradingContractsAtThisMonth = numberOfNewOptionInitialTradingContractsAtThisMonth;
    }

    @JsonProperty("NumberOfOptionContractsToTerminateAtThisMonth")
    public String getNumberOfOptionContractsToTerminateAtThisMonth() {
        return NumberOfOptionContractsToTerminateAtThisMonth;
    }

    public void setNumberOfOptionContractsToTerminateAtThisMonth(String numberOfOptionContractsToTerminateAtThisMonth) {
        NumberOfOptionContractsToTerminateAtThisMonth = numberOfOptionContractsToTerminateAtThisMonth;
    }

    @JsonProperty("StockOfOptionContractsAtEnding")
    public String getStockOfOptionContractsAtEnding() {
        return StockOfOptionContractsAtEnding;
    }

    public void setStockOfOptionContractsAtEnding(String stockOfOptionContractsAtEnding) {
        StockOfOptionContractsAtEnding = stockOfOptionContractsAtEnding;
    }

    @JsonProperty("NumberOfOptionContractsHasIncreasedInitialTransaction")
    public String getNumberOfOptionContractsHasIncreasedInitialTransaction() {
        return NumberOfOptionContractsHasIncreasedInitialTransaction;
    }

    public void setNumberOfOptionContractsHasIncreasedInitialTransaction(String numberOfOptionContractsHasIncreasedInitialTransaction) {
        NumberOfOptionContractsHasIncreasedInitialTransaction = numberOfOptionContractsHasIncreasedInitialTransaction;
    }

    @JsonProperty("StockOfForwardContractsAtBeginning")
    public String getStockOfForwardContractsAtBeginning() {
        return StockOfForwardContractsAtBeginning;
    }

    public void setStockOfForwardContractsAtBeginning(String stockOfForwardContractsAtBeginning) {
        StockOfForwardContractsAtBeginning = stockOfForwardContractsAtBeginning;
    }

    @JsonProperty("NumberOfNewForwardInitialTradingContractsAtThisMonth")
    public String getNumberOfNewForwardInitialTradingContractsAtThisMonth() {
        return NumberOfNewForwardInitialTradingContractsAtThisMonth;
    }

    public void setNumberOfNewForwardInitialTradingContractsAtThisMonth(String numberOfNewForwardInitialTradingContractsAtThisMonth) {
        NumberOfNewForwardInitialTradingContractsAtThisMonth = numberOfNewForwardInitialTradingContractsAtThisMonth;
    }

    @JsonProperty("NumberOfForwardContractsToTerminateAtThisMonth")
    public String getNumberOfForwardContractsToTerminateAtThisMonth() {
        return NumberOfForwardContractsToTerminateAtThisMonth;
    }

    public void setNumberOfForwardContractsToTerminateAtThisMonth(String numberOfForwardContractsToTerminateAtThisMonth) {
        NumberOfForwardContractsToTerminateAtThisMonth = numberOfForwardContractsToTerminateAtThisMonth;
    }

    @JsonProperty("StockOfForwardContractsAtEnding")
    public String getStockOfForwardContractsAtEnding() {
        return StockOfForwardContractsAtEnding;
    }

    public void setStockOfForwardContractsAtEnding(String stockOfForwardContractsAtEnding) {
        StockOfForwardContractsAtEnding = stockOfForwardContractsAtEnding;
    }

    @JsonProperty("NumberOfForwardContractsHasIncreasedInitialTransaction")
    public String getNumberOfForwardContractsHasIncreasedInitialTransaction() {
        return NumberOfForwardContractsHasIncreasedInitialTransaction;
    }

    public void setNumberOfForwardContractsHasIncreasedInitialTransaction(String numberOfForwardContractsHasIncreasedInitialTransaction) {
        NumberOfForwardContractsHasIncreasedInitialTransaction = numberOfForwardContractsHasIncreasedInitialTransaction;
    }

    @JsonProperty("SwapSignedWithTheCustomerThisMonth")
    public String getSwapSignedWithTheCustomerThisMonth() {
        return SwapSignedWithTheCustomerThisMonth;
    }

    public void setSwapSignedWithTheCustomerThisMonth(String swapSignedWithTheCustomerThisMonth) {
        SwapSignedWithTheCustomerThisMonth = swapSignedWithTheCustomerThisMonth;
    }

    @JsonProperty("NumberOfSwapTradingAccountsAtThisPeriodThisMonth")
    public String getNumberOfSwapTradingAccountsAtThisPeriodThisMonth() {
        return NumberOfSwapTradingAccountsAtThisPeriodThisMonth;
    }

    public void setNumberOfSwapTradingAccountsAtThisPeriodThisMonth(String numberOfSwapTradingAccountsAtThisPeriodThisMonth) {
        NumberOfSwapTradingAccountsAtThisPeriodThisMonth = numberOfSwapTradingAccountsAtThisPeriodThisMonth;
    }

    @JsonProperty("NumberOfSwapTradingClientStockThisMonth")
    public String getNumberOfSwapTradingClientStockThisMonth() {
        return NumberOfSwapTradingClientStockThisMonth;
    }

    public void setNumberOfSwapTradingClientStockThisMonth(String numberOfSwapTradingClientStockThisMonth) {
        NumberOfSwapTradingClientStockThisMonth = numberOfSwapTradingClientStockThisMonth;
    }

    @JsonProperty("SwapSignedWithTheCustomerLastMonth")
    public String getSwapSignedWithTheCustomerLastMonth() {
        return SwapSignedWithTheCustomerLastMonth;
    }

    public void setSwapSignedWithTheCustomerLastMonth(String swapSignedWithTheCustomerLastMonth) {
        SwapSignedWithTheCustomerLastMonth = swapSignedWithTheCustomerLastMonth;
    }

    @JsonProperty("NumberOfSwapTradingAccountsLastMonth")
    public String getNumberOfSwapTradingAccountsLastMonth() {
        return NumberOfSwapTradingAccountsLastMonth;
    }

    public void setNumberOfSwapTradingAccountsLastMonth(String numberOfSwapTradingAccountsLastMonth) {
        NumberOfSwapTradingAccountsLastMonth = numberOfSwapTradingAccountsLastMonth;
    }

    @JsonProperty("NumberOfSwapTradingClientStockLastMonth")
    public String getNumberOfSwapTradingClientStockLastMonth() {
        return NumberOfSwapTradingClientStockLastMonth;
    }

    public void setNumberOfSwapTradingClientStockLastMonth(String numberOfSwapTradingClientStockLastMonth) {
        NumberOfSwapTradingClientStockLastMonth = numberOfSwapTradingClientStockLastMonth;
    }

    @JsonProperty("OptionSignedWithTheCustomerThisMonth")
    public String getOptionSignedWithTheCustomerThisMonth() {
        return OptionSignedWithTheCustomerThisMonth;
    }

    public void setOptionSignedWithTheCustomerThisMonth(String optionSignedWithTheCustomerThisMonth) {
        OptionSignedWithTheCustomerThisMonth = optionSignedWithTheCustomerThisMonth;
    }

    @JsonProperty("NumberOfOptionTradingAccountsThisMonth")
    public String getNumberOfOptionTradingAccountsThisMonth() {
        return NumberOfOptionTradingAccountsThisMonth;
    }

    public void setNumberOfOptionTradingAccountsThisMonth(String numberOfOptionTradingAccountsThisMonth) {
        NumberOfOptionTradingAccountsThisMonth = numberOfOptionTradingAccountsThisMonth;
    }

    @JsonProperty("NumberOfOptionTradingClientStockThisMonth")
    public String getNumberOfOptionTradingClientStockThisMonth() {
        return NumberOfOptionTradingClientStockThisMonth;
    }

    public void setNumberOfOptionTradingClientStockThisMonth(String numberOfOptionTradingClientStockThisMonth) {
        NumberOfOptionTradingClientStockThisMonth = numberOfOptionTradingClientStockThisMonth;
    }

    @JsonProperty("OptionSignedWithTheCustomerLastMonth")
    public String getOptionSignedWithTheCustomerLastMonth() {
        return OptionSignedWithTheCustomerLastMonth;
    }

    public void setOptionSignedWithTheCustomerLastMonth(String optionSignedWithTheCustomerLastMonth) {
        OptionSignedWithTheCustomerLastMonth = optionSignedWithTheCustomerLastMonth;
    }

    @JsonProperty("NumberOfOptionTradingAccountsLastMonth")
    public String getNumberOfOptionTradingAccountsLastMonth() {
        return NumberOfOptionTradingAccountsLastMonth;
    }

    public void setNumberOfOptionTradingAccountsLastMonth(String numberOfOptionTradingAccountsLastMonth) {
        NumberOfOptionTradingAccountsLastMonth = numberOfOptionTradingAccountsLastMonth;
    }

    @JsonProperty("NumberOfOptionTradingClientStockLastMonth")
    public String getNumberOfOptionTradingClientStockLastMonth() {
        return NumberOfOptionTradingClientStockLastMonth;
    }

    public void setNumberOfOptionTradingClientStockLastMonth(String numberOfOptionTradingClientStockLastMonth) {
        NumberOfOptionTradingClientStockLastMonth = numberOfOptionTradingClientStockLastMonth;
    }

    @JsonProperty("ForwardSignedWithTheCustomerThisMonth")
    public String getForwardSignedWithTheCustomerThisMonth() {
        return ForwardSignedWithTheCustomerThisMonth;
    }

    public void setForwardSignedWithTheCustomerThisMonth(String forwardSignedWithTheCustomerThisMonth) {
        ForwardSignedWithTheCustomerThisMonth = forwardSignedWithTheCustomerThisMonth;
    }

    @JsonProperty("NumberOfForwardTradingAccountsThisMonth")
    public String getNumberOfForwardTradingAccountsThisMonth() {
        return NumberOfForwardTradingAccountsThisMonth;
    }

    public void setNumberOfForwardTradingAccountsThisMonth(String numberOfForwardTradingAccountsThisMonth) {
        NumberOfForwardTradingAccountsThisMonth = numberOfForwardTradingAccountsThisMonth;
    }

    @JsonProperty("NumberOfForwardTradingClientStockThisMonth")
    public String getNumberOfForwardTradingClientStockThisMonth() {
        return NumberOfForwardTradingClientStockThisMonth;
    }

    public void setNumberOfForwardTradingClientStockThisMonth(String numberOfForwardTradingClientStockThisMonth) {
        NumberOfForwardTradingClientStockThisMonth = numberOfForwardTradingClientStockThisMonth;
    }

    @JsonProperty("ForwardSignedWithTheCustomerLastMonth")
    public String getForwardSignedWithTheCustomerLastMonth() {
        return ForwardSignedWithTheCustomerLastMonth;
    }

    public void setForwardSignedWithTheCustomerLastMonth(String forwardSignedWithTheCustomerLastMonth) {
        ForwardSignedWithTheCustomerLastMonth = forwardSignedWithTheCustomerLastMonth;
    }

    @JsonProperty("NumberOfForwardTradingAccountsLastMonth")
    public String getNumberOfForwardTradingAccountsLastMonth() {
        return NumberOfForwardTradingAccountsLastMonth;
    }

    public void setNumberOfForwardTradingAccountsLastMonth(String numberOfForwardTradingAccountsLastMonth) {
        NumberOfForwardTradingAccountsLastMonth = numberOfForwardTradingAccountsLastMonth;
    }

    @JsonProperty("NumberOfForwardTradingClientStockLastMonth")
    public String getNumberOfForwardTradingClientStockLastMonth() {
        return NumberOfForwardTradingClientStockLastMonth;
    }

    public void setNumberOfForwardTradingClientStockLastMonth(String numberOfForwardTradingClientStockLastMonth) {
        NumberOfForwardTradingClientStockLastMonth = numberOfForwardTradingClientStockLastMonth;
    }

    @JsonProperty("SignedTotalCustomer")
    public String getSignedTotalCustomer() {
        return SignedTotalCustomer;
    }

    public void setSignedTotalCustomer(String signedTotalCustomer) {
        SignedTotalCustomer = signedTotalCustomer;
    }

    @JsonProperty("TotalNumberOfTradingAccountsAtThisPeriod")
    public String getTotalNumberOfTradingAccountsAtThisPeriod() {
        return TotalNumberOfTradingAccountsAtThisPeriod;
    }

    public void setTotalNumberOfTradingAccountsAtThisPeriod(String totalNumberOfTradingAccountsAtThisPeriod) {
        TotalNumberOfTradingAccountsAtThisPeriod = totalNumberOfTradingAccountsAtThisPeriod;
    }

    @JsonProperty("TotalNumberOfTradingClientAccounts")
    public String getTotalNumberOfTradingClientAccounts() {
        return TotalNumberOfTradingClientAccounts;
    }

    public void setTotalNumberOfTradingClientAccounts(String totalNumberOfTradingClientAccounts) {
        TotalNumberOfTradingClientAccounts = totalNumberOfTradingClientAccounts;
    }

    @JsonProperty("SignedTotalCustomerLastMonth")
    public String getSignedTotalCustomerLastMonth() {
        return SignedTotalCustomerLastMonth;
    }

    public void setSignedTotalCustomerLastMonth(String signedTotalCustomerLastMonth) {
        SignedTotalCustomerLastMonth = signedTotalCustomerLastMonth;
    }

    @JsonProperty("TotalNumberOfTradingAccountsAtThisPeriodLastMonth")
    public String getTotalNumberOfTradingAccountsAtThisPeriodLastMonth() {
        return TotalNumberOfTradingAccountsAtThisPeriodLastMonth;
    }

    public void setTotalNumberOfTradingAccountsAtThisPeriodLastMonth(String totalNumberOfTradingAccountsAtThisPeriodLastMonth) {
        TotalNumberOfTradingAccountsAtThisPeriodLastMonth = totalNumberOfTradingAccountsAtThisPeriodLastMonth;
    }

    @JsonProperty("TotalNumberOfTradingClientAccountsLastMonth")
    public String getTotalNumberOfTradingClientAccountsLastMonth() {
        return TotalNumberOfTradingClientAccountsLastMonth;
    }

    public void setTotalNumberOfTradingClientAccountsLastMonth(String totalNumberOfTradingClientAccountsLastMonth) {
        TotalNumberOfTradingClientAccountsLastMonth = totalNumberOfTradingClientAccountsLastMonth;
    }

    @JsonProperty("TotalNominalPrincipalAmountOfSwapThisMonth")
    public String getTotalNominalPrincipalAmountOfSwapThisMonth() {
        return TotalNominalPrincipalAmountOfSwapThisMonth;
    }

    public void setTotalNominalPrincipalAmountOfSwapThisMonth(String totalNominalPrincipalAmountOfSwapThisMonth) {
        TotalNominalPrincipalAmountOfSwapThisMonth = totalNominalPrincipalAmountOfSwapThisMonth;
    }

    @JsonProperty("TotalNominalPrincipalAmountOfSwapLastMonth")
    public String getTotalNominalPrincipalAmountOfSwapLastMonth() {
        return TotalNominalPrincipalAmountOfSwapLastMonth;
    }

    public void setTotalNominalPrincipalAmountOfSwapLastMonth(String totalNominalPrincipalAmountOfSwapLastMonth) {
        TotalNominalPrincipalAmountOfSwapLastMonth = totalNominalPrincipalAmountOfSwapLastMonth;
    }

    @JsonProperty("TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth")
    public String getTheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth() {
        return TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth;
    }

    public void setTheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth(String theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth) {
        TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth = theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth;
    }

    @JsonProperty("TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth")
    public String getTheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth() {
        return TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth;
    }

    public void setTheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth(String theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth) {
        TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth = theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth;
    }

    @JsonProperty("SwapCashCollateralValueThisMonth")
    public String getSwapCashCollateralValueThisMonth() {
        return SwapCashCollateralValueThisMonth;
    }

    public void setSwapCashCollateralValueThisMonth(String swapCashCollateralValueThisMonth) {
        SwapCashCollateralValueThisMonth = swapCashCollateralValueThisMonth;
    }

    @JsonProperty("SwapCashCollateralValueLastMonth")
    public String getSwapCashCollateralValueLastMonth() {
        return SwapCashCollateralValueLastMonth;
    }

    public void setSwapCashCollateralValueLastMonth(String swapCashCollateralValueLastMonth) {
        SwapCashCollateralValueLastMonth = swapCashCollateralValueLastMonth;
    }

    @JsonProperty("SwapSecuritiesCollateralValueThisMonth")
    public String getSwapSecuritiesCollateralValueThisMonth() {
        return SwapSecuritiesCollateralValueThisMonth;
    }

    public void setSwapSecuritiesCollateralValueThisMonth(String swapSecuritiesCollateralValueThisMonth) {
        SwapSecuritiesCollateralValueThisMonth = swapSecuritiesCollateralValueThisMonth;
    }

    @JsonProperty("SwapSecuritiesCollateralValueLastMonthThisMonth")
    public String getSwapSecuritiesCollateralValueLastMonthThisMonth() {
        return SwapSecuritiesCollateralValueLastMonthThisMonth;
    }

    public void setSwapSecuritiesCollateralValueLastMonthThisMonth(String swapSecuritiesCollateralValueLastMonthThisMonth) {
        SwapSecuritiesCollateralValueLastMonthThisMonth = swapSecuritiesCollateralValueLastMonthThisMonth;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull")
    public String getProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull() {
        return ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull;
    }

    public void setProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull(String proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull) {
        ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull = proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull")
    public String getProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull() {
        return ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull;
    }

    public void setProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull(String proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull) {
        ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull = proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet")
    public String getProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet() {
        return ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet;
    }

    public void setProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet(String proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet) {
        ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet = proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet")
    public String getProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet() {
        return ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet;
    }

    public void setProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet(String proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet) {
        ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet = proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet;
    }

    @JsonProperty("SwapNumberOfDefaultCustomersAtThisMonthThisMonth")
    public String getSwapNumberOfDefaultCustomersAtThisMonthThisMonth() {
        return SwapNumberOfDefaultCustomersAtThisMonthThisMonth;
    }

    public void setSwapNumberOfDefaultCustomersAtThisMonthThisMonth(String swapNumberOfDefaultCustomersAtThisMonthThisMonth) {
        SwapNumberOfDefaultCustomersAtThisMonthThisMonth = swapNumberOfDefaultCustomersAtThisMonthThisMonth;
    }

    @JsonProperty("SwapNumberOfDefaultCustomersAtThisMonthLastMonth")
    public String getSwapNumberOfDefaultCustomersAtThisMonthLastMonth() {
        return SwapNumberOfDefaultCustomersAtThisMonthLastMonth;
    }

    public void setSwapNumberOfDefaultCustomersAtThisMonthLastMonth(String swapNumberOfDefaultCustomersAtThisMonthLastMonth) {
        SwapNumberOfDefaultCustomersAtThisMonthLastMonth = swapNumberOfDefaultCustomersAtThisMonthLastMonth;
    }

    @JsonProperty("SwapDefaultTransactionNumberAtThisMonthThisMonth")
    public String getSwapDefaultTransactionNumberAtThisMonthThisMonth() {
        return SwapDefaultTransactionNumberAtThisMonthThisMonth;
    }

    public void setSwapDefaultTransactionNumberAtThisMonthThisMonth(String swapDefaultTransactionNumberAtThisMonthThisMonth) {
        SwapDefaultTransactionNumberAtThisMonthThisMonth = swapDefaultTransactionNumberAtThisMonthThisMonth;
    }

    @JsonProperty("SwapDefaultTransactionNumberAtThisMonthLastMonth")
    public String getSwapDefaultTransactionNumberAtThisMonthLastMonth() {
        return SwapDefaultTransactionNumberAtThisMonthLastMonth;
    }

    public void setSwapDefaultTransactionNumberAtThisMonthLastMonth(String swapDefaultTransactionNumberAtThisMonthLastMonth) {
        SwapDefaultTransactionNumberAtThisMonthLastMonth = swapDefaultTransactionNumberAtThisMonthLastMonth;
    }

    @JsonProperty("TotalSwapDefaultCustomerNumberInThisYearThisMonth")
    public String getTotalSwapDefaultCustomerNumberInThisYearThisMonth() {
        return TotalSwapDefaultCustomerNumberInThisYearThisMonth;
    }

    public void setTotalSwapDefaultCustomerNumberInThisYearThisMonth(String totalSwapDefaultCustomerNumberInThisYearThisMonth) {
        TotalSwapDefaultCustomerNumberInThisYearThisMonth = totalSwapDefaultCustomerNumberInThisYearThisMonth;
    }

    @JsonProperty("TotalSwapDefaultCustomerNumberInThisYearLastMonth")
    public String getTotalSwapDefaultCustomerNumberInThisYearLastMonth() {
        return TotalSwapDefaultCustomerNumberInThisYearLastMonth;
    }

    public void setTotalSwapDefaultCustomerNumberInThisYearLastMonth(String totalSwapDefaultCustomerNumberInThisYearLastMonth) {
        TotalSwapDefaultCustomerNumberInThisYearLastMonth = totalSwapDefaultCustomerNumberInThisYearLastMonth;
    }

    @JsonProperty("SwapNumberOfDefaultCustomersInThisYearThisMonth")
    public String getSwapNumberOfDefaultCustomersInThisYearThisMonth() {
        return SwapNumberOfDefaultCustomersInThisYearThisMonth;
    }

    public void setSwapNumberOfDefaultCustomersInThisYearThisMonth(String swapNumberOfDefaultCustomersInThisYearThisMonth) {
        SwapNumberOfDefaultCustomersInThisYearThisMonth = swapNumberOfDefaultCustomersInThisYearThisMonth;
    }

    @JsonProperty("SwapNumberOfDefaultCustomersInThisYearLastMonth")
    public String getSwapNumberOfDefaultCustomersInThisYearLastMonth() {
        return SwapNumberOfDefaultCustomersInThisYearLastMonth;
    }

    public void setSwapNumberOfDefaultCustomersInThisYearLastMonth(String swapNumberOfDefaultCustomersInThisYearLastMonth) {
        SwapNumberOfDefaultCustomersInThisYearLastMonth = swapNumberOfDefaultCustomersInThisYearLastMonth;
    }

    @JsonProperty("TotalNominalPrincipalAmountOfForwardThisMonth")
    public String getTotalNominalPrincipalAmountOfForwardThisMonth() {
        return TotalNominalPrincipalAmountOfForwardThisMonth;
    }

    public void setTotalNominalPrincipalAmountOfForwardThisMonth(String totalNominalPrincipalAmountOfForwardThisMonth) {
        TotalNominalPrincipalAmountOfForwardThisMonth = totalNominalPrincipalAmountOfForwardThisMonth;
    }

    @JsonProperty("TotalNominalPrincipalAmountOfForwardLastMonth")
    public String getTotalNominalPrincipalAmountOfForwardLastMonth() {
        return TotalNominalPrincipalAmountOfForwardLastMonth;
    }

    public void setTotalNominalPrincipalAmountOfForwardLastMonth(String totalNominalPrincipalAmountOfForwardLastMonth) {
        TotalNominalPrincipalAmountOfForwardLastMonth = totalNominalPrincipalAmountOfForwardLastMonth;
    }

    @JsonProperty("TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth")
    public String getTheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth() {
        return TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth;
    }

    public void setTheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth(String theValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth) {
        TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth = theValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth;
    }

    @JsonProperty("TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth")
    public String getTheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth() {
        return TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth;
    }

    public void setTheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth(String theValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth) {
        TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth = theValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth;
    }

    @JsonProperty("ForwardCashCollateralValueThisMonth")
    public String getForwardCashCollateralValueThisMonth() {
        return ForwardCashCollateralValueThisMonth;
    }

    public void setForwardCashCollateralValueThisMonth(String forwardCashCollateralValueThisMonth) {
        ForwardCashCollateralValueThisMonth = forwardCashCollateralValueThisMonth;
    }

    @JsonProperty("ForwardCashCollateralValueLastMonth")
    public String getForwardCashCollateralValueLastMonth() {
        return ForwardCashCollateralValueLastMonth;
    }

    public void setForwardCashCollateralValueLastMonth(String forwardCashCollateralValueLastMonth) {
        ForwardCashCollateralValueLastMonth = forwardCashCollateralValueLastMonth;
    }

    @JsonProperty("ForwardSecuritiesCollateralValueThisMonth")
    public String getForwardSecuritiesCollateralValueThisMonth() {
        return ForwardSecuritiesCollateralValueThisMonth;
    }

    public void setForwardSecuritiesCollateralValueThisMonth(String forwardSecuritiesCollateralValueThisMonth) {
        ForwardSecuritiesCollateralValueThisMonth = forwardSecuritiesCollateralValueThisMonth;
    }

    @JsonProperty("ForwardSecuritiesCollateralValueLastMonth")
    public String getForwardSecuritiesCollateralValueLastMonth() {
        return ForwardSecuritiesCollateralValueLastMonth;
    }

    public void setForwardSecuritiesCollateralValueLastMonth(String forwardSecuritiesCollateralValueLastMonth) {
        ForwardSecuritiesCollateralValueLastMonth = forwardSecuritiesCollateralValueLastMonth;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull")
    public String getProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull() {
        return ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull;
    }

    public void setProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull(String proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull) {
        ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull = proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull")
    public String getProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull() {
        return ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull;
    }

    public void setProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull(String proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull) {
        ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull = proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet")
    public String getProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet() {
        return ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet;
    }

    public void setProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet(String proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet) {
        ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet = proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet;
    }

    @JsonProperty("ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet")
    public String getProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet() {
        return ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet;
    }

    public void setProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet(String proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet) {
        ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet = proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet;
    }

    @JsonProperty("ForwardNumberOfDefaultCustomersAtThisMonthThisMonth")
    public String getForwardNumberOfDefaultCustomersAtThisMonthThisMonth() {
        return ForwardNumberOfDefaultCustomersAtThisMonthThisMonth;
    }

    public void setForwardNumberOfDefaultCustomersAtThisMonthThisMonth(String forwardNumberOfDefaultCustomersAtThisMonthThisMonth) {
        ForwardNumberOfDefaultCustomersAtThisMonthThisMonth = forwardNumberOfDefaultCustomersAtThisMonthThisMonth;
    }

    @JsonProperty("ForwardNumberOfDefaultCustomersAtThisMonthLastMonth")
    public String getForwardNumberOfDefaultCustomersAtThisMonthLastMonth() {
        return ForwardNumberOfDefaultCustomersAtThisMonthLastMonth;
    }

    public void setForwardNumberOfDefaultCustomersAtThisMonthLastMonth(String forwardNumberOfDefaultCustomersAtThisMonthLastMonth) {
        ForwardNumberOfDefaultCustomersAtThisMonthLastMonth = forwardNumberOfDefaultCustomersAtThisMonthLastMonth;
    }

    @JsonProperty("ForwardTransactionNumberAtThisMonthThisMonth")
    public String getForwardTransactionNumberAtThisMonthThisMonth() {
        return ForwardTransactionNumberAtThisMonthThisMonth;
    }

    public void setForwardTransactionNumberAtThisMonthThisMonth(String forwardTransactionNumberAtThisMonthThisMonth) {
        ForwardTransactionNumberAtThisMonthThisMonth = forwardTransactionNumberAtThisMonthThisMonth;
    }

    @JsonProperty("ForwardTransactionNumberAtThisMonthLastMonth")
    public String getForwardTransactionNumberAtThisMonthLastMonth() {
        return ForwardTransactionNumberAtThisMonthLastMonth;
    }

    public void setForwardTransactionNumberAtThisMonthLastMonth(String forwardTransactionNumberAtThisMonthLastMonth) {
        ForwardTransactionNumberAtThisMonthLastMonth = forwardTransactionNumberAtThisMonthLastMonth;
    }

    @JsonProperty("TotalForwardDefaultCustomerNumberInThisYearThisMonth")
    public String getTotalForwardDefaultCustomerNumberInThisYearThisMonth() {
        return TotalForwardDefaultCustomerNumberInThisYearThisMonth;
    }

    public void setTotalForwardDefaultCustomerNumberInThisYearThisMonth(String totalForwardDefaultCustomerNumberInThisYearThisMonth) {
        TotalForwardDefaultCustomerNumberInThisYearThisMonth = totalForwardDefaultCustomerNumberInThisYearThisMonth;
    }

    @JsonProperty("TotalForwardDefaultCustomerNumberInThisYearLastMonth")
    public String getTotalForwardDefaultCustomerNumberInThisYearLastMonth() {
        return TotalForwardDefaultCustomerNumberInThisYearLastMonth;
    }

    public void setTotalForwardDefaultCustomerNumberInThisYearLastMonth(String totalForwardDefaultCustomerNumberInThisYearLastMonth) {
        TotalForwardDefaultCustomerNumberInThisYearLastMonth = totalForwardDefaultCustomerNumberInThisYearLastMonth;
    }

    @JsonProperty("ForwardNumberOfDefaultCustomersInThisYearThisMonth")
    public String getForwardNumberOfDefaultCustomersInThisYearThisMonth() {
        return ForwardNumberOfDefaultCustomersInThisYearThisMonth;
    }

    public void setForwardNumberOfDefaultCustomersInThisYearThisMonth(String forwardNumberOfDefaultCustomersInThisYearThisMonth) {
        ForwardNumberOfDefaultCustomersInThisYearThisMonth = forwardNumberOfDefaultCustomersInThisYearThisMonth;
    }

    @JsonProperty("ForwardNumberOfDefaultCustomersInThisYearLastMonth")
    public String getForwardNumberOfDefaultCustomersInThisYearLastMonth() {
        return ForwardNumberOfDefaultCustomersInThisYearLastMonth;
    }

    public void setForwardNumberOfDefaultCustomersInThisYearLastMonth(String forwardNumberOfDefaultCustomersInThisYearLastMonth) {
        ForwardNumberOfDefaultCustomersInThisYearLastMonth = forwardNumberOfDefaultCustomersInThisYearLastMonth;
    }

    @JsonProperty("StockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth")
    public String getStockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth() {
        return StockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth;
    }

    public void setStockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth(String stockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth) {
        StockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth = stockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth;
    }

    @JsonProperty("StockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth")
    public String getStockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth() {
        return StockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth;
    }

    public void setStockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth(String stockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth) {
        StockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth = stockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth;
    }

    @JsonProperty("CashBalanceAtEndOfThisMonth")
    public String getCashBalanceAtEndOfThisMonth() {
        return CashBalanceAtEndOfThisMonth;
    }

    public void setCashBalanceAtEndOfThisMonth(String cashBalanceAtEndOfThisMonth) {
        CashBalanceAtEndOfThisMonth = cashBalanceAtEndOfThisMonth;
    }

    @JsonProperty("CashBalanceAtEndOfLastMonth")
    public String getCashBalanceAtEndOfLastMonth() {
        return CashBalanceAtEndOfLastMonth;
    }

    public void setCashBalanceAtEndOfLastMonth(String cashBalanceAtEndOfLastMonth) {
        CashBalanceAtEndOfLastMonth = cashBalanceAtEndOfLastMonth;
    }

    @JsonProperty("HoldStockMarketValueAtEndOfThisMonth")
    public String getHoldStockMarketValueAtEndOfThisMonth() {
        return HoldStockMarketValueAtEndOfThisMonth;
    }

    public void setHoldStockMarketValueAtEndOfThisMonth(String holdStockMarketValueAtEndOfThisMonth) {
        HoldStockMarketValueAtEndOfThisMonth = holdStockMarketValueAtEndOfThisMonth;
    }

    @JsonProperty("HoldStockMarketValueAtEndOfLastMonth")
    public String getHoldStockMarketValueAtEndOfLastMonth() {
        return HoldStockMarketValueAtEndOfLastMonth;
    }

    public void setHoldStockMarketValueAtEndOfLastMonth(String holdStockMarketValueAtEndOfLastMonth) {
        HoldStockMarketValueAtEndOfLastMonth = holdStockMarketValueAtEndOfLastMonth;
    }

    @JsonProperty("HoldMarketValueOfBondsAtTheEndOfThisMonth")
    public String getHoldMarketValueOfBondsAtTheEndOfThisMonth() {
        return HoldMarketValueOfBondsAtTheEndOfThisMonth;
    }

    public void setHoldMarketValueOfBondsAtTheEndOfThisMonth(String holdMarketValueOfBondsAtTheEndOfThisMonth) {
        HoldMarketValueOfBondsAtTheEndOfThisMonth = holdMarketValueOfBondsAtTheEndOfThisMonth;
    }

    @JsonProperty("HoldMarketValueOfBondsAtTheEndOfLastMonth")
    public String getHoldMarketValueOfBondsAtTheEndOfLastMonth() {
        return HoldMarketValueOfBondsAtTheEndOfLastMonth;
    }

    public void setHoldMarketValueOfBondsAtTheEndOfLastMonth(String holdMarketValueOfBondsAtTheEndOfLastMonth) {
        HoldMarketValueOfBondsAtTheEndOfLastMonth = holdMarketValueOfBondsAtTheEndOfLastMonth;
    }

    @JsonProperty("OwnedAssetManagementProductsAtTheEndOfThisMonth")
    public String getOwnedAssetManagementProductsAtTheEndOfThisMonth() {
        return OwnedAssetManagementProductsAtTheEndOfThisMonth;
    }

    public void setOwnedAssetManagementProductsAtTheEndOfThisMonth(String ownedAssetManagementProductsAtTheEndOfThisMonth) {
        OwnedAssetManagementProductsAtTheEndOfThisMonth = ownedAssetManagementProductsAtTheEndOfThisMonth;
    }

    @JsonProperty("OwnedAssetManagementProductsAtTheEndOfLastMonth")
    public String getOwnedAssetManagementProductsAtTheEndOfLastMonth() {
        return OwnedAssetManagementProductsAtTheEndOfLastMonth;
    }

    public void setOwnedAssetManagementProductsAtTheEndOfLastMonth(String ownedAssetManagementProductsAtTheEndOfLastMonth) {
        OwnedAssetManagementProductsAtTheEndOfLastMonth = ownedAssetManagementProductsAtTheEndOfLastMonth;
    }

    @JsonProperty("OwnedBankFinanceAtTheEndOfThisMonth")
    public String getOwnedBankFinanceAtTheEndOfThisMonth() {
        return OwnedBankFinanceAtTheEndOfThisMonth;
    }

    public void setOwnedBankFinanceAtTheEndOfThisMonth(String ownedBankFinanceAtTheEndOfThisMonth) {
        OwnedBankFinanceAtTheEndOfThisMonth = ownedBankFinanceAtTheEndOfThisMonth;
    }

    @JsonProperty("OwnedBankFinanceAtTheEndOfLastMonth")
    public String getOwnedBankFinanceAtTheEndOfLastMonth() {
        return OwnedBankFinanceAtTheEndOfLastMonth;
    }

    public void setOwnedBankFinanceAtTheEndOfLastMonth(String ownedBankFinanceAtTheEndOfLastMonth) {
        OwnedBankFinanceAtTheEndOfLastMonth = ownedBankFinanceAtTheEndOfLastMonth;
    }

    @JsonProperty("HoldTrustProductAtTheEndOfThisMonth")
    public String getHoldTrustProductAtTheEndOfThisMonth() {
        return HoldTrustProductAtTheEndOfThisMonth;
    }

    public void setHoldTrustProductAtTheEndOfThisMonth(String holdTrustProductAtTheEndOfThisMonth) {
        HoldTrustProductAtTheEndOfThisMonth = holdTrustProductAtTheEndOfThisMonth;
    }

    @JsonProperty("HoldTrustProductAtTheEndOfLastMonth")
    public String getHoldTrustProductAtTheEndOfLastMonth() {
        return HoldTrustProductAtTheEndOfLastMonth;
    }

    public void setHoldTrustProductAtTheEndOfLastMonth(String holdTrustProductAtTheEndOfLastMonth) {
        HoldTrustProductAtTheEndOfLastMonth = holdTrustProductAtTheEndOfLastMonth;
    }

    @JsonProperty("InsuranceProductsAreHeldAtTheEndOfThisMonth")
    public String getInsuranceProductsAreHeldAtTheEndOfThisMonth() {
        return InsuranceProductsAreHeldAtTheEndOfThisMonth;
    }

    public void setInsuranceProductsAreHeldAtTheEndOfThisMonth(String insuranceProductsAreHeldAtTheEndOfThisMonth) {
        InsuranceProductsAreHeldAtTheEndOfThisMonth = insuranceProductsAreHeldAtTheEndOfThisMonth;
    }

    @JsonProperty("InsuranceProductsAreHeldAtTheEndOfLastMonth")
    public String getInsuranceProductsAreHeldAtTheEndOfLastMonth() {
        return InsuranceProductsAreHeldAtTheEndOfLastMonth;
    }

    public void setInsuranceProductsAreHeldAtTheEndOfLastMonth(String insuranceProductsAreHeldAtTheEndOfLastMonth) {
        InsuranceProductsAreHeldAtTheEndOfLastMonth = insuranceProductsAreHeldAtTheEndOfLastMonth;
    }

    @JsonProperty("HoldOtherProductsAtTheEndOfThisMonth")
    public String getHoldOtherProductsAtTheEndOfThisMonth() {
        return HoldOtherProductsAtTheEndOfThisMonth;
    }

    public void setHoldOtherProductsAtTheEndOfThisMonth(String holdOtherProductsAtTheEndOfThisMonth) {
        HoldOtherProductsAtTheEndOfThisMonth = holdOtherProductsAtTheEndOfThisMonth;
    }

    @JsonProperty("HoldOtherProductsAtTheEndOfLastMonth")
    public String getHoldOtherProductsAtTheEndOfLastMonth() {
        return HoldOtherProductsAtTheEndOfLastMonth;
    }

    public void setHoldOtherProductsAtTheEndOfLastMonth(String holdOtherProductsAtTheEndOfLastMonth) {
        HoldOtherProductsAtTheEndOfLastMonth = holdOtherProductsAtTheEndOfLastMonth;
    }

    @JsonProperty("SettledSwapItemsAtThisMonth")
    public String getSettledSwapItemsAtThisMonth() {
        return SettledSwapItemsAtThisMonth;
    }

    public void setSettledSwapItemsAtThisMonth(String settledSwapItemsAtThisMonth) {
        SettledSwapItemsAtThisMonth = settledSwapItemsAtThisMonth;
    }

    @JsonProperty("SettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth")
    public String getSettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth() {
        return SettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth;
    }

    public void setSettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth(String settledSwapTransactionInvolvesNotionalPrincipalAtThisMonth) {
        SettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth = settledSwapTransactionInvolvesNotionalPrincipalAtThisMonth;
    }

    @JsonProperty("SwapIncomeCashFlow")
    public String getSwapIncomeCashFlow() {
        return SwapIncomeCashFlow;
    }

    public void setSwapIncomeCashFlow(String swapIncomeCashFlow) {
        SwapIncomeCashFlow = swapIncomeCashFlow;
    }

    @JsonProperty("SwapExpensesCashFlow")
    public String getSwapExpensesCashFlow() {
        return SwapExpensesCashFlow;
    }

    public void setSwapExpensesCashFlow(String swapExpensesCashFlow) {
        SwapExpensesCashFlow = swapExpensesCashFlow;
    }

    @JsonProperty("CashFlowCorrespondingToNetIncomeOnSwapMargin")
    public String getCashFlowCorrespondingToNetIncomeOnSwapMargin() {
        return CashFlowCorrespondingToNetIncomeOnSwapMargin;
    }

    public void setCashFlowCorrespondingToNetIncomeOnSwapMargin(String cashFlowCorrespondingToNetIncomeOnSwapMargin) {
        CashFlowCorrespondingToNetIncomeOnSwapMargin = cashFlowCorrespondingToNetIncomeOnSwapMargin;
    }

    @JsonProperty("SwapHedgeCost")
    public String getSwapHedgeCost() {
        return SwapHedgeCost;
    }

    public void setSwapHedgeCost(String swapHedgeCost) {
        SwapHedgeCost = swapHedgeCost;
    }

    @JsonProperty("SettledOptionItemsAtThisMonth")
    public String getSettledOptionItemsAtThisMonth() {
        return SettledOptionItemsAtThisMonth;
    }

    public void setSettledOptionItemsAtThisMonth(String settledOptionItemsAtThisMonth) {
        SettledOptionItemsAtThisMonth = settledOptionItemsAtThisMonth;
    }

    @JsonProperty("SettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth")
    public String getSettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth() {
        return SettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth;
    }

    public void setSettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth(String settledOptionTransactionInvolvesNotionalPrincipalAtThisMonth) {
        SettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth = settledOptionTransactionInvolvesNotionalPrincipalAtThisMonth;
    }

    @JsonProperty("OptionPremiumIncome")
    public String getOptionPremiumIncome() {
        return OptionPremiumIncome;
    }

    public void setOptionPremiumIncome(String optionPremiumIncome) {
        OptionPremiumIncome = optionPremiumIncome;
    }

    @JsonProperty("OptionHedgeCost")
    public String getOptionHedgeCost() {
        return OptionHedgeCost;
    }

    public void setOptionHedgeCost(String optionHedgeCost) {
        OptionHedgeCost = optionHedgeCost;
    }

    @JsonProperty("SettledForwardItemsAtThisMonth")
    public String getSettledForwardItemsAtThisMonth() {
        return SettledForwardItemsAtThisMonth;
    }

    public void setSettledForwardItemsAtThisMonth(String settledForwardItemsAtThisMonth) {
        SettledForwardItemsAtThisMonth = settledForwardItemsAtThisMonth;
    }

    @JsonProperty("SettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth")
    public String getSettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth() {
        return SettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth;
    }

    public void setSettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth(String settledForwardTransactionInvolvesNotionalPrincipalAtThisMonth) {
        SettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth = settledForwardTransactionInvolvesNotionalPrincipalAtThisMonth;
    }

    @JsonProperty("ForwardIncomeCashFlow")
    public String getForwardIncomeCashFlow() {
        return ForwardIncomeCashFlow;
    }

    public void setForwardIncomeCashFlow(String forwardIncomeCashFlow) {
        ForwardIncomeCashFlow = forwardIncomeCashFlow;
    }

    @JsonProperty("ForwardExpensesCashFlow")
    public String getForwardExpensesCashFlow() {
        return ForwardExpensesCashFlow;
    }

    public void setForwardExpensesCashFlow(String forwardExpensesCashFlow) {
        ForwardExpensesCashFlow = forwardExpensesCashFlow;
    }

    @JsonProperty("ForwardHedgeCost")
    public String getForwardHedgeCost() {
        return ForwardHedgeCost;
    }

    public void setForwardHedgeCost(String forwardHedgeCost) {
        ForwardHedgeCost = forwardHedgeCost;
    }

    @JsonProperty("BalanceOfSwapRealizedGainsAndLossesAtThisMonth")
    public String getBalanceOfSwapRealizedGainsAndLossesAtThisMonth() {
        return BalanceOfSwapRealizedGainsAndLossesAtThisMonth;
    }

    public void setBalanceOfSwapRealizedGainsAndLossesAtThisMonth(String balanceOfSwapRealizedGainsAndLossesAtThisMonth) {
        BalanceOfSwapRealizedGainsAndLossesAtThisMonth = balanceOfSwapRealizedGainsAndLossesAtThisMonth;
    }

    @JsonProperty("BalanceOfOptionRealizedGainsAndLossesAtThisMonth")
    public String getBalanceOfOptionRealizedGainsAndLossesAtThisMonth() {
        return BalanceOfOptionRealizedGainsAndLossesAtThisMonth;
    }

    public void setBalanceOfOptionRealizedGainsAndLossesAtThisMonth(String balanceOfOptionRealizedGainsAndLossesAtThisMonth) {
        BalanceOfOptionRealizedGainsAndLossesAtThisMonth = balanceOfOptionRealizedGainsAndLossesAtThisMonth;
    }

    @JsonProperty("BalanceOfForwardRealizedGainsAndLossesAtThisMonth")
    public String getBalanceOfForwardRealizedGainsAndLossesAtThisMonth() {
        return BalanceOfForwardRealizedGainsAndLossesAtThisMonth;
    }

    public void setBalanceOfForwardRealizedGainsAndLossesAtThisMonth(String balanceOfForwardRealizedGainsAndLossesAtThisMonth) {
        BalanceOfForwardRealizedGainsAndLossesAtThisMonth = balanceOfForwardRealizedGainsAndLossesAtThisMonth;
    }

    @JsonProperty("BalanceOfSwapRealizedGainsAndLossesAtThisYear")
    public String getBalanceOfSwapRealizedGainsAndLossesAtThisYear() {
        return BalanceOfSwapRealizedGainsAndLossesAtThisYear;
    }

    public void setBalanceOfSwapRealizedGainsAndLossesAtThisYear(String balanceOfSwapRealizedGainsAndLossesAtThisYear) {
        BalanceOfSwapRealizedGainsAndLossesAtThisYear = balanceOfSwapRealizedGainsAndLossesAtThisYear;
    }

    @JsonProperty("BalanceOfOptionRealizedGainsAndLossesAtThisYear")
    public String getBalanceOfOptionRealizedGainsAndLossesAtThisYear() {
        return BalanceOfOptionRealizedGainsAndLossesAtThisYear;
    }

    public void setBalanceOfOptionRealizedGainsAndLossesAtThisYear(String balanceOfOptionRealizedGainsAndLossesAtThisYear) {
        BalanceOfOptionRealizedGainsAndLossesAtThisYear = balanceOfOptionRealizedGainsAndLossesAtThisYear;
    }

    @JsonProperty("BalanceOfForwardRealizedGainsAndLossesAtThisYear")
    public String getBalanceOfForwardRealizedGainsAndLossesAtThisYear() {
        return BalanceOfForwardRealizedGainsAndLossesAtThisYear;
    }

    public void setBalanceOfForwardRealizedGainsAndLossesAtThisYear(String balanceOfForwardRealizedGainsAndLossesAtThisYear) {
        BalanceOfForwardRealizedGainsAndLossesAtThisYear = balanceOfForwardRealizedGainsAndLossesAtThisYear;
    }

    @JsonProperty("BalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth")
    public String getBalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth() {
        return BalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth;
    }

    public void setBalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth(String balanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth) {
        BalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth = balanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth;
    }

    @JsonProperty("BalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth")
    public String getBalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth() {
        return BalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth;
    }

    public void setBalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth(String balanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth) {
        BalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth = balanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth;
    }

    @JsonProperty("BalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth")
    public String getBalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth() {
        return BalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth;
    }

    public void setBalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth(String balanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth) {
        BalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth = balanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth;
    }

    @JsonProperty("BalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear")
    public String getBalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear() {
        return BalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear;
    }

    public void setBalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear(String balanceOfSwapChangedGainsAndLossesInFairValueAtThisYear) {
        BalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear = balanceOfSwapChangedGainsAndLossesInFairValueAtThisYear;
    }

    @JsonProperty("BalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear")
    public String getBalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear() {
        return BalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear;
    }

    public void setBalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear(String balanceOfOptionChangedGainsAndLossesInFairValueAtThisYear) {
        BalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear = balanceOfOptionChangedGainsAndLossesInFairValueAtThisYear;
    }

    @JsonProperty("BalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear")
    public String getBalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear() {
        return BalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear;
    }

    public void setBalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear(String balanceOfForwardChangedGainsAndLossesInFairValueAtThisYear) {
        BalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear = balanceOfForwardChangedGainsAndLossesInFairValueAtThisYear;
    }

    @JsonProperty("BalanceOfSwapTotalGainsAndLossesAtThisMonth")
    public String getBalanceOfSwapTotalGainsAndLossesAtThisMonth() {
        return BalanceOfSwapTotalGainsAndLossesAtThisMonth;
    }

    public void setBalanceOfSwapTotalGainsAndLossesAtThisMonth(String balanceOfSwapTotalGainsAndLossesAtThisMonth) {
        BalanceOfSwapTotalGainsAndLossesAtThisMonth = balanceOfSwapTotalGainsAndLossesAtThisMonth;
    }

    @JsonProperty("BalanceOfOptionTotalGainsAndLossesAtThisMonth")
    public String getBalanceOfOptionTotalGainsAndLossesAtThisMonth() {
        return BalanceOfOptionTotalGainsAndLossesAtThisMonth;
    }

    public void setBalanceOfOptionTotalGainsAndLossesAtThisMonth(String balanceOfOptionTotalGainsAndLossesAtThisMonth) {
        BalanceOfOptionTotalGainsAndLossesAtThisMonth = balanceOfOptionTotalGainsAndLossesAtThisMonth;
    }

    @JsonProperty("BalanceOfForwardTotalGainsAndLossesAtThisMonth")
    public String getBalanceOfForwardTotalGainsAndLossesAtThisMonth() {
        return BalanceOfForwardTotalGainsAndLossesAtThisMonth;
    }

    public void setBalanceOfForwardTotalGainsAndLossesAtThisMonth(String balanceOfForwardTotalGainsAndLossesAtThisMonth) {
        BalanceOfForwardTotalGainsAndLossesAtThisMonth = balanceOfForwardTotalGainsAndLossesAtThisMonth;
    }

    @JsonProperty("BalanceOfSwapTotalGainsAndLossesAtThisYear")
    public String getBalanceOfSwapTotalGainsAndLossesAtThisYear() {
        return BalanceOfSwapTotalGainsAndLossesAtThisYear;
    }

    public void setBalanceOfSwapTotalGainsAndLossesAtThisYear(String balanceOfSwapTotalGainsAndLossesAtThisYear) {
        BalanceOfSwapTotalGainsAndLossesAtThisYear = balanceOfSwapTotalGainsAndLossesAtThisYear;
    }

    @JsonProperty("BalanceOfOptionTotalGainsAndLossesAtThisYear")
    public String getBalanceOfOptionTotalGainsAndLossesAtThisYear() {
        return BalanceOfOptionTotalGainsAndLossesAtThisYear;
    }

    public void setBalanceOfOptionTotalGainsAndLossesAtThisYear(String balanceOfOptionTotalGainsAndLossesAtThisYear) {
        BalanceOfOptionTotalGainsAndLossesAtThisYear = balanceOfOptionTotalGainsAndLossesAtThisYear;
    }

    @JsonProperty("BalanceOfForwardTotalGainsAndLossesAtThisYear")
    public String getBalanceOfForwardTotalGainsAndLossesAtThisYear() {
        return BalanceOfForwardTotalGainsAndLossesAtThisYear;
    }

    public void setBalanceOfForwardTotalGainsAndLossesAtThisYear(String balanceOfForwardTotalGainsAndLossesAtThisYear) {
        BalanceOfForwardTotalGainsAndLossesAtThisYear = balanceOfForwardTotalGainsAndLossesAtThisYear;
    }

    @JsonProperty("IncreaseBusinessDetailsThisMonthTuple")
    public List<IncreaseBusinessDetailsThisMonthTupleDTO> getIncreaseBusinessDetailsThisMonthTuple() {
        return IncreaseBusinessDetailsThisMonthTuple;
    }

    public void setIncreaseBusinessDetailsThisMonthTuple(List<IncreaseBusinessDetailsThisMonthTupleDTO> increaseBusinessDetailsThisMonthTuple) {
        IncreaseBusinessDetailsThisMonthTuple = increaseBusinessDetailsThisMonthTuple;
    }

    @JsonProperty("TargetCaseAndHedgeTuple")
    public List<TargetCaseAndHedgeTupleDTO> getTargetCaseAndHedgeTuple() {
        return TargetCaseAndHedgeTuple;
    }

    public void setTargetCaseAndHedgeTuple(List<TargetCaseAndHedgeTupleDTO> targetCaseAndHedgeTuple) {
        TargetCaseAndHedgeTuple = targetCaseAndHedgeTuple;
    }
}
