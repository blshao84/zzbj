package tech.tongyu.core.dto.swapconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书-乙方支付甲方固定利率收益
 */
@JsonPropertyOrder({"PtyBAgreedInterestRate"})
public class FixedBRateReturnBTupleDTO {

    private String PtyBAgreedInterestRate;

    public FixedBRateReturnBTupleDTO() {
    }

    public FixedBRateReturnBTupleDTO(String ptyBAgreedInterestRate) {
        PtyBAgreedInterestRate = ptyBAgreedInterestRate;
    }

    @JsonProperty("PtyBAgreedInterestRate")
    public String getPtyBAgreedInterestRate() {
        return PtyBAgreedInterestRate;
    }

    public void setPtyBAgreedInterestRate(String ptyBAgreedInterestRate) {
        PtyBAgreedInterestRate = ptyBAgreedInterestRate;
    }
}
