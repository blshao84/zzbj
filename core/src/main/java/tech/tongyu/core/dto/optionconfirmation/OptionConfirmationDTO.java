package tech.tongyu.core.dto.optionconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易确认书
 */
@JsonPropertyOrder({"ExceID", "BizID", "MasterAgrmtNo", "SupAgrmtNo", "ConfirmationID",
        "ConfirmationNo", "ConfirmationType", "FillParty", "OptionSeller", "OptionDirection",
        "OptionStructureType", "OptionStructure", "ExerciseApproach", "StartDate", "DueDate",
        "SettlementDate", "OptionPremium", "Currency", "NotinalPrincipleAmt", "ClearingAgency", "TradingPlace",
        "BusinessModelType", "ConfirmationAttTuple", "ConfirmationRemark", "UndrlygAssetType", "UndrlygAssetNo",
        "ProfitCalculationInfo", "ProfitRemark", "UndrlygAssetTuple", "PerformanceGuaranteeType",
        "PerformanceCollProvider", "PartyUseColl", "CollInstruction", "CalculateCollInterest",
        "PerformanceCollInitialRatio", "PerformanceCollAddtlRatio", "PerformanceCollOffsetRatio",
        "PerformanceGuaranteeRemark", "PerformanceGuaranteeAtt", "PerformanceCollTuple",
        "Remark", "ValidNotinalPrincipleAmt", "ComplianceOpinion", "ExercisePriceOne", "ExercisePriceTwo",
        "PtyAPdctName", "PytAPdctCode", "PtyBPdctName", "PytBPdctCode"})
public class OptionConfirmationDTO extends RequestCommon {

    private String MasterAgrmtNo;
    private String SupAgrmtNo;
    private String ConfirmationID;
    private String ConfirmationNo;
    private String ConfirmationType;
    private String FillParty;
    private String OptionSeller;
    private String OptionDirection;
    private String OptionStructureType;
    private String OptionStructure;
    private String ExerciseApproach;
    private String StartDate;
    private String DueDate;
    private String SettlementDate;
    private String OptionPremium;
    private String Currency;
    private String NotinalPrincipleAmt;
    private String ClearingAgency;
    private String TradingPlace;
    private String BusinessModelType;
    private List<ConfirmationAttTupleDTO> ConfirmationAttTuple;
    private String ConfirmationRemark;
    private String UndrlygAssetType;
    private String UndrlygAssetNo;
    private String ProfitCalculationInfo;
    private String ProfitRemark;
    private List<UndrlygAssetTupleDTO> UndrlygAssetTuple;
    private String PerformanceGuaranteeType;
    private String PerformanceCollProvider;
    private String PartyUseColl;
    private String CollInstruction;
    private String CalculateCollInterest;
    private String PerformanceCollInitialRatio;
    private String PerformanceCollAddtlRatio;
    private String PerformanceCollOffsetRatio;
    private String PerformanceGuaranteeRemark;
    private String PerformanceGuaranteeAtt;
    private List<PerformanceCollTupleDTO> PerformanceCollTuple;
    private String Remark;
    private String ValidNotinalPrincipleAmt;
    private String ComplianceOpinion;
    private String ExercisePriceOne;
    private String ExercisePriceTwo;
    private String PtyAPdctName;
    private String PytAPdctCode;
    private String PtyBPdctName;
    private String PytBPdctCode;

