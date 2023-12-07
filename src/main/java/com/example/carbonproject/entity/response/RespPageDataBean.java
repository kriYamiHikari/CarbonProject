package com.example.carbonproject.entity.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class RespPageDataBean extends RespDataBean {
    private Integer tableCount;
    private Integer pageNum;
    private Integer pageSize;

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
