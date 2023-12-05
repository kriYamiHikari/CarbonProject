package com.example.carbonproject.service;

import com.example.carbonproject.mapper.MusicInfoMapper;
import com.example.carbonproject.pojo.MusicInfo;
import com.example.carbonproject.utils.TimeUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MusicInfoService {
    private final MusicInfoMapper musicInfoMapper;

    public MusicInfoService(MusicInfoMapper musicInfoMapper) {
        this.musicInfoMapper = musicInfoMapper;
    }

    public int countMusicInfo(MusicInfo musicInfo, Date startTime, Date endTime) {
        return musicInfoMapper.countMusicInfo(musicInfo, startTime, endTime);
    }

    public List<MusicInfo> getMusicInfoList(MusicInfo musicInfo, Date startTime, Date endTime, Integer pageNum, Integer pageSize) {
        int offset = 0;
        if (pageNum > 1) offset = (pageNum - 1) * pageSize;
        return musicInfoMapper.getMusicInfoList(musicInfo, startTime, endTime, offset, pageSize);
    }
}
