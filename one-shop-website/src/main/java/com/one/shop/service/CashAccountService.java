package com.one.shop.service;

import com.one.shop.domain.CashAccount;
import com.one.shop.domain.CashFlow;
import com.one.shop.domain.User;
import com.one.shop.entity.CashAccountEntity;
import com.one.shop.entity.CashFlowEntity;
import com.one.shop.repository.CashAccountRepository;
import com.one.shop.repository.impl.CashFlowRepositoryImpl;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/10/20.
 */
@Service
public class CashAccountService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CashAccountRepository cashAccountRepository;

    @Autowired
    private CashFlowRepositoryImpl cashFlowRepository;

    public CashAccount findCashAccountByUser(User user) {
        CashAccountEntity cashAccountEntity = cashAccountRepository.findByUserId(user.getId());
        if (cashAccountEntity == null) {
            logger.info("user has no cash Account . user = {}",user);
        }

        CashAccount cashAccount = ShopUtils.convert(cashAccountEntity, CashAccount.class);
        return cashAccount;
    }

    public List<CashFlow> findCashFlowByPage(int page, int size,int userId) {

        List<CashFlowEntity> cashFlowEntityList = cashFlowRepository.findCashFlowByPage(page, size, userId);
        if (cashFlowEntityList == null || cashFlowEntityList.isEmpty()) {
            logger.info("user has no cash flow . user = {}");
        }
        List<CashFlow> cashFlowList = ShopUtils.convert(cashFlowEntityList, CashFlow.class);

        return cashFlowList;
    }

    public int findCashFlowCount(int userId) {
        return cashFlowRepository.findCashFlowCount(userId);
    }
}
