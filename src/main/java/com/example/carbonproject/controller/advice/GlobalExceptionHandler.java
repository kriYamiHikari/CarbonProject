package com.example.carbonproject.controller.advice;

import com.example.carbonproject.entity.response.RespPlainBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.io.IOException;
import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 处理数据库操作异常
     *
     * @param e 事件
     * @return 自定义返回体
     */
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<RespPlainBean> dataIntegrityViolationException(DataIntegrityViolationException e) {
        String failedMsg = e.getMostSpecificCause().getMessage();
        return RespPlainBean.error(HttpStatus.BAD_REQUEST, "尝试对数据库操作时发生错误！", failedMsg);
    }

    /**
     * 处理传参异常
     *
     * @param e 事件
     * @return 自定义返回体
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<RespPlainBean> httpMessageNotReadableException(HttpMessageNotReadableException e) {
        String failedMsg = e.getMostSpecificCause().getMessage();
        return RespPlainBean.error(HttpStatus.BAD_REQUEST, "尝试读取请求参数时发生错误！", failedMsg);
    }

    /**
     * 处理请求method操作异常
     *
     * @param e 事件
     * @return 自定义返回体
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<RespPlainBean> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        Set<HttpMethod> supportedMethods = e.getSupportedHttpMethods();
        assert supportedMethods != null;
        String wrongMethod = e.getMethod();
        String rightMethod = supportedMethods.iterator().next().name();
        String failedMsg = e.getMessage();
        return RespPlainBean.error(HttpStatus.METHOD_NOT_ALLOWED,
                String.format("使用了错误的请求方法{%s}, 请使用{%s}来请求此接口！", wrongMethod, rightMethod), failedMsg);
    }

    /**
     * 处理404异常
     *
     * @param e 事件
     * @return 自定义返回体
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<RespPlainBean> noHandlerFoundException(NoHandlerFoundException e) {
        String failedMsg = e.getMessage();
        return RespPlainBean.error(HttpStatus.NOT_FOUND, "未找到资源！", failedMsg);
    }

    /**
     * 处理自定义错误
     *
     * @param e 事件
     * @return 自定义返回体
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<RespPlainBean> customException(CustomException e) {
        return RespPlainBean.error(e.getStatus(), e.getMessage(), null);
    }
}
