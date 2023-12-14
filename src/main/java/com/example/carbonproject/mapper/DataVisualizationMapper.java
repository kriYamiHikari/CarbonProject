package com.example.carbonproject.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@Mapper
public interface DataVisualizationMapper {
    List<LinkedHashMap<String, Integer>> getLanguageCount();

    List<LinkedHashMap<String, Integer>> getLanguageCountFilter();

    List<LinkedHashMap<String, Integer>> getMusicBpmByLanguage(String language);

    List<LinkedHashMap<String, Integer>> getGenreCount();

    List<LinkedHashMap<String, Integer>> getIntervalCount();

    List<LinkedHashMap<String, Integer>> getAvgVolumeByArtistFromInterval(String artist);

    LinkedHashMap<String, Integer> getAvgVolumeByArtistAndInterval(String artist, Integer interval);

    LinkedHashMap<String, Integer> getIntervalBetweenByArtists(List<String> artists);
}
