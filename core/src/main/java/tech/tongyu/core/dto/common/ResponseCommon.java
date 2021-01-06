package tech.tongyu.core.dto.common;

import java.util.List;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 响应
 **/
public class ResponseCommon {

    private ResponseHeaderCommon header;

    private List<ResponseBodyCommon> body;

    public ResponseCommon() {
    }

    public ResponseCommon(ResponseHeaderCommon header, List<ResponseBodyCommon> body) {
        this.header = header;
        this.body = body;
    }

    public ResponseHeaderCommon getHeader() {
        return header;
    }

    public void setHeader(ResponseHeaderCommon header) {
        this.header = header;
    }

    public List<ResponseBodyCommon> getBody() {
        return body;
    }

    public void setBody(List<ResponseBodyCommon> body) {
        this.body = body;
    }
}
