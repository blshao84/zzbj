package tech.tongyu.core.dto.optionconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 期权交易确认书
 */
@JsonPropertyOrder({"UndrlygAssetDtldType", "UndrlygAssetName", "UndrlygAssetTradgPlc", "UndrlygAssetCode", "UndrlygAssetAmt"})
public class UndrlygAssetTupleDTO {

    private String UndrlygAssetDtldType;

    private String UndrlygAssetName;

    private String UndrlygAssetTradgPlc;

    private String UndrlygAssetCode;

    private String UndrlygAssetAmt;

    public UndrlygAssetTupleDTO() {
    }

    public UndrlygAssetTupleDTO(String undrlygAssetDtldType, String undrlygAssetName, String undrlygAssetTradgPlc, String undrlygAssetCode, String undrlygAssetAmt) {
        UndrlygAssetDtldType = undrlygAssetDtldType;
        UndrlygAssetName = undrlygAssetName;
        UndrlygAssetTradgPlc = undrlygAssetTradgPlc;
        UndrlygAssetCode = undrlygAssetCode;
        UndrlygAssetAmt = undrlygAssetAmt;
    }

    @JsonProperty("UndrlygAssetDtldType")
    public String getUndrlygAssetDtldType() {
        return UndrlygAssetDtldType;
    }

    public void setUndrlygAssetDtldType(String undrlygAssetDtldType) {
        UndrlygAssetDtldType = undrlygAssetDtldType;
    }
    @JsonProperty("UndrlygAssetName")
    public String getUndrlygAssetName() {
        return UndrlygAssetName;
    }

    public void setUndrlygAssetName(String undrlygAssetName) {
        UndrlygAssetName = undrlygAssetName;
    }
    @JsonProperty("UndrlygAssetTradgPlc")
    public String getUndrlygAssetTradgPlc() {
        return UndrlygAssetTradgPlc;
    }

    public void setUndrlygAssetTradgPlc(String undrlygAssetTradgPlc) {
        UndrlygAssetTradgPlc = undrlygAssetTradgPlc;
    }
    @JsonProperty("UndrlygAssetCode")
    public String getUndrlygAssetCode() {
        return UndrlygAssetCode;
    }

    public void setUndrlygAssetCode(String undrlygAssetCode) {
        UndrlygAssetCode = undrlygAssetCode;
    }
    @JsonProperty("UndrlygAssetAmt")
    public String getUndrlygAssetAmt() {
        return UndrlygAssetAmt;
    }

    public void setUndrlygAssetAmt(String undrlygAssetAmt) {
        UndrlygAssetAmt = undrlygAssetAmt;
    }
}
