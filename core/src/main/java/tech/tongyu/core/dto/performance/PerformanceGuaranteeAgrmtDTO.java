package tech.tongyu.core.dto.performance;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.dto.contract.ContractNumberProcessDTO;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 履约保证书
 */
@JsonPropertyOrder({"ExceID", "BizID", "MasterAgrmtNo", "SupAgrmtNo", "PerformanceGuaranteeAgrmtID",
        "PerformanceGuaranteeAgrmt"})
public class PerformanceGuaranteeAgrmtDTO extends RequestCommon {

    /**
     * 主协议编号(双方约定)
     */
    private String MasterAgrmtNo;

    /**
     * 补充协议编号(双方约定)
     */
    private String SupAgrmtNo;

    /**
     * 履约担保协议编号
     */
    private String PerformanceGuaranteeAgrmtID;

    /**
     * 履约担保协议(附件)
     */
    private String PerformanceGuaranteeAgrmt;

    public static PerformanceGuaranteeAgrmtDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static PerformanceGuaranteeAgrmtDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        PerformanceGuaranteeAgrmtDTO dto = JsonUtils.mapper.convertValue(json, PerformanceGuaranteeAgrmtDTO.class);
        op.ifPresent(o -> {
            if (o.equals(OperationEnum.UPDATE) || o.equals(OperationEnum.DELETE)) {
                dto.setPerformanceGuaranteeAgrmtID(dto.getBizID());
                dto.setBizID(null);
            }
        });
        return dto;
    }

    public PerformanceGuaranteeAgrmtDTO() {
    }

    public PerformanceGuaranteeAgrmtDTO(String masterAgrmtNo, String supAgrmtNo, String performanceGuaranteeAgrmtID, String performanceGuaranteeAgrmt) {
        MasterAgrmtNo = masterAgrmtNo;
        SupAgrmtNo = supAgrmtNo;
        PerformanceGuaranteeAgrmtID = performanceGuaranteeAgrmtID;
        PerformanceGuaranteeAgrmt = performanceGuaranteeAgrmt;
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

    @JsonProperty("PerformanceGuaranteeAgrmtID")
    public String getPerformanceGuaranteeAgrmtID() {
        return PerformanceGuaranteeAgrmtID;
    }

    public void setPerformanceGuaranteeAgrmtID(String performanceGuaranteeAgrmtID) {
        PerformanceGuaranteeAgrmtID = performanceGuaranteeAgrmtID;
    }

    @JsonProperty("PerformanceGuaranteeAgrmt")
    public String getPerformanceGuaranteeAgrmt() {
        return PerformanceGuaranteeAgrmt;
    }

    public void setPerformanceGuaranteeAgrmt(String performanceGuaranteeAgrmt) {
        PerformanceGuaranteeAgrmt = performanceGuaranteeAgrmt;
    }
}
