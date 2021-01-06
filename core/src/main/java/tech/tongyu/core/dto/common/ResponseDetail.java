package tech.tongyu.core.dto.common;

import com.fasterxml.jackson.databind.JsonNode;

import java.io.Serializable;

public class ResponseDetail implements Serializable {

    private JsonNode data;

    private String message;

    public JsonNode getData() {
        return data;
    }

    public void setData(JsonNode data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
