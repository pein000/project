package com.one.shop.domain;

import com.one.shop.entity.Role;

/**
 * Created by pein on 2015/11/18.
 */
public class FullRole extends Role{

    /**
     * 角色的权限集合，以","隔开
     */
    private String permissions;

    public FullRole(Role role, String permissions) {
        this.setId(role.getId());
        this.setName(role.getName());
        this.setDescription(role.getDescription());
        this.setCreatorId(role.getCreatorId());
        this.setCreatorName(role.getCreatorName());
        this.setCreateTime(role.getCreateTime());
        this.permissions = permissions;
    }

    public String getPermissions() {
        return permissions;
    }

    public void setPermissions(String permissions) {
        this.permissions = permissions;
    }
}
