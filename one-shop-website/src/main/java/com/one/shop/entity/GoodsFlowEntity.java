package com.one.shop.entity;

import javax.persistence.*;

/**
 * Created by pein on 2015/10/21.
 */
@Entity()
@Table(name = "one_goods_flow")
public class GoodsFlowEntity {
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

    @Column(name="GOODS_TIME")
    private String goodsTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getGoodsTime() {
        return goodsTime;
    }

    public void setGoodsTime(String goodsTime) {
        this.goodsTime = goodsTime;
    }
}
