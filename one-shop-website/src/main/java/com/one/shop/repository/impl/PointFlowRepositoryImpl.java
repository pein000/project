package com.one.shop.repository.impl;

import com.one.shop.entity.PointFlowEntity;
import com.one.shop.enums.IncomePath;
import com.one.shop.enums.PointType;
import com.one.shop.util.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
public class PointFlowRepositoryImpl {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    public List<PointFlowEntity> findPointFlowByPage(int page, int size, int userId) {

        String sql = "select flow.ID, POINT_ID, flow.AMOUNT, INCOME_PATH, POINT_TYPE, POINT_TIME " +
                "from one_account_point point join one_point_flow flow on point.id = flow.point_id " +
                "where point.user_id = " + userId + " limit " + page + "," + size;

        Query q = em.createNativeQuery(sql);
        List<Object[]> objects = q.getResultList();
        if (objects == null || objects.isEmpty()) {
            logger.info("no cash flow found . page ={}, size = {}, userId = {}", page, size, userId);
            return null;
        }

        List<PointFlowEntity> pointFlowEntityList = new ArrayList<PointFlowEntity>();
        for (Object[] objectList : objects) {
            int id = objectList[0] == null ? null : Integer.parseInt(String.valueOf(objectList[0]));
            int pointId = objectList[1] == null ? null : Integer.parseInt(String.valueOf(objectList[1]));
            BigDecimal amount = objectList[2] == null ? null : new BigDecimal(String.valueOf(objectList[2]));
            IncomePath incomePath = objectList[3] == null ? null : IncomePath.valueOf(String.valueOf(objectList[3]));
            PointType pointType = objectList[4] == null ? null : PointType.valueOf(String.valueOf(objectList[4]));
            String pointTime = objectList[5] == null ? null : String.valueOf(objectList[5]);

            PointFlowEntity pointFlowEntity = new PointFlowEntity();
            pointFlowEntity.setId(id);
            pointFlowEntity.setPointId(pointId);
            pointFlowEntity.setAmount(amount);
            pointFlowEntity.setIncomePath(incomePath);
            pointFlowEntity.setPointType(pointType);
            pointFlowEntity.setPointTime(pointTime);

            pointFlowEntityList.add(pointFlowEntity);
        }

        return pointFlowEntityList;

    }

    public int findPointFlowCount(int userId) {
        String sql = "select count(flow.id) from one_account_point point " +
                "join one_point_flow flow on point.id = flow.point_id " +
                "where point.user_id = " + userId;

        Query q = em.createNativeQuery(sql);
        Object object = q.getSingleResult();
        if (object == null) {
            logger.info("no cash flow count found .userId = {}", userId);
            return 0;
        }
        return Integer.parseInt(String.valueOf(object));
    }
}
