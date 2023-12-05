package com.example.carbonproject.controller;

import com.example.carbonproject.pojo.MusicInfo;
import com.example.carbonproject.service.MusicInfoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicInfoController {
    private final MusicInfoService musicInfoService;

    public MusicInfoController(MusicInfoService musicInfoService) {
        this.musicInfoService = musicInfoService;
    }

    @GetMapping("/getMusicInfoList")
    public List<MusicInfo> getMusicInfoList(MusicInfo musicInfo) {
        return musicInfoService.getMusicInfoList(musicInfo);
    }
}
