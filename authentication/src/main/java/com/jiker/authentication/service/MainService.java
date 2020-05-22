package com.jiker.authentication.service;

import com.jiker.authentication.dao.domain.*;

import java.util.List;

public interface MainService {
    public List<LoginInfo> getLoginInfoList();
    public List<AuthUsers> getUserList();
    public List<OauthClientDetails> getOauthClientDetails();
    public List<AuthMenu> getMenuList();
    public List<AuthRoles> getRoleList();
}
