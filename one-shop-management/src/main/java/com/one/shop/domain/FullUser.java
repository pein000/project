package com.one.shop.domain;

import com.one.shop.entity.User;

/**
 * Created by pein on 2015/11/18.
 */
public class FullUser {

    private int id;

    private String name;

    private String password;
    /**
     * 创建者ID
     */
    private String creatorId;

    /**
     * 创建者名称
     */
    private String creatorName;

    private String isDeleted;
    /**
     * 创建时间
     **/
    private String createDate;
    /**
     * 用户的角色集合，以","隔开
     */
    private String roles;

    public FullUser() {
    }

    public FullUser(User user, String roles) {
        this.id = user.getId();
        this.name = user.getName();
        this.password = user.getPassword();
        this.creatorId = user.getCreatorId();
        this.creatorName = user.getCreatorName();
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

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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
