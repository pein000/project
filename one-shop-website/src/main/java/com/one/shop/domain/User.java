package com.one.shop.domain;

/**
 * Created by pein on 2015/10/11.
 */
public class User {

    private int id;

    private String name;

    private String sign;

    private String password;

    private String phone;

    private String email;

    private String photoUrl;

    private String address;

    private String pointId;//积分Id

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

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public void setEmail(String email) {
        this.email = email;
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
