package tech.tongyu.entrance.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.exceptions.JsonRpcResponse;
import tech.tongyu.core.exceptions.TradeCommonException;

import javax.servlet.ServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(NullPointerException.class)
    public Object handlerNullPointerException(ServletRequest request, NullPointerException e) {
        e.printStackTrace();
        return new JsonRpcResponse(JsonRpcResponse.ErrorCode.RUNTIME_ERROR, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(IllegalArgumentException.class)
    public Object handlerIllegalArgumentException(ServletRequest request, IllegalArgumentException e) {
        e.printStackTrace();
        return new JsonRpcResponse(JsonRpcResponse.ErrorCode.RUNTIME_ERROR, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public Object handlerCustomException(ServletRequest request, CustomException e) {
        e.printStackTrace();
        return new JsonRpcResponse(JsonRpcResponse.ErrorCode.RUNTIME_ERROR, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Object handlerAllException(ServletRequest request, Exception e) {
        e.printStackTrace();
        return new JsonRpcResponse(JsonRpcResponse.ErrorCode.RUNTIME_ERROR, e.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(TradeCommonException.class)
    public Object handlerTradeCommonException(ServletRequest request, Exception e) {
        e.printStackTrace();
        return new JsonRpcResponse(JsonRpcResponse.ErrorCode.RUNTIME_ERROR, e.getMessage());
    }
}
