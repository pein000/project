package com.one.shop.repository;

import com.one.shop.entity.QRole;
import com.one.shop.entity.QUser;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

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
}
