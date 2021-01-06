package tech.tongyu.core.dto.master;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.dto.contract.ContractNumberProcessDTO;
import tech.tongyu.core.dto.masterproduct.MasterAgrmtProductDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 主协议
 */
@JsonPropertyOrder({"ExceID", "MasterAgrmtID", "MasterAgrmtNo", "SigningDate", "MasterAgrmtVer"
        , "FillParty", "CounterpartyName", "CounterpartyCode", "ProCounterparty"
        , "CounterpartyType", "NFICode", "CounterpartyRegdCptl", "MasterAgrmtRemark"
        , "MasterAgrmtAtt", "CounterpartyInformationTuple", "CounterpartyIdentity"})
public class MasterAgrmtDTO extends RequestCommon {

    /**
     * 主协议编号(双方约定)
     */
    private String MasterAgrmtID;

    /**
     * 主协议编号(双方约定)
     */
    private String MasterAgrmtNo;

    /**
     * 签订时间
     */
    private String SigningDate;

    /**
     * 主协议版本
     */
    private String MasterAgrmtVer;

    /**
     * 填报方角色
     */
    private String FillParty;

    /**
     * 交易对手方名称
     */
    private String CounterpartyName;


    private String CounterpartyCode;

    /**
     * 交易对手方组织机构代码
     */
    private String ProCounterparty;

    /**
     * 交易对手方类型
     */
    private String CounterpartyType;

    /**
     * 非金融机构行业代码
     */
    private String NFICode;

    /**
     * 交易对手方注册资本(万元)
     */
    private String CounterpartyRegdCptl;

    /**
     * 主协议备注
     */
    private String MasterAgrmtRemark;

    /**
     * 主协议附件
     */
    private String MasterAgrmtAtt;

    /**
     * 填报方业务代表明细
     */
    private List<MasterAgrmtAttachmentDTO> CounterpartyInformationTuple;

    /**
     * 交易对手方身份
     */
    private String CounterpartyIdentity;

    public static MasterAgrmtDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static MasterAgrmtDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        MasterAgrmtDTO dto = JsonUtils.mapper.convertValue(json, MasterAgrmtDTO.class);
        op.ifPresent(o -> {
            if (o.equals(OperationEnum.UPDATE) || o.equals(OperationEnum.DELETE)) {
                dto.setMasterAgrmtID(dto.getBizID());
                dto.setBizID(null);
            }
        });
        removeNullableFields(dto);
        return dto;
    }

    private static void removeNullableFields(MasterAgrmtDTO dto) {
        if (Strings.isNullOrEmpty((dto.getNFICode()))) {
            dto.setNFICode(null);
        }
        if (Strings.isNullOrEmpty(dto.getCounterpartyRegdCptl())) {
            dto.setCounterpartyRegdCptl(null);
        }
        if (Strings.isNullOrEmpty(dto.getMasterAgrmtRemark())) {
            dto.setMasterAgrmtRemark(null);
        }
    }

    public MasterAgrmtDTO() {
    }

    public MasterAgrmtDTO(String masterAgrmtNo, String signingDate, String masterAgrmtVer,
                          String fillParty, String counterpartyName, String counterpartyCode,
                          String proCounterparty, String counterpartyType, String NFICode,
                          String counterpartyRegdCptl, String masterAgrmtRemark, String masterAgrmtAtt,
                          List<MasterAgrmtAttachmentDTO> counterpartyInformationTuple, String counterpartyIdentity) {
        MasterAgrmtNo = masterAgrmtNo;
        SigningDate = signingDate;
        MasterAgrmtVer = masterAgrmtVer;
        FillParty = fillParty;
        CounterpartyName = counterpartyName;
        CounterpartyCode = counterpartyCode;
        ProCounterparty = proCounterparty;
        CounterpartyType = counterpartyType;
        this.NFICode = NFICode;
        CounterpartyRegdCptl = counterpartyRegdCptl;
        MasterAgrmtRemark = masterAgrmtRemark;
        MasterAgrmtAtt = masterAgrmtAtt;
        CounterpartyInformationTuple = counterpartyInformationTuple;
        CounterpartyIdentity = counterpartyIdentity;
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

    @JsonProperty("SigningDate")
    public String getSigningDate() {
        return SigningDate;
    }

    public void setSigningDate(String signingDate) {
        SigningDate = signingDate;
    }

    @JsonProperty("MasterAgrmtVer")
    public String getMasterAgrmtVer() {
        return MasterAgrmtVer;
    }

    public void setMasterAgrmtVer(String masterAgrmtVer) {
        MasterAgrmtVer = masterAgrmtVer;
    }

    @JsonProperty("FillParty")
    public String getFillParty() {
        return FillParty;
    }

    public void setFillParty(String fillParty) {
        FillParty = fillParty;
    }

    @JsonProperty("CounterpartyName")
    public String getCounterpartyName() {
        return CounterpartyName;
    }

    public void setCounterpartyName(String counterpartyName) {
        CounterpartyName = counterpartyName;
    }

    @JsonProperty("CounterpartyCode")
    public String getCounterpartyCode() {
        return CounterpartyCode;
    }

    public void setCounterpartyCode(String counterpartyCode) {
        CounterpartyCode = counterpartyCode;
    }

    @JsonProperty("ProCounterparty")
    public String getProCounterparty() {
        return ProCounterparty;
    }

    public void setProCounterparty(String proCounterparty) {
        ProCounterparty = proCounterparty;
    }

    @JsonProperty("CounterpartyType")
    public String getCounterpartyType() {
        return CounterpartyType;
    }

    public void setCounterpartyType(String counterpartyType) {
        CounterpartyType = counterpartyType;
    }

    @JsonProperty("NFICode")
    public String getNFICode() {
        return NFICode;
    }

    public void setNFICode(String NFICode) {
        this.NFICode = NFICode;
    }

    @JsonProperty("CounterpartyRegdCptl")
    public String getCounterpartyRegdCptl() {
        return CounterpartyRegdCptl;
    }

    public void setCounterpartyRegdCptl(String counterpartyRegdCptl) {
        CounterpartyRegdCptl = counterpartyRegdCptl;
    }

    @JsonProperty("MasterAgrmtRemark")
    public String getMasterAgrmtRemark() {
        return MasterAgrmtRemark;
    }

    public void setMasterAgrmtRemark(String masterAgrmtRemark) {
        MasterAgrmtRemark = masterAgrmtRemark;
    }

    @JsonProperty("MasterAgrmtAtt")
    public String getMasterAgrmtAtt() {
        return MasterAgrmtAtt;
    }

    public void setMasterAgrmtAtt(String masterAgrmtAtt) {
        MasterAgrmtAtt = masterAgrmtAtt;
    }

    @JsonProperty("CounterpartyInformationTuple")
    public List<MasterAgrmtAttachmentDTO> getCounterpartyInformationTuple() {
        return CounterpartyInformationTuple;
    }

    public void setCounterpartyInformationTuple(List<MasterAgrmtAttachmentDTO> counterpartyInformationTuple) {
        CounterpartyInformationTuple = counterpartyInformationTuple;
    }

    @JsonProperty("CounterpartyIdentity")
    public String getCounterpartyIdentity() {
        return CounterpartyIdentity;
    }

    public void setCounterpartyIdentity(String counterpartyIdentity) {
        CounterpartyIdentity = counterpartyIdentity;
    }
    @JsonProperty("MasterAgrmtID")
    public String getMasterAgrmtID() {
        return MasterAgrmtID;
    }

    public void setMasterAgrmtID(String masterAgrmtID) {
        MasterAgrmtID = masterAgrmtID;
    }
}
