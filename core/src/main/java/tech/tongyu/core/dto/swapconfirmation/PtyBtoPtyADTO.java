package tech.tongyu.core.dto.swapconfirmation;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易确认书-乙方支付甲方权益收益
 */
@JsonPropertyOrder({"PtyBUndrlygAssetDtldType", "PtyBUndrlygAssetName", "PtyBUndrlygAssetTradgPlc", "PtyBUndrlygAssetCode",
        "PtyBUndrlygAssetInitialPrice", "PtyBUndrlygAssetAmt"})
public class PtyBtoPtyADTO {

    private String PtyBUndrlygAssetDtldType;
    private String PtyBUndrlygAssetName;
    private String PtyBUndrlygAssetTradgPlc;
    private String PtyBUndrlygAssetCode;
    private String PtyBUndrlygAssetInitialPrice;
    private String PtyBUndrlygAssetAmt;

    public PtyBtoPtyADTO() {
    }

    public PtyBtoPtyADTO(String ptyBUndrlygAssetDtldType, String ptyBUndrlygAssetName, String ptyBUndrlygAssetTradgPlc, String ptyBUndrlygAssetCode, String ptyBUndrlygAssetInitialPrice, String ptyBUndrlygAssetAmt) {
        PtyBUndrlygAssetDtldType = ptyBUndrlygAssetDtldType;
        PtyBUndrlygAssetName = ptyBUndrlygAssetName;
        PtyBUndrlygAssetTradgPlc = ptyBUndrlygAssetTradgPlc;
        PtyBUndrlygAssetCode = ptyBUndrlygAssetCode;
        PtyBUndrlygAssetInitialPrice = ptyBUndrlygAssetInitialPrice;
        PtyBUndrlygAssetAmt = ptyBUndrlygAssetAmt;
    }

    @JsonProperty("PtyBUndrlygAssetDtldType")
    public String getPtyBUndrlygAssetDtldType() {
        return PtyBUndrlygAssetDtldType;
    }

    public void setPtyBUndrlygAssetDtldType(String ptyBUndrlygAssetDtldType) {
        PtyBUndrlygAssetDtldType = ptyBUndrlygAssetDtldType;
    }

    @JsonProperty("PtyBUndrlygAssetName")
    public String getPtyBUndrlygAssetName() {
        return PtyBUndrlygAssetName;
    }

    public void setPtyBUndrlygAssetName(String ptyBUndrlygAssetName) {
        PtyBUndrlygAssetName = ptyBUndrlygAssetName;
    }

    @JsonProperty("PtyBUndrlygAssetTradgPlc")
    public String getPtyBUndrlygAssetTradgPlc() {
        return PtyBUndrlygAssetTradgPlc;
    }

    public void setPtyBUndrlygAssetTradgPlc(String ptyBUndrlygAssetTradgPlc) {
        PtyBUndrlygAssetTradgPlc = ptyBUndrlygAssetTradgPlc;
    }

    @JsonProperty("PtyBUndrlygAssetCode")
    public String getPtyBUndrlygAssetCode() {
        return PtyBUndrlygAssetCode;
    }

    public void setPtyBUndrlygAssetCode(String ptyBUndrlygAssetCode) {
        PtyBUndrlygAssetCode = ptyBUndrlygAssetCode;
    }

    @JsonProperty("PtyBUndrlygAssetInitialPrice")
    public String getPtyBUndrlygAssetInitialPrice() {
        return PtyBUndrlygAssetInitialPrice;
    }

    public void setPtyBUndrlygAssetInitialPrice(String ptyBUndrlygAssetInitialPrice) {
        PtyBUndrlygAssetInitialPrice = ptyBUndrlygAssetInitialPrice;
    }

    @JsonProperty("PtyBUndrlygAssetAmt")
    public String getPtyBUndrlygAssetAmt() {
        return PtyBUndrlygAssetAmt;
    }

    public void setPtyBUndrlygAssetAmt(String ptyBUndrlygAssetAmt) {
        PtyBUndrlygAssetAmt = ptyBUndrlygAssetAmt;
    }
}
