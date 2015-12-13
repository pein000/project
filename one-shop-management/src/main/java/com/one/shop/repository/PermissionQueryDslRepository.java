package com.one.shop.repository;

import com.mysema.query.types.Path;
import com.one.shop.entity.Permission;
import com.one.shop.entity.QPermission;
import com.one.shop.entity.QRole;
import com.one.shop.entity.Role;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class PermissionQueryDslRepository extends QuerydslRepository<Permission> {

    private QPermission qPermission = QPermission.permission1;

    public PermissionQueryDslRepository() {
        super(Permission.class);
    }

    public List<Permission> findAll() {
        return this.from(qPermission).list(qPermission);
    }

    public Permission findPermissionById(int permissionId) {
        return this.from(qPermission)
                .where(qPermission.id.eq(permissionId))
                .singleResult(qPermission);
    }

    public void updatePermission(Permission permission) {
        this.update(qPermission)
                .set(buildPathData(), buildValueData(permission))
                .where(qPermission.id.eq(permission.getId()))
                .execute();
    }

    public void deletePermissionById(int permissionId) {
        this.delete(qPermission).where(qPermission.id.eq(permissionId)).execute();
    }

    private List<Path<String>> buildPathData() {
        List<Path<String>> pathList = new ArrayList<Path<String>>();
        pathList.add(qPermission.permission);
        pathList.add(qPermission.description);
        return pathList;
    }

    private List<String> buildValueData(Permission permission) {
        List<String> valueList = new ArrayList<String>();
        valueList.add(permission.getPermission());
        valueList.add(permission.getDescription());
        return valueList;
    }
}
