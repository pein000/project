package com.one.shop.service;

import com.one.shop.domain.FullUser;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.enums.Deleted;
import com.one.shop.repository.UserQueryDslRepository;
import com.one.shop.repository.UserRoleSQLRepository;
import com.one.shop.util.DateUtils;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/11/18.
 */
@Service
public class UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private UserQueryDslRepository userQueryDslRepository;

    @Autowired
    private UserRoleSQLRepository userRoleSQLRepository;

    public List<FullUser> findAll() {
        LOGGER.info("begin to find all user. ");
        List<User> userList = userQueryDslRepository.findAll();
        if (userList == null || userList.isEmpty()) {
            LOGGER.warn("no user found! ");
            return null;
        }
        LOGGER.info("find all user. userList = {}", JSONUtils.toJson(userList));
        List<FullUser> fullUserList = new ArrayList<FullUser>();
        for (User user : userList) {
            List<Role> roleList = userRoleSQLRepository.findUserRoleByUser(user);
            if (roleList == null || roleList.isEmpty()) {
                LOGGER.warn("no role found by user .user = {}", JSONUtils.toJson(user));
                fullUserList.add(new FullUser(user, null));
                continue;
            }
            StringBuilder roles = new StringBuilder();
            for (Role role : roleList) {
                roles.append(role.getName()).append(",");
            }
            roles.delete(roles.lastIndexOf(","), roles.length());
            fullUserList.add(new FullUser(user, roles.toString()));
        }
        LOGGER.info("success to find all user. fullUserList = {}", JSONUtils.toJson(fullUserList));
        return fullUserList;
    }

    @Transactional
    public void saveUser(User user) {
        LOGGER.info("begin to save user. user = {}", JSONUtils.toJson(user));
        user.setCreateDate(DateUtils.formatDate());
        user.setIsDeleted(String.valueOf(Deleted.NONE.ordinal()));
        userQueryDslRepository.save(user);
        LOGGER.info("success to save user. user = {}", JSONUtils.toJson(user));
    }

    public User findUserById(int userId) {
        LOGGER.info("begin to find user by id . userId = {}", userId);
        User user = userQueryDslRepository.findUser(userId);
        if (user == null) {
            LOGGER.warn("no user found! ");
            return null;
        }
        LOGGER.info("success to find user. user = {}", JSONUtils.toJson(user));
        return user;
    }


    @Transactional
    public void deleteUser(int userId) {
        LOGGER.info("begin to delete user. userId = {}", userId);
        userQueryDslRepository.deleteUserById(userId);
        LOGGER.info("success to delete user. userId = {}", userId);
    }

}
