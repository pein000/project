package com.one.shop.request;

import com.one.shop.entity.HotGoods;

/**
 * Created by pein on 2015/11/5.
 */
public class HotGoodsRequest {

    HotGoods[] hotGoodses;

    public HotGoods[] getHotGoodses() {
        return hotGoodses;
    }

    public void setHotGoodses(HotGoods[] hotGoodses) {
        this.hotGoodses = hotGoodses;
    }
}
