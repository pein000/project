package com.one.shop.repository;

import com.mysema.query.types.Path;
import com.one.shop.entity.QRole;
import com.one.shop.entity.QUser;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class RoleQueryDslRepository extends QuerydslRepository<Role> {

    private QRole qRole = QRole.role;

    public RoleQueryDslRepository() {
        super(Role.class);
    }

    public List<Role> findAll() {
        return this.from(qRole).list(qRole);
    }

    public Role findRole(int roleId) {
        return this.from(qRole)
                .where(qRole.id.eq(roleId))
                .singleResult(qRole);
    }

    public void updateRole(Role role) {
        this.update(qRole)
                .set(buildPathData(),buildValueData(role))
                .where(qRole.id.eq(role.getId()))
                .execute();
    }

    public void deleteUserById(int userId) {
        this.delete(qRole).where(qRole.id.eq(userId)).execute();
    }

    private List<String> buildValueData(Role role) {
        List<String> valueList = new ArrayList<String>();
        valueList.add(role.getName());
        valueList.add(role.getDescription());
        return valueList;
    }

    private List<Path<String>> buildPathData() {
        List<Path<String>> pathList = new ArrayList<Path<String>>();
        pathList.add(qRole.name);
        pathList.add(qRole.description);
        return pathList;
    }
}
