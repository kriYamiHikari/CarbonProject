package com.example.carbonproject.mapper;

import com.example.carbonproject.entity.MusicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MusicInfoMapper {
    @Select("select count(*) from music_info")
    int getMusicInfoTableCount();

    @Select("select * from music_info limit #{offset},#{pageSize}")
    List<MusicInfo> getMusicInfoFromPage(int offset, int pageSize);

    @Select("select * from music_info where title like concat('%', #{musicInfo.title}, '%') and artist like concat('%', #{musicInfo.artist}, '%') and language like concat('%', #{musicInfo.language}, '%') and description like concat('%', #{musicInfo.description}, '%') and release_time = #{musicInfo.releaseTime} limit #{offset}, #{pageSize}")
    List<MusicInfo> getMusicInfoFromPageByParamsAndPointTime(MusicInfo musicInfo, int offset, int pageSize);

    @Select("select * from music_info where title like concat('%', #{musicInfo.title}, '%') and artist like concat('%', #{musicInfo.artist}, '%') and language like concat('%', #{musicInfo.language}, '%') and description like concat('%', #{musicInfo.description}, '%') limit #{offset}, #{pageSize}")
    List<MusicInfo> getMusicInfoFromPageByParamsAndNullPointTime(MusicInfo musicInfo, int offset, int pageSize);


    @Select("select * from music_info where title like concat('%', #{musicInfo.title}, '%') and artist like concat('%', #{musicInfo.artist}, '%') and language like concat('%', #{musicInfo.language} ,'%') and description like concat('%', #{musicInfo.description}, '%') and release_time between #{startTime} and #{endTime} limit #{offset},#{pageSize}")
    List<MusicInfo> getMusicInfoFromPageByParamsAndBetweenTime(MusicInfo musicInfo, int offset, int pageSize, String startTime, String endTime);

    void deleteMusicInfoMultipleById(List<Integer> ids);
}
