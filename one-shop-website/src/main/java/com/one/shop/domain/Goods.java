package com.one.shop.domain;


import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/13.
 */
public class Goods {
    private int id;

    private String name;

    private String description;

    private String outlineUrl;

    private int type;

    private BigDecimal price;

    private int totalAmount;

    private int curAmount;

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
}
