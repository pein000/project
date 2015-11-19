package com.one.shop.persistence;

import com.one.shop.domain.Marker;
import com.one.shop.domain.Reward;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

/**
 * Created by pein on 2015/11/9.
 */
public interface MarkerMapper {

    @Select("select ID as id,USER_ID as userId,GOODS_ID as goodsId,MARKER as marker,CREATE_TIME as createTime from one_shop_mark where GOODS_ID = #{goodsId} and MARKER = #{marker}")
    public Marker selectMarker(Marker param);

}
