package tech.tongyu.core.dto.optionconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易确认书
 */
public class ConfirmationAttTupleDTO {

    private String ConfirmationAtt;

    public ConfirmationAttTupleDTO() {
    }

    public ConfirmationAttTupleDTO(String confirmationAtt) {
        ConfirmationAtt = confirmationAtt;
    }

    @JsonProperty("ConfirmationAtt")
    public String getConfirmationAtt() {
        return ConfirmationAtt;
    }

    public void setConfirmationAtt(String confirmationAtt) {
        ConfirmationAtt = confirmationAtt;
    }
}
