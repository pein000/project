package com.one.shop.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public class PointAccountRepositoryImpl {

    private static Logger LOGGER = LoggerFactory.getLogger(PointAccountRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    public void decreasePoint(int pointId,BigDecimal amount) {
        String sql = "update one_account_point set amount = amount - " +amount+" where id = "+pointId;

        Query q = em.createNativeQuery(sql);
        q.executeUpdate();
    }
}
