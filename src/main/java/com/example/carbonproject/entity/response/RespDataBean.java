package com.example.carbonproject.entity.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespDataBean extends RespPlainBean {
    private Object data;
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
