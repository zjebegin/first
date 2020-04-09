package com.jiker.authentication.web;

import com.jiker.authentication.dao.domain.UserOrgs;
import com.jiker.authentication.service.UserOrgsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
public class UserOrgsController {

    @Autowired
    private UserOrgsService userOrgsService;

    @RequestMapping(value = { "/user" }, produces = "application/json")
    public Map<String, Object> user(OAuth2Authentication user) {
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put("user", user.getUserAuthentication().getPrincipal());
        userInfo.put("authorities", AuthorityUtils.authorityListToSet(user.getUserAuthentication().getAuthorities()));
        return userInfo;
    }
    @RequestMapping("/userOrgs")
    @ResponseBody
    public UserOrgs getUserOrgs(String userName) {
        System.out.println("in controller userOrgs userName="+userName);
        UserOrgs userOrgs = userOrgsService.getUserOrgs(userName);
        return userOrgs;
    }
    @RequestMapping("/userOrgsList")
    @ResponseBody
    public List<UserOrgs> getUserOrgsList() {
        System.out.println("in controller userOrgsList");
        List<UserOrgs> userOrgsList = userOrgsService.getUserOrgsList();
        return userOrgsList;
    }
}
