package com.one.shop.domain;

import com.one.shop.entity.User;

/**
 * Created by pein on 2015/11/18.
 */
public class FullUser {

    private int id;

    private String name;

    private String password;

    private String isDeleted;
    /**
     * 创建时间
     **/
    private String createDate;
    /**
     * 用户的角色集合，以","隔开
     */
    private String roles;

    public FullUser(User user, String roles) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.isDeleted = user.getIsDeleted();
        this.createDate = user.getCreateDate();
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
