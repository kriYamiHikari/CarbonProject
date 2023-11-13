package com.example.carbonproject.entity.response;

public class RespPlainBean {
    private int code;
    private String msg;
    private String failedMsg;
    private String type;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    public String getFailedMsg() {
        return failedMsg;
    }

    public void setFailedMsg(String failedMsg) {
        this.failedMsg = failedMsg;
    }

    public static RespPlainBean error(int code, String msg, String failedMsg) {
        RespPlainBean respPlainBean = new RespPlainBean();
        respPlainBean.setCode(code);
        respPlainBean.setMsg(msg);
        respPlainBean.setFailedMsg(failedMsg);
        respPlainBean.setType("error");
        return respPlainBean;
    }

    public static RespPlainBean success(String msg) {
        RespPlainBean respPlainBean = new RespPlainBean();
        respPlainBean.setCode(200);
        respPlainBean.setMsg(msg);
        respPlainBean.setType("success");
        return respPlainBean;
    }
}
