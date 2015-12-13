package com.one.shop.service;

import com.one.shop.entity.User;
import com.one.shop.repository.UserQueryDslRepository;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * Created by pein on 2015/11/16.
 */
@Service
public class LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserQueryDslRepository userQueryDslRepository;

    public User findUser(User user) {
        LOGGER.info("begin to find user. param = {}", JSONUtils.toJson(user));
        User userResult =  userQueryDslRepository.findUser(user);
        if (userResult == null) {
            LOGGER.warn("no user found . ");
            return null;
        }
        LOGGER.info("end to find user. result = {}", JSONUtils.toJson(userResult));
        return userResult;
    }
}
