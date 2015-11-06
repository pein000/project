package com.one.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pein on 2015/11/4.
 */
@Entity()
@Table(name = "one_shop_newest")
public class NewGoods {
    @Id
    @Column(name="ID")
    private int id;

    @Column(name="GOODS_ID")
    private int goodsId;

    @Column(name = "CREATE_TIME")
    private String createTime;


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

}
