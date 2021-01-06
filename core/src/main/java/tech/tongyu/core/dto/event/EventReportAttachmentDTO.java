package tech.tongyu.core.dto.event;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 重大事项报告文件
 **/
public class EventReportAttachmentDTO {

    private String EventReport;

    public EventReportAttachmentDTO() {
    }

    public EventReportAttachmentDTO(String eventReport) {
        EventReport = eventReport;
    }

    @JsonProperty("EventReport")
    public String getEventReport() {
        return EventReport;
    }

    public void setEventReport(String eventReport) {
        EventReport = eventReport;
    }
}
