package com.example.carbonproject.entity.response;

public class RespPageDataBean {
    private int code;
    private String msg;
    private String type;
    private int count;
    private int tableCount;
    private int pageSize;
    private int nowPage;
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

    public int getTableCount() {
        return tableCount;
    }

    public void setTableCount(int tableCount) {
        this.tableCount = tableCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static RespPageDataBean success(String msg, int count, int tableCount, int pageLimit, int nowPage, Object data) {
        RespPageDataBean respPageDataBean = new RespPageDataBean();
        respPageDataBean.setCode(200);
        respPageDataBean.setMsg(msg);
        respPageDataBean.setType("success");
        respPageDataBean.setCount(count);
        respPageDataBean.setTableCount(tableCount);
        respPageDataBean.setPageSize(pageLimit);
        respPageDataBean.setNowPage(nowPage);
        respPageDataBean.setData(data);
        return respPageDataBean;
    }

    public static RespPageDataBean warning(String msg, int count, int tableCount, int pageLimit, int nowPage, Object data) {
        RespPageDataBean respPageDataBean = new RespPageDataBean();
        respPageDataBean.setCode(200);
        respPageDataBean.setMsg(msg);
        respPageDataBean.setType("warning");
        respPageDataBean.setCount(count);
        respPageDataBean.setTableCount(tableCount);
        respPageDataBean.setPageSize(pageLimit);
        respPageDataBean.setNowPage(nowPage);
        respPageDataBean.setData(data);
        return respPageDataBean;
    }
}
