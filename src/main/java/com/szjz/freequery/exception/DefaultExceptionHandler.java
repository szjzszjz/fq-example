package com.szjz.freequery.exception;

import com.szjz.freequery.responsemodel.Result;
import org.omg.SendingContext.RunTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.ConversionNotSupportedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.async.AsyncRequestTimeoutException;
import org.springframework.web.multipart.support.MissingServletRequestPartException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
public class DefaultExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultExceptionHandler.class);

    @ResponseBody
    /** copy form {@link ResponseEntityExceptionHandler#handleException(Exception, WebRequest)} */
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class, //
            HttpMediaTypeNotSupportedException.class, //
            HttpMediaTypeNotAcceptableException.class, //
            MissingPathVariableException.class, //
            MissingServletRequestParameterException.class, //
            ServletRequestBindingException.class, //
            ConversionNotSupportedException.class, //
            TypeMismatchException.class, //
            HttpMessageNotReadableException.class, //
            HttpMessageNotWritableException.class, //
            MethodArgumentNotValidException.class, //
            MissingServletRequestPartException.class, //
            BindException.class, //
            NoHandlerFoundException.class, //
            AsyncRequestTimeoutException.class
    })
    public Result httpStatusException(ServletWebRequest webRequest, Exception ex) {
        // 获取异常对应的HttpStatus
        HttpStatus status = null;
        try {
            ResponseEntityExceptionHandler exceptionHandler = new ResponseEntityExceptionHandler() {
            };
            ResponseEntity<Object> entity = exceptionHandler.handleException(ex, webRequest);
            status = entity.getStatusCode();
        } catch (Exception e) {
            LOGGER.error("系统异常: " + e.getMessage(), e);
            Result result = Result.fail("系统异常: " + e.getMessage());
            return result;
        }

        // 返回结果模型
        String errorMsg = "HttpStatus[" + status.value() + "], " + ex.getMessage();
        Result result = Result.fail(errorMsg);
        return result;
    }

    @ResponseBody
    @ExceptionHandler({Exception.class,//
            RuntimeException.class})
    public Result exception(Exception ex) {
        if (ex instanceof BusinessException) {
            // 业务类型异常
            BusinessException businessException = (BusinessException) ex;
            Result result = businessException.getResult();
            if (result == null) {
                result = Result.fail(businessException.getMessage());
            }
            return result;
        } else {
            LOGGER.error("系统异常: " + ex.getMessage(), ex);
            Result result = Result.fail(ex.getMessage());
            return result;
        }
    }

}
