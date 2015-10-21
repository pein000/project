package com.one.shop.repository.impl;

import com.one.shop.entity.GoodsEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/10/15.
 */
@Repository
public class HottestRepositoryImpl {

    @PersistenceContext
    private EntityManager em;

    public List<GoodsEntity> findHottestByPage(int page,int size) {

        String sql = "select g.id as id ,g.name,g.description,g.outline_url,g.type,g.price,g.total_amount,g.cur_amount,t.id as tId,t.goods_id " +
                "from one_shop_goods g  join one_shop_hottest t on g.id = t.goods_id limit "+page+" , "+size;
        Query q = em.createNativeQuery(sql);
        List<Object[]> objectList = q.getResultList();
        if (objectList == null || objectList.isEmpty()) {
            return null;
        }
        List<GoodsEntity> goodsEntityList = new ArrayList<GoodsEntity>();
        for (Object[] objects : objectList) {
            GoodsEntity goodsEntity = new GoodsEntity();
            goodsEntity.setId(Integer.parseInt(String.valueOf(objects[0])));
            goodsEntity.setName(String.valueOf(objects[1]));
            goodsEntity.setDescription(String.valueOf(objects[2]));
            goodsEntity.setOutlineUrl(String.valueOf(objects[3]));
            goodsEntity.setType(Integer.parseInt(String.valueOf(objects[4])));
            goodsEntity.setPrice(new BigDecimal(String.valueOf(objects[5])));
            goodsEntity.setTotalAmount(Integer.parseInt(String.valueOf(objects[6])));
            goodsEntity.setCurAmount(Integer.parseInt(String.valueOf(objects[7])));

            goodsEntityList.add(goodsEntity);
        }
        return  goodsEntityList;
    }
}
