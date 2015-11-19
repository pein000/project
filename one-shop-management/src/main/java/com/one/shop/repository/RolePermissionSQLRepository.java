package com.one.shop.repository;

import com.one.shop.entity.Permission;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.repository.basic.SQLRepository;
import com.one.shop.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class RolePermissionSQLRepository extends SQLRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(RolePermissionSQLRepository.class);

    public List<String> findPermissionValueByRole(Role role){
        String sql = "select m.permission from authority_role_permission m\n" +
                "join authority_permission p\n" +
                "on m.PERMISSION_ID = p.ID\n" +
                "where m.ROLE_ID = '"+role.getId()+"'";
        LOGGER.info("RolePermissionSQLRepository -> findPermissionValueByRole :: {}",sql);
        List<Object[]> objects =  getEntityManager().createNativeQuery(sql).getResultList();

        return buildPermissionValueList(objects);
    }

    public List<Permission> findPermissionByRole(Role role){
        String sql = "select p.id,p.permission,p.description from authority_role_permission m\n" +
                "join authority_permission p\n" +
                "on m.PERMISSION_ID = p.ID\n" +
                "where m.ROLE_ID = '"+role.getId()+"'";

        LOGGER.info("RolePermissionSQLRepository -> findPermissionByRole :: {}",sql);
        List<Object[]> objects =  getEntityManager().createNativeQuery(sql).getResultList();

        return buildPermissionList(objects);
    }


    private List<Permission> buildPermissionList(List<Object[]> objects) {
        if (objects == null || objects.isEmpty()) {
            return null;
        }

        List<Permission> permissionList = new ArrayList<Permission>();
        for (Object[] objectList : objects) {
            permissionList.add(buildPermissionDomain(objectList));
        }
        return permissionList;
    }

    private List<String> buildPermissionValueList(List<Object[]> objects) {
        if (objects == null || objects.isEmpty()) {
            return null;
        }

        List<String> permissionList = new ArrayList<String>();
        for (Object[] objectList : objects) {
            permissionList.add(buildPermissionValueDomain(objectList));
        }
        return permissionList;
    }
}
