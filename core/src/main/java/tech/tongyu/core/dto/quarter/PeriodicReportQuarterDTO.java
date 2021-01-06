package tech.tongyu.core.dto.quarter;

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
 * @description 定期报告-季报
 */
@JsonPropertyOrder({"ExceID", "BizID", "Year", "Quarter", "DerivativesQuarterlyReportAnnexTuple"})
public class PeriodicReportQuarterDTO extends RequestCommon {

    private String Year;
    private String Quarter;
    private List<DerivativesQuarterlyReportAnnexDTO> DerivativesQuarterlyReportAnnexTuple;

    public static PeriodicReportQuarterDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static PeriodicReportQuarterDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        PeriodicReportQuarterDTO dto = JsonUtils.mapper.convertValue(json, PeriodicReportQuarterDTO.class);
        return dto;
    }

    public PeriodicReportQuarterDTO() {
    }

    public PeriodicReportQuarterDTO(String year, String quarter, List<DerivativesQuarterlyReportAnnexDTO> derivativesQuarterlyReportAnnexTuple) {
        Year = year;
        Quarter = quarter;
        DerivativesQuarterlyReportAnnexTuple = derivativesQuarterlyReportAnnexTuple;
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

    @JsonProperty("Quarter")
    public String getQuarter() {
        return Quarter;
    }

    public void setQuarter(String quarter) {
        Quarter = quarter;
    }

    @JsonProperty("DerivativesQuarterlyReportAnnexTuple")
    public List<DerivativesQuarterlyReportAnnexDTO> getDerivativesQuarterlyReportAnnexTuple() {
        return DerivativesQuarterlyReportAnnexTuple;
    }

    public void setDerivativesQuarterlyReportAnnexTuple(List<DerivativesQuarterlyReportAnnexDTO> derivativesQuarterlyReportAnnexTuple) {
        DerivativesQuarterlyReportAnnexTuple = derivativesQuarterlyReportAnnexTuple;
    }
}
