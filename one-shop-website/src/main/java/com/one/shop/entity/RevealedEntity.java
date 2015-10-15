package com.one.shop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by pein on 2015/10/13.
 */
@Entity()
@Table(name="one_shop_revealed")
public class RevealedEntity {
    @Id
    @Column(name="ID")
    private int id;

    @Column(name="GOODS_ID")
    private int goodsId;

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
}
