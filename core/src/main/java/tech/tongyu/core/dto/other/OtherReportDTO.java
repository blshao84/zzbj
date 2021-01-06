package tech.tongyu.core.dto.other;

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
 * @description 其他事件报告
 */
@JsonPropertyOrder({"ExceID", "BizID", "OtherReportFileTuple", "DetailedDescription"})
public class OtherReportDTO extends RequestCommon {

    private List<OtherReportAttachmentDTO> OtherReportFileTuple;

    private String DetailedDescription;

    public static OtherReportDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static OtherReportDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        OtherReportDTO dto = JsonUtils.mapper.convertValue(json, OtherReportDTO.class);
        return dto;
    }


    public OtherReportDTO() {
    }

    public OtherReportDTO(List<OtherReportAttachmentDTO> otherReportFileTuple, String detailedDescription) {
        OtherReportFileTuple = otherReportFileTuple;
        DetailedDescription = detailedDescription;
    }

    public LinkedHashMap<String, Object> toLinkedHashMap() {
        return JsonUtils.fromJsonToLinkedHashMap(JsonUtils.toJson(this));
    }

    @JsonProperty("OtherReportFileTuple")
    public List<OtherReportAttachmentDTO> getOtherReportFileTuple() {
        return OtherReportFileTuple;
    }

    public void setOtherReportFileTuple(List<OtherReportAttachmentDTO> otherReportFileTuple) {
        OtherReportFileTuple = otherReportFileTuple;
    }

    @JsonProperty("DetailedDescription")
    public String getDetailedDescription() {
        return DetailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        DetailedDescription = detailedDescription;
    }
}
