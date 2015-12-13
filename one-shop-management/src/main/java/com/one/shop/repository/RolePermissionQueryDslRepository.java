package com.one.shop.repository;

import com.one.shop.entity.*;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class RolePermissionQueryDslRepository extends QuerydslRepository<RolePermissionMapper> {

    private QRolePermissionMapper qRolePermissionMapper = QRolePermissionMapper.rolePermissionMapper;

    public RolePermissionQueryDslRepository() {
        super(RolePermissionMapper.class);
    }

    public void deleteRolePermissionByRole(Role role) {
        this.delete(qRolePermissionMapper)
                .where(qRolePermissionMapper.roleId.eq(role.getId()))
                .execute();
    }

    public void deleteRolePermissionByRoleId(int roleId) {
        this.delete(qRolePermissionMapper)
                .where(qRolePermissionMapper.roleId.eq(roleId))
                .execute();
    }
}
