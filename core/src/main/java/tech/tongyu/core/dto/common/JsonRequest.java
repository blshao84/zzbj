package tech.tongyu.core.dto.common;

import java.io.Serializable;
import java.util.Map;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 请求接收
 **/
public class JsonRequest implements Serializable {

    private String id;
    private Map<String, Object> params;

    public JsonRequest(String id, Map<String, Object> params) {
        this.id = id;
        this.params = params;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "JsonRequest{" +
                "id='" + id + '\'' +
                ", params=" + params +
                '}';
    }
}
