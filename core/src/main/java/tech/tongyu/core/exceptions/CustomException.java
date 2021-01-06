package tech.tongyu.core.exceptions;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 自定义错误
 **/
public class CustomException extends RuntimeException {

    public CustomException() {
        super();
    }

    private ErrorCode errorCode;

    public CustomException(String message) {
        super(message);
        this.errorCode = ErrorCode.UNKNOWN;
    }

    public CustomException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}