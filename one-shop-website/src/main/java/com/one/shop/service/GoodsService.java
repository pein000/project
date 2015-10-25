package com.one.shop.service;

import com.one.shop.domain.GoodsFlow;
import com.one.shop.repository.impl.GoodsFlowRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/10/25.
 */
@Service
public class GoodsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GoodsService.class);

    @Autowired
    private GoodsFlowRepositoryImpl goodsFlowRepository;

    public List<GoodsFlow> findGoodsFlowByUserId(int userId) {
        List<GoodsFlow> goodsFlowList = goodsFlowRepository.findGoodsFlowByUserId(userId);
        if (goodsFlowList == null || goodsFlowList.isEmpty()) {
            LOGGER.info("user {} has no goods flow ", userId);
            return null;
        }
        return goodsFlowList;
    }
}
