package tech.tongyu.core.dto.other;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 其余事件报告附件
 */
public class OtherReportAttachmentDTO {

    private String OtherReportFile;

    public OtherReportAttachmentDTO(){}

    public OtherReportAttachmentDTO(String otherReportFile) {
        OtherReportFile = otherReportFile;
    }

    @JsonProperty("OtherReportFile")
    public String getOtherReportFile() {
        return OtherReportFile;
    }

    public void setOtherReportFile(String otherReportFile) {
        OtherReportFile = otherReportFile;
    }
}
