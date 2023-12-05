package com.example.carbonproject.mapper;

import com.example.carbonproject.pojo.MusicInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;

@Mapper
public interface MusicInfoMapper {
    List<MusicInfo> getMusicInfoList(MusicInfo musicInfo, Date startTime, Date endTime, Integer offset, Integer pageSize);

    int countMusicInfo(MusicInfo musicInfo, Date startTime, Date endTime);
}
