package com.one.shop.entity;

import javax.persistence.*;

/**
 * Created by pein on 2015/11/16.
 */
@Entity()
@Table(name = "authority_permission")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    Integer id;
    /**
     * token
     **/
    @Column(name = "TAKEN")
    String token;
    /**
     * 资源url
     **/
    @Column(name = "URL")
    String url;
    /**
     * 权限说明
     **/
    @Column(name = "DESCRIPTION")
    String description;
    /**
     * 用户权限
     **/
    @Column(name = "PERMISSION")
    String permission;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
