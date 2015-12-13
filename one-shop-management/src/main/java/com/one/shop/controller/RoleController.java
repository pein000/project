package com.one.shop.controller;

import com.one.shop.domain.FullRole;
import com.one.shop.domain.FullUser;
import com.one.shop.entity.Permission;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.service.PermissionService;
import com.one.shop.service.RoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pein on 2015/11/18.
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(RoleController.class);

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "to_role")
    @RequiresPermissions("role:query")
    public ModelAndView toRole(ModelMap modelMap) {
        List<FullRole> fullRoleList = roleService.findAll();
        modelMap.put("fullRoleList", fullRoleList);
        return new ModelAndView("/role/role_profile", modelMap);
    }

    @RequestMapping(value = "/to_add_role")
    @RequiresPermissions("role:add")
    public String toAddRole() {

        return "/role/role_add";
    }

    @RequestMapping(value="/add_role",method = RequestMethod.POST)
    @RequiresPermissions("role:add")
    public String addUser(Role role) {
        roleService.saveRole(role);
        return "redirect:/role/to_role";
    }

    @RequestMapping(value="/to_detail_role")
    @RequiresPermissions("role:query")
    public ModelAndView toDetailUser(int roleId, ModelMap modelMap) {
        Role role = roleService.findRoleById(roleId);
        if(role == null){
            LOGGER.error("no role found! roleId = {}",roleId);
            return new ModelAndView("/error/error");
        }
        List<Permission> rolePermissionList = permissionService.findPermissionByRole(role);

        modelMap.put("role", role);
        modelMap.put("rolePermissionList",rolePermissionList);

        return new ModelAndView("/role/role_detail", modelMap);
    }

    /**
     * 进入编辑角色页面
     * @param roleId
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/to_edit_role")
    @RequiresPermissions("role:edit")
    public ModelAndView toEditUser(int roleId, ModelMap modelMap) {
        Role role = roleService.findRoleById(roleId);
        if(role == null){
            LOGGER.error("no user found! userId = {}",roleId);
            return new ModelAndView("/error/error");
        }
        List<Permission> rolePermissionList = permissionService.findPermissionByRole(role);
        List<Permission> allPermissionList =  permissionService.findAllPermission();

        modelMap.put("role", role);
        modelMap.put("rolePermissionList",rolePermissionList);
        modelMap.put("allPermissionList",allPermissionList);

        return new ModelAndView("/role/role_edit", modelMap);
    }

    /**
     * 提交编辑角色请求
     * @param
     * @return
     */
    @RequestMapping(value = "edit_operate_role")
    @RequiresPermissions("role:edit")
    public String editOperateUser(FullRole fullRole) {
        roleService.updateRoleAndPermission(fullRole);
        return "redirect:/role/to_role";
    }

    /**
     * 删除角色
     * @param roleId
     * @return
     */
    @RequestMapping(value="/to_delete_role")
    @RequiresPermissions("role:delete")
    public String toDeleteUser(int roleId) {
        roleService.deleteRole(roleId);
        return "redirect:/role/to_role";
    }

}
