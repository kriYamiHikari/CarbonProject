package com.example.carbonproject.controller.advice;

import com.example.carbonproject.entity.response.RespPlainBean;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionController {

    //绑定数据错误
    @ExceptionHandler(BindException.class)
    public ResponseEntity<RespPlainBean> BindException(BindException e) {
        List<FieldError> fieldErrors = e.getFieldErrors();
        String errorField = fieldErrors.get(0).getField();
        Object errorValue = fieldErrors.get(0).getRejectedValue();
        String errorMsg = String.format("尝试绑定或转换数据时错误！字段[%s]的值[%s]不符合要求！", errorField, errorValue);
        String failedMsg = e.getMessage();
        return new ResponseEntity<>(RespPlainBean.error(HttpStatus.BAD_REQUEST.value(), errorMsg, failedMsg), HttpStatus.BAD_REQUEST);
    }

    //传入参数类型错误
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<RespPlainBean> MethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        String errorMsg = "传入的参数类型有误！";
        String failedMsg = e.getMostSpecificCause().getMessage();
        return new ResponseEntity<>(RespPlainBean.error(HttpStatus.BAD_REQUEST.value(), errorMsg, failedMsg), HttpStatus.BAD_REQUEST);
    }

    //传入了空值或缺少部分参数
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<RespPlainBean> MissingServletRequestParameterException(MissingServletRequestParameterException e) {
        String errorMsg = "传入的参数有误！";
        String failedMsg = e.getParameterName() + "参数没有被传入！";
        return new ResponseEntity<>(RespPlainBean.error(HttpStatus.BAD_REQUEST.value(), errorMsg, failedMsg), HttpStatus.BAD_REQUEST);
    }

    //数据库操作错误
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<RespPlainBean> DataIntegrityException(DataIntegrityViolationException e) {
        String errorMsg = "尝试对数据库操作时发生错误！请检查数据是否有误！";
        String failedMsg = e.getMostSpecificCause().getMessage();
        return new ResponseEntity<>(RespPlainBean.error(HttpStatus.BAD_REQUEST.value(), errorMsg, failedMsg), HttpStatus.BAD_REQUEST);
    }
}
