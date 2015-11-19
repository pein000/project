package com.one.shop.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.one.shop.consts.ConstsVariable;
import com.one.shop.domain.Goods;
import com.one.shop.domain.Marker;
import com.one.shop.domain.Reward;
import com.one.shop.persistence.GoodsMapper;
import com.one.shop.persistence.MarkerMapper;
import com.one.shop.persistence.RevealedMapper;
import com.one.shop.persistence.RewardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pein on 2015/11/9.
 */
@Service
public class RevealService {

    private Logger LOGGER = LoggerFactory.getLogger(RevealService.class);

    @Autowired
    private GoodsMapper goodsMapper;

    @Autowired
    private MarkerMapper markerMapper;

    @Autowired
    private RewardMapper rewardMapper;

    @Autowired
    private RevealedMapper revealedMapper;

    /**
     * 1 查询网站商品购买最近100条记录时间（时分秒）总和 sumA
     * 2 当前商品的总人次 personB
     * 3 marker = sumA%personB+100001
     *
     * 插入中奖表
     * 更新商品表记录状态为已揭晓
     * 插入揭晓表
     */
    @Transactional
    public void revealGoods(){
        List<Goods> goodsList =  goodsMapper.findRevealingGoods();
        if (goodsList == null || goodsList.isEmpty()) {
            LOGGER.warn("no reveal goods found.");
            return;
        }
        int sumTime = goodsMapper.findSumTime();
        for (Goods goods : goodsList) {
            int totalAmount = goods.getTotalAmount();
            int marker = sumTime%totalAmount + ConstsVariable.MARKER_BASIC_VALUE;
            LOGGER.info("circle to reveal goods .marker = {},goods = {}",marker, goods);
            Marker param = new Marker();
            param.setGoodsId(goods.getId());
            param.setMarker(String.valueOf(marker));
            Marker rewardMarker = markerMapper.selectMarker(param);
            if (rewardMarker == null) {
                LOGGER.warn("no rewarded user found . rewardMarker = {}",rewardMarker);
                continue;
            }
            Reward reward = new Reward();
            reward.setUserId(rewardMarker.getUserId());
            reward.setGoodsId(rewardMarker.getGoodsId());
            reward.setMarker(String.valueOf(marker));
            rewardMapper.insertReward(reward);
            goodsMapper.updateGoodsToRevealed(goods.getId());
            revealedMapper.insertRevealed(goods.getId());

            LOGGER.info("reward created now . reward = {}",reward);
        }
    }
}
