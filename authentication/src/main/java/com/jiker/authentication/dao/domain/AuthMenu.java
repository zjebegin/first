package com.jiker.authentication.dao.domain;

import java.util.Date;

public class AuthMenu {
    private int menuId;
    private int parentId;
    private String menuName;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    private String menuUrl;
    private String remark;
    private Date createTime;
    private Date updateTime;

    public int getMenuId() {
        return menuId;
    }

    public int getParentId() {
        return parentId;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public String getRemark() {
        return remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
