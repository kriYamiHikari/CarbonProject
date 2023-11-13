package com.example.carbonproject.service;

import com.example.carbonproject.entity.TestTable;
import com.example.carbonproject.entity.response.RespPlainBean;
import com.example.carbonproject.mapper.TestTableMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestTableService {
    private final TestTableMapper testTableMapper;

    public TestTableService(TestTableMapper testTableMapper) {
        this.testTableMapper = testTableMapper;
    }

    public void addTestTableInfo(TestTable testTable) {
        testTableMapper.addTestTableInfo(testTable);
    }

    public void deleteTestTableInfoById(int id) {
        testTableMapper.deleteTestTableInfoById(id);
    }

    public List<TestTable> getTestTableInfoById(int id) {
        return testTableMapper.getTestTableInfoById(id);
    }

    public List<TestTable> getAllTestTableInfo() {
        return testTableMapper.getAllTestTableInfo();
    }

    public int getTestTableCount() {
        return testTableMapper.getTestTableCount();
    }
}
