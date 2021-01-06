package tech.tongyu.core.dto.common;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 请求接收
 **/
public class JsonRequestCollection implements Serializable {

    private List<Map<String, Object>> params;

    public JsonRequestCollection() {
    }

    public JsonRequestCollection(List<Map<String, Object>> params) {
        this.params = params;
    }

    public List<Map<String, Object>> getParams() {
        return params;
    }

    public void setParams(List<Map<String, Object>> params) {
        this.params = params;
    }
}
