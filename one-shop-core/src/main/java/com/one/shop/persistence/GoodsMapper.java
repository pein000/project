package com.one.shop.persistence;

import com.one.shop.domain.Goods;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by pein on 2015/11/9.
 */
public interface GoodsMapper {

    /**
     * 查询所有正在揭晓的商品
     * @return
     */
    @Select("select ID as id ,NAME as name ,DESCRIPTION as description,OUTLINE_URL as outlineUrl,TYPE as type,PRICE as price,TOTAL_AMOUNT as totalAmount,CUR_AMOUNT as curAmount,STATUS as status,CREATE_TIME as createTime from one_shop_goods where status = '1'")
    public List<Goods> findRevealingGoods();

    @Select("select sum(date_FORMAT(GOODS_TIME,'%H%i%s')) from one_goods_flow order by GOODS_TIME DESC limit 0,100")
    public int findSumTime();

    @Update("update one_shop_goods set status = '2' where id = #{id}")
    public void updateGoodsToRevealed(int id);
}
