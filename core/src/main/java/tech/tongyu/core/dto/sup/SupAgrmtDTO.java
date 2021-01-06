package tech.tongyu.core.dto.sup;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.dto.contract.ContractNumberProcessDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 补充协议
 */
@JsonPropertyOrder({"ExceID", "BizID", "MasterAgrmtNo", "SupAgrmtID",
        "SupAgrmtNo",
        "SupAgrmtType",
        "SigningDate",
        "SupAgrmtRemark",
        "SupAgrmtAttTuple"
})
public class SupAgrmtDTO extends RequestCommon {

    /**
     * 主协议编号(双方约定)
     */
    private String MasterAgrmtNo;

    /**
     * 补充议编号
     */
    private String SupAgrmtID;


    /**
     * 补充协议编号(双方约定)
     */
    private String SupAgrmtNo;

    /**
     * 补充协议类型
     */
    private String SupAgrmtType;

    /**
     * 签署时间
     */
    private String SigningDate;

    /**
     * 补充协议备注
     */
    private String SupAgrmtRemark;

    /**
     * 补充协议附件
     */
    private List<SupAgrmtAttachmentDTO> SupAgrmtAttTuple;

    public static SupAgrmtDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static SupAgrmtDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        SupAgrmtDTO dto = JsonUtils.mapper.convertValue(json, SupAgrmtDTO.class);
        op.ifPresent(o -> {
            if (o.equals(OperationEnum.UPDATE) || o.equals(OperationEnum.DELETE)) {
                dto.setSupAgrmtID(dto.getBizID());
                dto.setBizID(null);
            }
        });
        removeNullableFields(dto);
        return dto;
    }

    private static void removeNullableFields(SupAgrmtDTO dto) {
        if (Strings.isNullOrEmpty(dto.getSupAgrmtRemark())) {
            dto.setSupAgrmtRemark(null);
        }
    }


    public SupAgrmtDTO() {
    }

    public SupAgrmtDTO(String masterAgrmtNo, String supAgrmtID, String supAgrmtNo, String supAgrmtType, String signingDate, String supAgrmtRemark, List<SupAgrmtAttachmentDTO> supAgrmtAttTuple) {
        MasterAgrmtNo = masterAgrmtNo;
        SupAgrmtID = supAgrmtID;
        SupAgrmtNo = supAgrmtNo;
        SupAgrmtType = supAgrmtType;
        SigningDate = signingDate;
        SupAgrmtRemark = supAgrmtRemark;
        SupAgrmtAttTuple = supAgrmtAttTuple;
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

    @JsonProperty("SupAgrmtID")
    public String getSupAgrmtID() {
        return SupAgrmtID;
    }

    public void setSupAgrmtID(String supAgrmtID) {
        SupAgrmtID = supAgrmtID;
    }

    @JsonProperty("SupAgrmtNo")
    public String getSupAgrmtNo() {
        return SupAgrmtNo;
    }

    public void setSupAgrmtNo(String supAgrmtNo) {
        SupAgrmtNo = supAgrmtNo;
    }

    @JsonProperty("SupAgrmtType")
    public String getSupAgrmtType() {
        return SupAgrmtType;
    }

    public void setSupAgrmtType(String supAgrmtType) {
        SupAgrmtType = supAgrmtType;
    }

    @JsonProperty("SigningDate")
    public String getSigningDate() {
        return SigningDate;
    }

    public void setSigningDate(String signingDate) {
        SigningDate = signingDate;
    }

    @JsonProperty("SupAgrmtRemark")
    public String getSupAgrmtRemark() {
        return SupAgrmtRemark;
    }

    public void setSupAgrmtRemark(String supAgrmtRemark) {
        SupAgrmtRemark = supAgrmtRemark;
    }

    @JsonProperty("SupAgrmtAttTuple")
    public List<SupAgrmtAttachmentDTO> getSupAgrmtAttTuple() {
        return SupAgrmtAttTuple;
    }

    public void setSupAgrmtAttTuple(List<SupAgrmtAttachmentDTO> supAgrmtAttTuple) {
        SupAgrmtAttTuple = supAgrmtAttTuple;
    }
}
