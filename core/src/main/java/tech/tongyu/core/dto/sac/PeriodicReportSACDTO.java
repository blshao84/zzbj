package tech.tongyu.core.dto.sac;

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
 * @description SAC
 */
@JsonPropertyOrder({"ExceID", "BizID", "Year", "Month", "MainAgreementAddedThisMonth", "MainAgreementAccumulatedThisYear",
        "MainAgreementValidedAtEndOfThisMonth",
        "SupplementalAgreementAddedThisMonth",
        "SupplementalAgreementAccumulatedThisYear",
        "SupplementalAgreementValidedAtTheEndOfThisMonth",
        "PerformanceGuaranteeAgreementAddedThisMonth",
        "PerformanceGuaranteeAgreementAccumulatedThisYear",
        "PerformanceGuaranteeAgreementValidedAtEndOfThisMonth",
        "TransactionConfirmationAddedThisMonth",
        "TransactionConfirmationBookAccumulatedThisYear",
        "TransactionConfirmationValidedAtEndOfThisMonth",
        "ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence",
        "NetCapitalAtEndOfTheMonth",
        "ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital",
        "OTCOptionHasSignedByLegalPerson",
        "OTCOptionsHaveContractedProducts",
        "OTCOptionsForTheMonthOfTheNewAddLegalPerson",
        "OTCOptionsForTheMonthOfTheNewAddProduct",
        "OTCOptionsLegalPersonInDurationForThisMouth",
        "OTCOptionsProductsInDurationForThisMouth",
        "IncomeSwapHasSignedLegalPersonNumber",
        "IncomeSwapHasSignedProductNumber",
        "IncomeSwapForTheMonthOfTheNewAddLegalPerson",
        "IncomeSwapForTheMonthOfTheNewAddProduct",
        "IncomeSwapLegalPersonInDurationForThisMouth",
        "IncomeSwapProductsInDurationForThisMouth",
        "OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale",
        "OTCOptionsWithinIndividualStocksLateLastMonthDurationScale",
        "OTCOptionsCommoditiesLastMonthDurationScale",
        "OTCOptionsOtherSubjectLastMonthDurationScale",
        "RevenueExchangeDomesticStockIndexLastMonthDurationScale",
        "RevenueExchangeDomesticIndividualStocksLastMonthDurationScale",
        "RevenueExchangeCommoditiesLastMonthDurationScale",
        "RevenueExchangeOtherSubjectLastMonthDurationScale",
        "TotalOfLastMonthDurationScale",
        "OTCOptionsWithinTheIndexThisMonthOfTheNewScale",
        "OTCOptionsToAddScaleDomesticStocksInThisMonth",
        "OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth",
        "OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth",
        "RevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth",
        "RevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth",
        "RevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth",
        "RevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth",
        "TotalOfTheNewSizeOfTheIncreaseInThisMonth",
        "OTCOptionsTerminateScaleDomesticStockIndexThisMonth",
        "OTCOptionsTerminateScaleDomesticStocksInThisMonth",
        "OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth",
        "OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth",
        "RevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth",
        "RevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth",
        "RevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth",
        "RevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth",
        "TotalOfTerminationOfTheScaleOfThisMonth",
        "OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale",
        "OTCOptionsWithinIndividualStocksInThisMonthDurationScale",
        "OTCOptionsCommoditiesInThisMonthDurationScale",
        "OTCOptionsOtherSubjectThisMonthDurationScale",
        "RevenueExchangeDomesticStockIndexThisMonthDurationScale",
        "RevenueExchangeDomesticIndividualStocksThisMonthDurationScale",
        "RevenueExchangeCommoditiesThisMonthDurationScale",
        "RevenueExchangeOtherSubjectThisMonthDurationScale",
        "TotalOfThisMonthDurationScale",
        "OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory",
        "OTCOptionsStockThisYearCumulativeScaleOfNewTerritory",
        "OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory",
        "OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory",
        "IncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear",
        "IncomeSwapDomesticStockHasAddedNewScaleInThisYear",
        "IncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear",
        "IncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear",
        "TotalNewScaleInThisYear",
        "OTCOptionsStockIndexAtTheEndOfLastMonth",
        "OTCOptionsStockAtTheEndOfLastMonth",
        "OTCOptionsCommoditiesAtTheEndOfLastMonth",
        "OTCOptionsOtherSubjectAtTheEndOfLastMonth",
        "IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth",
        "IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth",
        "IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth",
        "IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth",
        "TotalNumberOfContractsAtTheEndOfLastMonth",
        "OTCOptionsStockIndexThisMonthNewDomesticContractNumber",
        "OTCOptionsStockThisMonthNewDomesticContractNumber",
        "OTCOptionsCommoditiesThisMonthNewDomesticContractNumber",
        "OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber",
        "IncomeSwapDomesticStockIndexNewContractInThisMonth",
        "IncomeSwapDomesticStockNewContractInThisMonth",
        "IncomeSwapCommoditiesNewContractInThisMonth",
        "IncomeSwapOtherSubjectNewContractInThisMonth",
        "TotalNumberOfNewContractsInThisMonth",
        "OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber",
        "OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber",
        "OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber",
        "OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber",
        "IncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth",
        "IncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth",
        "IncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth",
        "IncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth",
        "TotalNumberOfContractsTerminatedThisMonth",
        "OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth",
        "OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth",
        "OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth",
        "OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth",
        "IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth",
        "IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth",
        "IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth",
        "IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth",
        "TotalNumberOfContractsAtTheEndOfThisMonth",
        "OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear",
        "OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear",
        "OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear",
        "OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear",
        "IncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear",
        "IncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear",
        "IncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear",
        "IncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear",
        "TotalNumberOfNewContractsInThisYear",
        "TotalNominalPrincipalAmountOfSwapThisMonth",
        "TotalNominalPrincipalAmountOfSwapLastMonth",
        "TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth",
        "TheValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth",
        "SwapCashCollateralValueThisMonth",
        "SwapCashCollateralValueLastMonth",
        "SwapSecuritiesCollateralValueThisMonth",
        "SwapSecuritiesCollateralValueLastMonthThisMonth",
        "ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull",
        "ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull",
        "ProportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet",
        "ProportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet",
        "SwapNumberOfDefaultCustomersAtThisMonthThisMonth",
        "SwapNumberOfDefaultCustomersAtThisMonthLastMonth",
        "SwapDefaultTransactionNumberAtThisMonthThisMonth",
        "SwapDefaultTransactionNumberAtThisMonthLastMonth",
        "TotalSwapDefaultCustomerNumberInThisYearThisMonth",
        "TotalSwapDefaultCustomerNumberInThisYearLastMonth",
        "SwapNumberOfDefaultCustomersInThisYearThisMonth",
        "SwapNumberOfDefaultCustomersInThisYearLastMonth",
        "TotalNominalPrincipalAmountOfForwardThisMonth",
        "TotalNominalPrincipalAmountOfForwardLastMonth",
        "TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth",
        "TheValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth",
        "ForwardCashCollateralValueThisMonth",
        "ForwardCashCollateralValueLastMonth",
        "ForwardSecuritiesCollateralValueThisMonth",
        "ForwardSecuritiesCollateralValueLastMonth",
        "ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull",
        "ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull",
        "ProportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet",
        "ProportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet",
        "ForwardNumberOfDefaultCustomersAtThisMonthThisMonth",
        "ForwardNumberOfDefaultCustomersAtThisMonthLastMonth",
        "ForwardTransactionNumberAtThisMonthThisMonth",
        "ForwardTransactionNumberAtThisMonthLastMonth",
        "TotalForwardDefaultCustomerNumberInThisYearThisMonth",
        "TotalForwardDefaultCustomerNumberInThisYearLastMonth",
        "ForwardNumberOfDefaultCustomersInThisYearThisMonth",
        "ForwardNumberOfDefaultCustomersInThisYearLastMonth",
        "StockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth",
        "StockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth",
        "CashBalanceAtEndOfThisMonth",
        "CashBalanceAtEndOfLastMonth",
        "HoldStockMarketValueAtEndOfThisMonth",
        "HoldStockMarketValueAtEndOfLastMonth",
        "HoldMarketValueOfBondsAtTheEndOfThisMonth",
        "HoldMarketValueOfBondsAtTheEndOfLastMonth",
        "OwnedAssetManagementProductsAtTheEndOfThisMonth",
        "OwnedAssetManagementProductsAtTheEndOfLastMonth",
        "OwnedBankFinanceAtTheEndOfThisMonth",
        "OwnedBankFinanceAtTheEndOfLastMonth",
        "HoldTrustProductAtTheEndOfThisMonth",
        "HoldTrustProductAtTheEndOfLastMonth",
        "InsuranceProductsAreHeldAtTheEndOfThisMonth",
        "InsuranceProductsAreHeldAtTheEndOfLastMonth",
        "HoldOtherProductsAtTheEndOfThisMonth",
        "HoldOtherProductsAtTheEndOfLastMonth",
        "SettledSwapItemsAtThisMonth",
        "SettledSwapTransactionInvolvesNotionalPrincipalAtThisMonth",
        "SwapIncomeCashFlow",
        "SwapExpensesCashFlow",
        "CashFlowCorrespondingToNetIncomeOnSwapMargin",
        "SwapHedgeCost",
        "SettledOptionItemsAtThisMonth",
        "SettledOptionTransactionInvolvesNotionalPrincipalAtThisMonth",
        "OptionPremiumIncome",
        "OptionHedgeCost",
        "SettledForwardItemsAtThisMonth",
        "SettledForwardTransactionInvolvesNotionalPrincipalAtThisMonth",
        "ForwardIncomeCashFlow",
        "ForwardExpensesCashFlow",
        "ForwardHedgeCost",
        "BalanceOfSwapRealizedGainsAndLossesAtThisMonth",
        "BalanceOfOptionRealizedGainsAndLossesAtThisMonth",
        "BalanceOfForwardRealizedGainsAndLossesAtThisMonth",
        "BalanceOfSwapRealizedGainsAndLossesAtThisYear",
        "BalanceOfOptionRealizedGainsAndLossesAtThisYear",
        "BalanceOfForwardRealizedGainsAndLossesAtThisYear",
        "BalanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth",
        "BalanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth",
        "BalanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth",
        "BalanceOfSwapChangedGainsAndLossesInFairValueAtThisYear",
        "BalanceOfOptionChangedGainsAndLossesInFairValueAtThisYear",
        "BalanceOfForwardChangedGainsAndLossesInFairValueAtThisYear",
        "BalanceOfSwapTotalGainsAndLossesAtThisMonth",
        "BalanceOfOptionTotalGainsAndLossesAtThisMonth",
        "BalanceOfForwardTotalGainsAndLossesAtThisMonth",
        "BalanceOfSwapTotalGainsAndLossesAtThisYear",
        "BalanceOfOptionTotalGainsAndLossesAtThisYear",
        "BalanceOfForwardTotalGainsAndLossesAtThisYear",
        "IncreaseBusinessDetailsThisMonthTuple",
        "InventoryBusinessDetailsAtTheEndOfThisMonth",
        "TargetCaseAndHedgeTuple"})
