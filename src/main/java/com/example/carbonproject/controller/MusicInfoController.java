package com.example.carbonproject.controller;

import com.example.carbonproject.entity.MusicInfo;
import com.example.carbonproject.entity.msg.ActionMsg;
import com.example.carbonproject.entity.response.RespPageDataBean;
import com.example.carbonproject.entity.response.RespPlainBean;
import com.example.carbonproject.service.MusicInfoService;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MusicInfoController {
    private final MusicInfoService musicInfoService;

    public MusicInfoController(MusicInfoService musicInfoService) {
        this.musicInfoService = musicInfoService;
    }

    @GetMapping("/music/getMusicInfoFromPage")
    public RespPageDataBean getMusicInfoFromPage(int nowPage, @RequestParam int pageSize) {
        if (nowPage == 0) {
            nowPage = 1;
        }
        if (pageSize == 0) {
            throw new DataIntegrityViolationException("pageSize不能为空或为0!");
        } else {
            List<MusicInfo> musicInfoList = musicInfoService.getMusicInfoFromPage(nowPage, pageSize);
            if (musicInfoList.isEmpty()) {
                return RespPageDataBean.warning(ActionMsg.QUERY_SUCCESS_BY_EMPTY, 0, musicInfoService.getMusicInfoTableCount(), pageSize, nowPage, null);
            }
            return RespPageDataBean.warning(ActionMsg.QUERY_SUCCESS_BY_EMPTY, musicInfoList.size(), musicInfoService.getMusicInfoTableCount(), pageSize, nowPage, musicInfoList);
        }
    }

    @GetMapping("/music/getMusicInfoFromPageByParamsAndPointTime")
    public RespPageDataBean getMusicInfoFromPageByParamsAndPointTime(MusicInfo musicInfo, int nowPage, @RequestParam int pageSize) {
        if (nowPage == 0) {
            nowPage = 1;
        }
        if (pageSize == 0) {
            throw new DataIntegrityViolationException("pageSize不能为空或为0!");
        } else {
            List<MusicInfo> musicInfoList;
            boolean releaseTimeNull = false;
            if (musicInfo.getReleaseTime() == null) {
                musicInfoList = musicInfoService.getMusicInfoFromPageByParamsAndNullPointTime(musicInfo, nowPage, pageSize);
                releaseTimeNull = true;
            } else {
                musicInfoList = musicInfoService.getMusicInfoFromPageByParamsAndPointTime(musicInfo, nowPage, pageSize);
            }
            if (musicInfoList.isEmpty()) {
                return RespPageDataBean.warning(ActionMsg.QUERY_SUCCESS_BY_EMPTY, 0, 0, pageSize, nowPage, null);
            }
            if (releaseTimeNull) {
                return RespPageDataBean.success(ActionMsg.QUERY_SUCCESS, musicInfoList.size(), musicInfoService.getMusicInfoTableCountByParamsAndNullPointTime(musicInfo), pageSize, nowPage, musicInfoList);
            } else {
                return RespPageDataBean.success(ActionMsg.QUERY_SUCCESS, musicInfoList.size(), musicInfoService.getMusicInfoTableCountByParamsAndPointTime(musicInfo), pageSize, nowPage, musicInfoList);
            }

        }
    }

    @GetMapping("/music/getMusicInfoFromPageByParamsAndBetweenTime")
    public RespPageDataBean getMusicInfoFromPageByParamsAndBetweenTime(MusicInfo musicInfo, int nowPage, @RequestParam int pageSize, @RequestParam String startTime, @RequestParam String endTime) {
        if (nowPage == 0) {
            nowPage = 1;
        }
        if (pageSize == 0) {
            throw new DataIntegrityViolationException("pageSize不能为空或为0!");
        } else {
            if (startTime.isEmpty() || endTime.isEmpty()) {
                throw new DataIntegrityViolationException("startTime或endTime不能为空字符串!");
            } else {
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    sdf.parse(startTime);
                    sdf.parse(endTime);
                } catch (Exception e) {
                    throw new DataIntegrityViolationException("startTime或endTime日期格式错误!请保证格式为yyyy-MM-dd(0000-00-00)");
                }
                List<MusicInfo> musicInfoList = musicInfoService.getMusicInfoFromPageByParamsAndBetweenTime(musicInfo, nowPage, pageSize, startTime, endTime);
                if (musicInfoList.isEmpty()) {
                    return RespPageDataBean.warning(ActionMsg.QUERY_SUCCESS_BY_EMPTY, 0, 0, pageSize, nowPage, null);
                }
                return RespPageDataBean.success(ActionMsg.QUERY_SUCCESS, musicInfoList.size(), musicInfoService.getMusicInfoTableCountByParamsAndBetweenTime(musicInfo, startTime, endTime), pageSize, nowPage, musicInfoList);
            }
        }
    }

    @DeleteMapping("/music/deleteMusicInfoMultipleById")
    public RespPlainBean deleteMusicInfoMultipleById(@RequestBody List<Integer> id) {
        musicInfoService.deleteMusicInfoMultipleById(id);
        return RespPlainBean.success(ActionMsg.DELETE_SUCCESS);
    }

    @PostMapping("/music/addMusicInfo")
    public RespPlainBean addMusicInfo(@RequestBody MusicInfo musicInfo) {
        musicInfoService.addMusicInfo(musicInfo);
        return RespPlainBean.success(ActionMsg.ADD_SUCCESS);
    }

    @PutMapping("/music/updateMusicInfoById")
    public RespPlainBean updateMusicInfoById(@RequestBody MusicInfo musicInfo) {
        if (musicInfoService.getMusicInfoCountById(musicInfo.getId()) == 0) {
            throw new DataIntegrityViolationException("该歌曲不存在!请检查id是否传达正确！");
        }
        musicInfoService.updateMusicInfoById(musicInfo);
        return RespPlainBean.success(ActionMsg.UPDATE_SUCCESS);
    }
}
