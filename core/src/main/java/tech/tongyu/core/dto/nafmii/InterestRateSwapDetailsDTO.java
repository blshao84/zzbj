package tech.tongyu.core.dto.nafmii;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description NAFMII-利率互换明细
 */
@JsonPropertyOrder({"TransactionDate", "FillInTheNameOfTheOrganization", "FillInTheNameOfTheAgency",
        "NameOfCounterparty", "CounterpartyAllographProduct", "CounterpartyType",
        "CounterpartyIsProfessionalInstitutionsOrNot", "FixedInterestPaymentParty",
        "FloatingInterestPaymentParty", "NotionalPrincipalAmount",
        "ContractPeriod", "DalueDate", "DueDate", "FixedRate", "FixedRatePaymentCycle",
        "FixedInterestRateBasis", "ReferenceRateName", "Spreads",
        "FloatingRatePaymentCycle", "ResetTheFrequency", "FloatingInterestRateBasis",
        "FirstInterestPaymentDay"})
public class InterestRateSwapDetailsDTO {

    private String TransactionDate;
    private String FillInTheNameOfTheOrganization;
    private String FillInTheNameOfTheAgency;
    private String NameOfCounterparty;
    private String CounterpartyAllographProduct;

    private String CounterpartyType;
    private String CounterpartyIsProfessionalInstitutionsOrNot;
    private String FixedInterestPaymentParty;
    private String FloatingInterestPaymentParty;
    private String NotionalPrincipalAmount;

    private String ContractPeriod;
    private String DalueDate;
    private String DueDate;
    private String FixedRate;
    private String FixedRatePaymentCycle;

    private String FixedInterestRateBasis;
    private String ReferenceRateName;
    private String Spreads;
    private String FloatingRatePaymentCycle;
    private String ResetTheFrequency;

    private String FloatingInterestRateBasis;
    private String FirstInterestPaymentDay;

    public InterestRateSwapDetailsDTO() {
    }

    public InterestRateSwapDetailsDTO(String transactionDate, String fillInTheNameOfTheOrganization, String fillInTheNameOfTheAgency, String nameOfCounterparty, String counterpartyAllographProduct, String counterpartyType, String counterpartyIsProfessionalInstitutionsOrNot, String fixedInterestPaymentParty, String floatingInterestPaymentParty, String notionalPrincipalAmount, String contractPeriod, String dalueDate, String dueDate, String fixedRate, String fixedRatePaymentCycle, String fixedInterestRateBasis, String referenceRateName, String spreads, String floatingRatePaymentCycle, String resetTheFrequency, String floatingInterestRateBasis, String firstInterestPaymentDay) {
        TransactionDate = transactionDate;
        FillInTheNameOfTheOrganization = fillInTheNameOfTheOrganization;
        FillInTheNameOfTheAgency = fillInTheNameOfTheAgency;
        NameOfCounterparty = nameOfCounterparty;
        CounterpartyAllographProduct = counterpartyAllographProduct;
        CounterpartyType = counterpartyType;
        CounterpartyIsProfessionalInstitutionsOrNot = counterpartyIsProfessionalInstitutionsOrNot;
        FixedInterestPaymentParty = fixedInterestPaymentParty;
        FloatingInterestPaymentParty = floatingInterestPaymentParty;
        NotionalPrincipalAmount = notionalPrincipalAmount;
        ContractPeriod = contractPeriod;
        DalueDate = dalueDate;
        DueDate = dueDate;
        FixedRate = fixedRate;
        FixedRatePaymentCycle = fixedRatePaymentCycle;
        FixedInterestRateBasis = fixedInterestRateBasis;
        ReferenceRateName = referenceRateName;
        Spreads = spreads;
        FloatingRatePaymentCycle = floatingRatePaymentCycle;
        ResetTheFrequency = resetTheFrequency;
        FloatingInterestRateBasis = floatingInterestRateBasis;
        FirstInterestPaymentDay = firstInterestPaymentDay;
    }

