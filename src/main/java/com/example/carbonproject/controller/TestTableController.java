package com.example.carbonproject.controller;

import com.example.carbonproject.entity.TestTable;
import com.example.carbonproject.entity.msg.ActionMsg;
import com.example.carbonproject.entity.response.RespDataBean;
import com.example.carbonproject.entity.response.RespPlainBean;
import com.example.carbonproject.service.TestTableService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestTableController {
    private final TestTableService testTableService;

    public TestTableController(TestTableService testTableService) {
        this.testTableService = testTableService;
    }

    @PostMapping("/addTestTableInfo")
    public RespPlainBean addTestTableInfo(TestTable testTable) {
        testTableService.addTestTableInfo(testTable);
        return RespPlainBean.success(ActionMsg.ADD_SUCCESS);
    }

    @DeleteMapping("/deleteTestTableInfo")
    public RespPlainBean deleteTestTableInfo(int id) {
        if (testTableService.getTestTableInfoById(id).isEmpty()) {
            throw new DataIntegrityViolationException(ActionMsg.DELETE_FAILED);
        } else {
            testTableService.deleteTestTableInfoById(id);
            return RespPlainBean.success(ActionMsg.DELETE_SUCCESS);
        }
    }

    @GetMapping("/getTestTableInfoById")
    public RespDataBean getTestTableInfo(int id) {
        List<TestTable> testTables = testTableService.getTestTableInfoById(id);
        if (testTables.isEmpty()) {
            return RespDataBean.warning(ActionMsg.QUERY_SUCCESS_BY_EMPTY, 0, null);
        } else {
            return RespDataBean.success(ActionMsg.QUERY_SUCCESS, testTables.size(), testTables);
        }
    }

    @GetMapping("/getAllTestTableInfo")
    public RespDataBean getAllTestTableInfo() {
        List<TestTable> testTables = testTableService.getAllTestTableInfo();
        if (testTables.isEmpty()) {
            return RespDataBean.warning(ActionMsg.QUERY_SUCCESS_BY_EMPTY, 0, null);
        } else {
            return RespDataBean.success(ActionMsg.QUERY_SUCCESS, testTables.size(), testTables);
        }
    }

    @GetMapping("/getTestTableCount")
    public RespPlainBean getTestTableCount() {
        return RespPlainBean.success(String.format("%d", testTableService.getTestTableCount()));
    }
}
