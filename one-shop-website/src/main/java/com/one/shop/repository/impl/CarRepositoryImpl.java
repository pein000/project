package com.one.shop.repository.impl;

import com.one.shop.domain.FullCar;
import com.one.shop.enums.Active;
import com.one.shop.enums.TradePath;
import com.one.shop.enums.TradeType;
import com.one.shop.util.RepositoryUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/10/22.
 */
@Repository
public class CarRepositoryImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    public List<FullCar> findFullCarByUserId(int userId) {

        String sql = "select " +
                "car.id," +
                "car.user_id as userId," +
                "car.goods_id as goodsId," +
                "car.quantity as quantity," +
                "car.active as active, " +
                "goods.name as name," +
                "goods.description as description," +
                "goods.outline_url as outlineUrl," +
                "goods.type as type," +
                "goods.price as price," +
                "goods.total_amount as totalAmount," +
                "goods.cur_amount as curAmount\n" +
                "from one_shop_car car join one_shop_goods goods on car.goods_id = goods.id where user_id ="+userId;

        Query q = em.createNativeQuery(sql);
        List<Object[]> objects = q.getResultList();

        if (objects == null || objects.isEmpty()) {
            logger.info("user {} has no goods in car now",userId);
            return null;
        }

        List<FullCar> fullCarList = new ArrayList<FullCar>();
        for (Object[] objectList : objects) {
            int id = RepositoryUtils.resolveNullToInteger(objectList[0]);
            int userIdc = RepositoryUtils.resolveNullToInteger(objectList[1]);
            int goodsId = RepositoryUtils.resolveNullToInteger(objectList[2]);
            int quantity = RepositoryUtils.resolveNullToInteger(objectList[3]);
            String active = RepositoryUtils.resolveNullToString(objectList[4]);
            String name = RepositoryUtils.resolveNullToString(objectList[5]);
            String description = RepositoryUtils.resolveNullToString(objectList[6]);
            String outlineUrl = RepositoryUtils.resolveNullToString(objectList[7]);
            int type = RepositoryUtils.resolveNullToInteger(objectList[8]);
            BigDecimal price = RepositoryUtils.resolveNullToBigDecimal(objectList[9]);
            int totalAmount =  RepositoryUtils.resolveNullToInteger(objectList[10]);
            int curAmount =  RepositoryUtils.resolveNullToInteger(objectList[11]);

            FullCar fullCar = new FullCar();
            fullCar.setId(id);
            fullCar.setUserId(userIdc);
            fullCar.setGoodsId(goodsId);
            fullCar.setQuantity(quantity);
            fullCar.setActive(active);
            fullCar.setName(name);
            fullCar.setDescription(description);
            fullCar.setOutlineUrl(outlineUrl);
            fullCar.setType(type);
            fullCar.setPrice(price);
            fullCar.setTotalAmount(totalAmount);
            fullCar.setCurAmount(curAmount);

            fullCarList.add(fullCar);
        }

        return fullCarList;

    }

    public void deleteCarByUserId(int userId) {
        String sql = "delete from one_shop_car where user_id = "+userId;

        Query q = em.createNativeQuery(sql);
        q.executeUpdate();
    }
}
