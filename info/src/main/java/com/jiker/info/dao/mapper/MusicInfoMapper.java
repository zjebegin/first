package com.jiker.info.dao.mapper;

import com.jiker.info.dao.domain.MusicInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MusicInfoMapper {
   @ResultMap("BaseResultMap")
   @Select("select * from music_info")
    List<MusicInfo> selectAll(MusicInfo musicInfo);
   @Delete("delete from music_info")
   int deleteAll();
}
