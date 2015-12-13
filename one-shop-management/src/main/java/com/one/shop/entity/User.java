package com.one.shop.entity;

import javax.persistence.*;

/**
 * Created by pein on 2015/10/11.
 */
@Entity()
@Table(name = "authority_user")
public class User {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PASSWORD")
    private String password;

    /**
     * 创建者ID
     */
    @Column(name = "CREATOR_ID")
    private String creatorId;

    /**
     * 创建者名称
     */
    @Column(name = "CREATOR_NAME")
    private String creatorName;

    @Column(name = "IS_DELETED")
    private String isDeleted;
    /**
     * 创建时间
     **/
    @Column(name = "CREATE_DATE")
    private String createDate;


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
}
