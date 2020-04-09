package com.jiker.authentication.dao.mapper;

import com.jiker.authentication.dao.domain.UserOrgs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserOrgsMapper {
    @ResultMap("BaseResultMap")
    @Select("select * from user_orgs where user_name=#{userName}")
    UserOrgs select(String userName);

    @ResultMap("BaseResultMap")
    @Select("select * from user_orgs")
    List<UserOrgs> selectList();
}
