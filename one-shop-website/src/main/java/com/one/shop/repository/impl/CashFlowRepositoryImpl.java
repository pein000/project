package com.one.shop.repository.impl;

import com.one.shop.entity.CashFlowEntity;
import com.one.shop.entity.GoodsEntity;
import com.one.shop.enums.TradePath;
import com.one.shop.enums.TradeType;
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
public class CashFlowRepositoryImpl{

    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    public List<CashFlowEntity> findCashFlowByPage(int page,int size,int userId) {

        String sql = "select flow.ID, CASH_ID, flow.AMOUNT, TRADE_TYPE, TRADE_PATH, TRADE_TIME " +
                "from one_account_cash cash join one_cash_flow flow on cash.id = flow.cash_id " +
                "where cash.user_id = "+userId+" limit "+page+","+size;

        Query q = em.createNativeQuery(sql);
        List<Object[]> objects = q.getResultList();
        if (objects == null || objects.isEmpty()) {
            logger.info("no cash flow found . page ={}, size = {}, userId = {}",page,size,userId);
            return null;
        }

        List<CashFlowEntity> cashFlowEntityList = new ArrayList<CashFlowEntity>();
        for (Object[] objectList : objects) {
            int id = objectList[0]==null?null:Integer.parseInt(String.valueOf(objectList[0]));
            int cashId = objectList[1]==null?null:Integer.parseInt(String.valueOf(objectList[1]));
            BigDecimal amount = objectList[2]==null?null:new BigDecimal(String.valueOf(objectList[2]));
            TradeType tradeType = objectList[3]==null?null:TradeType.valueOf(String.valueOf(objectList[3]));
            TradePath tradePath = objectList[4]==null?null:TradePath.valueOf(String.valueOf(objectList[4]));
            String tradeTime = objectList[5]==null?null: String.valueOf(objectList[5]);

            CashFlowEntity cashFlowEntity = new CashFlowEntity();
            cashFlowEntity.setId(id);
            cashFlowEntity.setCashId(cashId);
            cashFlowEntity.setAmount(amount);
            cashFlowEntity.setTradeType(tradeType);
            cashFlowEntity.setTradePath(tradePath);
            cashFlowEntity.setTradeTime(tradeTime);

            cashFlowEntityList.add(cashFlowEntity);
        }

        return cashFlowEntityList;

    }

    public int findCashFlowCount(int userId){
        String sql = "select count(flow.id) from one_account_cash cash " +
                "join one_cash_flow flow on cash.id = flow.cash_id " +
                "where cash.user_id = "+userId;

        Query q = em.createNativeQuery(sql);
        Object object = q.getSingleResult();
        if (object == null) {
            logger.info("no cash flow count found .userId = {}",userId);
            return 0;
        }
        return Integer.parseInt(String.valueOf(object));
    }

}
