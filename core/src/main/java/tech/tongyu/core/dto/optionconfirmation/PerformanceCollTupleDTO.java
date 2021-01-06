package tech.tongyu.core.dto.optionconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易确认书
 */
@JsonPropertyOrder({"PerformanceCollType", "PerformanceCollRange", "MultiConfirmationID"})
public class PerformanceCollTupleDTO {

    private String PerformanceCollType;
    private String PerformanceCollRange;
    private String MultiConfirmationID;

    public PerformanceCollTupleDTO() {
    }

    public PerformanceCollTupleDTO(String performanceCollType, String performanceCollRange, String multiConfirmationID) {
        PerformanceCollType = performanceCollType;
        PerformanceCollRange = performanceCollRange;
        MultiConfirmationID = multiConfirmationID;
    }


    @JsonProperty("PerformanceCollType")
    public String getPerformanceCollType() {
        return PerformanceCollType;
    }

    public void setPerformanceCollType(String performanceCollType) {
        PerformanceCollType = performanceCollType;
    }
    @JsonProperty("PerformanceCollRange")
    public String getPerformanceCollRange() {
        return PerformanceCollRange;
    }

    public void setPerformanceCollRange(String performanceCollRange) {
        PerformanceCollRange = performanceCollRange;
    }
    @JsonProperty("MultiConfirmationID")
    public String getMultiConfirmationID() {
        return MultiConfirmationID;
    }

    public void setMultiConfirmationID(String multiConfirmationID) {
        MultiConfirmationID = multiConfirmationID;
    }
}
