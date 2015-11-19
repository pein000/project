package com.one.shop.service;

import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.repository.RolePermissionSQLRepository;
import com.one.shop.repository.UserQueryDslRepository;
import com.one.shop.repository.UserRoleSQLRepository;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pein on 2015/11/16.
 */
@Service
public class AuthenticationService {

    private Logger LOGGER = LoggerFactory.getLogger(AuthenticationService.class);

    @Autowired
    private UserQueryDslRepository userQueryDslRepository;

    @Autowired
    private UserRoleSQLRepository userRoleSQLRepository;

    @Autowired
    private RolePermissionSQLRepository rolePermissionSQLRepository;

    public User findUserByName(String userName) {
        LOGGER.info("begin to find user by name . username = {}", userName);
        User user = userQueryDslRepository.findUserByName(userName);
        if (user == null) {
            LOGGER.warn("no user found. ");
            return null;
        }
        LOGGER.info("success to found user. user = {}", JSONUtils.toJson(user));
        return user;
    }

    public List<Role> findRolesByUser(User user) {
        LOGGER.info("begin to find role by user . user = {}", JSONUtils.toJson(user));
        List<Role> roleList = userRoleSQLRepository.findUserRoleByUser(user);
        if (roleList == null || roleList.isEmpty()) {
            LOGGER.warn("no role found. ");
            return null;
        }
        LOGGER.info("success to found role. roleList = {}", JSONUtils.toJson(roleList));
        return roleList;
    }

    /**
     * 每个用户可能有多个角色（role）
     * 每个角色可能有多个权限（permission）
     * 查询当前用户下所有的权限（permission）
     *
     * @param roleList
     * @return
     */
    public Set<String> findPermissionByRole(List<Role> roleList) {
        LOGGER.info("begin to find permission by roleList . roleList = {}", JSONUtils.toJson(roleList));
        if (roleList == null || roleList.isEmpty()) {
            LOGGER.warn("param error.  roleList is null!");
            return null;
        }
        List<String> permissionList = new ArrayList<String>();
        //每个角色对应多个permission
        for (Role role : roleList) {
            List<String> oneRolePermissionList = rolePermissionSQLRepository.findPermissionValueByRole(role);
            LOGGER.info("one role permission list = {},role = {}", JSONUtils.toJson(oneRolePermissionList), JSONUtils.toJson(role));
            permissionList.addAll(oneRolePermissionList);
        }

        if (permissionList == null || permissionList.isEmpty()) {
            LOGGER.warn("no permission found. ");
            return null;
        }
        Set<String> permissions = new HashSet<String>();
        permissions.addAll(permissionList);
        LOGGER.info("success to found permission. permissions = {}", JSONUtils.toJson(permissions));
        return permissions;
    }

}
