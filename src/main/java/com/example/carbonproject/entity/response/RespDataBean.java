package com.example.carbonproject.entity.response;

public class RespDataBean {
    private int code;
    private String msg;
    private String type;
    private int count;
    private Object data;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static RespDataBean success(String msg, int count, Object data) {
        RespDataBean respDataBean = new RespDataBean();
        respDataBean.setCode(200);
        respDataBean.setMsg(msg);
        respDataBean.setType("success");
        respDataBean.setCount(count);
        respDataBean.setData(data);
        return respDataBean;
    }

    public static RespDataBean warning(String msg, int count, Object data) {
        RespDataBean respDataBean = new RespDataBean();
        respDataBean.setCode(200);
        respDataBean.setMsg(msg);
        respDataBean.setType("warning");
        respDataBean.setCount(count);
        respDataBean.setData(data);
        return respDataBean;
    }
}
