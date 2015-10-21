package com.one.shop.service;

import com.one.shop.domain.PointAccount;
import com.one.shop.domain.PointFlow;
import com.one.shop.domain.User;
import com.one.shop.entity.PointAccountEntity;
import com.one.shop.entity.PointFlowEntity;
import com.one.shop.repository.PointAccountRepository;
import com.one.shop.repository.impl.PointFlowRepositoryImpl;
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
public class PointAccountService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private PointAccountRepository pointAccountRepository;

    @Autowired
    private PointFlowRepositoryImpl pointFlowRepository;

    public PointAccount findPointAccountByUser(User user) {
        PointAccountEntity pointAccountEntity = pointAccountRepository.findByUserId(user.getId());
        if (pointAccountEntity == null) {
            logger.info("user has no point Account . user = {}", user);
        }

        PointAccount pointAccount = ShopUtils.convert(pointAccountEntity, PointAccount.class);
        return pointAccount;
    }

    public List<PointFlow> findPointFlowByPage(int page, int size,int userId) {

        List<PointFlowEntity> pointFlowEntityList = pointFlowRepository.findPointFlowByPage(page, size, userId);
        if (pointFlowEntityList == null || pointFlowEntityList.isEmpty()) {
            logger.info("user has no point flow . userId = {}",userId);
        }
        List<PointFlow> pointFlowList = ShopUtils.convert(pointFlowEntityList, PointFlow.class);

        return pointFlowList;
    }

    public int findPointFlowCount(int userId) {
        return pointFlowRepository.findPointFlowCount(userId);
    }
}
