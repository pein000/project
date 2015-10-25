package com.one.shop.repository.impl;

import com.one.shop.domain.GoodsFlow;
import com.one.shop.util.RepositoryUtils;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public class GoodsFlowRepositoryImpl{

    @PersistenceContext
    private EntityManager em;


    public List<GoodsFlow> findGoodsFlowByUserId(int userId) {
        String sql = "select " +
                "goods.name as name," +
                "goods.description as description," +
                "goods.outline_url as outlineUrl," +
                "goods.type as type," +
                "goods.price as price," +
                "goods.total_amount as totalAmount," +
                "goods.cur_amount as curAmount," +
                "flow.id as id," +
                "flow.user_id as userId," +
                "flow.goods_id as goodsId," +
                "flow.quantity as quantity," +
                "flow.goods_time as goodsTime\n" +
                "from one_shop_goods goods join one_goods_flow flow on goods.id = flow.goods_id where flow.user_id ="+userId;

        Query q = em.createNativeQuery(sql);
        List<Object[]> objects = q.getResultList();
        if (objects == null || objects.isEmpty()) {
            return null;
        }
        List<GoodsFlow> goodsFlowList = new ArrayList<GoodsFlow>();
        for (Object[] objectList : objects) {
            String name  = RepositoryUtils.resolveNullToString(objectList[0]);
            String description = RepositoryUtils.resolveNullToString(objectList[1]);
            String outlineUrl = RepositoryUtils.resolveNullToString(objectList[2]);
            int type = RepositoryUtils.resolveNullToInteger(objectList[3]);
            BigDecimal price = RepositoryUtils.resolveNullToBigDecimal(objectList[4]);
            int totalAmount = RepositoryUtils.resolveNullToInteger(objectList[5]);
            int curAmount = RepositoryUtils.resolveNullToInteger(objectList[6]);
            int id = RepositoryUtils.resolveNullToInteger(objectList[7]);
            int userIdc = RepositoryUtils.resolveNullToInteger(objectList[8]);
            int goodsId = RepositoryUtils.resolveNullToInteger(objectList[8]);
            int quantity = RepositoryUtils.resolveNullToInteger(objectList[10]);
            String goodsTime =  RepositoryUtils.resolveNullToString(objectList[11]);

            GoodsFlow goodsFlow = new GoodsFlow();
            goodsFlow.setName(name);
            goodsFlow.setDescription(description);
            goodsFlow.setOutlineUrl(outlineUrl);
            goodsFlow.setType(type);
            goodsFlow.setPrice(price);
            goodsFlow.setTotalAmount(totalAmount);
            goodsFlow.setCurAmount(curAmount);
            goodsFlow.setId(id);
            goodsFlow.setUserId(userIdc);
            goodsFlow.setGoodsId(goodsId);
            goodsFlow.setQuantity(quantity);
            goodsFlow.setGoodsTime(goodsTime);

            goodsFlowList.add(goodsFlow);
        }
        return  goodsFlowList;
    }

}
