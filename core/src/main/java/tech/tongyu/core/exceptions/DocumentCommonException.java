package tech.tongyu.core.exceptions;


public class DocumentCommonException extends CustomException {

    public DocumentCommonException() {
        super();
    }

    public DocumentCommonException(ErrorMessageAndTemolateDef.Errors error, Object... params) {
        super(ErrorCode.SERVICE_FAILED, error.getMessage(params));
    }

}
