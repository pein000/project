package com.one.shop.repository.impl;

import com.one.shop.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by pein on 2015/10/13.
 * 在Spring Data的核心接口里面Repository是最基本的接口了,
 * spring提供了很多实现了该接口的基本接口,
 * 如: CrudRepository, PagingAndSortingRepository,SimpleJpaRepository,QueryDslJpaRepository等大量查询接口
 */
@Repository
@Transactional
public class UserRepositoryImpl {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager em;

    public List<UserEntity> findUserByPhoneOrNameOrEmail(String phone, String password) {
        String sql = "select * from one_shop_user where (name = '" + phone +
                "' or phone = '" + phone + "' or email = '" + phone +
                "') and password = '" + password + "'";

        Query query = em.createNativeQuery(sql);
        List<Object[]> objects = query.getResultList();
        if (objects == null || objects.isEmpty()) {
            logger.info("no user . findUserByPhoneOrNameOrEmail. name={}",phone);
            return null;
        }

        List<UserEntity> userEntityList = new ArrayList<UserEntity>();
        for (Object[] objectList : objects) {
            UserEntity userEntity = new UserEntity();
            int id = objectList[0]==null?null:Integer.parseInt(String.valueOf(objectList[0]));
            String name = objectList[1]==null?null:String.valueOf(objectList[1]);
            String sign = objectList[2]==null?null:String.valueOf(objectList[2]);
            String passw = objectList[3]==null?null:String.valueOf(objectList[3]);
            String ph = objectList[4]==null?null:String.valueOf(objectList[4]);
            String email = objectList[5]==null?null:String.valueOf(objectList[5]);
            String photoUrl = objectList[6]==null?null:String.valueOf(objectList[6]);
            String address = objectList[7]==null?null:String.valueOf(objectList[7]);

            userEntity.setId(id);
            userEntity.setName(name);
            userEntity.setSign(sign);
            userEntity.setPassword(passw);
            userEntity.setPhone(ph);
            userEntity.setEmail(email);
            userEntity.setPhotoUrl(photoUrl);
            userEntity.setAddress(address);

            userEntityList.add(userEntity);
        }

        return userEntityList;

    }
}
