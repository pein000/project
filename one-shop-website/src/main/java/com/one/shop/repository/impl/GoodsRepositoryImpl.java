package com.one.shop.repository.impl;

import com.one.shop.enums.GoodsStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
public class GoodsRepositoryImpl{

    private static Logger logger = LoggerFactory.getLogger(GoodsRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    public void addQuantity(int goodsId, int quantity) {
        String sql = "update one_shop_goods\n" +
                "set cur_amount =  cur_amount + " + quantity + "," +
                "status = case when  cur_amount + " + quantity + " >= total_amount then "+ GoodsStatus.ING.getCode()+" else status end \n" +
                "where id = "+goodsId;

        Query q = em.createNativeQuery(sql);
        q.executeUpdate();
    }

}
