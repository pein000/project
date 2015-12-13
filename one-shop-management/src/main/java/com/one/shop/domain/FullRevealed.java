package com.one.shop.domain;

import java.math.BigDecimal;

/**
 * Created by pein on 2015/11/23.
 */
public class FullRevealed{

    /**
     * reward表
     */

    private String rewardMarker;

    /**
     * user表
     */
    private int userId;
    private String userName;

    private String userSign;

    private String userPhone;

    private String userEmail;

    private String userAddress;

    /**
     * 商品表
     */

    private int goodsId;

    private String goodsName;

    private String goodsDescription;

    private int goodsType;

    private BigDecimal goodsPrice;

    private int goodsTotalAmount;

    private int goodsCurAmount;

    private String goodsStatus;


    public String getRewardMarker() {
        return rewardMarker;
    }

    public void setRewardMarker(String rewardMarker) {
        this.rewardMarker = rewardMarker;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSign() {
        return userSign;
    }

    public void setUserSign(String userSign) {
        this.userSign = userSign;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDescription() {
        return goodsDescription;
    }

    public void setGoodsDescription(String goodsDescription) {
        this.goodsDescription = goodsDescription;
    }

    public int getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(int goodsType) {
        this.goodsType = goodsType;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsTotalAmount() {
        return goodsTotalAmount;
    }

    public void setGoodsTotalAmount(int goodsTotalAmount) {
        this.goodsTotalAmount = goodsTotalAmount;
    }

    public int getGoodsCurAmount() {
        return goodsCurAmount;
    }

    public void setGoodsCurAmount(int goodsCurAmount) {
        this.goodsCurAmount = goodsCurAmount;
    }

    public String getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(String goodsStatus) {
        this.goodsStatus = goodsStatus;
    }
}
