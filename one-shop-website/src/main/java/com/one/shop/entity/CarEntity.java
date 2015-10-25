package com.one.shop.entity;

import com.one.shop.enums.Active;

import javax.persistence.*;

/**
 * Created by pein on 2015/10/21.
 */
@Entity()
@Table(name = "one_shop_car")
public class CarEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID")
    private int id;

    @Column(name="USER_ID")
    private int userId;

    @Column(name="GOODS_ID")
    private int goodsId;

    @Column(name="QUANTITY")
    private int quantity;

    @Column(name="ACTIVE")
    private String active;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
