package tech.tongyu.core.dto.sac;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description SAC
 */
@JsonPropertyOrder({"SecurityCompany", "BusinessType", "SumInvestmentTargetType",
        "SumInvestmentTargetName", "BuyingImpulseVolume", "SellingImpulseVolume",
        "ImpulseVolume", "PositionAtTheEndOfThisMonth", "TheNumberOfPositionsHeldAtTheEndOfThisMonth",
        "AveragePriceAtTheEndOfTheMonth", "MarketValueOfTheLastTradingDayOfTheMonth"})
public class TargetCaseAndHedgeTupleDTO {

    private String SecurityCompany;
    private String BusinessType;
    private String SumInvestmentTargetType;
    private String SumInvestmentTargetName;
    private String BuyingImpulseVolume;
    private String SellingImpulseVolume;
    private String ImpulseVolume;
    private String PositionAtTheEndOfThisMonth;
    private String TheNumberOfPositionsHeldAtTheEndOfThisMonth;
    private String AveragePriceAtTheEndOfTheMonth;
    private String MarketValueOfTheLastTradingDayOfTheMonth;

    public TargetCaseAndHedgeTupleDTO() {
    }

    public TargetCaseAndHedgeTupleDTO(String securityCompany, String businessType, String sumInvestmentTargetType, String sumInvestmentTargetName, String buyingImpulseVolume, String sellingImpulseVolume, String impulseVolume, String positionAtTheEndOfThisMonth, String theNumberOfPositionsHeldAtTheEndOfThisMonth, String averagePriceAtTheEndOfTheMonth, String marketValueOfTheLastTradingDayOfTheMonth) {
        SecurityCompany = securityCompany;
        BusinessType = businessType;
        SumInvestmentTargetType = sumInvestmentTargetType;
        SumInvestmentTargetName = sumInvestmentTargetName;
        BuyingImpulseVolume = buyingImpulseVolume;
        SellingImpulseVolume = sellingImpulseVolume;
        ImpulseVolume = impulseVolume;
        PositionAtTheEndOfThisMonth = positionAtTheEndOfThisMonth;
        TheNumberOfPositionsHeldAtTheEndOfThisMonth = theNumberOfPositionsHeldAtTheEndOfThisMonth;
        AveragePriceAtTheEndOfTheMonth = averagePriceAtTheEndOfTheMonth;
        MarketValueOfTheLastTradingDayOfTheMonth = marketValueOfTheLastTradingDayOfTheMonth;
    }

    @JsonProperty("SecurityCompany")
    public String getSecurityCompany() {
        return SecurityCompany;
    }

    public void setSecurityCompany(String securityCompany) {
        SecurityCompany = securityCompany;
    }

    @JsonProperty("BusinessType")
    public String getBusinessType() {
        return BusinessType;
    }

    public void setBusinessType(String businessType) {
        BusinessType = businessType;
    }

    @JsonProperty("SumInvestmentTargetType")
    public String getSumInvestmentTargetType() {
        return SumInvestmentTargetType;
    }

    public void setSumInvestmentTargetType(String sumInvestmentTargetType) {
        SumInvestmentTargetType = sumInvestmentTargetType;
    }

    @JsonProperty("SumInvestmentTargetName")
    public String getSumInvestmentTargetName() {
        return SumInvestmentTargetName;
    }

    public void setSumInvestmentTargetName(String sumInvestmentTargetName) {
        SumInvestmentTargetName = sumInvestmentTargetName;
    }

    @JsonProperty("BuyingImpulseVolume")
    public String getBuyingImpulseVolume() {
        return BuyingImpulseVolume;
    }

    public void setBuyingImpulseVolume(String buyingImpulseVolume) {
        BuyingImpulseVolume = buyingImpulseVolume;
    }

    @JsonProperty("SellingImpulseVolume")
    public String getSellingImpulseVolume() {
        return SellingImpulseVolume;
    }

    public void setSellingImpulseVolume(String sellingImpulseVolume) {
        SellingImpulseVolume = sellingImpulseVolume;
    }

    @JsonProperty("ImpulseVolume")
    public String getImpulseVolume() {
        return ImpulseVolume;
    }

    public void setImpulseVolume(String impulseVolume) {
        ImpulseVolume = impulseVolume;
    }

    @JsonProperty("PositionAtTheEndOfThisMonth")
    public String getPositionAtTheEndOfThisMonth() {
        return PositionAtTheEndOfThisMonth;
    }

    public void setPositionAtTheEndOfThisMonth(String positionAtTheEndOfThisMonth) {
        PositionAtTheEndOfThisMonth = positionAtTheEndOfThisMonth;
    }

    @JsonProperty("TheNumberOfPositionsHeldAtTheEndOfThisMonth")
    public String getTheNumberOfPositionsHeldAtTheEndOfThisMonth() {
        return TheNumberOfPositionsHeldAtTheEndOfThisMonth;
    }

    public void setTheNumberOfPositionsHeldAtTheEndOfThisMonth(String theNumberOfPositionsHeldAtTheEndOfThisMonth) {
        TheNumberOfPositionsHeldAtTheEndOfThisMonth = theNumberOfPositionsHeldAtTheEndOfThisMonth;
    }

    @JsonProperty("AveragePriceAtTheEndOfTheMonth")
    public String getAveragePriceAtTheEndOfTheMonth() {
        return AveragePriceAtTheEndOfTheMonth;
    }

    public void setAveragePriceAtTheEndOfTheMonth(String averagePriceAtTheEndOfTheMonth) {
        AveragePriceAtTheEndOfTheMonth = averagePriceAtTheEndOfTheMonth;
    }

    @JsonProperty("MarketValueOfTheLastTradingDayOfTheMonth")
    public String getMarketValueOfTheLastTradingDayOfTheMonth() {
        return MarketValueOfTheLastTradingDayOfTheMonth;
    }

    public void setMarketValueOfTheLastTradingDayOfTheMonth(String marketValueOfTheLastTradingDayOfTheMonth) {
        MarketValueOfTheLastTradingDayOfTheMonth = marketValueOfTheLastTradingDayOfTheMonth;
    }
}
