package tech.tongyu.core.dto.event;

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
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 重大事件报告
 **/
@JsonPropertyOrder({"ExceID", "BizID", "EventReportTuple", "DetailedDescription"})
public class EventReportDTO extends RequestCommon {

    private List<EventReportAttachmentDTO> EventReportTuple;

    private String DetailedDescription;

    public static EventReportDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static EventReportDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        EventReportDTO dto = JsonUtils.mapper.convertValue(json, EventReportDTO.class);
        return dto;
    }

    public EventReportDTO() {
    }

    public EventReportDTO(List<EventReportAttachmentDTO> eventReportTuple, String detailedDescription) {
        this.EventReportTuple = eventReportTuple;
        this.DetailedDescription = detailedDescription;
    }

    public LinkedHashMap<String, Object> toLinkedHashMap() {
        return JsonUtils.fromJsonToLinkedHashMap(JsonUtils.toJson(this));
    }

    @JsonProperty("EventReportTuple")
    public List<EventReportAttachmentDTO> getEventReportTuple() {
        return EventReportTuple;
    }

    public void setEventReportTuple(List<EventReportAttachmentDTO> eventReportTuple) {
        EventReportTuple = eventReportTuple;
    }

    @JsonProperty("DetailedDescription")
    public String getDetailedDescription() {
        return DetailedDescription;
    }

    public void setDetailedDescription(String detailedDescription) {
        DetailedDescription = detailedDescription;
    }
}
