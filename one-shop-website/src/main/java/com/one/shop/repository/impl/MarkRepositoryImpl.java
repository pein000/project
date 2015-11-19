package com.one.shop.repository.impl;

import com.one.shop.entity.MarkerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by pein on 2015/10/22.
 */
@Repository
public class MarkRepositoryImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    public void insertMark(List<MarkerEntity> markerEntityList){
        String sql = "insert into one_shop_mark(USER_ID,GOODS_ID,MARKER,CREATE_TIME) values";
        if (markerEntityList == null || markerEntityList.isEmpty()) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(sql);
        for (MarkerEntity markerEntity : markerEntityList) {
            sb.append("(")
                    .append(markerEntity.getUserId()).append(",")
                    .append(markerEntity.getGoodsId()).append(",")
                    .append("'").append(markerEntity.getMarker()).append("'").append(",")
                    .append("'").append(markerEntity.getCreateTime()).append("'").append(")")
                    .append(",");
        }
        sb.delete(sb.length()-1, sb.length());
        em.createNativeQuery(sb.toString()).executeUpdate();
    }

}
