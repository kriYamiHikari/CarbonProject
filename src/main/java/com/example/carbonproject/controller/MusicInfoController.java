package com.example.carbonproject.controller;

import com.example.carbonproject.pojo.MusicInfo;
import com.example.carbonproject.pojo.response.RespPageDataBean;
import com.example.carbonproject.pojo.response.RespPlainBean;
import com.example.carbonproject.service.MusicInfoService;
import com.example.carbonproject.utils.TimeUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/music")
public class MusicInfoController {
    private final MusicInfoService musicInfoService;

    public MusicInfoController(MusicInfoService musicInfoService) {
        this.musicInfoService = musicInfoService;
    }

    @GetMapping("/getMusicInfoList")
    public ResponseEntity<RespPageDataBean> getMusicInfoList(MusicInfo musicInfo, String startTime, String endTime, Integer pageNum, Integer pageSize) {
        int tableCount = musicInfoService.countMusicInfo(musicInfo, TimeUtils.stringDateTest(startTime), TimeUtils.stringDateTest(endTime));
        if (pageSize == null) pageSize = tableCount;
        if (pageNum == null) pageNum = 1;

        int maxPage = (int) Math.ceil((double) tableCount / pageSize);
        if (pageNum > maxPage) pageNum = maxPage;

        List<MusicInfo> musicInfoList = musicInfoService.getMusicInfoList(musicInfo, TimeUtils.stringDateTest(startTime), TimeUtils.stringDateTest(endTime), pageNum, pageSize);
        return RespPageDataBean.success("获取成功", tableCount, pageNum, pageSize, musicInfoList);
    }
}
