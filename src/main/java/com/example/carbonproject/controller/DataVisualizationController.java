package com.example.carbonproject.controller;

import com.example.carbonproject.entity.response.RespDataBean;
import com.example.carbonproject.service.DataVisualizationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dataVisualization")
public class DataVisualizationController {
    private final DataVisualizationService dataVisualizationService;

    public DataVisualizationController(DataVisualizationService dataVisualizationService) {
        this.dataVisualizationService = dataVisualizationService;
    }


    @GetMapping("/getLanguageCount")
    public ResponseEntity<RespDataBean> getLanguageCount() {
        Object data = dataVisualizationService.getLanguageCount();
        return RespDataBean.success("获取成功", data);
    }

    @GetMapping("/getLanguageCountFilter")
    public ResponseEntity<RespDataBean> getLanguageCountFilter() {
        Object data = dataVisualizationService.getLanguageCountFilter();
        return RespDataBean.success("获取成功", data);
    }

    @GetMapping("/getMusicBpmByLanguage")
    public ResponseEntity<RespDataBean> getMusicBpmByLanguage(String language) {
        Object data = dataVisualizationService.getMusicBpmByLanguage(language);
        return RespDataBean.success("获取成功", data);
    }

    @GetMapping("/getGenreCount")
    public ResponseEntity<RespDataBean> getGenreCount() {
        Object data = dataVisualizationService.getGenreCount();
        return RespDataBean.success("获取成功", data);
    }

    @GetMapping("/getIntervalCount")
    public ResponseEntity<RespDataBean> getIntervalCount() {
        Object data = dataVisualizationService.getIntervalCount();
        return RespDataBean.success("获取成功", data);
    }

    @GetMapping("/getMusicVolumeAnalysis")
    public ResponseEntity<RespDataBean> getMusicVolumeAnalysis() {
        Object data = dataVisualizationService.getMusicVolumeAnalysis();
        return RespDataBean.success("获取成功", data);
    }
}
