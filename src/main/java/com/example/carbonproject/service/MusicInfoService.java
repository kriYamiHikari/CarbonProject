package com.example.carbonproject.service;

import com.example.carbonproject.mapper.MusicInfoMapper;
import com.example.carbonproject.pojo.MusicInfo;
import com.example.carbonproject.pojo.MusicInfoExample;
import com.sun.org.apache.xpath.internal.operations.And;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@MapperScan("com.example.carbonproject.mapper")
public class MusicInfoService {
    private final MusicInfoMapper musicInfoMapper;

    public MusicInfoService(MusicInfoMapper musicInfoMapper) {
        this.musicInfoMapper = musicInfoMapper;
    }

    public List<MusicInfo> getMusicInfoList(MusicInfo musicInfo) {
        MusicInfoExample musicInfoExample = new MusicInfoExample();
        musicInfoExample.createCriteria()
                .andTitleLike("%" + testString(musicInfo.getTitle()) + "%")
                .andArtistLike("%" + testString(musicInfo.getArtist()) + "%")
                .andLanguageLike("%" + testString(musicInfo.getLanguage()) + "%")
                .andDescriptionLike("%" + testString(musicInfo.getDescription()) + "%");
        return musicInfoMapper.selectByExample(musicInfoExample);
    }

    public String testString(String str) {
        if (str == null) {
            return "";
        }
        return str;
    }
}
