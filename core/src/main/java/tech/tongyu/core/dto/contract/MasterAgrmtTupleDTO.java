package tech.tongyu.core.dto.contract;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"MasterAgrmtID", "MasterAgrmtNo"})
public class MasterAgrmtTupleDTO {

    private String MasterAgrmtID;
    private String MasterAgrmtNo;

    public MasterAgrmtTupleDTO() {
    }

    public MasterAgrmtTupleDTO(String masterAgrmtID, String masterAgrmtNo) {
        MasterAgrmtID = masterAgrmtID;
        MasterAgrmtNo = masterAgrmtNo;
    }

    @JsonProperty("MasterAgrmtID")
    public String getMasterAgrmtID() {
        return MasterAgrmtID;
    }

    public void setMasterAgrmtID(String masterAgrmtID) {
        MasterAgrmtID = masterAgrmtID;
    }

    @JsonProperty("MasterAgrmtNo")
    public String getMasterAgrmtNo() {
        return MasterAgrmtNo;
    }

    public void setMasterAgrmtNo(String masterAgrmtNo) {
        MasterAgrmtNo = masterAgrmtNo;
    }
}
