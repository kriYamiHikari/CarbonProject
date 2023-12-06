package com.example.carbonproject.pojo.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespPageDataBean {
    private Integer code;
    private String msg;
    private String type;
    private Integer tableCount;
    private Integer pageNum;
    private Integer pageSize;
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

    public Integer getTableCount() {
        return tableCount;
    }

    public void setTableCount(Integer tableCount) {
        this.tableCount = tableCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseEntity<RespPageDataBean> success(String msg, Integer tableCount, Integer pageNum, Integer pageSize, Object data) {
        RespPageDataBean resp = new RespPageDataBean();
        resp.setCode(HttpStatus.OK.value());
        resp.setMsg(msg);
        resp.setType("success");
        resp.setTableCount(tableCount);
        resp.setPageNum(pageNum);
        resp.setPageSize(pageSize);
        resp.setData(data);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
}
