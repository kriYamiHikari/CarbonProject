package com.example.carbonproject.mapper;

import com.example.carbonproject.entity.TestTable;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestTableMapper {
    @Insert("insert into test_table(name, date) values(#{name}, #{date})")
    void addTestTableInfo(TestTable testTable);

    @Delete("delete from test_table where id = #{id}")
    void deleteTestTableInfoById(int id);

    @Select("select * from test_table where id = #{id}")
    List<TestTable> getTestTableInfoById(int id);

    @Select("select * from test_table")
    List<TestTable> getAllTestTableInfo();

    @Select("select count(*) from test_table")
    int getTestTableCount();
}
