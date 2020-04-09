package com.jiker.authentication.service;

import com.jiker.authentication.dao.domain.UserOrgs;

import java.util.List;

public interface UserOrgsService {
    public UserOrgs getUserOrgs(String userName);
    public List<UserOrgs> getUserOrgsList();
}
