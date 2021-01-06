package tech.tongyu.core.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 相应报文
 **/
public class ResponseBodyCommon implements Serializable {

    private String ExecID;

    private String RetCode;

    private String RetMsg;

    private String BizID;

    public ResponseBodyCommon() {
    }

    public ResponseBodyCommon(String execID, String retCode, String retMsg, String bizID) {
        ExecID = execID;
        RetCode = retCode;
        RetMsg = retMsg;
        BizID = bizID;
    }

    @JsonProperty("ExecID")
    public String getExecID() {
        return ExecID;
    }

    public void setExecID(String execID) {
        ExecID = execID;
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

    @JsonProperty("BizID")
    public String getBizID() {
        return BizID;
    }

    public void setBizID(String bizID) {
        BizID = bizID;
    }
}
