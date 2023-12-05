package com.example.carbonproject.mapper;

import com.example.carbonproject.pojo.MusicInfo;
import com.example.carbonproject.pojo.MusicInfoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MusicInfoMapper {
    long countByExample(MusicInfoExample example);

    int deleteByExample(MusicInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MusicInfo record);

    int insertSelective(MusicInfo record);

    List<MusicInfo> selectByExample(MusicInfoExample example);

    MusicInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MusicInfo record, @Param("example") MusicInfoExample example);

    int updateByExample(@Param("record") MusicInfo record, @Param("example") MusicInfoExample example);

    int updateByPrimaryKeySelective(MusicInfo record);

    int updateByPrimaryKey(MusicInfo record);
}