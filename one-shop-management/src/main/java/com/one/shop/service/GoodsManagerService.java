package com.one.shop.service;

import com.one.shop.entity.Goods;
import com.one.shop.repository.GoodsQueryDslRepository;
import com.one.shop.request.GoodsRequest;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/10/29.
 */
@Service
public class GoodsManagerService {

    private Logger LOGGER = LoggerFactory.getLogger(GoodsManagerService.class);

    @Value("${goods.page.size}")
    private int pageSize;

    @Autowired
    private GoodsQueryDslRepository goodsQueryDslRepository;


    public List<Goods> pageableGoods(GoodsRequest goodsRequest) {
//        Page<Goods> goodsPage = getGoodsPage(page, size);
//        List<Goods> goodsList = goodsPage.getContent();
        List<Goods> goodsList = goodsQueryDslRepository.pageQuery(goodsRequest,pageSize);

        if (goodsList == null || goodsList.isEmpty()) {
            LOGGER.warn("no goods found by pageable. GoodsRequest = {}", JSONUtils.toJson(goodsRequest));
            return null;
        }
        LOGGER.info("the goods List by pageable .GoodsRequest = {}", JSONUtils.toJson(goodsList));
        return goodsList;
    }

    public int getPageableSize(GoodsRequest goodsRequest) {
        Long count = goodsQueryDslRepository.countQuery(goodsRequest);
        if (count == null || count == 0) {
            LOGGER.warn("no goods found by pageable. GoodsRequest = {}", JSONUtils.toJson(goodsRequest));
            return 0;
        }
        int totalPage =  count.intValue()%pageSize==0?count.intValue()/pageSize:count.intValue()/pageSize+1;
        LOGGER.info("the goods count by pageable .count  = {},totalPage = {}", count,totalPage);

        return totalPage;
    }

    public Goods findGoodsById(int id){
       Goods goods =  goodsQueryDslRepository.findGoodsById(id);
        if (goods == null) {
            LOGGER.warn("no goods has found by id . id = {}", id);
        }
        LOGGER.info("found a goods by id . goods = {}", JSONUtils.toJson(goods));
        return goods;
    }

    public Goods updateGoods(Goods goods){
        goodsQueryDslRepository.updateGoods(goods);
        LOGGER.info("success to update goods . goods = {}",JSONUtils.toJson(goods));
        return goods;
    }

    public Goods saveGoods(Goods goods) {
        goodsQueryDslRepository.save(goods);
        LOGGER.info("success to save goods . goods = {}", JSONUtils.toJson(goods));
        return goods;
    }

    public void deleteGoodsById(int id) {
        goodsQueryDslRepository.deleteGoods(id);
        LOGGER.info("success to delete goods by id  . id = {}", id);
    }

//    public int getPageableSize(int page, int size) {
//        Page<Goods> goodsPage = getGoodsPage(page, size);
//        return goodsPage.getTotalPages();
//    }
//
//    private Page<Goods> getGoodsPage(int page, int size) {
//        Pageable request = new PageRequest(page, size, Direction.DESC, "createTime");
//        return goodsRepository.findAll(request);
//    }

}
