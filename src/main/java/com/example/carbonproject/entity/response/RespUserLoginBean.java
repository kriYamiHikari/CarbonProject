package com.example.carbonproject.entity.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespUserLoginBean extends RespDataBean {
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static ResponseEntity<RespUserLoginBean> success(String msg, String token, String avatar, Object data) {
        RespUserLoginBean resp = new RespUserLoginBean();
        resp.setCode(HttpStatus.OK.value());
        resp.setMsg(msg);
        resp.setType("success");
        resp.setToken(token);
        resp.setData(data);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
