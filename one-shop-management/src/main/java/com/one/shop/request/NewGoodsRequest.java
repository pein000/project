package com.one.shop.request;

import com.one.shop.entity.NewGoods;

/**
 * Created by pein on 2015/11/5.
 */
public class NewGoodsRequest {

    NewGoods[] newGoodses;

    public NewGoods[] getNewGoodses() {
        return newGoodses;
    }

    public void setNewGoodses(NewGoods[] newGoodses) {
        this.newGoodses = newGoodses;
    }
}
