package com.example.carbonproject.service;

import com.example.carbonproject.entity.MusicInfo;
import com.example.carbonproject.mapper.DataVisualizationMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DataVisualizationService {
    private final DataVisualizationMapper dataVisualizationMapper;
    private final MusicInfoService musicInfoService;

    public DataVisualizationService(DataVisualizationMapper dataVisualizationMapper, MusicInfoService musicInfoService) {
        this.dataVisualizationMapper = dataVisualizationMapper;
        this.musicInfoService = musicInfoService;
    }

    public List<List<Object>> convetHashMapToList(List<LinkedHashMap<String, Integer>> data) {
        try {
            List<List<Object>> result = new ArrayList<>();

            List<Object> propList = new ArrayList<>();
            for (Map.Entry<String, Integer> entry : data.get(0).entrySet()) {
                propList.add(entry.getKey());
            }
            result.add(propList);

            for (LinkedHashMap<String, Integer> lineData : data) {
                List<Object> valueList = new ArrayList<>();
                for (Map.Entry<String, Integer> entry : lineData.entrySet()) {
                    valueList.add(entry.getValue());
                }
                result.add(valueList);
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public List<?> getLanguageCount() {
        List<LinkedHashMap<String, Integer>> data = dataVisualizationMapper.getLanguageCount();
        return convetHashMapToList(data);
    }

    public List<?> getLanguageCountFilter() {
        List<LinkedHashMap<String, Integer>> data = dataVisualizationMapper.getLanguageCountFilter();
        return convetHashMapToList(data);
    }

    public List<?> getMusicBpmByLanguage(String language) {
        List<LinkedHashMap<String, Integer>> data = dataVisualizationMapper.getMusicBpmByLanguage(language);
        return convetHashMapToList(data);
    }

    public List<?> getGenreCount() {
        List<LinkedHashMap<String, Integer>> data = dataVisualizationMapper.getGenreCount();
        return convetHashMapToList(data);
    }

    public List<?> getIntervalCount() {
        List<LinkedHashMap<String, Integer>> data = dataVisualizationMapper.getIntervalCount();
        return convetHashMapToList(data);
    }

    public List<?> getMusicVolumeAnalysis() {
        MusicInfo musicInfo = new MusicInfo();
        List<MusicInfo> musicInfoList = musicInfoService.getMusicInfoList(musicInfo, null, null, 1, null);

        LinkedHashMap<String, Integer> artistMap = new LinkedHashMap<>();
        musicInfoList.forEach(musicInfo1 -> {
            if (Objects.equals(musicInfo1.getLanguage(), "日语")) {
                String[] artistSplit = musicInfo1.getArtist().split(" / ");
                for (String artist : artistSplit) {
                    artistMap.put(artist, artistMap.getOrDefault(artist, 1) + 1);
                }
            }
        });
        List<Map.Entry<String, Integer>> artistSortList = new ArrayList<>(artistMap.entrySet());
        artistSortList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        List<Object> result = new ArrayList<>();

        List<String> propList = new ArrayList<>();
        List<String> artistList = new ArrayList<>();

        propList.add("不同时长响度");
        for (int i = 0; i < 4; i++) {
            artistList.add(artistSortList.get(i).getKey());
            List<LinkedHashMap<String, Integer>> volumeMap = dataVisualizationMapper.getAvgVolumeByArtistFromInterval(artistSortList.get(i).getKey());
            for (LinkedHashMap<String, Integer> volume : volumeMap) {

            }
//            result.add(volumeMap);
        }
        System.out.println(artistList);
//        LinkedHashMap<String,Integer> timeBetween = dataVisualizationMapper.getIntervalBetweenByArtists(artistList);
        propList.addAll(artistList);
        result.add(propList);

        LinkedHashMap<String, Integer> volumeObject = dataVisualizationMapper.getAvgVolumeByArtistAndInterval("初音未来", 4);
        result.add(volumeObject);
        return result;
    }
}
