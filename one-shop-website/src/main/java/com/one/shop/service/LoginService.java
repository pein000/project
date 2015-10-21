package com.one.shop.service;

import com.one.shop.domain.User;
import com.one.shop.entity.UserEntity;
import com.one.shop.repository.UserRepository;
import com.one.shop.repository.impl.UserRepositoryImpl;
import com.one.shop.util.ShopUtils;
import jodd.bean.BeanCopy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/10/13.
 */
@Service
public class LoginService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepositoryImpl userRepositoryImpl;

    public User login(String  name) {
//        UserEntity userEntity = new UserEntity();
//        BeanCopy.beans(user,userEntity).copy();
        UserEntity userEntity = userRepository.findByName(name);
        User user = new User();
        BeanCopy.beans(userEntity, user).copy();
        return  user;
    }

    /**
     * 通过手机或用户或邮箱
     * @param phone
     * @param password
     * @return
     */
    public User findByPhoneOrNameOrEmail(String phone,String password) {

        List<UserEntity> userEntityList = userRepositoryImpl.findUserByPhoneOrNameOrEmail(phone, password);
        if(userEntityList == null || userEntityList.isEmpty()){
            logger.info("not find user. phone = {},password={}",phone,password);
            return null;
        }
        if (userEntityList.size() > 1) {
            logger.info(" duplicated user. userEntityList  = {}", userEntityList);
            throw new RuntimeException("duplicated user.size = "+userEntityList.size());
        }

        UserEntity userEntity = userEntityList.get(0);
        User user = ShopUtils.convert(userEntity, User.class);

        return user;
    }

}
