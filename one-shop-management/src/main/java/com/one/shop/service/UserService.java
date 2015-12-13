package com.one.shop.service;

import com.one.shop.domain.FullUser;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.entity.UserRoleMapper;
import com.one.shop.enums.Deleted;
import com.one.shop.repository.UserQueryDslRepository;
import com.one.shop.repository.UserRoleQueryDslRepository;
import com.one.shop.repository.UserRoleSQLRepository;
import com.one.shop.util.DateUtils;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Autowired
    private UserRoleQueryDslRepository userRoleQueryDslRepository;

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

    /**
     * 1更新用户表，用户记录
     * 2删除用户角色映射表中当前用户所有角色
     * 3重新添加新的角色
     * @param fullUser
     */
    @Transactional
    public void updateUserAndRole(FullUser fullUser) {
        LOGGER.info("begin to update user and role. fullUser = {}", JSONUtils.toJson(fullUser));
        User user = buildUser(fullUser);
        userQueryDslRepository.updateUser(user);
        String roleIds = fullUser.getRoles();
        List<String> roleIdList = Arrays.asList(roleIds.split(","));
        userRoleQueryDslRepository.deleteUserRoleByUser(user);
        for (String roleId : roleIdList) {
            userRoleQueryDslRepository.save(buildUserRoleMapper(user, roleId));
        }
        LOGGER.info("success to update user and role. fullUser = {}", JSONUtils.toJson(fullUser));
    }

    @Transactional
    public void deleteUser(int userId) {
        LOGGER.info("begin to delete user. userId = {}", userId);
        userQueryDslRepository.deleteUserById(userId);
        userRoleQueryDslRepository.deleteUserRoleByUserId(userId);
        LOGGER.info("success to delete user. userId = {}", userId);
    }

    private User buildUser(FullUser fullUser) {
        User user = new User();
        user.setId(fullUser.getId());
        user.setName(fullUser.getName());
        user.setPassword(fullUser.getPassword());
        return user;
    }

    private UserRoleMapper buildUserRoleMapper(User user, String roleId) {
        UserRoleMapper mapper = new UserRoleMapper();
        mapper.setRoleId(Integer.parseInt(roleId));
        mapper.setUserId(user.getId());
        return mapper;
    }

}
