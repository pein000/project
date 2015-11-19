package com.one.shop.service;

import com.one.shop.domain.FullRole;
import com.one.shop.entity.Permission;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.repository.*;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/11/18.
 */
@Service
public class RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private RoleQueryDslRepository roleQueryDslRepository;

    @Autowired
    private UserRoleSQLRepository userRoleSQLRepository;

    @Autowired
    private RolePermissionSQLRepository rolePermissionSQLRepository;

    public List<FullRole> findAll() {
        LOGGER.info("begin to find all role. ");
        List<Role> roleList = roleQueryDslRepository.findAll();
        if (roleList == null || roleList.isEmpty()) {
            LOGGER.warn("no role found! ");
            return null;
        }
        LOGGER.info("find all role. roleList = {}", JSONUtils.toJson(roleList));
        List<FullRole> fullRoleList = new ArrayList<FullRole>();
        for(Role role: roleList) {
            List<Permission> permissionList = rolePermissionSQLRepository.findPermissionByRole(role);
            StringBuilder permissions = new StringBuilder();
            for (Permission permission : permissionList) {
                permissions.append(permission.getPermission()).append(",");
            }
            permissions.delete(permissions.lastIndexOf(","), permissions.length());
            fullRoleList.add(new FullRole(role, permissions.toString()));
        }
        LOGGER.info("success to find all role. fullRoleList = {}", JSONUtils.toJson(fullRoleList));
        return fullRoleList;
    }

    public List<Role> findRoleByUser(User user) {
        LOGGER.info("begin to find role by user . userId = {}", user.getId());
        List<Role> roleList = userRoleSQLRepository.findUserRoleByUser(user);
        if (roleList == null || roleList.isEmpty()) {
            LOGGER.warn("no role found! ");
            return null;
        }
        LOGGER.info("success to find roleList. roleList = {}", JSONUtils.toJson(roleList));
        return roleList;
    }

    public List<Role> findAllRole() {
        LOGGER.info("begin to find all role. ");
        List<Role> roleList = roleQueryDslRepository.findAll();
        if (roleList == null || roleList.isEmpty()) {
            LOGGER.warn("no role found! ");
            return null;
        }
        LOGGER.info("success to find roleList. roleList = {}", JSONUtils.toJson(roleList));
        return roleList;
    }
}
