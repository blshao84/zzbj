package tech.tongyu.core.dto.sup;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 补充协议
 */
public class SupAgrmtAttachmentDTO {

    /**
     * 补充协议附件
     */
    private String SupAgrmtAtt;

    public SupAgrmtAttachmentDTO(){}

    public SupAgrmtAttachmentDTO(String supAgrmtAtt) {
        SupAgrmtAtt = supAgrmtAtt;
    }

    @JsonProperty("SupAgrmtAtt")
    public String getSupAgrmtAtt() {
        return SupAgrmtAtt;
    }

    public void setSupAgrmtAtt(String supAgrmtAtt) {
        SupAgrmtAtt = supAgrmtAtt;
    }
}
