package tech.tongyu.core.dto.swapconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书-乙方支付甲方浮动利率收益
 */
@JsonPropertyOrder({"PtyBRefRateType", "PtyBRefRateName"})
public class ReferenceBRateBTupleDTO {

    private String PtyBRefRateType;
    private String PtyBRefRateName;

    public ReferenceBRateBTupleDTO() {
    }

    public ReferenceBRateBTupleDTO(String ptyBRefRateType, String ptyBRefRateName) {
        PtyBRefRateType = ptyBRefRateType;
        PtyBRefRateName = ptyBRefRateName;
    }

    @JsonProperty("PtyBRefRateType")
    public String getPtyBRefRateType() {
        return PtyBRefRateType;
    }

    public void setPtyBRefRateType(String ptyBRefRateType) {
        PtyBRefRateType = ptyBRefRateType;
    }

    @JsonProperty("PtyBRefRateName")
    public String getPtyBRefRateName() {
        return PtyBRefRateName;
    }

    public void setPtyBRefRateName(String ptyBRefRateName) {
        PtyBRefRateName = ptyBRefRateName;
    }
}
