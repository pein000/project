package com.one.shop.repository;

import com.one.shop.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by pein on 2015/10/13.
 * 在Spring Data的核心接口里面Repository是最基本的接口了,
 * spring提供了很多实现了该接口的基本接口,
 * 如: CrudRepository, PagingAndSortingRepository,SimpleJpaRepository,QueryDslJpaRepository等大量查询接口
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<UserEntity,Long>{

    public UserEntity findByName(String name);

}
