package com.jiker.authentication.service.impl;

import com.jiker.authentication.dao.domain.UserOrgs;
import com.jiker.authentication.dao.mapper.UserOrgsMapper;
import com.jiker.authentication.service.UserOrgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserOrgsServiceImpl implements UserOrgsService {
    @Autowired
    private UserOrgsMapper userOrgsMapper;

    @Override
    public UserOrgs getUserOrgs(String userName) {
        UserOrgs userOrgs = userOrgsMapper.select(userName);
        return userOrgs;
    }

    @Override
    public List<UserOrgs> getUserOrgsList() {
        List<UserOrgs> userOrgsList = userOrgsMapper.selectList();
        return userOrgsList;
    }
}
