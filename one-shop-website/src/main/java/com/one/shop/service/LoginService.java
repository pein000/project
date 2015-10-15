package com.one.shop.service;

import com.one.shop.domain.User;
import com.one.shop.entity.UserEntity;
import com.one.shop.repository.UserRepository;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by pein on 2015/10/13.
 */
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(getClass());

    public User login(String  name) {
//        UserEntity userEntity = new UserEntity();
//        BeanCopy.beans(user,userEntity).copy();
        UserEntity userEntity = userRepository.findByName(name);
        User user = new User();
        BeanCopy.beans(userEntity, user).copy();
        return  user;
    }

}
