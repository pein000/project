package com.one.shop.service;

import com.one.shop.entity.Permission;
import com.one.shop.repository.PermissionQueryDslRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by pein on 2015/11/18.
 */
@Service
public class PermissionService {

    private Logger LOGGER = LoggerFactory.getLogger(GoodsManagerService.class);

    @Autowired
    private PermissionQueryDslRepository permissionQueryDslRepository;

    public List<Permission> findAll() {
        LOGGER.info("begin to find all permission. ");
        List<Permission> permissionList = permissionQueryDslRepository.findAll();
        if (permissionList == null || permissionList.isEmpty()) {
            LOGGER.warn("no permission found. ");
        }
        LOGGER.info("permission found. permissionList = {}",permissionList);
        return permissionList;
    }
}
