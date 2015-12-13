package com.one.shop.repository;

import com.one.shop.domain.FullRevealed;
import com.one.shop.repository.basic.SQLRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by pein on 2015/11/4.
 */
@Repository
public class RevealedSQLRepository extends SQLRepository {

    public FullRevealed findFullRevealedById(int id) {
        String sql = "select \n" +
                "w.marker AS rewardMarker,\n" +
                "u.ID AS userId,\n" +
                "u.NAME AS userName,\n" +
                "u.SIGN AS userSign,\n" +
                "u.PHONE AS userPhone,\n" +
                "u.EMAIL AS userEmail,\n" +
                "u.ADDRESS AS userAddress,\n" +
                "g.ID AS goodsId,\n" +
                "g.NAME AS goodsName,\n" +
                "g.DESCRIPTION AS goodsDescription,\n" +
                "g.TYPE AS goodsType,\n" +
                "g.PRICE AS goodsPrice,\n" +
                "g.TOTAL_AMOUNT AS goodsTotalAmount,\n" +
                "g.CUR_AMOUNT AS goodsCurAmount,\n" +
                "g.STATUS AS goodsStatus\n" +
                "from one_shop_revealed v\n" +
                "join one_shop_reward w\n" +
                "join one_shop_goods g\n" +
                "join one_shop_user u\n" +
                "on v.GOODS_ID = g.ID\n" +
                "and w.GOODS_ID = g.ID\n" +
                "and w.USER_ID = u.ID\n" +
                "where v.ID = " + id;

        Query query = getEntityManager().createNativeQuery(sql);
        List<Object[]> objects = query.getResultList();

        return buildFullRevealedDomain(objects.get(0));

    }

}
