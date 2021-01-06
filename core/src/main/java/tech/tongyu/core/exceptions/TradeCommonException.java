package tech.tongyu.core.exceptions;

import java.io.Serializable;

public class TradeCommonException extends CustomException implements Serializable {

    public TradeCommonException() {
        super();
    }

    public TradeCommonException(TradeReturnMessage.Errors error, Object... params) {
        super(ErrorCode.SERVICE_FAILED, error.getMessage(params));
    }
}
