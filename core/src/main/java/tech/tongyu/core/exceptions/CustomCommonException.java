package tech.tongyu.core.exceptions;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 自定义通用错误
 **/
public class CustomCommonException extends CustomException {

    public CustomCommonException() {
        super();
    }

    public CustomCommonException(CustomErrorMessage.Errors error, Object... params) {
        super(ErrorCode.SERVICE_FAILED, error.getMessage(params));
    }

}
