package com.one.shop.entity;

import com.mysql.jdbc.V1toV2StatementInterceptorAdapter;
import org.hibernate.annotations.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pein on 2015/10/11.
 */
@Entity()
@Table(name = "one_shop_user")
public class UserEntity {

    @Id
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SIGN")
    private String sign;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHOTO_URL")
    private String photoUrl;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "POINT_ID")
    private String pointId;//积分Id

    @Column(name = "CASH_ACCOUNT_ID")
    private String cashAccountId;//现金账户Id

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPointId() {
        return pointId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public String getCashAccountId() {
        return cashAccountId;
    }

    public void setCashAccountId(String cashAccountId) {
        this.cashAccountId = cashAccountId;
    }
}
