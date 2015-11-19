package com.one.shop.persistence;

import org.apache.ibatis.annotations.Insert;

/**
 * Created by pein on 2015/11/9.
 */
public interface RevealedMapper {

    @Insert("insert into one_shop_revealed(GOODS_ID,CREATE_TIME)values(#{goodsId},now());")
    public void insertRevealed(int  goodsId);

}
