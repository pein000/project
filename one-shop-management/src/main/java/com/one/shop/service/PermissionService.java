package com.one.shop.service;

import com.one.shop.entity.Permission;
import com.one.shop.entity.Role;
import com.one.shop.repository.PermissionQueryDslRepository;
import com.one.shop.repository.RolePermissionSQLRepository;
import com.one.shop.util.JSONUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pein on 2015/11/18.
 */
@Service
public class PermissionService {

    private Logger LOGGER = LoggerFactory.getLogger(GoodsManagerService.class);

    @Autowired
    private PermissionQueryDslRepository permissionQueryDslRepository;

    @Autowired
    private RolePermissionSQLRepository rolePermissionSQLRepository;

    public List<Permission> findAll() {
        LOGGER.info("begin to find all permission. ");
        List<Permission> permissionList = permissionQueryDslRepository.findAll();
        if (permissionList == null || permissionList.isEmpty()) {
            LOGGER.warn("no permission found. ");
        }
        LOGGER.info("permission found. permissionList = {}",permissionList);
        return permissionList;
    }

    public List<Permission> findPermissionByRole(Role role) {
        LOGGER.info("begin to find permission by role . roleId = {}", role.getId());
        List<Permission> permissionList = rolePermissionSQLRepository.findPermissionByRole(role);
        if (permissionList == null || permissionList.isEmpty()) {
            LOGGER.warn("no permission found! ");
            return null;
        }
        LOGGER.info("success to find permissionList. permissionList = {}", JSONUtils.toJson(permissionList));
        return permissionList;
    }

    public List<Permission> findAllPermission(){
        LOGGER.info("begin to find all permission. ");
        List<Permission> permissionList = permissionQueryDslRepository.findAll();
        if (permissionList == null || permissionList.isEmpty()) {
            LOGGER.warn("no permission found! ");
            return null;
        }
        LOGGER.info("success to find permissionList. permissionList = {}", JSONUtils.toJson(permissionList));
        return permissionList;
    }

    @Transactional
    public void savePermission(Permission permission) {
        LOGGER.info("begin to save permission. permission = {}. ",JSONUtils.toJson(permission));
        permissionQueryDslRepository.save(permission);
        LOGGER.info("success to save permission. ");
    }

    public Permission findPermissionById(int permissionId) {
        LOGGER.info("begin to find permission by id. permissionId = {}. ",permissionId);
        Permission permission =  permissionQueryDslRepository.findPermissionById(permissionId);
        if (permission == null) {
            LOGGER.warn("no permission found! ");
            return null;
        }
        LOGGER.info("success to find permission by id. permission={}. ", permission);
        return permission;
    }

    public void updatePermission(Permission permission) {
        LOGGER.info("begin to update permission.  permission= {}. ",JSONUtils.toJson(permission));
        permissionQueryDslRepository.updatePermission(permission);
        LOGGER.info("success to update permission. ");
    }

    @Transactional
    public void deletePermission(int permissionId) {
        LOGGER.info("begin to permission. permissionId = {}", permissionId);
        permissionQueryDslRepository.deletePermissionById(permissionId);
        LOGGER.info("success to delete permission. ");
    }

}
