package com.one.shop.repository;

import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.repository.basic.SQLRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pein on 2015/11/16.
 */
@Repository
public class UserRoleSQLRepository extends SQLRepository {

    public List<Role> findUserRoleByUser(User user){
        String sql = "SELECT r.ID,r.NAME,r.DESCRIPTION FROM authority_user_role m\n" +
                "join authority_user u\n" +
                "join authority_role r\n" +
                "on m.USER_ID = u.ID\n" +
                "and m.ROLE_ID= r.ID\n" +
                "WHERE m.USER_ID = '"+user.getId()+"'";

        List<Object[]> objects =  getEntityManager().createNativeQuery(sql).getResultList();

        return buildRoleList(objects);
    }

    private List<Role> buildRoleList(List<Object[]> objects) {
        if (objects == null || objects.isEmpty()) {
            return null;
        }

        List<Role> roleList = new ArrayList<Role>();
        for (Object[] objectList : objects) {
            roleList.add(buildRoleDomain(objectList));
        }
        return roleList;
    }
}
