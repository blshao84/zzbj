package tech.tongyu.core.dto.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"ConfirmationID", "ConfirmationNo"})
public class OptionConfirmationTupleDTO {

    private String ConfirmationID;
    private String ConfirmationNo;

    public OptionConfirmationTupleDTO() {
    }

    public OptionConfirmationTupleDTO(String confirmationID, String confirmationNo) {
        ConfirmationID = confirmationID;
        ConfirmationNo = confirmationNo;
    }

    @JsonProperty("ConfirmationID")
    public String getConfirmationID() {
        return ConfirmationID;
    }

    public void setConfirmationID(String confirmationID) {
        ConfirmationID = confirmationID;
    }

    @JsonProperty("ConfirmationNo")
    public String getConfirmationNo() {
        return ConfirmationNo;
    }

    public void setConfirmationNo(String confirmationNo) {
        ConfirmationNo = confirmationNo;
    }
}
