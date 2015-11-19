package com.one.shop.repository;

import com.one.shop.entity.Permission;
import com.one.shop.entity.QPermission;
import com.one.shop.entity.QRole;
import com.one.shop.entity.Role;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

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
}
