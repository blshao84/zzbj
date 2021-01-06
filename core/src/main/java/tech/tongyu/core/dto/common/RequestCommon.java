package tech.tongyu.core.dto.common;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 头部关键数据
 **/
public class RequestCommon implements Serializable {

    private String ExecID;

    private String BizID;

    public RequestCommon() {
    }

    public RequestCommon(String execID, String bizID) {
        ExecID = execID;
        BizID = bizID;
    }

    @JsonProperty("ExceID")
    public String getExecID() {
        return ExecID;
    }

    public void setExecID(String execID) {
        ExecID = execID;
    }

    @JsonProperty("BizID")
    public String getBizID() {
        return BizID;
    }

    public void setBizID(String bizID) {
        BizID = bizID;
    }
}