    @JsonProperty("TransactionDate")
    public String getTransactionDate() {
        return TransactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        TransactionDate = transactionDate;
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

    @JsonProperty("FixedInterestPaymentParty")
    public String getFixedInterestPaymentParty() {
        return FixedInterestPaymentParty;
    }

    public void setFixedInterestPaymentParty(String fixedInterestPaymentParty) {
        FixedInterestPaymentParty = fixedInterestPaymentParty;
    }

    @JsonProperty("FloatingInterestPaymentParty")
    public String getFloatingInterestPaymentParty() {
        return FloatingInterestPaymentParty;
    }

    public void setFloatingInterestPaymentParty(String floatingInterestPaymentParty) {
        FloatingInterestPaymentParty = floatingInterestPaymentParty;
    }

    @JsonProperty("NotionalPrincipalAmount")
    public String getNotionalPrincipalAmount() {
        return NotionalPrincipalAmount;
    }

    public void setNotionalPrincipalAmount(String notionalPrincipalAmount) {
        NotionalPrincipalAmount = notionalPrincipalAmount;
    }

    @JsonProperty("ContractPeriod")
    public String getContractPeriod() {
        return ContractPeriod;
    }

    public void setContractPeriod(String contractPeriod) {
        ContractPeriod = contractPeriod;
    }

    @JsonProperty("DalueDate")
    public String getDalueDate() {
        return DalueDate;
    }

    public void setDalueDate(String dalueDate) {
        DalueDate = dalueDate;
    }

    @JsonProperty("DueDate")
    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    @JsonProperty("FixedRate")
    public String getFixedRate() {
        return FixedRate;
    }

    public void setFixedRate(String fixedRate) {
        FixedRate = fixedRate;
    }

    @JsonProperty("FixedRatePaymentCycle")
    public String getFixedRatePaymentCycle() {
        return FixedRatePaymentCycle;
    }

    public void setFixedRatePaymentCycle(String fixedRatePaymentCycle) {
        FixedRatePaymentCycle = fixedRatePaymentCycle;
    }

    @JsonProperty("FixedInterestRateBasis")
    public String getFixedInterestRateBasis() {
        return FixedInterestRateBasis;
    }

    public void setFixedInterestRateBasis(String fixedInterestRateBasis) {
        FixedInterestRateBasis = fixedInterestRateBasis;
    }

    @JsonProperty("ReferenceRateName")
    public String getReferenceRateName() {
        return ReferenceRateName;
    }

    public void setReferenceRateName(String referenceRateName) {
        ReferenceRateName = referenceRateName;
    }

    @JsonProperty("Spreads")
    public String getSpreads() {
        return Spreads;
    }

    public void setSpreads(String spreads) {
        Spreads = spreads;
    }

    @JsonProperty("FloatingRatePaymentCycle")
    public String getFloatingRatePaymentCycle() {
        return FloatingRatePaymentCycle;
    }

    public void setFloatingRatePaymentCycle(String floatingRatePaymentCycle) {
        FloatingRatePaymentCycle = floatingRatePaymentCycle;
    }

    @JsonProperty("ResetTheFrequency")
    public String getResetTheFrequency() {
        return ResetTheFrequency;
    }

    public void setResetTheFrequency(String resetTheFrequency) {
        ResetTheFrequency = resetTheFrequency;
    }

    @JsonProperty("FloatingInterestRateBasis")
    public String getFloatingInterestRateBasis() {
        return FloatingInterestRateBasis;
    }

    public void setFloatingInterestRateBasis(String floatingInterestRateBasis) {
        FloatingInterestRateBasis = floatingInterestRateBasis;
    }

    @JsonProperty("FirstInterestPaymentDay")
    public String getFirstInterestPaymentDay() {
        return FirstInterestPaymentDay;
    }

    public void setFirstInterestPaymentDay(String firstInterestPaymentDay) {
        FirstInterestPaymentDay = firstInterestPaymentDay;
    }
}