    public static OptionConfirmationDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static OptionConfirmationDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        OptionConfirmationDTO dto = JsonUtils.mapper.convertValue(json, OptionConfirmationDTO.class);
        op.ifPresent(o -> {
            if (o.equals(OperationEnum.UPDATE) || o.equals(OperationEnum.DELETE)) {
                dto.setConfirmationID(dto.getBizID());
                dto.setBizID(null);
            }
        });
        removeNullableFields(dto);
        return dto;
    }

    private static void removeNullableFields(OptionConfirmationDTO dto) {
        if (Strings.isNullOrEmpty((dto.getConfirmationID()))) {
            dto.setConfirmationID(null);
        }
        if (Strings.isNullOrEmpty(dto.getOptionStructure())) {
            dto.setOptionStructure(null);
        }
        if (Strings.isNullOrEmpty(dto.getSettlementDate())) {
            dto.setSettlementDate(null);
        }
        if (Strings.isNullOrEmpty(dto.getConfirmationRemark())) {
            dto.setConfirmationRemark(null);
        }
        if (Strings.isNullOrEmpty(dto.getProfitRemark())) {
            dto.setProfitRemark(null);
        }
        if (Strings.isNullOrEmpty(dto.getPerformanceCollProvider())) {
            dto.setPerformanceCollProvider(null);
        }
        if (Strings.isNullOrEmpty(dto.getPartyUseColl())) {
            dto.setPartyUseColl(null);
        }
        if (Strings.isNullOrEmpty(dto.getCollInstruction())) {
            dto.setCollInstruction(null);
        }
        if (Strings.isNullOrEmpty(dto.getCalculateCollInterest())) {
            dto.setCalculateCollInterest(null);
        }
        if (Strings.isNullOrEmpty(dto.getPerformanceCollInitialRatio())) {
            dto.setPerformanceCollInitialRatio(null);
        }
        if (Strings.isNullOrEmpty(dto.getPerformanceCollAddtlRatio())) {
            dto.setPerformanceCollAddtlRatio(null);
        }
        if (Strings.isNullOrEmpty(dto.getPerformanceCollOffsetRatio())) {
            dto.setPerformanceCollOffsetRatio(null);
        }
        if (Strings.isNullOrEmpty(dto.getPerformanceGuaranteeRemark())) {
            dto.setPerformanceGuaranteeRemark(null);
        }
        if (Strings.isNullOrEmpty(dto.getPerformanceGuaranteeAtt())) {
            dto.setPerformanceGuaranteeAtt(null);
        }
        if (Strings.isNullOrEmpty(dto.getRemark())) {
            dto.setRemark(null);
        }
        if (Strings.isNullOrEmpty(dto.getValidNotinalPrincipleAmt())) {
            dto.setComplianceOpinion(null);
        }
        if (Strings.isNullOrEmpty(dto.getComplianceOpinion())) {
            dto.setComplianceOpinion(null);
        }
        if (Strings.isNullOrEmpty(dto.getExercisePriceOne())) {
            dto.setExercisePriceOne(null);
        }
        if (Strings.isNullOrEmpty(dto.getExercisePriceTwo())) {
            dto.setExercisePriceTwo(null);
        }
        if (Strings.isNullOrEmpty(dto.getPtyAPdctName())) {
            dto.setPtyAPdctName(null);
        }
        if (Strings.isNullOrEmpty(dto.getPytAPdctCode())) {
            dto.setPytAPdctCode(null);
        }
        if (Strings.isNullOrEmpty(dto.getPtyBPdctName())) {
            dto.setPtyBPdctName(null);
        }
        if (Strings.isNullOrEmpty(dto.getPytBPdctCode())) {
            dto.setPytBPdctCode(null);
        }
    }


    public OptionConfirmationDTO() {
    }

    public OptionConfirmationDTO(String masterAgrmtNo, String supAgrmtNo, String confirmationID,
                                 String confirmationNo, String confirmationType, String fillParty,
                                 String optionSeller, String optionDirection, String optionStructureType,
                                 String optionStructure, String exerciseApproach, String startDate,
                                 String dueDate, String settlementDate, String optionPremium,
                                 String currency, String notinalPrincipleAmt, String clearingAgency, String tradingPlace,
                                 String businessModelType, List<ConfirmationAttTupleDTO> confirmationAttTuple,
                                 String confirmationRemark, String undrlygAssetType, String undrlygAssetNo,
                                 String profitCalculationInfo, String profitRemark, List<UndrlygAssetTupleDTO> undrlygAssetTuple,
                                 String performanceGuaranteeType, String performanceCollProvider, String partyUseColl,
                                 String collInstruction, String calculateCollInterest, String performanceCollInitialRatio,
                                 String performanceCollAddtlRatio, String performanceCollOffsetRatio,
                                 String performanceGuaranteeRemark, String performanceGuaranteeAtt,
                                 List<PerformanceCollTupleDTO> performanceCollTuple, String remark, String validNotinalPrincipleAmt,
                                 String complianceOpinion, String exercisePriceOne, String exercisePriceTwo,
                                 String ptyAPdctName, String pytAPdctCode, String ptyBPdctName, String pytBPdctCode) {
        MasterAgrmtNo = masterAgrmtNo;
        SupAgrmtNo = supAgrmtNo;
        ConfirmationID = confirmationID;
        ConfirmationNo = confirmationNo;
        ConfirmationType = confirmationType;
        FillParty = fillParty;
        OptionSeller = optionSeller;
        OptionDirection = optionDirection;
        OptionStructureType = optionStructureType;
        OptionStructure = optionStructure;
        ExerciseApproach = exerciseApproach;
        StartDate = startDate;
        DueDate = dueDate;
        SettlementDate = settlementDate;
        OptionPremium = optionPremium;
        Currency = currency;
        NotinalPrincipleAmt = notinalPrincipleAmt;
        ClearingAgency = clearingAgency;
        TradingPlace = tradingPlace;
        BusinessModelType = businessModelType;
        ConfirmationAttTuple = confirmationAttTuple;
        ConfirmationRemark = confirmationRemark;
        UndrlygAssetType = undrlygAssetType;
        UndrlygAssetNo = undrlygAssetNo;
        ProfitCalculationInfo = profitCalculationInfo;
        ProfitRemark = profitRemark;
        UndrlygAssetTuple = undrlygAssetTuple;
        PerformanceGuaranteeType = performanceGuaranteeType;
        PerformanceCollProvider = performanceCollProvider;
        PartyUseColl = partyUseColl;
        CollInstruction = collInstruction;
        CalculateCollInterest = calculateCollInterest;
        PerformanceCollInitialRatio = performanceCollInitialRatio;
        PerformanceCollAddtlRatio = performanceCollAddtlRatio;
        PerformanceCollOffsetRatio = performanceCollOffsetRatio;
        PerformanceGuaranteeRemark = performanceGuaranteeRemark;
        PerformanceGuaranteeAtt = performanceGuaranteeAtt;
        PerformanceCollTuple = performanceCollTuple;
        Remark = remark;
        ValidNotinalPrincipleAmt = validNotinalPrincipleAmt;
        ComplianceOpinion = complianceOpinion;
        ExercisePriceOne = exercisePriceOne;
        ExercisePriceTwo = exercisePriceTwo;
        PtyAPdctName = ptyAPdctName;
        PytAPdctCode = pytAPdctCode;
        PtyBPdctName = ptyBPdctName;
        PytBPdctCode = pytBPdctCode;
    }

    public LinkedHashMap<String, Object> toLinkedHashMap() {
        return JsonUtils.fromJsonToLinkedHashMap(JsonUtils.toJson(this));
    }

    @JsonProperty("MasterAgrmtNo")
    public String getMasterAgrmtNo() {
        return MasterAgrmtNo;
    }

    public void setMasterAgrmtNo(String masterAgrmtNo) {
        MasterAgrmtNo = masterAgrmtNo;
    }

    @JsonProperty("SupAgrmtNo")
    public String getSupAgrmtNo() {
        return SupAgrmtNo;
    }

    public void setSupAgrmtNo(String supAgrmtNo) {
        SupAgrmtNo = supAgrmtNo;
    }

    @JsonProperty("ConfirmationID")
    public String getConfirmationID() {
        return ConfirmationID;
    }

    public void setConfirmationID(String confirmationID) {
        ConfirmationID = confirmationID;
    }

    @JsonProperty("ConfirmationNo")
    public String getConfirmationNo() {
        return ConfirmationNo;
    }

    public void setConfirmationNo(String confirmationNo) {
        ConfirmationNo = confirmationNo;
    }

    @JsonProperty("ConfirmationType")
    public String getConfirmationType() {
        return ConfirmationType;
    }

    public void setConfirmationType(String confirmationType) {
        ConfirmationType = confirmationType;
    }

    @JsonProperty("FillParty")
    public String getFillParty() {
        return FillParty;
    }

    public void setFillParty(String fillParty) {
        FillParty = fillParty;
    }

    @JsonProperty("OptionSeller")
    public String getOptionSeller() {
        return OptionSeller;
    }

    public void setOptionSeller(String optionSeller) {
        OptionSeller = optionSeller;
    }

    @JsonProperty("OptionDirection")
    public String getOptionDirection() {
        return OptionDirection;
    }

    public void setOptionDirection(String optionDirection) {
        OptionDirection = optionDirection;
    }

    @JsonProperty("OptionStructureType")
    public String getOptionStructureType() {
        return OptionStructureType;
    }

    public void setOptionStructureType(String optionStructureType) {
        OptionStructureType = optionStructureType;
    }

    @JsonProperty("OptionStructure")
    public String getOptionStructure() {
        return OptionStructure;
    }

    public void setOptionStructure(String optionStructure) {
        OptionStructure = optionStructure;
    }

    @JsonProperty("ExerciseApproach")
    public String getExerciseApproach() {
        return ExerciseApproach;
    }

    public void setExerciseApproach(String exerciseApproach) {
        ExerciseApproach = exerciseApproach;
    }

    @JsonProperty("StartDate")
    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    @JsonProperty("DueDate")
    public String getDueDate() {
        return DueDate;
    }

    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }

    @JsonProperty("SettlementDate")
    public String getSettlementDate() {
        return SettlementDate;
    }

    public void setSettlementDate(String settlementDate) {
        SettlementDate = settlementDate;
    }

    @JsonProperty("OptionPremium")
    public String getOptionPremium() {
        return OptionPremium;
    }

    public void setOptionPremium(String optionPremium) {
        OptionPremium = optionPremium;
    }

    @JsonProperty("Currency")
    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    @JsonProperty("NotinalPrincipleAmt")
    public String getNotinalPrincipleAmt() {
        return NotinalPrincipleAmt;
    }

    public void setNotinalPrincipleAmt(String notinalPrincipleAmt) {
        NotinalPrincipleAmt = notinalPrincipleAmt;
    }

    @JsonProperty("ClearingAgency")
    public String getClearingAgency() {
        return ClearingAgency;
    }

    public void setClearingAgency(String clearingAgency) {
        ClearingAgency = clearingAgency;
    }

    @JsonProperty("TradingPlace")
    public String getTradingPlace() {
        return TradingPlace;
    }

    public void setTradingPlace(String tradingPlace) {
        TradingPlace = tradingPlace;
    }

    @JsonProperty("BusinessModelType")
    public String getBusinessModelType() {
        return BusinessModelType;
    }

    public void setBusinessModelType(String businessModelType) {
        BusinessModelType = businessModelType;
    }

    @JsonProperty("ConfirmationAttTuple")
    public List<ConfirmationAttTupleDTO> getConfirmationAttTuple() {
        return ConfirmationAttTuple;
    }

    public void setConfirmationAttTuple(List<ConfirmationAttTupleDTO> confirmationAttTuple) {
        ConfirmationAttTuple = confirmationAttTuple;
    }

    @JsonProperty("ConfirmationRemark")
    public String getConfirmationRemark() {
        return ConfirmationRemark;
    }

    public void setConfirmationRemark(String confirmationRemark) {
        ConfirmationRemark = confirmationRemark;
    }

    @JsonProperty("UndrlygAssetType")
    public String getUndrlygAssetType() {
        return UndrlygAssetType;
    }

    public void setUndrlygAssetType(String undrlygAssetType) {
        UndrlygAssetType = undrlygAssetType;
    }

    @JsonProperty("UndrlygAssetNo")
    public String getUndrlygAssetNo() {
        return UndrlygAssetNo;
    }

    public void setUndrlygAssetNo(String undrlygAssetNo) {
        UndrlygAssetNo = undrlygAssetNo;
    }

    @JsonProperty("ProfitCalculationInfo")
    public String getProfitCalculationInfo() {
        return ProfitCalculationInfo;
    }

    public void setProfitCalculationInfo(String profitCalculationInfo) {
        ProfitCalculationInfo = profitCalculationInfo;
    }

    @JsonProperty("ProfitRemark")
    public String getProfitRemark() {
        return ProfitRemark;
    }

    public void setProfitRemark(String profitRemark) {
        ProfitRemark = profitRemark;
    }

    @JsonProperty("UndrlygAssetTuple")
    public List<UndrlygAssetTupleDTO> getUndrlygAssetTuple() {
        return UndrlygAssetTuple;
    }

    public void setUndrlygAssetTuple(List<UndrlygAssetTupleDTO> undrlygAssetTuple) {
        UndrlygAssetTuple = undrlygAssetTuple;
    }

    @JsonProperty("PerformanceGuaranteeType")
    public String getPerformanceGuaranteeType() {
        return PerformanceGuaranteeType;
    }

    public void setPerformanceGuaranteeType(String performanceGuaranteeType) {
        PerformanceGuaranteeType = performanceGuaranteeType;
    }

    @JsonProperty("PerformanceCollProvider")
    public String getPerformanceCollProvider() {
        return PerformanceCollProvider;
    }

    public void setPerformanceCollProvider(String performanceCollProvider) {
        PerformanceCollProvider = performanceCollProvider;
    }

    @JsonProperty("PartyUseColl")
    public String getPartyUseColl() {
        return PartyUseColl;
    }

    public void setPartyUseColl(String partyUseColl) {
        PartyUseColl = partyUseColl;
    }

    @JsonProperty("CollInstruction")
    public String getCollInstruction() {
        return CollInstruction;
    }

    public void setCollInstruction(String collInstruction) {
        CollInstruction = collInstruction;
    }

    @JsonProperty("CalculateCollInterest")
    public String getCalculateCollInterest() {
        return CalculateCollInterest;
    }

    public void setCalculateCollInterest(String calculateCollInterest) {
        CalculateCollInterest = calculateCollInterest;
    }

    @JsonProperty("PerformanceCollInitialRatio")
    public String getPerformanceCollInitialRatio() {
        return PerformanceCollInitialRatio;
    }

    public void setPerformanceCollInitialRatio(String performanceCollInitialRatio) {
        PerformanceCollInitialRatio = performanceCollInitialRatio;
    }

    @JsonProperty("PerformanceCollAddtlRatio")
    public String getPerformanceCollAddtlRatio() {
        return PerformanceCollAddtlRatio;
    }

    public void setPerformanceCollAddtlRatio(String performanceCollAddtlRatio) {
        PerformanceCollAddtlRatio = performanceCollAddtlRatio;
    }

    @JsonProperty("PerformanceCollOffsetRatio")
    public String getPerformanceCollOffsetRatio() {
        return PerformanceCollOffsetRatio;
    }

    public void setPerformanceCollOffsetRatio(String performanceCollOffsetRatio) {
        PerformanceCollOffsetRatio = performanceCollOffsetRatio;
    }

    @JsonProperty("PerformanceGuaranteeRemark")
    public String getPerformanceGuaranteeRemark() {
        return PerformanceGuaranteeRemark;
    }

    public void setPerformanceGuaranteeRemark(String performanceGuaranteeRemark) {
        PerformanceGuaranteeRemark = performanceGuaranteeRemark;
    }

    @JsonProperty("PerformanceGuaranteeAtt")
    public String getPerformanceGuaranteeAtt() {
        return PerformanceGuaranteeAtt;
    }

    public void setPerformanceGuaranteeAtt(String performanceGuaranteeAtt) {
        PerformanceGuaranteeAtt = performanceGuaranteeAtt;
    }

    @JsonProperty("PerformanceCollTuple")
    public List<PerformanceCollTupleDTO> getPerformanceCollTuple() {
        return PerformanceCollTuple;
    }

    public void setPerformanceCollTuple(List<PerformanceCollTupleDTO> performanceCollTuple) {
        PerformanceCollTuple = performanceCollTuple;
    }

    @JsonProperty("Remark")
    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    @JsonProperty("ValidNotinalPrincipleAmt")
    public String getValidNotinalPrincipleAmt() {
        return ValidNotinalPrincipleAmt;
    }

    public void setValidNotinalPrincipleAmt(String validNotinalPrincipleAmt) {
        ValidNotinalPrincipleAmt = validNotinalPrincipleAmt;
    }

    @JsonProperty("ComplianceOpinion")
    public String getComplianceOpinion() {
        return ComplianceOpinion;
    }

    public void setComplianceOpinion(String complianceOpinion) {
        ComplianceOpinion = complianceOpinion;
    }

    @JsonProperty("ExercisePriceOne")
    public String getExercisePriceOne() {
        return ExercisePriceOne;
    }

    public void setExercisePriceOne(String exercisePriceOne) {
        ExercisePriceOne = exercisePriceOne;
    }

    @JsonProperty("ExercisePriceTwo")
    public String getExercisePriceTwo() {
        return ExercisePriceTwo;
    }

    public void setExercisePriceTwo(String exercisePriceTwo) {
        ExercisePriceTwo = exercisePriceTwo;
    }

    @JsonProperty("PtyAPdctName")
    public String getPtyAPdctName() {
        return PtyAPdctName;
    }

    public void setPtyAPdctName(String ptyAPdctName) {
        PtyAPdctName = ptyAPdctName;
    }

    @JsonProperty("PytAPdctCode")
    public String getPytAPdctCode() {
        return PytAPdctCode;
    }

    public void setPytAPdctCode(String pytAPdctCode) {
        PytAPdctCode = pytAPdctCode;
    }

    @JsonProperty("PtyBPdctName")
    public String getPtyBPdctName() {
        return PtyBPdctName;
    }

    public void setPtyBPdctName(String ptyBPdctName) {
        PtyBPdctName = ptyBPdctName;
    }

    @JsonProperty("PytBPdctCode")
    public String getPytBPdctCode() {
        return PytBPdctCode;
    }

    public void setPytBPdctCode(String pytBPdctCode) {
        PytBPdctCode = pytBPdctCode;
    }
}
