package com.one.shop.domain;

import java.math.BigDecimal;

/**
 * Created by pein on 2015/11/5.
 */
public class FullGoods {
    private int id;

    private int goodsId;

    private String createTime;

    private String name;

    private String description;

    private String outlineUrl;

    private int type;

    private BigDecimal price;

    private int totalAmount;

    private int curAmount;

    private String status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getOutlineUrl() {
        return outlineUrl;
    }

    public void setOutlineUrl(String outlineUrl) {
        this.outlineUrl = outlineUrl;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getCurAmount() {
        return curAmount;
    }

    public void setCurAmount(int curAmount) {
        this.curAmount = curAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
