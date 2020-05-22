package com.jiker.authentication.service.impl;

import com.jiker.authentication.dao.domain.*;
import com.jiker.authentication.dao.mapper.MainMapper;
import com.jiker.authentication.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MainServiceImpl implements MainService {
    @Autowired
    private MainMapper mainMapper;

    @Override
    public List<LoginInfo> getLoginInfoList() {
        return mainMapper.selectLoginInfo();
    }

    @Override
    public List<AuthUsers> getUserList() {
        return mainMapper.selectUserList();
    }

    @Override
    public List<OauthClientDetails> getOauthClientDetails() {
        return mainMapper.selectOauthClientDetails();
    }

    @Override
    public List<AuthMenu> getMenuList() {
        return mainMapper.selectAuthMenuList();
    }

    @Override
    public List<AuthRoles> getRoleList() {
        return  mainMapper.selectRoleList();
    }
}
