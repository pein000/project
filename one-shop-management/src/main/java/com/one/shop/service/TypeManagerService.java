package com.one.shop.service;

import com.one.shop.domain.FullGoods;
import com.one.shop.entity.Goods;
import com.one.shop.entity.HotGoods;
import com.one.shop.entity.NewGoods;
import com.one.shop.repository.HotQueryDslRepository;
import com.one.shop.repository.HotSQLRepository;
import com.one.shop.repository.NewQueryDslRepository;
import com.one.shop.repository.NewSQLRepository;
import com.one.shop.util.DateUtils;
import com.one.shop.util.JSONUtils;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by pein on 2015/11/4.
 */
@Service
public class TypeManagerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TypeManagerService.class);

    @Autowired
    private HotSQLRepository hotSQLRepository;

    @Autowired
    private HotQueryDslRepository hotQueryDslRepository;

    @Autowired
    private NewSQLRepository newSQLRepository;

    @Autowired
    private NewQueryDslRepository newQueryDslRepository;

    public List<FullGoods> findAllHot(){
        List<FullGoods> hotGoodList = hotSQLRepository.findAllDescTime();
        if (hotGoodList == null || hotGoodList.isEmpty()) {
            LOGGER.warn("no hot goods found.");
            return null;
        }
        LOGGER.info("find all hot goods .hotGoodList = {}", JSONUtils.toJson(hotGoodList));

        return hotGoodList;
    }

    public List<Goods> findAllNotHotGoods() {
        List<Goods> goodsList = hotSQLRepository.findGoodsNotHot();
        if (goodsList == null || goodsList.isEmpty()) {
            LOGGER.warn("no not hot goods found.");
            return null;
        }
        LOGGER.info("find all not hot goods . goodsList = {}", JSONUtils.toJson(goodsList));
        return goodsList;
    }

    @Transactional
    public void updateHotGoodsList(List<HotGoods> hotGoodsList){
        LOGGER.info("begin to update hot goods all tables.");
        hotQueryDslRepository.deleteAll();
        ShopUtils.setProperties(hotGoodsList,"id","createTime", DateUtils.formatDate(new Date()));
        hotQueryDslRepository.save(hotGoodsList);
        LOGGER.info("update hot goods all tables success.");
    }


    public List<FullGoods> findAllNew(){
        List<FullGoods> newGoodList = newSQLRepository.findAllDescTime();
        if (newGoodList == null || newGoodList.isEmpty()) {
            LOGGER.warn("no new goods found.");
            return null;
        }
        LOGGER.info("find all new goods .newGoodList = {}", JSONUtils.toJson(newGoodList));

        return newGoodList;
    }

    public List<Goods> findAllNotNewGoods() {
        List<Goods> goodsList = newSQLRepository.findGoodsNotNew();
        if (goodsList == null || goodsList.isEmpty()) {
            LOGGER.warn("no not new goods found.");
            return null;
        }
        LOGGER.info("find all not new goods . goodsList = {}", JSONUtils.toJson(goodsList));
        return goodsList;
    }

    @Transactional
    public void updateNewGoodsList(List<NewGoods> newGoodsList){
        LOGGER.info("begin to update new goods all tables.");
        newQueryDslRepository.deleteAll();
        ShopUtils.setProperties(newGoodsList,"id","createTime", DateUtils.formatDate(new Date()));
        newQueryDslRepository.save(newGoodsList);
        LOGGER.info("update new goods all tables success.");
    }


}
