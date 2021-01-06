package tech.tongyu.core.dto.swapconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.dto.optionconfirmation.ConfirmationAttTupleDTO;
import tech.tongyu.core.dto.optionconfirmation.PerformanceCollTupleDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书
 */
@JsonPropertyOrder({"ExceID", "BizID", "MasterAgrmtNo", "SupAgrmtNo",
        "ConfirmationID", "ConfirmationNo", "ConfirmationType", "FillParty",
        "PtyAPaymentMethod", "PtyBPaymentMethod", "PtyAPaymentFreq", "PtyBPaymentFreq",
        "StartDate", "DueDate", "SettlementDate", "Currency", "NotinalPrincipleAmt",
        "ClearingAgency", "TradingPlace", "UndrlygAssetType", "ConfirmationRemark",
        "PtyAtoPtyB", "PtyBtoPtyA", "PerformanceGuaranteeType", "PerformanceCollProvider",
        "PartyUseColl", "CollInstruction", "CalculateCollInterest", "PerformanceCollInitialRatio",
        "PerformanceCollAddtlRatio", "PerformanceCollOffsetRatio", "PerformanceGuaranteeAtt", "PerformanceGuaranteeRemark",
        "PerformanceCollTuple", "Remark", "ConfirmationAttTuple", "ComplianceOpinion", "PtyAUndrlygAssetNo",
        "PtyAProfitCalculationInfo", "PtyAProfitRemark", "PtyBUndrlygAssetNo", "PtyBProfitCalculationInfo",
        "PtyBProfitRemark", "ReferenceARateBTuple", "ReferenceBRateBTuple", "FixedARateReturnBTuple",
        "FixedBRateReturnBTuple", "PtyAPdctName", "PytAPdctCode", "PtyBPdctName", "PytBPdctCode"})
public class SwapConfirmationDTO extends RequestCommon {

    private String MasterAgrmtNo;

    private String SupAgrmtNo;

    private String ConfirmationID;

    private String ConfirmationNo;

    private String ConfirmationType;

    private String FillParty;

    private String PtyAPaymentMethod;

    private String PtyBPaymentMethod;

    private String PtyAPaymentFreq;

    private String PtyBPaymentFreq;

    private String StartDate;

    private String DueDate;

    private String SettlementDate;

    private String Currency;

    private String NotinalPrincipleAmt;

    private String ClearingAgency;

    private String TradingPlace;

    private String UndrlygAssetType;

    private String ConfirmationRemark;

    private List<PtyAtoPtyBDTO> PtyAtoPtyB;

    private List<PtyBtoPtyADTO> PtyBtoPtyA;

    private String PerformanceGuaranteeType;

    private String PerformanceCollProvider;

    private String PartyUseColl;

    private String CollInstruction;

    private String CalculateCollInterest;

    private String PerformanceCollInitialRatio;

    private String PerformanceCollAddtlRatio;

    private String PerformanceCollOffsetRatio;

    private String PerformanceGuaranteeAtt;

    private String PerformanceGuaranteeRemark;

    private List<PerformanceCollTupleDTO> PerformanceCollTuple;

    private String Remark;

    private List<ConfirmationAttTupleDTO> ConfirmationAttTuple;

    private String ComplianceOpinion;

    private String PtyAUndrlygAssetNo;

    private String PtyAProfitCalculationInfo;

    private String PtyAProfitRemark;

    private String PtyBUndrlygAssetNo;

    private String PtyBProfitCalculationInfo;

    private String PtyBProfitRemark;

    private List<ReferenceARateBTupleDTO> ReferenceARateBTuple;

    private List<ReferenceBRateBTupleDTO> ReferenceBRateBTuple;

    private List<FixedARateReturnBTupleDTO> FixedARateReturnBTuple;

    private List<FixedBRateReturnBTupleDTO> FixedBRateReturnBTuple;

    private String PtyAPdctName;

    private String PytAPdctCode;

    private String PtyBPdctName;

    private String PytBPdctCode;

