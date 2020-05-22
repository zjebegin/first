package com.jiker.authentication.dao.mapper;

import com.jiker.authentication.dao.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface MainMapper {
    @ResultMap("loginInfoResultMap")
    @Select("select t1.user_name,t1.password,t2.role_name,t2.role_code " +
            "from auth_users t1,auth_roles t2,user_role t3 " +
            "where t1.user_id = t3.user_id and t2.role_id = t3.role_id")
    List<LoginInfo> selectLoginInfo();

    @ResultMap("userResultMap")
    @Select("select user_name from auth_users ")
    List<AuthUsers> selectUserList();

    @ResultMap("oauthClientDetailsResultMap")
    @Select("select * from oauth_client_details where client_id=#{clientId} ")
    OauthClientDetails selectOauthClientDetailsByClientId(String clientId);

    @ResultMap("oauthClientDetailsResultMap")
    @Select("select * from oauth_client_details ")
    List<OauthClientDetails> selectOauthClientDetails();

    @ResultMap("menuResultMap")
    @Select("select * from auth_menu ")
    List<AuthMenu> selectAuthMenuList();

    @ResultMap("roleResultMap")
    @Select("select * from auth_roles ")
    List<AuthRoles> selectRoleList();
}
