package tech.tongyu.core.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 相应报文
 **/
public class ResponseHeaderCommon implements Serializable {

    private String Version;
    private String SenderCode;
    private String ReceiverCode;
    private String SendDate;
    private String FileNumber;
    private String BusiDataType;
    private String OperationType;
    private String RetCode;
    private String RetMsg;

    public ResponseHeaderCommon() {
    }

    public ResponseHeaderCommon(String version, String senderCode, String receiverCode,
                                String sendDate, String fileNumber, String busiDataType,
                                String operationType, String retCode, String retMsg) {
        Version = version;
        SenderCode = senderCode;
        ReceiverCode = receiverCode;
        SendDate = sendDate;
        FileNumber = fileNumber;
        BusiDataType = busiDataType;
        OperationType = operationType;
        RetCode = retCode;
        RetMsg = retMsg;
    }

    @JsonProperty("RetCode")
    public String getRetCode() {
        return RetCode;
    }

    public void setRetCode(String retCode) {
        RetCode = retCode;
    }

    @JsonProperty("RetMsg")
    public String getRetMsg() {
        return RetMsg;
    }

    public void setRetMsg(String retMsg) {
        RetMsg = retMsg;
    }

    @JsonProperty("Version")
    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    @JsonProperty("SenderCode")
    public String getSenderCode() {
        return SenderCode;
    }

    public void setSenderCode(String senderCode) {
        SenderCode = senderCode;
    }

    @JsonProperty("ReceiverCode")
    public String getReceiverCode() {
        return ReceiverCode;
    }

    public void setReceiverCode(String receiverCode) {
        ReceiverCode = receiverCode;
    }

    @JsonProperty("SendDate")
    public String getSendDate() {
        return SendDate;
    }

    public void setSendDate(String sendDate) {
        SendDate = sendDate;
    }

    @JsonProperty("FileNumber")
    public String getFileNumber() {
        return FileNumber;
    }

    public void setFileNumber(String fileNumber) {
        FileNumber = fileNumber;
    }

    @JsonProperty("BusiDataType")
    public String getBusiDataType() {
        return BusiDataType;
    }

    public void setBusiDataType(String busiDataType) {
        BusiDataType = busiDataType;
    }

    @JsonProperty("OperationType")
    public String getOperationType() {
        return OperationType;
    }

    public void setOperationType(String operationType) {
        OperationType = operationType;
    }
}
