package com.jiker.authentication.web;

import com.jiker.authentication.dao.domain.AuthMenu;
import com.jiker.authentication.dao.domain.AuthRoles;
import com.jiker.authentication.dao.domain.AuthUsers;
import com.jiker.authentication.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@Controller
//@RestController
public class MainController {
    private static final String INDEX = "index";
    @Autowired
    private MainService mainService;

    @Autowired
    private UserDetailsService userService;

    @RequestMapping("/userList")
    @ResponseBody
    public List<AuthUsers> getUserList() {
        List<AuthUsers> userList = mainService.getUserList();
        return userList;
    }
    @RequestMapping("/login")
    public String getIndex() {
        System.out.println("in index");
        return INDEX;
    }
    @ResponseBody
    @RequestMapping("/userPage")
    public Object getUserPage() {
        List<AuthUsers> userList = mainService.getUserList();
        System.out.println(userList.get(0).getUserName());
        return userList;
    }
    @ResponseBody
    @RequestMapping("/rolePage")
    public Object getRolePage() {
        List<AuthRoles> roleList = mainService.getRoleList();
        System.out.println(roleList.get(0).getRoleName());
        return roleList;
    }
    @RequestMapping("/auth")
    public String getMenuPage() {
        return "menuMng";
    }
    @ResponseBody
    @RequestMapping("/menus")
    public Object getMenus() {
        List<AuthMenu> menuList = mainService.getMenuList();
        System.out.println(menuList.get(0).getMenuUrl());
        return menuList;
    }
}