    public static SwapConfirmationDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static SwapConfirmationDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        SwapConfirmationDTO dto = JsonUtils.mapper.convertValue(json, SwapConfirmationDTO.class);
        op.ifPresent(o -> {
            if (o.equals(OperationEnum.UPDATE) || o.equals(OperationEnum.DELETE)) {
                dto.setConfirmationID(dto.getBizID());
                dto.setBizID(null);
            }
        });
        removeNullableFields(dto);
        return dto;
    }

    private static void removeNullableFields(SwapConfirmationDTO dto) {
        if (Strings.isNullOrEmpty((dto.getConfirmationID()))) {
            dto.setConfirmationID(null);
        }
        if (Strings.isNullOrEmpty(dto.getSettlementDate())) {
            dto.setSettlementDate(null);
        }

        if (Strings.isNullOrEmpty(dto.getConfirmationRemark())) {
            dto.setConfirmationRemark(null);
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
        if (Strings.isNullOrEmpty(dto.getPerformanceGuaranteeAtt())) {
            dto.setPerformanceGuaranteeAtt(null);
        }
        if (Strings.isNullOrEmpty(dto.getPerformanceGuaranteeRemark())) {
            dto.setPerformanceGuaranteeRemark(null);
        }
        if (Strings.isNullOrEmpty(dto.getRemark())) {
            dto.setRemark(null);
        }
        if (Strings.isNullOrEmpty(dto.getComplianceOpinion())) {
            dto.setComplianceOpinion(null);
        }
        if (Strings.isNullOrEmpty(dto.getPtyAProfitCalculationInfo())) {
            dto.setPtyAProfitCalculationInfo(null);
        }
        if (Strings.isNullOrEmpty(dto.getPtyAProfitRemark())) {
            dto.setPtyAProfitRemark(null);
        }
        if (Strings.isNullOrEmpty(dto.getPtyBUndrlygAssetNo())) {
            dto.setPtyBUndrlygAssetNo(null);
        }
        if (Strings.isNullOrEmpty(dto.getPtyBProfitCalculationInfo())) {
            dto.setPtyBProfitCalculationInfo(null);
        }
        if (Strings.isNullOrEmpty(dto.getPtyBProfitRemark())) {
            dto.setPtyBProfitRemark(null);
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


    public SwapConfirmationDTO() {
    }

    public SwapConfirmationDTO(String masterAgrmtNo, String supAgrmtNo, String confirmationID, String confirmationNo, String confirmationType, String fillParty, String ptyAPaymentMethod, String ptyBPaymentMethod, String ptyAPaymentFreq, String ptyBPaymentFreq, String startDate, String dueDate, String settlementDate, String currency, String notinalPrincipleAmt, String clearingAgency, String tradingPlace, String undrlygAssetType, String confirmationRemark, List<PtyAtoPtyBDTO> ptyAtoPtyB, List<PtyBtoPtyADTO> ptyBtoPtyA, String performanceGuaranteeType, String performanceCollProvider, String partyUseColl, String collInstruction, String calculateCollInterest, String performanceCollInitialRatio, String performanceCollAddtlRatio, String performanceCollOffsetRatio, String performanceGuaranteeAtt, String performanceGuaranteeRemark, List<PerformanceCollTupleDTO> performanceCollTuple, String remark, List<ConfirmationAttTupleDTO> confirmationAttTuple, String complianceOpinion, String ptyAUndrlygAssetNo, String ptyAProfitCalculationInfo, String ptyAProfitRemark, String ptyBUndrlygAssetNo, String ptyBProfitCalculationInfo, String ptyBProfitRemark, List<ReferenceARateBTupleDTO> referenceARateBTuple, List<ReferenceBRateBTupleDTO> referenceBRateBTuple, List<FixedARateReturnBTupleDTO> fixedARateReturnBTuple, List<FixedBRateReturnBTupleDTO> fixedBRateReturnBTuple, String ptyAPdctName, String pytAPdctCode, String ptyBPdctName, String pytBPdctCode) {
        MasterAgrmtNo = masterAgrmtNo;
        SupAgrmtNo = supAgrmtNo;
        ConfirmationID = confirmationID;
        ConfirmationNo = confirmationNo;
        ConfirmationType = confirmationType;
        FillParty = fillParty;
        PtyAPaymentMethod = ptyAPaymentMethod;
        PtyBPaymentMethod = ptyBPaymentMethod;
        PtyAPaymentFreq = ptyAPaymentFreq;
        PtyBPaymentFreq = ptyBPaymentFreq;
        StartDate = startDate;
        DueDate = dueDate;
        SettlementDate = settlementDate;
        Currency = currency;
        NotinalPrincipleAmt = notinalPrincipleAmt;
        ClearingAgency = clearingAgency;
        TradingPlace = tradingPlace;
        UndrlygAssetType = undrlygAssetType;
        ConfirmationRemark = confirmationRemark;
        PtyAtoPtyB = ptyAtoPtyB;
        PtyBtoPtyA = ptyBtoPtyA;
        PerformanceGuaranteeType = performanceGuaranteeType;
        PerformanceCollProvider = performanceCollProvider;
        PartyUseColl = partyUseColl;
        CollInstruction = collInstruction;
        CalculateCollInterest = calculateCollInterest;
        PerformanceCollInitialRatio = performanceCollInitialRatio;
        PerformanceCollAddtlRatio = performanceCollAddtlRatio;
        PerformanceCollOffsetRatio = performanceCollOffsetRatio;
        PerformanceGuaranteeAtt = performanceGuaranteeAtt;
        PerformanceGuaranteeRemark = performanceGuaranteeRemark;
        PerformanceCollTuple = performanceCollTuple;
        Remark = remark;
        ConfirmationAttTuple = confirmationAttTuple;
        ComplianceOpinion = complianceOpinion;
        PtyAUndrlygAssetNo = ptyAUndrlygAssetNo;
        PtyAProfitCalculationInfo = ptyAProfitCalculationInfo;
        PtyAProfitRemark = ptyAProfitRemark;
        PtyBUndrlygAssetNo = ptyBUndrlygAssetNo;
        PtyBProfitCalculationInfo = ptyBProfitCalculationInfo;
        PtyBProfitRemark = ptyBProfitRemark;
        ReferenceARateBTuple = referenceARateBTuple;
        ReferenceBRateBTuple = referenceBRateBTuple;
        FixedARateReturnBTuple = fixedARateReturnBTuple;
        FixedBRateReturnBTuple = fixedBRateReturnBTuple;
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

    @JsonProperty("PtyAPaymentMethod")
    public String getPtyAPaymentMethod() {
        return PtyAPaymentMethod;
    }

    public void setPtyAPaymentMethod(String ptyAPaymentMethod) {
        PtyAPaymentMethod = ptyAPaymentMethod;
    }

    @JsonProperty("PtyBPaymentMethod")
    public String getPtyBPaymentMethod() {
        return PtyBPaymentMethod;
    }

    public void setPtyBPaymentMethod(String ptyBPaymentMethod) {
        PtyBPaymentMethod = ptyBPaymentMethod;
    }

    @JsonProperty("PtyAPaymentFreq")
    public String getPtyAPaymentFreq() {
        return PtyAPaymentFreq;
    }

    public void setPtyAPaymentFreq(String ptyAPaymentFreq) {
        PtyAPaymentFreq = ptyAPaymentFreq;
    }

    @JsonProperty("PtyBPaymentFreq")
    public String getPtyBPaymentFreq() {
        return PtyBPaymentFreq;
    }

    public void setPtyBPaymentFreq(String ptyBPaymentFreq) {
        PtyBPaymentFreq = ptyBPaymentFreq;
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

    @JsonProperty("UndrlygAssetType")
    public String getUndrlygAssetType() {
        return UndrlygAssetType;
    }

    public void setUndrlygAssetType(String undrlygAssetType) {
        UndrlygAssetType = undrlygAssetType;
    }

    @JsonProperty("ConfirmationRemark")
    public String getConfirmationRemark() {
        return ConfirmationRemark;
    }

    public void setConfirmationRemark(String confirmationRemark) {
        ConfirmationRemark = confirmationRemark;
    }

    @JsonProperty("PtyAtoPtyB")
    public List<PtyAtoPtyBDTO> getPtyAtoPtyB() {
        return PtyAtoPtyB;
    }

    public void setPtyAtoPtyB(List<PtyAtoPtyBDTO> ptyAtoPtyB) {
        PtyAtoPtyB = ptyAtoPtyB;
    }

    @JsonProperty("PtyBtoPtyA")
    public List<PtyBtoPtyADTO> getPtyBtoPtyA() {
        return PtyBtoPtyA;
    }

    public void setPtyBtoPtyA(List<PtyBtoPtyADTO> ptyBtoPtyA) {
        PtyBtoPtyA = ptyBtoPtyA;
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

    @JsonProperty("PerformanceGuaranteeAtt")
    public String getPerformanceGuaranteeAtt() {
        return PerformanceGuaranteeAtt;
    }

    public void setPerformanceGuaranteeAtt(String performanceGuaranteeAtt) {
        PerformanceGuaranteeAtt = performanceGuaranteeAtt;
    }

    @JsonProperty("PerformanceGuaranteeRemark")
    public String getPerformanceGuaranteeRemark() {
        return PerformanceGuaranteeRemark;
    }

    public void setPerformanceGuaranteeRemark(String performanceGuaranteeRemark) {
        PerformanceGuaranteeRemark = performanceGuaranteeRemark;
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

    @JsonProperty("ConfirmationAttTuple")
    public List<ConfirmationAttTupleDTO> getConfirmationAttTuple() {
        return ConfirmationAttTuple;
    }

    public void setConfirmationAttTuple(List<ConfirmationAttTupleDTO> confirmationAttTuple) {
        ConfirmationAttTuple = confirmationAttTuple;
    }

    @JsonProperty("ComplianceOpinion")
    public String getComplianceOpinion() {
        return ComplianceOpinion;
    }

    public void setComplianceOpinion(String complianceOpinion) {
        ComplianceOpinion = complianceOpinion;
    }

    @JsonProperty("PtyAUndrlygAssetNo")
    public String getPtyAUndrlygAssetNo() {
        return PtyAUndrlygAssetNo;
    }

    public void setPtyAUndrlygAssetNo(String ptyAUndrlygAssetNo) {
        PtyAUndrlygAssetNo = ptyAUndrlygAssetNo;
    }

    @JsonProperty("PtyAProfitCalculationInfo")
    public String getPtyAProfitCalculationInfo() {
        return PtyAProfitCalculationInfo;
    }

    public void setPtyAProfitCalculationInfo(String ptyAProfitCalculationInfo) {
        PtyAProfitCalculationInfo = ptyAProfitCalculationInfo;
    }

    @JsonProperty("PtyAProfitRemark")
    public String getPtyAProfitRemark() {
        return PtyAProfitRemark;
    }

    public void setPtyAProfitRemark(String ptyAProfitRemark) {
        PtyAProfitRemark = ptyAProfitRemark;
    }

    @JsonProperty("PtyBUndrlygAssetNo")
    public String getPtyBUndrlygAssetNo() {
        return PtyBUndrlygAssetNo;
    }

    public void setPtyBUndrlygAssetNo(String ptyBUndrlygAssetNo) {
        PtyBUndrlygAssetNo = ptyBUndrlygAssetNo;
    }

    @JsonProperty("PtyBProfitCalculationInfo")
    public String getPtyBProfitCalculationInfo() {
        return PtyBProfitCalculationInfo;
    }

    public void setPtyBProfitCalculationInfo(String ptyBProfitCalculationInfo) {
        PtyBProfitCalculationInfo = ptyBProfitCalculationInfo;
    }

    @JsonProperty("PtyBProfitRemark")
    public String getPtyBProfitRemark() {
        return PtyBProfitRemark;
    }

    public void setPtyBProfitRemark(String ptyBProfitRemark) {
        PtyBProfitRemark = ptyBProfitRemark;
    }

    @JsonProperty("ReferenceARateBTuple")
    public List<ReferenceARateBTupleDTO> getReferenceARateBTuple() {
        return ReferenceARateBTuple;
    }

    public void setReferenceARateBTuple(List<ReferenceARateBTupleDTO> referenceARateBTuple) {
        ReferenceARateBTuple = referenceARateBTuple;
    }

    @JsonProperty("ReferenceBRateBTuple")
    public List<ReferenceBRateBTupleDTO> getReferenceBRateBTuple() {
        return ReferenceBRateBTuple;
    }

    public void setReferenceBRateBTuple(List<ReferenceBRateBTupleDTO> referenceBRateBTuple) {
        ReferenceBRateBTuple = referenceBRateBTuple;
    }

    @JsonProperty("FixedARateReturnBTuple")
    public List<FixedARateReturnBTupleDTO> getFixedARateReturnBTuple() {
        return FixedARateReturnBTuple;
    }

    public void setFixedARateReturnBTuple(List<FixedARateReturnBTupleDTO> fixedARateReturnBTuple) {
        FixedARateReturnBTuple = fixedARateReturnBTuple;
    }

    @JsonProperty("FixedBRateReturnBTuple")
    public List<FixedBRateReturnBTupleDTO> getFixedBRateReturnBTuple() {
        return FixedBRateReturnBTuple;
    }

    public void setFixedBRateReturnBTuple(List<FixedBRateReturnBTupleDTO> fixedBRateReturnBTuple) {
        FixedBRateReturnBTuple = fixedBRateReturnBTuple;
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