public class PeriodicReportSACDTO extends RequestCommon {

    private String Year;
    private String Month;
    private String MainAgreementAddedThisMonth;
    private String MainAgreementAccumulatedThisYear;
    private String MainAgreementValidedAtEndOfThisMonth;
    private String SupplementalAgreementAddedThisMonth;
    private String SupplementalAgreementAccumulatedThisYear;
    private String SupplementalAgreementValidedAtTheEndOfThisMonth;
    private String PerformanceGuaranteeAgreementAddedThisMonth;
    private String PerformanceGuaranteeAgreementAccumulatedThisYear;
    private String PerformanceGuaranteeAgreementValidedAtEndOfThisMonth;
    private String TransactionConfirmationAddedThisMonth;
    private String TransactionConfirmationBookAccumulatedThisYear;
    private String TransactionConfirmationValidedAtEndOfThisMonth;
    private String ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence;
    private String NetCapitalAtEndOfTheMonth;
    private String ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital;
    private String OTCOptionHasSignedByLegalPerson;
    private String OTCOptionsHaveContractedProducts;
    private String OTCOptionsForTheMonthOfTheNewAddLegalPerson;
    private String OTCOptionsForTheMonthOfTheNewAddProduct;
    private String OTCOptionsLegalPersonInDurationForThisMouth;
    private String OTCOptionsProductsInDurationForThisMouth;
    private String IncomeSwapHasSignedLegalPersonNumber;
    private String IncomeSwapHasSignedProductNumber;
    private String IncomeSwapForTheMonthOfTheNewAddLegalPerson;
    private String IncomeSwapForTheMonthOfTheNewAddProduct;
    private String IncomeSwapLegalPersonInDurationForThisMouth;
    private String IncomeSwapProductsInDurationForThisMouth;
    private String OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale;
    private String OTCOptionsWithinIndividualStocksLateLastMonthDurationScale;
    private String OTCOptionsCommoditiesLastMonthDurationScale;
    private String OTCOptionsOtherSubjectLastMonthDurationScale;
    private String RevenueExchangeDomesticStockIndexLastMonthDurationScale;
    private String RevenueExchangeDomesticIndividualStocksLastMonthDurationScale;
    private String RevenueExchangeCommoditiesLastMonthDurationScale;
    private String RevenueExchangeOtherSubjectLastMonthDurationScale;
    private String TotalOfLastMonthDurationScale;
    private String OTCOptionsWithinTheIndexThisMonthOfTheNewScale;
    private String OTCOptionsToAddScaleDomesticStocksInThisMonth;
    private String OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
    private String OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
    private String RevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth;
    private String RevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth;
    private String RevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
    private String RevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
    private String TotalOfTheNewSizeOfTheIncreaseInThisMonth;
    private String OTCOptionsTerminateScaleDomesticStockIndexThisMonth;
    private String OTCOptionsTerminateScaleDomesticStocksInThisMonth;
    private String OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth;
    private String OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth;
    private String RevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth;
    private String RevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth;
    private String RevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth;
    private String RevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth;
    private String TotalOfTerminationOfTheScaleOfThisMonth;
    private String OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale;
    private String OTCOptionsWithinIndividualStocksInThisMonthDurationScale;
    private String OTCOptionsCommoditiesInThisMonthDurationScale;
    private String OTCOptionsOtherSubjectThisMonthDurationScale;
    private String RevenueExchangeDomesticStockIndexThisMonthDurationScale;
    private String RevenueExchangeDomesticIndividualStocksThisMonthDurationScale;
    private String RevenueExchangeCommoditiesThisMonthDurationScale;
    private String RevenueExchangeOtherSubjectThisMonthDurationScale;
    private String TotalOfThisMonthDurationScale;
    private String OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory;
    private String OTCOptionsStockThisYearCumulativeScaleOfNewTerritory;
    private String OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory;
    private String OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory;
    private String IncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear;
    private String IncomeSwapDomesticStockHasAddedNewScaleInThisYear;
    private String IncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear;
    private String IncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear;
    private String TotalNewScaleInThisYear;
    private String OTCOptionsStockIndexAtTheEndOfLastMonth;
    private String OTCOptionsStockAtTheEndOfLastMonth;
    private String OTCOptionsCommoditiesAtTheEndOfLastMonth;
    private String OTCOptionsOtherSubjectAtTheEndOfLastMonth;
    private String IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth;
    private String IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth;
    private String IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth;
    private String IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth;
    private String TotalNumberOfContractsAtTheEndOfLastMonth;
    private String OTCOptionsStockIndexThisMonthNewDomesticContractNumber;
    private String OTCOptionsStockThisMonthNewDomesticContractNumber;
    private String OTCOptionsCommoditiesThisMonthNewDomesticContractNumber;
    private String OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber;
    private String IncomeSwapDomesticStockIndexNewContractInThisMonth;
    private String IncomeSwapDomesticStockNewContractInThisMonth;
    private String IncomeSwapCommoditiesNewContractInThisMonth;
    private String IncomeSwapOtherSubjectNewContractInThisMonth;
    private String TotalNumberOfNewContractsInThisMonth;
    private String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber;
    private String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber;
    private String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber;
    private String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber;
    private String IncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth;
    private String IncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth;
    private String IncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth;
    private String IncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth;
    private String TotalNumberOfContractsTerminatedThisMonth;
    private String OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
    private String TotalNumberOfContractsAtTheEndOfThisMonth;
    private String OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear;
    private String OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear;
    private String OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear;
    private String OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear;
    private String IncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear;
    private String IncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear;
    private String IncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear;
    private String IncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear;
    private String TotalNumberOfNewContractsInThisYear;
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
    private List<InventoryBusinessDetailsAtTheEndOfThisMonthDTO> InventoryBusinessDetailsAtTheEndOfThisMonth;
    private List<TargetCaseAndHedgeTupleDTO> TargetCaseAndHedgeTuple;

