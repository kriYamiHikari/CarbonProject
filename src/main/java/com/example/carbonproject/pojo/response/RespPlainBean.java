package com.example.carbonproject.pojo.response;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespPlainBean {
    private Integer code;
    private String msg;
    private String type;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static ResponseEntity<RespPlainBean> success(String msg) {
        RespPlainBean resp = new RespPlainBean();
        resp.setCode(HttpStatus.OK.value());
        resp.setMsg(msg);
        resp.setType("success");
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    public static ResponseEntity<RespPlainBean> error(HttpStatus failedHttpStatus, String msg) {
        RespPlainBean resp = new RespPlainBean();
        resp.setCode(failedHttpStatus.value());
        resp.setMsg(msg);
        resp.setType("error");
        return new ResponseEntity<>(resp, failedHttpStatus);
    }
}
