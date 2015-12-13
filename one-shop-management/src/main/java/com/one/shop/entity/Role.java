package com.one.shop.entity;

import javax.persistence.*;

/**
 * Created by pein on 2015/11/16.
 */
@Entity
@Table(name = "authority_role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    int id;
    /**
     * 角色名
     **/
    @Column(name = "NAME")
    String name;
    /**
     * 角色说明
     **/
    @Column(name = "DESCRIPTION")
    String description;

    /**
     * 创建者ID
     */
    @Column(name = "CREATOR_ID")
    String creatorId;

    /**
     * 创建者名称
     */
    @Column(name = "CREATOR_NAME")
    String creatorName;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    String createTime;


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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
}
