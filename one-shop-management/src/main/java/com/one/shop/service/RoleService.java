package com.one.shop.service;

import com.one.shop.domain.FullRole;
import com.one.shop.domain.FullUser;
import com.one.shop.entity.Permission;
import com.one.shop.entity.Role;
import com.one.shop.entity.RolePermissionMapper;
import com.one.shop.entity.User;
import com.one.shop.enums.Deleted;
import com.one.shop.repository.*;
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
public class RoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginService.class);

    @Autowired
    private RoleQueryDslRepository roleQueryDslRepository;

    @Autowired
    private UserRoleSQLRepository userRoleSQLRepository;

    @Autowired
    private RolePermissionSQLRepository rolePermissionSQLRepository;

    @Autowired
    private RolePermissionQueryDslRepository rolePermissionQueryDslRepository;

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
            if (permissionList == null || permissionList.isEmpty()) {
                LOGGER.warn("no permission found by role .role = {}", JSONUtils.toJson(role));
                fullRoleList.add(new FullRole(role, null));
                continue;
            }
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


    @Transactional
    public void saveRole(Role role){
        LOGGER.info("begin to save role. role = {}", JSONUtils.toJson(role));
        role.setCreateTime(DateUtils.formatDate("yyyy-MM-dd HH:mm:ss"));
        roleQueryDslRepository.save(role);
        LOGGER.info("success to save role. role = {}", JSONUtils.toJson(role));

    }

    public Role findRoleById(int roleId) {
        LOGGER.info("begin to find role by id . userId = {}", roleId);
        Role role = roleQueryDslRepository.findRole(roleId);
        if (role == null) {
            LOGGER.warn("no role found! ");
            return null;
        }
        LOGGER.info("success to find user. user = {}", JSONUtils.toJson(role));
        return role;
    }

    /**
     * 1更新用户表，用户记录
     * 2删除用户角色映射表中当前用户所有角色
     * 3重新添加新的角色
     * @param fullRole
     */
    @Transactional
    public void updateRoleAndPermission(FullRole fullRole) {
        LOGGER.info("begin to update role and permission. fullRole = {}", JSONUtils.toJson(fullRole));
        Role role = buildRole(fullRole);
        roleQueryDslRepository.updateRole(role);
        String permissionIds = fullRole.getPermissions();
        List<String> permissionIdsIdList = Arrays.asList(permissionIds.split(","));
        rolePermissionQueryDslRepository.deleteRolePermissionByRole(role);
        for (String permissionId : permissionIdsIdList) {
            rolePermissionQueryDslRepository.save(buildRolePermissionMapper(role, permissionId));
        }
        LOGGER.info("success to update role and permission. fullRole = {}", JSONUtils.toJson(fullRole));
    }

    @Transactional
    public void deleteRole(int roleId) {
        LOGGER.info("begin to delete role. roleId = {}", roleId);
        roleQueryDslRepository.deleteUserById(roleId);
        rolePermissionQueryDslRepository.deleteRolePermissionByRoleId(roleId);
        LOGGER.info("success to delete role. roleId = {}", roleId);
    }

    private Role buildRole(FullRole fullRole) {
        Role role = new Role();
        role.setId(fullRole.getId());
        role.setName(fullRole.getName());
        role.setDescription(fullRole.getDescription());
        return role;
    }

    private RolePermissionMapper buildRolePermissionMapper(Role role,String permissionId){
        RolePermissionMapper rRolePermissionMapper = new RolePermissionMapper();
        rRolePermissionMapper.setRoleId(role.getId());
        rRolePermissionMapper.setPermissionId(Integer.parseInt(permissionId));
        return rRolePermissionMapper;
    }
}
