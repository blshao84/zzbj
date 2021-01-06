package tech.tongyu.core.dto.swapconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书-甲方支付乙方固定利率收益
 */
@JsonPropertyOrder({"PtyAAgreedInterestRate"})
public class FixedARateReturnBTupleDTO {

    private String PtyAAgreedInterestRate;

    public FixedARateReturnBTupleDTO() {
    }

    public FixedARateReturnBTupleDTO(String ptyAAgreedInterestRate) {
        PtyAAgreedInterestRate = ptyAAgreedInterestRate;
    }

    @JsonProperty("PtyAAgreedInterestRate")
    public String getPtyAAgreedInterestRate() {
        return PtyAAgreedInterestRate;
    }

    public void setPtyAAgreedInterestRate(String ptyAAgreedInterestRate) {
        PtyAAgreedInterestRate = ptyAAgreedInterestRate;
    }
}
