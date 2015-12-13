package com.one.shop.entity;

import javax.persistence.*;

/**
 * Created by pein on 2015/11/16.
 */
@Entity()
@Table(name="authority_role_permission")
public class RolePermissionMapper {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "ROLE_ID")
    private int roleId;

    @Column(name = "PERMISSION_ID")
    private int permissionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
