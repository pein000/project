package com.one.shop.repository;

import com.one.shop.entity.QUserRoleMapper;
import com.one.shop.entity.User;
import com.one.shop.entity.UserRoleMapper;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class UserRoleQueryDslRepository extends QuerydslRepository<UserRoleMapper> {

    private QUserRoleMapper qUserRoleMapper = QUserRoleMapper.userRoleMapper;

    public UserRoleQueryDslRepository() {
        super(UserRoleMapper.class);
    }

    public void deleteUserRoleByUser(User user) {
        this.delete(qUserRoleMapper)
                .where(qUserRoleMapper.userId.eq(user.getId()))
                .execute();
    }

    public void deleteUserRoleByUserId(int userId) {
        this.delete(qUserRoleMapper)
                .where(qUserRoleMapper.userId.eq(userId))
                .execute();
    }

}
