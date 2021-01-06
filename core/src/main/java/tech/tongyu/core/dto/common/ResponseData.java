package tech.tongyu.core.dto.common;

import com.fasterxml.jackson.databind.JsonNode;
import tech.tongyu.core.enums.InterfaceInfoEnum;

import java.io.Serializable;
import java.util.List;

public class ResponseData implements Serializable {

    private String interfaceInfo;

    private List<ResponseDetail> data;

    private String headerMessage;

    public ResponseData() {
    }

    public ResponseData(String interfaceInfo, List<ResponseDetail> data) {
        this.interfaceInfo = interfaceInfo;
        this.data = data;
    }

    public String getHeaderMessage() {
        return headerMessage;
    }

    public void setHeaderMessage(String headerMessage) {
        this.headerMessage = headerMessage;
    }

    public String getInterfaceInfo() {
        return interfaceInfo;
    }

    public void setInterfaceInfo(String interfaceInfo) {
        this.interfaceInfo = interfaceInfo;
    }

    public List<ResponseDetail> getData() {
        return data;
    }

    public void setData(List<ResponseDetail> data) {
        this.data = data;
    }
}
