package tech.tongyu.core.dto.swaptermination;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.JsonNode;
import com.google.common.base.Strings;
import tech.tongyu.core.dto.common.RequestCommon;
import tech.tongyu.core.enums.DurationOperationTypeEnum;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.utils.common.JsonUtils;

import java.util.LinkedHashMap;
import java.util.Optional;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 互换交易存续期管理
 */
@JsonPropertyOrder({"ExceID", "BizID", "ConfirmationNo", "ExpirationDate", "DefaultingParty"
        , "DefaultEvent", "RenewalDate", "DurationOperationType", "TerminationAmount", "Balance"
        , "AmountPaidThisTime"})
public class SwapTerminationDTO extends RequestCommon {

    /**
     * 交易确认书编号(双方约定)
     */
    private String ConfirmationNo;

    /**
     * 终止日期
     */
    private String ExpirationDate;

    /**
     * 违约方
     */
    private String DefaultingParty;

    /**
     * 违约事件说明
     */
    private String DefaultEvent;

    /**
     * 展期日期
     */
    private String RenewalDate;

    /**
     * 存续期操作类型
     */
    private String DurationOperationType;

    /**
     * 本次终止金额
     */
    private String TerminationAmount;

    /**
     * 余额
     */
    private String Balance;

    /**
     * 本次支付金额
     */
    private String AmountPaidThisTime;

    public static SwapTerminationDTO fromJson(JsonNode json) {
        return fromJson(json, Optional.empty());
    }

    public static SwapTerminationDTO fromJson(JsonNode json, Optional<OperationEnum> op) {
        SwapTerminationDTO dto = JsonUtils.mapper.convertValue(json, SwapTerminationDTO.class);
        if (DurationOperationTypeEnum.ROLL.code().equals(dto.getDurationOperationType())) {
            dto.setTerminationAmount(null);
            dto.setAmountPaidThisTime(null);
        }
        removeNullableFields(dto);
        return dto;
    }

    private static void removeNullableFields(SwapTerminationDTO dto) {
        if (Strings.isNullOrEmpty((dto.getExpirationDate()))) {
            dto.setExpirationDate(null);
        }
        if (Strings.isNullOrEmpty((dto.getDefaultingParty()))) {
            dto.setDefaultingParty(null);
        }
        if (Strings.isNullOrEmpty((dto.getDefaultEvent()))) {
            dto.setDefaultEvent(null);
        }
        if (Strings.isNullOrEmpty((dto.getRenewalDate()))) {
            dto.setRenewalDate(null);
        }
    }

    public SwapTerminationDTO() {
    }

    public SwapTerminationDTO(String confirmationNo, String expirationDate, String defaultingParty, String defaultEvent, String renewalDate, String durationOperationType, String terminationAmount, String balance, String amountPaidThisTime) {
        ConfirmationNo = confirmationNo;
        ExpirationDate = expirationDate;
        DefaultingParty = defaultingParty;
        DefaultEvent = defaultEvent;
        RenewalDate = renewalDate;
        DurationOperationType = durationOperationType;
        TerminationAmount = terminationAmount;
        Balance = balance;
        AmountPaidThisTime = amountPaidThisTime;
    }

    public LinkedHashMap<String, Object> toLinkedHashMap() {
        return JsonUtils.fromJsonToLinkedHashMap(JsonUtils.toJson(this));
    }

    @JsonProperty("ConfirmationNo")
    public String getConfirmationNo() {
        return ConfirmationNo;
    }

    public void setConfirmationNo(String confirmationNo) {
        ConfirmationNo = confirmationNo;
    }

    @JsonProperty("ExpirationDate")
    public String getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        ExpirationDate = expirationDate;
    }

    @JsonProperty("DefaultingParty")
    public String getDefaultingParty() {
        return DefaultingParty;
    }

    public void setDefaultingParty(String defaultingParty) {
        DefaultingParty = defaultingParty;
    }

    @JsonProperty("DefaultEvent")
    public String getDefaultEvent() {
        return DefaultEvent;
    }

    public void setDefaultEvent(String defaultEvent) {
        DefaultEvent = defaultEvent;
    }

    @JsonProperty("RenewalDate")
    public String getRenewalDate() {
        return RenewalDate;
    }

    public void setRenewalDate(String renewalDate) {
        RenewalDate = renewalDate;
    }

    @JsonProperty("DurationOperationType")
    public String getDurationOperationType() {
        return DurationOperationType;
    }

    public void setDurationOperationType(String durationOperationType) {
        DurationOperationType = durationOperationType;
    }

    @JsonProperty("TerminationAmount")
    public String getTerminationAmount() {
        return TerminationAmount;
    }

    public void setTerminationAmount(String terminationAmount) {
        TerminationAmount = terminationAmount;
    }

    @JsonProperty("Balance")
    public String getBalance() {
        return Balance;
    }

    public void setBalance(String balance) {
        Balance = balance;
    }

    @JsonProperty("AmountPaidThisTime")
    public String getAmountPaidThisTime() {
        return AmountPaidThisTime;
    }

    public void setAmountPaidThisTime(String amountPaidThisTime) {
        AmountPaidThisTime = amountPaidThisTime;
    }
}
