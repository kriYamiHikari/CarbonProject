package com.example.carbonproject.mapper;

import com.example.carbonproject.entity.MusicInfo;
import com.example.carbonproject.service.MusicInfoService;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface MusicInfoMapper {
    @Select("select count(*) from music_info")
    int getMusicInfoTableCount();

    @Select("select count(*) from music_info where title like concat('%', #{title}, '%') and artist like concat('%', #{artist}, '%') and language like concat('%', #{language}, '%') and description like concat('%', #{description}, '%') and release_time = #{releaseTime}")
    int getMusicInfoTableCountByParamsAndPointTime(MusicInfo musicInfo);

    @Select("select count(*) from music_info where title like concat('%', #{title}, '%') and artist like concat('%', #{artist}, '%') and language like concat('%', #{language}, '%') and description like concat('%', #{description}, '%')")
    int getMusicInfoTableCountByParamsAndNullPointTime(MusicInfo musicInfo);

    @Select("select count(*) from music_info where title like concat('%', #{musicInfo.title}, '%') and artist like concat('%', #{musicInfo.artist}, '%') and language like concat('%', #{musicInfo.language} ,'%') and description like concat('%', #{musicInfo.description}, '%') and release_time between #{startTime} and #{endTime}")
    int getMusicInfoTableCountByParamsAndBetweenTime(MusicInfo musicInfo, String startTime, String endTime);

    @Select("select count(*) from music_info where id = #{id}")
    int getMusicInfoCountById(int id);

    @Select("select * from music_info limit #{offset},#{pageSize}")
    List<MusicInfo> getMusicInfoFromPage(int offset, int pageSize);

    @Select("select * from music_info where title like concat('%', #{musicInfo.title}, '%') and artist like concat('%', #{musicInfo.artist}, '%') and language like concat('%', #{musicInfo.language}, '%') and description like concat('%', #{musicInfo.description}, '%') and release_time = #{musicInfo.releaseTime} limit #{offset}, #{pageSize}")
    List<MusicInfo> getMusicInfoFromPageByParamsAndPointTime(MusicInfo musicInfo, int offset, int pageSize);

    @Select("select * from music_info where title like concat('%', #{musicInfo.title}, '%') and artist like concat('%', #{musicInfo.artist}, '%') and language like concat('%', #{musicInfo.language}, '%') and description like concat('%', #{musicInfo.description}, '%') limit #{offset}, #{pageSize}")
    List<MusicInfo> getMusicInfoFromPageByParamsAndNullPointTime(MusicInfo musicInfo, int offset, int pageSize);


    @Select("select * from music_info where title like concat('%', #{musicInfo.title}, '%') and artist like concat('%', #{musicInfo.artist}, '%') and language like concat('%', #{musicInfo.language} ,'%') and description like concat('%', #{musicInfo.description}, '%') and release_time between #{startTime} and #{endTime} limit #{offset},#{pageSize}")
    List<MusicInfo> getMusicInfoFromPageByParamsAndBetweenTime(MusicInfo musicInfo, int offset, int pageSize, String startTime, String endTime);

    void deleteMusicInfoMultipleById(List<Integer> ids);

    @Insert("insert into music_info (title, artist, language, description, release_time) values (#{title}, #{artist}, #{language}, #{description}, #{releaseTime})")
    void addMusicInfo(MusicInfo musicInfo);


    @Update("update music_info set title = #{title}, artist = #{artist}, language = #{language}, description = #{description}, release_time = #{releaseTime} where id = #{id}")
    void updateMusicInfoById(MusicInfo musicInfo);
}
