package com.one.shop.repository;

import com.one.shop.entity.QUser;
import com.one.shop.entity.User;
import com.one.shop.repository.basic.QuerydslRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class UserQueryDslRepository extends QuerydslRepository<User> {

    private static  final QUser qUser = QUser.user;

    public UserQueryDslRepository() {
        super(User.class);
    }

    public User findUser(User user) {
        return this.from(qUser)
                .where(qUser.name.eq(user.getName()), qUser.password.eq(user.getPassword()))
                .singleResult(qUser);
    }

    public User findUser(int userId) {
        return this.from(qUser)
                .where(qUser.id.eq(userId))
                .singleResult(qUser);
    }

    public User findUserByName(String name) {
        return this.from(qUser)
                .where(qUser.name.eq(name))
                .singleResult(qUser);
    }

    public List<User> findAll() {
        return this.from(qUser).list(qUser);
    }


    public void deleteUserById(int userId) {
        this.delete(qUser).where(qUser.id.eq(userId)).execute();
    }
}
