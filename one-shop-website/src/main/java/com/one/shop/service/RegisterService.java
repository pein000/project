package com.one.shop.service;

import com.one.shop.domain.User;
import com.one.shop.entity.UserEntity;
import com.one.shop.repository.UserRepository;
import com.one.shop.util.ShopUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pein on 2015/10/18.
 */
@Service
public class RegisterService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    public User addUser(User user) {
        UserEntity paramUser = ShopUtils.convert(user, UserEntity.class);
        UserEntity resultUser = userRepository.save(paramUser);
        if (resultUser == null) {
            logger.info("add user to mysql error.");
            return null;
        }
        User result = ShopUtils.convert(resultUser, User.class);
        return result;
    }
}
