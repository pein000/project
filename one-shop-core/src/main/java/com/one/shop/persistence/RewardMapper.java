package com.one.shop.persistence;

import com.one.shop.domain.Reward;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by pein on 2015/11/9.
 */
public interface RewardMapper {

    @Insert("insert into one_shop_reward(USER_ID,GOODS_ID,MARKER,CREATE_TIME)values(#{userId},#{goodsId},#{marker},now());")
    public void insertReward(Reward reward);

}
