package com.example.carbonproject.controller;

import com.example.carbonproject.Annotaion.AdminOnly;
import com.example.carbonproject.entity.MusicInfo;
import com.example.carbonproject.entity.response.RespPageDataBean;
import com.example.carbonproject.entity.response.RespPlainBean;
import com.example.carbonproject.service.MusicInfoService;
import com.example.carbonproject.utils.TimeUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/music")
public class MusicInfoController {
    private final MusicInfoService musicInfoService;

    public MusicInfoController(MusicInfoService musicInfoService) {
        this.musicInfoService = musicInfoService;
    }

    /**
     * 获取音乐信息
     *
     * @param musicInfo 搜索基础条件
     * @param startTime 开始日期
     * @param endTime   结束日期
     * @param pageNum   当前页
     * @param pageSize  每页最大数量
     * @return 根据条件返回音乐信息结果
     */
    @GetMapping("/getMusicInfoList")
    public ResponseEntity<RespPageDataBean> getMusicInfoList(MusicInfo musicInfo, String startTime, String endTime, Integer pageNum, Integer pageSize) {
        int tableCount = musicInfoService.countMusicInfo(musicInfo, TimeUtils.stringDateTest(startTime), TimeUtils.stringDateTest(endTime));
        if (pageSize == null) pageSize = tableCount;
        if (pageNum == null) pageNum = 1;

        int maxPage = (int) Math.ceil((double) tableCount / pageSize);
        if (pageNum > maxPage) pageNum = maxPage;

        List<MusicInfo> musicInfoList = musicInfoService.getMusicInfoList(musicInfo, TimeUtils.stringDateTest(startTime), TimeUtils.stringDateTest(endTime), pageNum, pageSize);
        return RespPageDataBean.success("获取成功！", tableCount, pageNum, pageSize, musicInfoList);
    }

    /**
     * 添加音乐
     *
     * @param musicInfo 音乐信息
     * @return 添加结果
     */
    @PostMapping("insertMusicInfo")
    @AdminOnly
    public ResponseEntity<RespPlainBean> insertMusicInfo(@RequestBody MusicInfo musicInfo) {
        musicInfoService.insertMusicInfo(musicInfo);
        return RespPlainBean.success("添加成功！");
    }

    @PutMapping("updateMusicInfo")
    @AdminOnly
    public ResponseEntity<RespPlainBean> updateMusicInfo(@RequestBody MusicInfo musicInfo) {
        musicInfoService.updateMusicInfoById(musicInfo);
        return RespPlainBean.success("更新成功！");
    }

    @DeleteMapping("deleteMusicInfoByIds")
    @AdminOnly
    public ResponseEntity<RespPlainBean> deleteMusicInfo(@RequestBody List<Integer> ids) {
        musicInfoService.deleteMusicInfoByIds(Objects.requireNonNull(ids));
        return RespPlainBean.success("删除成功");
    }
}
