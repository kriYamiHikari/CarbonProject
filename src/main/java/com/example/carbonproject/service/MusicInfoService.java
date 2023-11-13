package com.example.carbonproject.service;

import com.example.carbonproject.entity.MusicInfo;
import com.example.carbonproject.mapper.MusicInfoMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicInfoService {
    private final MusicInfoMapper musicInfoMapper;

    public MusicInfoService(MusicInfoMapper musicInfoMapper) {
        this.musicInfoMapper = musicInfoMapper;
    }

    public int getMusicInfoTableCount() {
        return musicInfoMapper.getMusicInfoTableCount();
    }

    public List<MusicInfo> getMusicInfoFromPage(int nowPage, int pageSize) {
        int offset = 0;
        if (nowPage > 1) {
            offset = (nowPage - 1) * pageSize;
        }
        return musicInfoMapper.getMusicInfoFromPage(offset, pageSize);
    }

    public List<MusicInfo> getMusicInfoFromPageByParamsAndPointTime(MusicInfo musicInfo, int nowPage, int pageSize) {
        int offset = 0;
        if (nowPage > 1) {
            offset = (nowPage - 1) * pageSize;
        }
        if (musicInfo.getReleaseTime() == null) {
            return musicInfoMapper.getMusicInfoFromPageByParamsAndNullPointTime(musicInfo, offset, pageSize);
        } else {
            return musicInfoMapper.getMusicInfoFromPageByParamsAndPointTime(musicInfo, offset, pageSize);
        }
    }

    public List<MusicInfo> getMusicInfoFromPageByParamsAndBetweenTime(MusicInfo musicInfo, int nowPage, int pageSize, String startTime, String endTime) {
        int offset = 0;
        if (nowPage > 1) {
            offset = (nowPage - 1) * pageSize;
        }
        return musicInfoMapper.getMusicInfoFromPageByParamsAndBetweenTime(musicInfo, offset, pageSize, startTime, endTime);
    }

    public void deleteMusicInfoMultipleById(List<Integer> id) {
        musicInfoMapper.deleteMusicInfoMultipleById(id);
    }
}
