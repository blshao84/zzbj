package tech.tongyu.core.dto.swapconfirmation;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书-甲方支付乙方权益收益
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"PtyAUndrlygAssetDtldType", "PtyAUndrlygAssetName", "PtyAUndrlygAssetTradgPlc", "PtyAUndrlygAssetCode",
        "PtyAUndrlygAssetInitialPrice", "PtyAUndrlygAssetAmt"})
public class PtyAtoPtyBDTO {

    private String PtyAUndrlygAssetDtldType;
    private String PtyAUndrlygAssetName;
    private String PtyAUndrlygAssetTradgPlc;
    private String PtyAUndrlygAssetCode;
    private String PtyAUndrlygAssetInitialPrice;
    private String PtyAUndrlygAssetAmt;

    public PtyAtoPtyBDTO() {
    }

    public PtyAtoPtyBDTO(String ptyAUndrlygAssetDtldType, String ptyAUndrlygAssetName, String ptyAUndrlygAssetTradgPlc, String ptyAUndrlygAssetCode, String ptyAUndrlygAssetInitialPrice, String ptyAUndrlygAssetAmt) {
        PtyAUndrlygAssetDtldType = ptyAUndrlygAssetDtldType;
        PtyAUndrlygAssetName = ptyAUndrlygAssetName;
        PtyAUndrlygAssetTradgPlc = ptyAUndrlygAssetTradgPlc;
        PtyAUndrlygAssetCode = ptyAUndrlygAssetCode;
        PtyAUndrlygAssetInitialPrice = ptyAUndrlygAssetInitialPrice;
        PtyAUndrlygAssetAmt = ptyAUndrlygAssetAmt;
    }

    @JsonProperty("PtyAUndrlygAssetDtldType")
    public String getPtyAUndrlygAssetDtldType() {
        return PtyAUndrlygAssetDtldType;
    }

    public void setPtyAUndrlygAssetDtldType(String ptyAUndrlygAssetDtldType) {
        PtyAUndrlygAssetDtldType = ptyAUndrlygAssetDtldType;
    }

    @JsonProperty("PtyAUndrlygAssetName")
    public String getPtyAUndrlygAssetName() {
        return PtyAUndrlygAssetName;
    }

    public void setPtyAUndrlygAssetName(String ptyAUndrlygAssetName) {
        PtyAUndrlygAssetName = ptyAUndrlygAssetName;
    }

    @JsonProperty("PtyAUndrlygAssetTradgPlc")
    public String getPtyAUndrlygAssetTradgPlc() {
        return PtyAUndrlygAssetTradgPlc;
    }

    public void setPtyAUndrlygAssetTradgPlc(String ptyAUndrlygAssetTradgPlc) {
        PtyAUndrlygAssetTradgPlc = ptyAUndrlygAssetTradgPlc;
    }

    @JsonProperty("PtyAUndrlygAssetCode")
    public String getPtyAUndrlygAssetCode() {
        return PtyAUndrlygAssetCode;
    }

    public void setPtyAUndrlygAssetCode(String ptyAUndrlygAssetCode) {
        PtyAUndrlygAssetCode = ptyAUndrlygAssetCode;
    }

    @JsonProperty("PtyAUndrlygAssetInitialPrice")
    public String getPtyAUndrlygAssetInitialPrice() {
        return PtyAUndrlygAssetInitialPrice;
    }

    public void setPtyAUndrlygAssetInitialPrice(String ptyAUndrlygAssetInitialPrice) {
        PtyAUndrlygAssetInitialPrice = ptyAUndrlygAssetInitialPrice;
    }

    @JsonProperty("PtyAUndrlygAssetAmt")
    public String getPtyAUndrlygAssetAmt() {
        return PtyAUndrlygAssetAmt;
    }

    public void setPtyAUndrlygAssetAmt(String ptyAUndrlygAssetAmt) {
        PtyAUndrlygAssetAmt = ptyAUndrlygAssetAmt;
    }
}