    public static PeriodicReportSACDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static PeriodicReportSACDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        PeriodicReportSACDTO dto = JsonUtils.mapper.convertValue(json, PeriodicReportSACDTO.class);
        return dto;
    }

    public PeriodicReportSACDTO() {
    }

    public PeriodicReportSACDTO(String year, String month, String mainAgreementAddedThisMonth, String mainAgreementAccumulatedThisYear, String mainAgreementValidedAtEndOfThisMonth, String supplementalAgreementAddedThisMonth, String supplementalAgreementAccumulatedThisYear, String supplementalAgreementValidedAtTheEndOfThisMonth, String performanceGuaranteeAgreementAddedThisMonth, String performanceGuaranteeAgreementAccumulatedThisYear, String performanceGuaranteeAgreementValidedAtEndOfThisMonth, String transactionConfirmationAddedThisMonth, String transactionConfirmationBookAccumulatedThisYear, String transactionConfirmationValidedAtEndOfThisMonth, String toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence, String netCapitalAtEndOfTheMonth, String toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital, String OTCOptionHasSignedByLegalPerson, String OTCOptionsHaveContractedProducts, String OTCOptionsForTheMonthOfTheNewAddLegalPerson, String OTCOptionsForTheMonthOfTheNewAddProduct, String OTCOptionsLegalPersonInDurationForThisMouth, String OTCOptionsProductsInDurationForThisMouth, String incomeSwapHasSignedLegalPersonNumber, String incomeSwapHasSignedProductNumber, String incomeSwapForTheMonthOfTheNewAddLegalPerson, String incomeSwapForTheMonthOfTheNewAddProduct, String incomeSwapLegalPersonInDurationForThisMouth, String incomeSwapProductsInDurationForThisMouth, String OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale, String OTCOptionsWithinIndividualStocksLateLastMonthDurationScale, String OTCOptionsCommoditiesLastMonthDurationScale, String OTCOptionsOtherSubjectLastMonthDurationScale, String revenueExchangeDomesticStockIndexLastMonthDurationScale, String revenueExchangeDomesticIndividualStocksLastMonthDurationScale, String revenueExchangeCommoditiesLastMonthDurationScale, String revenueExchangeOtherSubjectLastMonthDurationScale, String totalOfLastMonthDurationScale, String OTCOptionsWithinTheIndexThisMonthOfTheNewScale, String OTCOptionsToAddScaleDomesticStocksInThisMonth, String OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth, String OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth, String revenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth, String revenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth, String revenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth, String revenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth, String totalOfTheNewSizeOfTheIncreaseInThisMonth, String OTCOptionsTerminateScaleDomesticStockIndexThisMonth, String OTCOptionsTerminateScaleDomesticStocksInThisMonth, String OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth, String OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth, String revenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth, String revenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth, String revenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth, String revenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth, String totalOfTerminationOfTheScaleOfThisMonth, String OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale, String OTCOptionsWithinIndividualStocksInThisMonthDurationScale, String OTCOptionsCommoditiesInThisMonthDurationScale, String OTCOptionsOtherSubjectThisMonthDurationScale, String revenueExchangeDomesticStockIndexThisMonthDurationScale, String revenueExchangeDomesticIndividualStocksThisMonthDurationScale, String revenueExchangeCommoditiesThisMonthDurationScale, String revenueExchangeOtherSubjectThisMonthDurationScale, String totalOfThisMonthDurationScale, String OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory, String OTCOptionsStockThisYearCumulativeScaleOfNewTerritory, String OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory, String OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory, String incomeSwapDomesticStockIndexHasAddedNewScaleInThisYear, String incomeSwapDomesticStockHasAddedNewScaleInThisYear, String incomeSwapCommoditiesIndexHasAddedNewScaleInThisYear, String incomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear, String totalNewScaleInThisYear, String OTCOptionsStockIndexAtTheEndOfLastMonth, String OTCOptionsStockAtTheEndOfLastMonth, String OTCOptionsCommoditiesAtTheEndOfLastMonth, String OTCOptionsOtherSubjectAtTheEndOfLastMonth, String incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth, String incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth, String incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth, String incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth, String totalNumberOfContractsAtTheEndOfLastMonth, String OTCOptionsStockIndexThisMonthNewDomesticContractNumber, String OTCOptionsStockThisMonthNewDomesticContractNumber, String OTCOptionsCommoditiesThisMonthNewDomesticContractNumber, String OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber, String incomeSwapDomesticStockIndexNewContractInThisMonth, String incomeSwapDomesticStockNewContractInThisMonth, String incomeSwapCommoditiesNewContractInThisMonth, String incomeSwapOtherSubjectNewContractInThisMonth, String totalNumberOfNewContractsInThisMonth, String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber, String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber, String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber, String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber, String incomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth, String incomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth, String incomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth, String incomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth, String totalNumberOfContractsTerminatedThisMonth, String OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth, String OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth, String OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth, String OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth, String incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth, String incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth, String incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth, String incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth, String totalNumberOfContractsAtTheEndOfThisMonth, String OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear, String OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear, String OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear, String OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear, String incomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear, String incomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear, String incomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear, String incomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear, String totalNumberOfNewContractsInThisYear, String totalNominalPrincipalAmountOfSwapThisMonth, String totalNominalPrincipalAmountOfSwapLastMonth, String theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeThisMonth, String theValueOfTheStockSwapInTheCorrespondingPerformanceGuaranteeLastMonth, String swapCashCollateralValueThisMonth, String swapCashCollateralValueLastMonth, String swapSecuritiesCollateralValueThisMonth, String swapSecuritiesCollateralValueLastMonthThisMonth, String proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthFull, String proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthFull, String proportionOfTheOverallPerformanceOfTheSwapBusinessThisMonthNet, String proportionOfTheOverallPerformanceOfTheSwapBusinessLastMonthNet, String swapNumberOfDefaultCustomersAtThisMonthThisMonth, String swapNumberOfDefaultCustomersAtThisMonthLastMonth, String swapDefaultTransactionNumberAtThisMonthThisMonth, String swapDefaultTransactionNumberAtThisMonthLastMonth, String totalSwapDefaultCustomerNumberInThisYearThisMonth, String totalSwapDefaultCustomerNumberInThisYearLastMonth, String swapNumberOfDefaultCustomersInThisYearThisMonth, String swapNumberOfDefaultCustomersInThisYearLastMonth, String totalNominalPrincipalAmountOfForwardThisMonth, String totalNominalPrincipalAmountOfForwardLastMonth, String theValueOfTheStockForwardCorrespondingPerformanceGuaranteeThisMonth, String theValueOfTheStockForwardCorrespondingPerformanceGuaranteeLastMonth, String forwardCashCollateralValueThisMonth, String forwardCashCollateralValueLastMonth, String forwardSecuritiesCollateralValueThisMonth, String forwardSecuritiesCollateralValueLastMonth, String proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthFull, String proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthFull, String proportionOfTheOverallPerformanceOfTheForwardBusinessThisMonthNet, String proportionOfTheOverallPerformanceOfTheForwardBusinessLastMonthNet, String forwardNumberOfDefaultCustomersAtThisMonthThisMonth, String forwardNumberOfDefaultCustomersAtThisMonthLastMonth, String forwardTransactionNumberAtThisMonthThisMonth, String forwardTransactionNumberAtThisMonthLastMonth, String totalForwardDefaultCustomerNumberInThisYearThisMonth, String totalForwardDefaultCustomerNumberInThisYearLastMonth, String forwardNumberOfDefaultCustomersInThisYearThisMonth, String forwardNumberOfDefaultCustomersInThisYearLastMonth, String stockTradingCorrespondsToValueOfCollateralAtEndOfThisMonth, String stockTradingCorrespondsToValueOfCollateralAtEndOfLastMonth, String cashBalanceAtEndOfThisMonth, String cashBalanceAtEndOfLastMonth, String holdStockMarketValueAtEndOfThisMonth, String holdStockMarketValueAtEndOfLastMonth, String holdMarketValueOfBondsAtTheEndOfThisMonth, String holdMarketValueOfBondsAtTheEndOfLastMonth, String ownedAssetManagementProductsAtTheEndOfThisMonth, String ownedAssetManagementProductsAtTheEndOfLastMonth, String ownedBankFinanceAtTheEndOfThisMonth, String ownedBankFinanceAtTheEndOfLastMonth, String holdTrustProductAtTheEndOfThisMonth, String holdTrustProductAtTheEndOfLastMonth, String insuranceProductsAreHeldAtTheEndOfThisMonth, String insuranceProductsAreHeldAtTheEndOfLastMonth, String holdOtherProductsAtTheEndOfThisMonth, String holdOtherProductsAtTheEndOfLastMonth, String settledSwapItemsAtThisMonth, String settledSwapTransactionInvolvesNotionalPrincipalAtThisMonth, String swapIncomeCashFlow, String swapExpensesCashFlow, String cashFlowCorrespondingToNetIncomeOnSwapMargin, String swapHedgeCost, String settledOptionItemsAtThisMonth, String settledOptionTransactionInvolvesNotionalPrincipalAtThisMonth, String optionPremiumIncome, String optionHedgeCost, String settledForwardItemsAtThisMonth, String settledForwardTransactionInvolvesNotionalPrincipalAtThisMonth, String forwardIncomeCashFlow, String forwardExpensesCashFlow, String forwardHedgeCost, String balanceOfSwapRealizedGainsAndLossesAtThisMonth, String balanceOfOptionRealizedGainsAndLossesAtThisMonth, String balanceOfForwardRealizedGainsAndLossesAtThisMonth, String balanceOfSwapRealizedGainsAndLossesAtThisYear, String balanceOfOptionRealizedGainsAndLossesAtThisYear, String balanceOfForwardRealizedGainsAndLossesAtThisYear, String balanceOfSwapChangedGainsAndLossesInFairValueAtThisMonth, String balanceOfOptionChangedGainsAndLossesInFairValueAtThisMonth, String balanceOfForwardChangedGainsAndLossesInFairValueAtThisMonth, String balanceOfSwapChangedGainsAndLossesInFairValueAtThisYear, String balanceOfOptionChangedGainsAndLossesInFairValueAtThisYear, String balanceOfForwardChangedGainsAndLossesInFairValueAtThisYear, String balanceOfSwapTotalGainsAndLossesAtThisMonth, String balanceOfOptionTotalGainsAndLossesAtThisMonth, String balanceOfForwardTotalGainsAndLossesAtThisMonth, String balanceOfSwapTotalGainsAndLossesAtThisYear, String balanceOfOptionTotalGainsAndLossesAtThisYear, String balanceOfForwardTotalGainsAndLossesAtThisYear, List<IncreaseBusinessDetailsThisMonthTupleDTO> increaseBusinessDetailsThisMonthTuple, List<InventoryBusinessDetailsAtTheEndOfThisMonthDTO> inventoryBusinessDetailsAtTheEndOfThisMonth, List<TargetCaseAndHedgeTupleDTO> targetCaseAndHedgeTuple) {
        Year = year;
        Month = month;
        MainAgreementAddedThisMonth = mainAgreementAddedThisMonth;
        MainAgreementAccumulatedThisYear = mainAgreementAccumulatedThisYear;
        MainAgreementValidedAtEndOfThisMonth = mainAgreementValidedAtEndOfThisMonth;
        SupplementalAgreementAddedThisMonth = supplementalAgreementAddedThisMonth;
        SupplementalAgreementAccumulatedThisYear = supplementalAgreementAccumulatedThisYear;
        SupplementalAgreementValidedAtTheEndOfThisMonth = supplementalAgreementValidedAtTheEndOfThisMonth;
        PerformanceGuaranteeAgreementAddedThisMonth = performanceGuaranteeAgreementAddedThisMonth;
        PerformanceGuaranteeAgreementAccumulatedThisYear = performanceGuaranteeAgreementAccumulatedThisYear;
        PerformanceGuaranteeAgreementValidedAtEndOfThisMonth = performanceGuaranteeAgreementValidedAtEndOfThisMonth;
        TransactionConfirmationAddedThisMonth = transactionConfirmationAddedThisMonth;
        TransactionConfirmationBookAccumulatedThisYear = transactionConfirmationBookAccumulatedThisYear;
        TransactionConfirmationValidedAtEndOfThisMonth = transactionConfirmationValidedAtEndOfThisMonth;
        ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence = toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence;
        NetCapitalAtEndOfTheMonth = netCapitalAtEndOfTheMonth;
        ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital = toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital;
        this.OTCOptionHasSignedByLegalPerson = OTCOptionHasSignedByLegalPerson;
        this.OTCOptionsHaveContractedProducts = OTCOptionsHaveContractedProducts;
        this.OTCOptionsForTheMonthOfTheNewAddLegalPerson = OTCOptionsForTheMonthOfTheNewAddLegalPerson;
        this.OTCOptionsForTheMonthOfTheNewAddProduct = OTCOptionsForTheMonthOfTheNewAddProduct;
        this.OTCOptionsLegalPersonInDurationForThisMouth = OTCOptionsLegalPersonInDurationForThisMouth;
        this.OTCOptionsProductsInDurationForThisMouth = OTCOptionsProductsInDurationForThisMouth;
        IncomeSwapHasSignedLegalPersonNumber = incomeSwapHasSignedLegalPersonNumber;
        IncomeSwapHasSignedProductNumber = incomeSwapHasSignedProductNumber;
        IncomeSwapForTheMonthOfTheNewAddLegalPerson = incomeSwapForTheMonthOfTheNewAddLegalPerson;
        IncomeSwapForTheMonthOfTheNewAddProduct = incomeSwapForTheMonthOfTheNewAddProduct;
        IncomeSwapLegalPersonInDurationForThisMouth = incomeSwapLegalPersonInDurationForThisMouth;
        IncomeSwapProductsInDurationForThisMouth = incomeSwapProductsInDurationForThisMouth;
        this.OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale = OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale;
        this.OTCOptionsWithinIndividualStocksLateLastMonthDurationScale = OTCOptionsWithinIndividualStocksLateLastMonthDurationScale;
        this.OTCOptionsCommoditiesLastMonthDurationScale = OTCOptionsCommoditiesLastMonthDurationScale;
        this.OTCOptionsOtherSubjectLastMonthDurationScale = OTCOptionsOtherSubjectLastMonthDurationScale;
        RevenueExchangeDomesticStockIndexLastMonthDurationScale = revenueExchangeDomesticStockIndexLastMonthDurationScale;
        RevenueExchangeDomesticIndividualStocksLastMonthDurationScale = revenueExchangeDomesticIndividualStocksLastMonthDurationScale;
        RevenueExchangeCommoditiesLastMonthDurationScale = revenueExchangeCommoditiesLastMonthDurationScale;
        RevenueExchangeOtherSubjectLastMonthDurationScale = revenueExchangeOtherSubjectLastMonthDurationScale;
        TotalOfLastMonthDurationScale = totalOfLastMonthDurationScale;
        this.OTCOptionsWithinTheIndexThisMonthOfTheNewScale = OTCOptionsWithinTheIndexThisMonthOfTheNewScale;
        this.OTCOptionsToAddScaleDomesticStocksInThisMonth = OTCOptionsToAddScaleDomesticStocksInThisMonth;
        this.OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth = OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
        this.OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth = OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
        RevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth;
        RevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth;
        RevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
        RevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
        TotalOfTheNewSizeOfTheIncreaseInThisMonth = totalOfTheNewSizeOfTheIncreaseInThisMonth;
        this.OTCOptionsTerminateScaleDomesticStockIndexThisMonth = OTCOptionsTerminateScaleDomesticStockIndexThisMonth;
        this.OTCOptionsTerminateScaleDomesticStocksInThisMonth = OTCOptionsTerminateScaleDomesticStocksInThisMonth;
        this.OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth = OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth;
        this.OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth = OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth;
        RevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth = revenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth;
        RevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth = revenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth;
        RevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth = revenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth;
        RevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth = revenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth;
        TotalOfTerminationOfTheScaleOfThisMonth = totalOfTerminationOfTheScaleOfThisMonth;
        this.OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale = OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale;
        this.OTCOptionsWithinIndividualStocksInThisMonthDurationScale = OTCOptionsWithinIndividualStocksInThisMonthDurationScale;
        this.OTCOptionsCommoditiesInThisMonthDurationScale = OTCOptionsCommoditiesInThisMonthDurationScale;
        this.OTCOptionsOtherSubjectThisMonthDurationScale = OTCOptionsOtherSubjectThisMonthDurationScale;
        RevenueExchangeDomesticStockIndexThisMonthDurationScale = revenueExchangeDomesticStockIndexThisMonthDurationScale;
        RevenueExchangeDomesticIndividualStocksThisMonthDurationScale = revenueExchangeDomesticIndividualStocksThisMonthDurationScale;
        RevenueExchangeCommoditiesThisMonthDurationScale = revenueExchangeCommoditiesThisMonthDurationScale;
        RevenueExchangeOtherSubjectThisMonthDurationScale = revenueExchangeOtherSubjectThisMonthDurationScale;
        TotalOfThisMonthDurationScale = totalOfThisMonthDurationScale;
        this.OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory = OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory;
        this.OTCOptionsStockThisYearCumulativeScaleOfNewTerritory = OTCOptionsStockThisYearCumulativeScaleOfNewTerritory;
        this.OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory = OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory;
        this.OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory = OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory;
        IncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear = incomeSwapDomesticStockIndexHasAddedNewScaleInThisYear;
        IncomeSwapDomesticStockHasAddedNewScaleInThisYear = incomeSwapDomesticStockHasAddedNewScaleInThisYear;
        IncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear = incomeSwapCommoditiesIndexHasAddedNewScaleInThisYear;
        IncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear = incomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear;
        TotalNewScaleInThisYear = totalNewScaleInThisYear;
        this.OTCOptionsStockIndexAtTheEndOfLastMonth = OTCOptionsStockIndexAtTheEndOfLastMonth;
        this.OTCOptionsStockAtTheEndOfLastMonth = OTCOptionsStockAtTheEndOfLastMonth;
        this.OTCOptionsCommoditiesAtTheEndOfLastMonth = OTCOptionsCommoditiesAtTheEndOfLastMonth;
        this.OTCOptionsOtherSubjectAtTheEndOfLastMonth = OTCOptionsOtherSubjectAtTheEndOfLastMonth;
        IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth;
        IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth;
        IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth;
        IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth;
        TotalNumberOfContractsAtTheEndOfLastMonth = totalNumberOfContractsAtTheEndOfLastMonth;
        this.OTCOptionsStockIndexThisMonthNewDomesticContractNumber = OTCOptionsStockIndexThisMonthNewDomesticContractNumber;
        this.OTCOptionsStockThisMonthNewDomesticContractNumber = OTCOptionsStockThisMonthNewDomesticContractNumber;
        this.OTCOptionsCommoditiesThisMonthNewDomesticContractNumber = OTCOptionsCommoditiesThisMonthNewDomesticContractNumber;
        this.OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber = OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber;
        IncomeSwapDomesticStockIndexNewContractInThisMonth = incomeSwapDomesticStockIndexNewContractInThisMonth;
        IncomeSwapDomesticStockNewContractInThisMonth = incomeSwapDomesticStockNewContractInThisMonth;
        IncomeSwapCommoditiesNewContractInThisMonth = incomeSwapCommoditiesNewContractInThisMonth;
        IncomeSwapOtherSubjectNewContractInThisMonth = incomeSwapOtherSubjectNewContractInThisMonth;
        TotalNumberOfNewContractsInThisMonth = totalNumberOfNewContractsInThisMonth;
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber;
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber;
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber;
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber;
        IncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth = incomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth;
        IncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth = incomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth;
        IncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth = incomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth;
        IncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth = incomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth;
        TotalNumberOfContractsTerminatedThisMonth = totalNumberOfContractsTerminatedThisMonth;
        this.OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth = OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
        this.OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth = OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
        this.OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth = OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
        this.OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth = OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
        IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
        IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
        IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
        IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
        TotalNumberOfContractsAtTheEndOfThisMonth = totalNumberOfContractsAtTheEndOfThisMonth;
        this.OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear = OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear;
        this.OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear = OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear;
        this.OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear = OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear;
        this.OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear = OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear;
        IncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear = incomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear;
        IncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear = incomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear;
        IncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear = incomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear;
        IncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear = incomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear;
        TotalNumberOfNewContractsInThisYear = totalNumberOfNewContractsInThisYear;
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
        InventoryBusinessDetailsAtTheEndOfThisMonth = inventoryBusinessDetailsAtTheEndOfThisMonth;
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

    @JsonProperty("ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence")
    public String getToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence() {
        return ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence;
    }

    public void setToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence(String toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence) {
        ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence = toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionBusinessCorrespondence;
    }

    @JsonProperty("NetCapitalAtEndOfTheMonth")
    public String getNetCapitalAtEndOfTheMonth() {
        return NetCapitalAtEndOfTheMonth;
    }

    public void setNetCapitalAtEndOfTheMonth(String netCapitalAtEndOfTheMonth) {
        NetCapitalAtEndOfTheMonth = netCapitalAtEndOfTheMonth;
    }

    @JsonProperty("ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital")
    public String getToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital() {
        return ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital;
    }

    public void setToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital(String toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital) {
        ToCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital = toCarryOutSelfEquitySecuritiesAndOTCDerivativesScaleStockOptionsBusinessAccountedForTheProportionOfTheCorrespondingNetCapital;
    }

    @JsonProperty("OTCOptionHasSignedByLegalPerson")
    public String getOTCOptionHasSignedByLegalPerson() {
        return OTCOptionHasSignedByLegalPerson;
    }

    public void setOTCOptionHasSignedByLegalPerson(String OTCOptionHasSignedByLegalPerson) {
        this.OTCOptionHasSignedByLegalPerson = OTCOptionHasSignedByLegalPerson;
    }

    @JsonProperty("OTCOptionsHaveContractedProducts")
    public String getOTCOptionsHaveContractedProducts() {
        return OTCOptionsHaveContractedProducts;
    }

    public void setOTCOptionsHaveContractedProducts(String OTCOptionsHaveContractedProducts) {
        this.OTCOptionsHaveContractedProducts = OTCOptionsHaveContractedProducts;
    }

    @JsonProperty("OTCOptionsForTheMonthOfTheNewAddLegalPerson")
    public String getOTCOptionsForTheMonthOfTheNewAddLegalPerson() {
        return OTCOptionsForTheMonthOfTheNewAddLegalPerson;
    }

    public void setOTCOptionsForTheMonthOfTheNewAddLegalPerson(String OTCOptionsForTheMonthOfTheNewAddLegalPerson) {
        this.OTCOptionsForTheMonthOfTheNewAddLegalPerson = OTCOptionsForTheMonthOfTheNewAddLegalPerson;
    }

    @JsonProperty("OTCOptionsForTheMonthOfTheNewAddProduct")
    public String getOTCOptionsForTheMonthOfTheNewAddProduct() {
        return OTCOptionsForTheMonthOfTheNewAddProduct;
    }

    public void setOTCOptionsForTheMonthOfTheNewAddProduct(String OTCOptionsForTheMonthOfTheNewAddProduct) {
        this.OTCOptionsForTheMonthOfTheNewAddProduct = OTCOptionsForTheMonthOfTheNewAddProduct;
    }

    @JsonProperty("OTCOptionsLegalPersonInDurationForThisMouth")
    public String getOTCOptionsLegalPersonInDurationForThisMouth() {
        return OTCOptionsLegalPersonInDurationForThisMouth;
    }

    public void setOTCOptionsLegalPersonInDurationForThisMouth(String OTCOptionsLegalPersonInDurationForThisMouth) {
        this.OTCOptionsLegalPersonInDurationForThisMouth = OTCOptionsLegalPersonInDurationForThisMouth;
    }

    @JsonProperty("OTCOptionsProductsInDurationForThisMouth")
    public String getOTCOptionsProductsInDurationForThisMouth() {
        return OTCOptionsProductsInDurationForThisMouth;
    }

    public void setOTCOptionsProductsInDurationForThisMouth(String OTCOptionsProductsInDurationForThisMouth) {
        this.OTCOptionsProductsInDurationForThisMouth = OTCOptionsProductsInDurationForThisMouth;
    }

    @JsonProperty("IncomeSwapHasSignedLegalPersonNumber")
    public String getIncomeSwapHasSignedLegalPersonNumber() {
        return IncomeSwapHasSignedLegalPersonNumber;
    }

    public void setIncomeSwapHasSignedLegalPersonNumber(String incomeSwapHasSignedLegalPersonNumber) {
        IncomeSwapHasSignedLegalPersonNumber = incomeSwapHasSignedLegalPersonNumber;
    }

    @JsonProperty("IncomeSwapHasSignedProductNumber")
    public String getIncomeSwapHasSignedProductNumber() {
        return IncomeSwapHasSignedProductNumber;
    }

    public void setIncomeSwapHasSignedProductNumber(String incomeSwapHasSignedProductNumber) {
        IncomeSwapHasSignedProductNumber = incomeSwapHasSignedProductNumber;
    }

    @JsonProperty("IncomeSwapForTheMonthOfTheNewAddLegalPerson")
    public String getIncomeSwapForTheMonthOfTheNewAddLegalPerson() {
        return IncomeSwapForTheMonthOfTheNewAddLegalPerson;
    }

    public void setIncomeSwapForTheMonthOfTheNewAddLegalPerson(String incomeSwapForTheMonthOfTheNewAddLegalPerson) {
        IncomeSwapForTheMonthOfTheNewAddLegalPerson = incomeSwapForTheMonthOfTheNewAddLegalPerson;
    }

    @JsonProperty("IncomeSwapForTheMonthOfTheNewAddProduct")
    public String getIncomeSwapForTheMonthOfTheNewAddProduct() {
        return IncomeSwapForTheMonthOfTheNewAddProduct;
    }

    public void setIncomeSwapForTheMonthOfTheNewAddProduct(String incomeSwapForTheMonthOfTheNewAddProduct) {
        IncomeSwapForTheMonthOfTheNewAddProduct = incomeSwapForTheMonthOfTheNewAddProduct;
    }

    @JsonProperty("IncomeSwapLegalPersonInDurationForThisMouth")
    public String getIncomeSwapLegalPersonInDurationForThisMouth() {
        return IncomeSwapLegalPersonInDurationForThisMouth;
    }

    public void setIncomeSwapLegalPersonInDurationForThisMouth(String incomeSwapLegalPersonInDurationForThisMouth) {
        IncomeSwapLegalPersonInDurationForThisMouth = incomeSwapLegalPersonInDurationForThisMouth;
    }

    @JsonProperty("IncomeSwapProductsInDurationForThisMouth")
    public String getIncomeSwapProductsInDurationForThisMouth() {
        return IncomeSwapProductsInDurationForThisMouth;
    }

    public void setIncomeSwapProductsInDurationForThisMouth(String incomeSwapProductsInDurationForThisMouth) {
        IncomeSwapProductsInDurationForThisMouth = incomeSwapProductsInDurationForThisMouth;
    }

    @JsonProperty("OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale")
    public String getOTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale() {
        return OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale;
    }

    public void setOTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale(String OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale) {
        this.OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale = OTCStockIndexOptionsWithinTheLastMonthTheExistenceOfScale;
    }

    @JsonProperty("OTCOptionsWithinIndividualStocksLateLastMonthDurationScale")
    public String getOTCOptionsWithinIndividualStocksLateLastMonthDurationScale() {
        return OTCOptionsWithinIndividualStocksLateLastMonthDurationScale;
    }

    public void setOTCOptionsWithinIndividualStocksLateLastMonthDurationScale(String OTCOptionsWithinIndividualStocksLateLastMonthDurationScale) {
        this.OTCOptionsWithinIndividualStocksLateLastMonthDurationScale = OTCOptionsWithinIndividualStocksLateLastMonthDurationScale;
    }

    @JsonProperty("OTCOptionsCommoditiesLastMonthDurationScale")
    public String getOTCOptionsCommoditiesLastMonthDurationScale() {
        return OTCOptionsCommoditiesLastMonthDurationScale;
    }

    public void setOTCOptionsCommoditiesLastMonthDurationScale(String OTCOptionsCommoditiesLastMonthDurationScale) {
        this.OTCOptionsCommoditiesLastMonthDurationScale = OTCOptionsCommoditiesLastMonthDurationScale;
    }

    @JsonProperty("OTCOptionsOtherSubjectLastMonthDurationScale")
    public String getOTCOptionsOtherSubjectLastMonthDurationScale() {
        return OTCOptionsOtherSubjectLastMonthDurationScale;
    }

    public void setOTCOptionsOtherSubjectLastMonthDurationScale(String OTCOptionsOtherSubjectLastMonthDurationScale) {
        this.OTCOptionsOtherSubjectLastMonthDurationScale = OTCOptionsOtherSubjectLastMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeDomesticStockIndexLastMonthDurationScale")
    public String getRevenueExchangeDomesticStockIndexLastMonthDurationScale() {
        return RevenueExchangeDomesticStockIndexLastMonthDurationScale;
    }

    public void setRevenueExchangeDomesticStockIndexLastMonthDurationScale(String revenueExchangeDomesticStockIndexLastMonthDurationScale) {
        RevenueExchangeDomesticStockIndexLastMonthDurationScale = revenueExchangeDomesticStockIndexLastMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeDomesticIndividualStocksLastMonthDurationScale")
    public String getRevenueExchangeDomesticIndividualStocksLastMonthDurationScale() {
        return RevenueExchangeDomesticIndividualStocksLastMonthDurationScale;
    }

    public void setRevenueExchangeDomesticIndividualStocksLastMonthDurationScale(String revenueExchangeDomesticIndividualStocksLastMonthDurationScale) {
        RevenueExchangeDomesticIndividualStocksLastMonthDurationScale = revenueExchangeDomesticIndividualStocksLastMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeCommoditiesLastMonthDurationScale")
    public String getRevenueExchangeCommoditiesLastMonthDurationScale() {
        return RevenueExchangeCommoditiesLastMonthDurationScale;
    }

    public void setRevenueExchangeCommoditiesLastMonthDurationScale(String revenueExchangeCommoditiesLastMonthDurationScale) {
        RevenueExchangeCommoditiesLastMonthDurationScale = revenueExchangeCommoditiesLastMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeOtherSubjectLastMonthDurationScale")
    public String getRevenueExchangeOtherSubjectLastMonthDurationScale() {
        return RevenueExchangeOtherSubjectLastMonthDurationScale;
    }

    public void setRevenueExchangeOtherSubjectLastMonthDurationScale(String revenueExchangeOtherSubjectLastMonthDurationScale) {
        RevenueExchangeOtherSubjectLastMonthDurationScale = revenueExchangeOtherSubjectLastMonthDurationScale;
    }

    @JsonProperty("TotalOfLastMonthDurationScale")
    public String getTotalOfLastMonthDurationScale() {
        return TotalOfLastMonthDurationScale;
    }

    public void setTotalOfLastMonthDurationScale(String totalOfLastMonthDurationScale) {
        TotalOfLastMonthDurationScale = totalOfLastMonthDurationScale;
    }

    @JsonProperty("OTCOptionsWithinTheIndexThisMonthOfTheNewScale")
    public String getOTCOptionsWithinTheIndexThisMonthOfTheNewScale() {
        return OTCOptionsWithinTheIndexThisMonthOfTheNewScale;
    }

    public void setOTCOptionsWithinTheIndexThisMonthOfTheNewScale(String OTCOptionsWithinTheIndexThisMonthOfTheNewScale) {
        this.OTCOptionsWithinTheIndexThisMonthOfTheNewScale = OTCOptionsWithinTheIndexThisMonthOfTheNewScale;
    }

    @JsonProperty("OTCOptionsToAddScaleDomesticStocksInThisMonth")
    public String getOTCOptionsToAddScaleDomesticStocksInThisMonth() {
        return OTCOptionsToAddScaleDomesticStocksInThisMonth;
    }

    public void setOTCOptionsToAddScaleDomesticStocksInThisMonth(String OTCOptionsToAddScaleDomesticStocksInThisMonth) {
        this.OTCOptionsToAddScaleDomesticStocksInThisMonth = OTCOptionsToAddScaleDomesticStocksInThisMonth;
    }

    @JsonProperty("OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth")
    public String getOTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth() {
        return OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
    }

    public void setOTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth(String OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth) {
        this.OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth = OTCOptionsCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
    }

    @JsonProperty("OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth")
    public String getOTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth() {
        return OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
    }

    public void setOTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth(String OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth) {
        this.OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth = OTCOptionsOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
    }

    @JsonProperty("RevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth")
    public String getRevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth() {
        return RevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth;
    }

    public void setRevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth(String revenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth) {
        RevenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeDomesticStockIndexTheNewSizeOfTheIncreaseInThisMonth;
    }

    @JsonProperty("RevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth")
    public String getRevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth() {
        return RevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth;
    }

    public void setRevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth(String revenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth) {
        RevenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeDomesticIndividualStocksTheNewSizeOfTheIncreaseInThisMonth;
    }

    @JsonProperty("RevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth")
    public String getRevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth() {
        return RevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
    }

    public void setRevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth(String revenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth) {
        RevenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeCommoditiesTheNewSizeOfTheIncreaseInThisMonth;
    }

    @JsonProperty("RevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth")
    public String getRevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth() {
        return RevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
    }

    public void setRevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth(String revenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth) {
        RevenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth = revenueExchangeOtherSubjectTheNewSizeOfTheIncreaseInThisMonth;
    }

    @JsonProperty("TotalOfTheNewSizeOfTheIncreaseInThisMonth")
    public String getTotalOfTheNewSizeOfTheIncreaseInThisMonth() {
        return TotalOfTheNewSizeOfTheIncreaseInThisMonth;
    }

    public void setTotalOfTheNewSizeOfTheIncreaseInThisMonth(String totalOfTheNewSizeOfTheIncreaseInThisMonth) {
        TotalOfTheNewSizeOfTheIncreaseInThisMonth = totalOfTheNewSizeOfTheIncreaseInThisMonth;
    }

    @JsonProperty("OTCOptionsTerminateScaleDomesticStockIndexThisMonth")
    public String getOTCOptionsTerminateScaleDomesticStockIndexThisMonth() {
        return OTCOptionsTerminateScaleDomesticStockIndexThisMonth;
    }

    public void setOTCOptionsTerminateScaleDomesticStockIndexThisMonth(String OTCOptionsTerminateScaleDomesticStockIndexThisMonth) {
        this.OTCOptionsTerminateScaleDomesticStockIndexThisMonth = OTCOptionsTerminateScaleDomesticStockIndexThisMonth;
    }

    @JsonProperty("OTCOptionsTerminateScaleDomesticStocksInThisMonth")
    public String getOTCOptionsTerminateScaleDomesticStocksInThisMonth() {
        return OTCOptionsTerminateScaleDomesticStocksInThisMonth;
    }

    public void setOTCOptionsTerminateScaleDomesticStocksInThisMonth(String OTCOptionsTerminateScaleDomesticStocksInThisMonth) {
        this.OTCOptionsTerminateScaleDomesticStocksInThisMonth = OTCOptionsTerminateScaleDomesticStocksInThisMonth;
    }

    @JsonProperty("OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth")
    public String getOTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth() {
        return OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth;
    }

    public void setOTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth(String OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth) {
        this.OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth = OTCOptionsCommoditiesTerminationOfTheScaleOfThisMonth;
    }

    @JsonProperty("OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth")
    public String getOTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth() {
        return OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth;
    }

    public void setOTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth(String OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth) {
        this.OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth = OTCOptionsOtherSubjectTerminationOfTheScaleOfThisMonth;
    }

    @JsonProperty("RevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth")
    public String getRevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth() {
        return RevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth;
    }

    public void setRevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth(String revenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth) {
        RevenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth = revenueExchangeDomesticStockIndexTerminationOfTheScaleOfThisMonth;
    }

    @JsonProperty("RevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth")
    public String getRevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth() {
        return RevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth;
    }

    public void setRevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth(String revenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth) {
        RevenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth = revenueExchangeDomesticIndividualStocksTerminationOfTheScaleOfThisMonth;
    }

    @JsonProperty("RevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth")
    public String getRevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth() {
        return RevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth;
    }

    public void setRevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth(String revenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth) {
        RevenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth = revenueExchangeCommoditiesTerminationOfTheScaleOfThisMonth;
    }

    @JsonProperty("RevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth")
    public String getRevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth() {
        return RevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth;
    }

    public void setRevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth(String revenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth) {
        RevenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth = revenueExchangeOtherSubjectTerminationOfTheScaleOfThisMonth;
    }

    @JsonProperty("TotalOfTerminationOfTheScaleOfThisMonth")
    public String getTotalOfTerminationOfTheScaleOfThisMonth() {
        return TotalOfTerminationOfTheScaleOfThisMonth;
    }

    public void setTotalOfTerminationOfTheScaleOfThisMonth(String totalOfTerminationOfTheScaleOfThisMonth) {
        TotalOfTerminationOfTheScaleOfThisMonth = totalOfTerminationOfTheScaleOfThisMonth;
    }

    @JsonProperty("OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale")
    public String getOTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale() {
        return OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale;
    }

    public void setOTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale(String OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale) {
        this.OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale = OTCStockIndexOptionsWithinThisMonthOfTheExistenceOfScale;
    }

    @JsonProperty("OTCOptionsWithinIndividualStocksInThisMonthDurationScale")
    public String getOTCOptionsWithinIndividualStocksInThisMonthDurationScale() {
        return OTCOptionsWithinIndividualStocksInThisMonthDurationScale;
    }

    public void setOTCOptionsWithinIndividualStocksInThisMonthDurationScale(String OTCOptionsWithinIndividualStocksInThisMonthDurationScale) {
        this.OTCOptionsWithinIndividualStocksInThisMonthDurationScale = OTCOptionsWithinIndividualStocksInThisMonthDurationScale;
    }

    @JsonProperty("OTCOptionsCommoditiesInThisMonthDurationScale")
    public String getOTCOptionsCommoditiesInThisMonthDurationScale() {
        return OTCOptionsCommoditiesInThisMonthDurationScale;
    }

    public void setOTCOptionsCommoditiesInThisMonthDurationScale(String OTCOptionsCommoditiesInThisMonthDurationScale) {
        this.OTCOptionsCommoditiesInThisMonthDurationScale = OTCOptionsCommoditiesInThisMonthDurationScale;
    }

    @JsonProperty("OTCOptionsOtherSubjectThisMonthDurationScale")
    public String getOTCOptionsOtherSubjectThisMonthDurationScale() {
        return OTCOptionsOtherSubjectThisMonthDurationScale;
    }

    public void setOTCOptionsOtherSubjectThisMonthDurationScale(String OTCOptionsOtherSubjectThisMonthDurationScale) {
        this.OTCOptionsOtherSubjectThisMonthDurationScale = OTCOptionsOtherSubjectThisMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeDomesticStockIndexThisMonthDurationScale")
    public String getRevenueExchangeDomesticStockIndexThisMonthDurationScale() {
        return RevenueExchangeDomesticStockIndexThisMonthDurationScale;
    }

    public void setRevenueExchangeDomesticStockIndexThisMonthDurationScale(String revenueExchangeDomesticStockIndexThisMonthDurationScale) {
        RevenueExchangeDomesticStockIndexThisMonthDurationScale = revenueExchangeDomesticStockIndexThisMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeDomesticIndividualStocksThisMonthDurationScale")
    public String getRevenueExchangeDomesticIndividualStocksThisMonthDurationScale() {
        return RevenueExchangeDomesticIndividualStocksThisMonthDurationScale;
    }

    public void setRevenueExchangeDomesticIndividualStocksThisMonthDurationScale(String revenueExchangeDomesticIndividualStocksThisMonthDurationScale) {
        RevenueExchangeDomesticIndividualStocksThisMonthDurationScale = revenueExchangeDomesticIndividualStocksThisMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeCommoditiesThisMonthDurationScale")
    public String getRevenueExchangeCommoditiesThisMonthDurationScale() {
        return RevenueExchangeCommoditiesThisMonthDurationScale;
    }

    public void setRevenueExchangeCommoditiesThisMonthDurationScale(String revenueExchangeCommoditiesThisMonthDurationScale) {
        RevenueExchangeCommoditiesThisMonthDurationScale = revenueExchangeCommoditiesThisMonthDurationScale;
    }

    @JsonProperty("RevenueExchangeOtherSubjectThisMonthDurationScale")
    public String getRevenueExchangeOtherSubjectThisMonthDurationScale() {
        return RevenueExchangeOtherSubjectThisMonthDurationScale;
    }

    public void setRevenueExchangeOtherSubjectThisMonthDurationScale(String revenueExchangeOtherSubjectThisMonthDurationScale) {
        RevenueExchangeOtherSubjectThisMonthDurationScale = revenueExchangeOtherSubjectThisMonthDurationScale;
    }

    @JsonProperty("TotalOfThisMonthDurationScale")
    public String getTotalOfThisMonthDurationScale() {
        return TotalOfThisMonthDurationScale;
    }

    public void setTotalOfThisMonthDurationScale(String totalOfThisMonthDurationScale) {
        TotalOfThisMonthDurationScale = totalOfThisMonthDurationScale;
    }

    @JsonProperty("OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory")
    public String getOTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory() {
        return OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory;
    }

    public void setOTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory(String OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory) {
        this.OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory = OTCOptionsStockIndexThisYearCumulativeScaleOfNewTerritory;
    }

    @JsonProperty("OTCOptionsStockThisYearCumulativeScaleOfNewTerritory")
    public String getOTCOptionsStockThisYearCumulativeScaleOfNewTerritory() {
        return OTCOptionsStockThisYearCumulativeScaleOfNewTerritory;
    }

    public void setOTCOptionsStockThisYearCumulativeScaleOfNewTerritory(String OTCOptionsStockThisYearCumulativeScaleOfNewTerritory) {
        this.OTCOptionsStockThisYearCumulativeScaleOfNewTerritory = OTCOptionsStockThisYearCumulativeScaleOfNewTerritory;
    }

    @JsonProperty("OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory")
    public String getOTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory() {
        return OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory;
    }

    public void setOTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory(String OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory) {
        this.OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory = OTCOptionsCommoditiesThisYearCumulativeScaleOfNewTerritory;
    }

    @JsonProperty("OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory")
    public String getOTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory() {
        return OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory;
    }

    public void setOTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory(String OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory) {
        this.OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory = OTCOptionsOtherSubjectThisYearCumulativeScaleOfNewTerritory;
    }

    @JsonProperty("IncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear")
    public String getIncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear() {
        return IncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear;
    }

    public void setIncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear(String incomeSwapDomesticStockIndexHasAddedNewScaleInThisYear) {
        IncomeSwapDomesticStockIndexHasAddedNewScaleInThisYear = incomeSwapDomesticStockIndexHasAddedNewScaleInThisYear;
    }

    @JsonProperty("IncomeSwapDomesticStockHasAddedNewScaleInThisYear")
    public String getIncomeSwapDomesticStockHasAddedNewScaleInThisYear() {
        return IncomeSwapDomesticStockHasAddedNewScaleInThisYear;
    }

    public void setIncomeSwapDomesticStockHasAddedNewScaleInThisYear(String incomeSwapDomesticStockHasAddedNewScaleInThisYear) {
        IncomeSwapDomesticStockHasAddedNewScaleInThisYear = incomeSwapDomesticStockHasAddedNewScaleInThisYear;
    }

    @JsonProperty("IncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear")
    public String getIncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear() {
        return IncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear;
    }

    public void setIncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear(String incomeSwapCommoditiesIndexHasAddedNewScaleInThisYear) {
        IncomeSwapCommoditiesIndexHasAddedNewScaleInThisYear = incomeSwapCommoditiesIndexHasAddedNewScaleInThisYear;
    }

    @JsonProperty("IncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear")
    public String getIncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear() {
        return IncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear;
    }

    public void setIncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear(String incomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear) {
        IncomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear = incomeSwapOtherSubjectIndexHasAddedNewScaleInThisYear;
    }

    @JsonProperty("TotalNewScaleInThisYear")
    public String getTotalNewScaleInThisYear() {
        return TotalNewScaleInThisYear;
    }

    public void setTotalNewScaleInThisYear(String totalNewScaleInThisYear) {
        TotalNewScaleInThisYear = totalNewScaleInThisYear;
    }

    @JsonProperty("OTCOptionsStockIndexAtTheEndOfLastMonth")
    public String getOTCOptionsStockIndexAtTheEndOfLastMonth() {
        return OTCOptionsStockIndexAtTheEndOfLastMonth;
    }

    public void setOTCOptionsStockIndexAtTheEndOfLastMonth(String OTCOptionsStockIndexAtTheEndOfLastMonth) {
        this.OTCOptionsStockIndexAtTheEndOfLastMonth = OTCOptionsStockIndexAtTheEndOfLastMonth;
    }

    @JsonProperty("OTCOptionsStockAtTheEndOfLastMonth")
    public String getOTCOptionsStockAtTheEndOfLastMonth() {
        return OTCOptionsStockAtTheEndOfLastMonth;
    }

    public void setOTCOptionsStockAtTheEndOfLastMonth(String OTCOptionsStockAtTheEndOfLastMonth) {
        this.OTCOptionsStockAtTheEndOfLastMonth = OTCOptionsStockAtTheEndOfLastMonth;
    }

    @JsonProperty("OTCOptionsCommoditiesAtTheEndOfLastMonth")
    public String getOTCOptionsCommoditiesAtTheEndOfLastMonth() {
        return OTCOptionsCommoditiesAtTheEndOfLastMonth;
    }

    public void setOTCOptionsCommoditiesAtTheEndOfLastMonth(String OTCOptionsCommoditiesAtTheEndOfLastMonth) {
        this.OTCOptionsCommoditiesAtTheEndOfLastMonth = OTCOptionsCommoditiesAtTheEndOfLastMonth;
    }

    @JsonProperty("OTCOptionsOtherSubjectAtTheEndOfLastMonth")
    public String getOTCOptionsOtherSubjectAtTheEndOfLastMonth() {
        return OTCOptionsOtherSubjectAtTheEndOfLastMonth;
    }

    public void setOTCOptionsOtherSubjectAtTheEndOfLastMonth(String OTCOptionsOtherSubjectAtTheEndOfLastMonth) {
        this.OTCOptionsOtherSubjectAtTheEndOfLastMonth = OTCOptionsOtherSubjectAtTheEndOfLastMonth;
    }

    @JsonProperty("IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth")
    public String getIncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth() {
        return IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    public void setIncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth(String incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth) {
        IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    @JsonProperty("IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth")
    public String getIncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth() {
        return IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    public void setIncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth(String incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth) {
        IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    @JsonProperty("IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth")
    public String getIncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth() {
        return IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    public void setIncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth(String incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth) {
        IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    @JsonProperty("IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth")
    public String getIncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth() {
        return IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    public void setIncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth(String incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth) {
        IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth = incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfLastMonth;
    }

    @JsonProperty("TotalNumberOfContractsAtTheEndOfLastMonth")
    public String getTotalNumberOfContractsAtTheEndOfLastMonth() {
        return TotalNumberOfContractsAtTheEndOfLastMonth;
    }

    public void setTotalNumberOfContractsAtTheEndOfLastMonth(String totalNumberOfContractsAtTheEndOfLastMonth) {
        TotalNumberOfContractsAtTheEndOfLastMonth = totalNumberOfContractsAtTheEndOfLastMonth;
    }

    @JsonProperty("OTCOptionsStockIndexThisMonthNewDomesticContractNumber")
    public String getOTCOptionsStockIndexThisMonthNewDomesticContractNumber() {
        return OTCOptionsStockIndexThisMonthNewDomesticContractNumber;
    }

    public void setOTCOptionsStockIndexThisMonthNewDomesticContractNumber(String OTCOptionsStockIndexThisMonthNewDomesticContractNumber) {
        this.OTCOptionsStockIndexThisMonthNewDomesticContractNumber = OTCOptionsStockIndexThisMonthNewDomesticContractNumber;
    }

    @JsonProperty("OTCOptionsStockThisMonthNewDomesticContractNumber")
    public String getOTCOptionsStockThisMonthNewDomesticContractNumber() {
        return OTCOptionsStockThisMonthNewDomesticContractNumber;
    }

    public void setOTCOptionsStockThisMonthNewDomesticContractNumber(String OTCOptionsStockThisMonthNewDomesticContractNumber) {
        this.OTCOptionsStockThisMonthNewDomesticContractNumber = OTCOptionsStockThisMonthNewDomesticContractNumber;
    }

    @JsonProperty("OTCOptionsCommoditiesThisMonthNewDomesticContractNumber")
    public String getOTCOptionsCommoditiesThisMonthNewDomesticContractNumber() {
        return OTCOptionsCommoditiesThisMonthNewDomesticContractNumber;
    }

    public void setOTCOptionsCommoditiesThisMonthNewDomesticContractNumber(String OTCOptionsCommoditiesThisMonthNewDomesticContractNumber) {
        this.OTCOptionsCommoditiesThisMonthNewDomesticContractNumber = OTCOptionsCommoditiesThisMonthNewDomesticContractNumber;
    }

    @JsonProperty("OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber")
    public String getOTCOptionsOtherSubjectThisMonthNewDomesticContractNumber() {
        return OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber;
    }

    public void setOTCOptionsOtherSubjectThisMonthNewDomesticContractNumber(String OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber) {
        this.OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber = OTCOptionsOtherSubjectThisMonthNewDomesticContractNumber;
    }

    @JsonProperty("IncomeSwapDomesticStockIndexNewContractInThisMonth")
    public String getIncomeSwapDomesticStockIndexNewContractInThisMonth() {
        return IncomeSwapDomesticStockIndexNewContractInThisMonth;
    }

    public void setIncomeSwapDomesticStockIndexNewContractInThisMonth(String incomeSwapDomesticStockIndexNewContractInThisMonth) {
        IncomeSwapDomesticStockIndexNewContractInThisMonth = incomeSwapDomesticStockIndexNewContractInThisMonth;
    }

    @JsonProperty("IncomeSwapDomesticStockNewContractInThisMonth")
    public String getIncomeSwapDomesticStockNewContractInThisMonth() {
        return IncomeSwapDomesticStockNewContractInThisMonth;
    }

    public void setIncomeSwapDomesticStockNewContractInThisMonth(String incomeSwapDomesticStockNewContractInThisMonth) {
        IncomeSwapDomesticStockNewContractInThisMonth = incomeSwapDomesticStockNewContractInThisMonth;
    }

    @JsonProperty("IncomeSwapCommoditiesNewContractInThisMonth")
    public String getIncomeSwapCommoditiesNewContractInThisMonth() {
        return IncomeSwapCommoditiesNewContractInThisMonth;
    }

    public void setIncomeSwapCommoditiesNewContractInThisMonth(String incomeSwapCommoditiesNewContractInThisMonth) {
        IncomeSwapCommoditiesNewContractInThisMonth = incomeSwapCommoditiesNewContractInThisMonth;
    }

    @JsonProperty("IncomeSwapOtherSubjectNewContractInThisMonth")
    public String getIncomeSwapOtherSubjectNewContractInThisMonth() {
        return IncomeSwapOtherSubjectNewContractInThisMonth;
    }

    public void setIncomeSwapOtherSubjectNewContractInThisMonth(String incomeSwapOtherSubjectNewContractInThisMonth) {
        IncomeSwapOtherSubjectNewContractInThisMonth = incomeSwapOtherSubjectNewContractInThisMonth;
    }

    @JsonProperty("TotalNumberOfNewContractsInThisMonth")
    public String getTotalNumberOfNewContractsInThisMonth() {
        return TotalNumberOfNewContractsInThisMonth;
    }

    public void setTotalNumberOfNewContractsInThisMonth(String totalNumberOfNewContractsInThisMonth) {
        TotalNumberOfNewContractsInThisMonth = totalNumberOfNewContractsInThisMonth;
    }

    @JsonProperty("OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber")
    public String getOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber() {
        return OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber;
    }

    public void setOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber(String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber) {
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockIndexNumber;
    }

    @JsonProperty("OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber")
    public String getOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber() {
        return OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber;
    }

    public void setOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber(String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber) {
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheStockNumber;
    }

    @JsonProperty("OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber")
    public String getOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber() {
        return OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber;
    }

    public void setOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber(String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber) {
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheCommoditiesNumber;
    }

    @JsonProperty("OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber")
    public String getOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber() {
        return OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber;
    }

    public void setOTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber(String OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber) {
        this.OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber = OTCOptionsThisMonthToTerminateTheContractWithinTheTerritoryOfTheOtherSubjectNumber;
    }

    @JsonProperty("IncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth")
    public String getIncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth() {
        return IncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth;
    }

    public void setIncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth(String incomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth) {
        IncomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth = incomeSwapDomesticStockIndexTerminatesTheNumberOfContractsThisMonth;
    }

    @JsonProperty("IncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth")
    public String getIncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth() {
        return IncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth;
    }

    public void setIncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth(String incomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth) {
        IncomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth = incomeSwapDomesticStockTerminatesTheNumberOfContractsThisMonth;
    }

    @JsonProperty("IncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth")
    public String getIncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth() {
        return IncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth;
    }

    public void setIncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth(String incomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth) {
        IncomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth = incomeSwapCommoditiesTerminatesTheNumberOfContractsThisMonth;
    }

    @JsonProperty("IncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth")
    public String getIncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth() {
        return IncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth;
    }

    public void setIncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth(String incomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth) {
        IncomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth = incomeSwapOtherSubjectTerminatesTheNumberOfContractsThisMonth;
    }

    @JsonProperty("TotalNumberOfContractsTerminatedThisMonth")
    public String getTotalNumberOfContractsTerminatedThisMonth() {
        return TotalNumberOfContractsTerminatedThisMonth;
    }

    public void setTotalNumberOfContractsTerminatedThisMonth(String totalNumberOfContractsTerminatedThisMonth) {
        TotalNumberOfContractsTerminatedThisMonth = totalNumberOfContractsTerminatedThisMonth;
    }

    @JsonProperty("OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getOTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setOTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth(String OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth) {
        this.OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth = OTCDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getOTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setOTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth(String OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth) {
        this.OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth = OTCDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getOTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setOTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth(String OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth) {
        this.OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth = OTCCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getOTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setOTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth(String OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth) {
        this.OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth = OTCOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getIncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setIncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth(String incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth) {
        IncomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeDomesticStockIndexNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getIncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setIncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth(String incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth) {
        IncomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeDomesticStockNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getIncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setIncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth(String incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth) {
        IncomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeCommoditiesNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth")
    public String getIncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth() {
        return IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    public void setIncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth(String incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth) {
        IncomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth = incomeExchangeOtherSubjectNumberOfRemainingContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("TotalNumberOfContractsAtTheEndOfThisMonth")
    public String getTotalNumberOfContractsAtTheEndOfThisMonth() {
        return TotalNumberOfContractsAtTheEndOfThisMonth;
    }

    public void setTotalNumberOfContractsAtTheEndOfThisMonth(String totalNumberOfContractsAtTheEndOfThisMonth) {
        TotalNumberOfContractsAtTheEndOfThisMonth = totalNumberOfContractsAtTheEndOfThisMonth;
    }

    @JsonProperty("OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear")
    public String getOTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear() {
        return OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear;
    }

    public void setOTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear(String OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear) {
        this.OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear = OTCOptionsStockIndexCumulativeDomesticNewContractNumberInThisYear;
    }

    @JsonProperty("OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear")
    public String getOTCOptionsStockCumulativeDomesticNewContractNumberInThisYear() {
        return OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear;
    }

    public void setOTCOptionsStockCumulativeDomesticNewContractNumberInThisYear(String OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear) {
        this.OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear = OTCOptionsStockCumulativeDomesticNewContractNumberInThisYear;
    }

    @JsonProperty("OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear")
    public String getOTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear() {
        return OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear;
    }

    public void setOTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear(String OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear) {
        this.OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear = OTCOptionsCommoditiesCumulativeDomesticNewContractNumberInThisYear;
    }

    @JsonProperty("OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear")
    public String getOTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear() {
        return OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear;
    }

    public void setOTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear(String OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear) {
        this.OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear = OTCOptionsOtherSubjectCumulativeDomesticNewContractNumberInThisYear;
    }

    @JsonProperty("IncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear")
    public String getIncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear() {
        return IncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear;
    }

    public void setIncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear(String incomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear) {
        IncomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear = incomeSwapDomesticStockIndexCumulativeNumberOfNewContractsInThisYear;
    }

    @JsonProperty("IncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear")
    public String getIncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear() {
        return IncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear;
    }

    public void setIncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear(String incomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear) {
        IncomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear = incomeSwapDomesticStockCumulativeNumberOfNewContractsInThisYear;
    }

    @JsonProperty("IncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear")
    public String getIncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear() {
        return IncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear;
    }

    public void setIncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear(String incomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear) {
        IncomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear = incomeSwapCommoditiesCumulativeNumberOfNewContractsInThisYear;
    }

    @JsonProperty("IncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear")
    public String getIncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear() {
        return IncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear;
    }

    public void setIncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear(String incomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear) {
        IncomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear = incomeSwapOtherSubjectCumulativeNumberOfNewContractsInThisYear;
    }

    @JsonProperty("TotalNumberOfNewContractsInThisYear")
    public String getTotalNumberOfNewContractsInThisYear() {
        return TotalNumberOfNewContractsInThisYear;
    }

    public void setTotalNumberOfNewContractsInThisYear(String totalNumberOfNewContractsInThisYear) {
        TotalNumberOfNewContractsInThisYear = totalNumberOfNewContractsInThisYear;
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

    @JsonProperty("InventoryBusinessDetailsAtTheEndOfThisMonth")
    public List<InventoryBusinessDetailsAtTheEndOfThisMonthDTO> getInventoryBusinessDetailsAtTheEndOfThisMonth() {
        return InventoryBusinessDetailsAtTheEndOfThisMonth;
    }

    public void setInventoryBusinessDetailsAtTheEndOfThisMonth(List<InventoryBusinessDetailsAtTheEndOfThisMonthDTO> inventoryBusinessDetailsAtTheEndOfThisMonth) {
        InventoryBusinessDetailsAtTheEndOfThisMonth = inventoryBusinessDetailsAtTheEndOfThisMonth;
    }

    @JsonProperty("TargetCaseAndHedgeTuple")
    public List<TargetCaseAndHedgeTupleDTO> getTargetCaseAndHedgeTuple() {
        return TargetCaseAndHedgeTuple;
    }

    public void setTargetCaseAndHedgeTuple(List<TargetCaseAndHedgeTupleDTO> targetCaseAndHedgeTuple) {
        TargetCaseAndHedgeTuple = targetCaseAndHedgeTuple;
    }
}
