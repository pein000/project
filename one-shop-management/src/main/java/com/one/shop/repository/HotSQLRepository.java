package com.one.shop.repository;

import com.one.shop.domain.FullGoods;
import com.one.shop.entity.Goods;
import com.one.shop.repository.basic.SQLRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/11/4.
 */
@Repository
public class HotSQLRepository extends SQLRepository{

    public List<FullGoods> findAllDescTime() {
        String sql = "select \n" +
                "hot.id,\n" +
                "hot.goods_id,\n" +
                "hot.create_time,\n" +
                "goods.name,\n" +
                "goods.description,\n" +
                "goods.outline_url,\n" +
                "goods.type,\n" +
                "goods.price,\n" +
                "goods.total_amount,\n" +
                "goods.cur_amount,\n" +
                "goods.status \n" +
                "from one_shop_hottest hot join one_shop_goods goods on hot.goods_id = goods.id order by hot.create_time desc";
        Query query = getEntityManager().createNativeQuery(sql);
        List<Object[]> objects = query.getResultList();

        return buildFullHotGoodsList(objects);

    }


    public List<Goods> findGoodsNotHot() {
        String sql = "select \n" +
                "goods.ID,\n" +
                "goods.NAME,\n" +
                "goods.DESCRIPTION,\n" +
                "goods.OUTLINE_URL,\n" +
                "goods.TYPE,\n" +
                "goods.PRICE,\n" +
                "goods.TOTAL_AMOUNT,\n" +
                "goods.CUR_AMOUNT,\n" +
                "goods.STATUS,\n" +
                "goods.CREATE_TIME\n" +
                "from one_shop_hottest hot right join one_shop_goods goods \n" +
                "on hot.goods_id = goods.id \n" +
                "where hot.id is null\n" +
                "order by goods.create_time desc";
        Query query = getEntityManager().createNativeQuery(sql);
        List<Object[]> objects = query.getResultList();

        return buildGoodsList(objects);
    }


    private List<FullGoods> buildFullHotGoodsList(List<Object[]> objects) {
        if (objects == null || objects.isEmpty()) {
            return null;
        }

        List<FullGoods> fullGoodsList = new ArrayList<FullGoods>();
        for (Object[] objectList : objects) {
            fullGoodsList.add(buildFullDomain(objectList));
        }

        return fullGoodsList;
    }

    private List<Goods> buildGoodsList(List<Object[]> objects) {
        if (objects == null || objects.isEmpty()) {
            return null;
        }
        List<Goods> goodsList = new ArrayList<Goods>();
        for (Object[] objectList : objects) {
            goodsList.add(buildGoodsDomain(objectList));
        }

        return goodsList;
    }

}
