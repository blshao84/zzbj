package tech.tongyu.core.dto.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"SupAgrmtID", "SupAgrmtNo"})
public class SupAgrmtTupleDTO {

    private String SupAgrmtID;
    private String SupAgrmtNo;

    public SupAgrmtTupleDTO() {
    }

    public SupAgrmtTupleDTO(String supAgrmtID, String supAgrmtNo) {
        SupAgrmtID = supAgrmtID;
        SupAgrmtNo = supAgrmtNo;
    }

    @JsonProperty("SupAgrmtID")
    public String getSupAgrmtID() {
        return SupAgrmtID;
    }

    public void setSupAgrmtID(String supAgrmtID) {
        SupAgrmtID = supAgrmtID;
    }

    @JsonProperty("SupAgrmtNo")
    public String getSupAgrmtNo() {
        return SupAgrmtNo;
    }

    public void setSupAgrmtNo(String supAgrmtNo) {
        SupAgrmtNo = supAgrmtNo;
    }
}
