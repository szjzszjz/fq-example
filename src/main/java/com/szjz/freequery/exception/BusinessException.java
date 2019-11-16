package com.szjz.freequery.exception;

import com.szjz.freequery.responsemodel.Result;
import lombok.Getter;

/**
 * 业务异常类
 */
public class BusinessException extends RuntimeException {

    private static final long serialVersionUID = 720264575217922710L;

    @Getter
    private Object[] msgArgs;

    @Getter
    private Result result;

    public BusinessException() {
        super();
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, Object... msgArgs) {
        super(message, cause);
        this.msgArgs = msgArgs;
    }

    public BusinessException(String message, Object... msgArgs) {
        super(message);
        this.msgArgs = msgArgs;
    }

    public BusinessException(Result result, Throwable cause) {
        super(cause);
        this.result = result;
    }

    public BusinessException(Result result) {
        super(result.getErrorMsg());
        this.result = result;
    }

    public void setResult(Result accountDisabled) {
        this.result = accountDisabled;
    }
}
