package com.one.shop.repository.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/13.
 */
@Repository
@Transactional
public class CashAccountRepositoryImpl {

    private static Logger LOGGER = LoggerFactory.getLogger(CashAccountRepositoryImpl.class);

    @PersistenceContext
    private EntityManager em;

    public void decreaseCash(int cashId,BigDecimal amount) {
        String sql = "update one_account_cash set amount = amount - " +amount+" where id = "+cashId;

        Query q = em.createNativeQuery(sql);
        q.executeUpdate();
    }
}
