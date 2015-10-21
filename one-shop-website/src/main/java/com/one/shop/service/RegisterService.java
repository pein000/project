package com.one.shop.service;

import com.one.shop.domain.User;
import com.one.shop.entity.CashAccountEntity;
import com.one.shop.entity.PointAccountEntity;
import com.one.shop.entity.UserEntity;
import com.one.shop.repository.CashAccountRepository;
import com.one.shop.repository.PointAccountRepository;
import com.one.shop.repository.UserRepository;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

/**
 * Created by pein on 2015/10/18.
 */
@Service
public class RegisterService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CashAccountRepository cashAccountRepository;

    @Autowired
    private PointAccountRepository pointAccountRepository;

    @Transactional
    public User addUser(User user) {
        UserEntity paramUser = ShopUtils.convert(user, UserEntity.class);
        UserEntity resultUser = userRepository.save(paramUser);
        if (resultUser == null) {
            logger.info("add user to mysql error.");
            return null;
        }
        //生成一个金额为0的现金账户
        CashAccountEntity cashAccountEntity = new CashAccountEntity();
        cashAccountEntity.setUserId(resultUser.getId());
        cashAccountEntity.setAmount(BigDecimal.ZERO);
        cashAccountRepository.save(cashAccountEntity);
        //生成一个金额为0的积分账户
        PointAccountEntity pointAccountEntity = new PointAccountEntity();
        pointAccountEntity.setUserId(resultUser.getId());
        pointAccountEntity.setAmount(BigDecimal.ZERO);
        pointAccountRepository.save(pointAccountEntity);

        User result = ShopUtils.convert(resultUser, User.class);
        return result;
    }
}
