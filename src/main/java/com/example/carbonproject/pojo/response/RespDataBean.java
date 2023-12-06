package com.example.carbonproject.pojo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespDataBean {
    private Integer code;
    private String msg;
    private String type;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseEntity<RespDataBean> success(String msg, Object data) {
        RespDataBean resp = new RespDataBean();
        resp.setCode(HttpStatus.OK.value());
        resp.setMsg(msg);
        resp.setType("success");
        resp.setData(data);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
