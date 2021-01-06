package tech.tongyu.core.dto.swapconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书-甲方支付乙方浮动利率收益
 */
@JsonPropertyOrder({"PtyARefRateType", "PtyARefRateName"})
public class ReferenceARateBTupleDTO {

    private String PtyARefRateType;
    private String PtyARefRateName;

    public ReferenceARateBTupleDTO() {
    }

    public ReferenceARateBTupleDTO(String ptyARefRateType, String ptyARefRateName) {
        PtyARefRateType = ptyARefRateType;
        PtyARefRateName = ptyARefRateName;
    }

    @JsonProperty("PtyARefRateType")
    public String getPtyARefRateType() {
        return PtyARefRateType;
    }

    public void setPtyARefRateType(String ptyARefRateType) {
        PtyARefRateType = ptyARefRateType;
    }

    @JsonProperty("PtyARefRateName")
    public String getPtyARefRateName() {
        return PtyARefRateName;
    }

    public void setPtyARefRateName(String ptyARefRateName) {
        PtyARefRateName = ptyARefRateName;
    }
}
