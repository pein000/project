package com.one.shop.controller;

import com.one.shop.entity.Permission;
import com.one.shop.service.PermissionService;
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
@RequestMapping("/permission")
public class PermissionController {

    private static final Logger LOGGER = LoggerFactory.getLogger(Permission.class);

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "to_permission")
    @RequiresPermissions("permission:query")
    public ModelAndView toRole(ModelMap modelMap) {
        List<Permission> permissionList = permissionService.findAll();
        modelMap.put("permissionList", permissionList);
        return new ModelAndView("/permission/permission_profile", modelMap);
    }

    @RequestMapping(value = "/to_add_permission")
    @RequiresPermissions("permission:add")
    public String toAddRole() {

        return "/permission/permission_add";
    }

    @RequestMapping(value="/add_permission",method = RequestMethod.POST)
    @RequiresPermissions("permission:add")
    public String addPermission(Permission permission) {
        permissionService.savePermission(permission);
        return "redirect:/permission/to_permission";
    }

    @RequestMapping(value="/to_detail_permission")
    @RequiresPermissions("permission:query")
    public ModelAndView toDetailPermission(int permissionId, ModelMap modelMap) {
        Permission permission = permissionService.findPermissionById(permissionId);
        if(permission == null){
            LOGGER.error("no permission found! permissionId = {}",permissionId);
            return new ModelAndView("/error/error");
        }
        modelMap.put("permission", permission);

        return new ModelAndView("/permission/permission_detail", modelMap);
    }

    /**
     * 点击编辑，进入编辑页面
     * @param permissionId
     * @param modelMap
     * @return
     */
    @RequestMapping(value="/to_edit_permission")
    @RequiresPermissions("permission:edit")
    public ModelAndView toEditPermission(int permissionId, ModelMap modelMap) {
        Permission permission = permissionService.findPermissionById(permissionId);
        if(permission == null){
            LOGGER.error("no user found! permissionId = {}",permissionId);
            return new ModelAndView("/error/error");
        }

        modelMap.put("permission", permission);
        return new ModelAndView("/permission/permission_edit", modelMap);
    }

    /**
     * 提交编辑数据
     *
     * @param permission
     * @return
     */
    @RequestMapping(value = "edit_operate_permission")
    @RequiresPermissions("permission:edit")
    public String editOperatePermission(Permission permission) {
        permissionService.updatePermission(permission);
        return "redirect:/permission/to_permission";
    }

    /**
     * 删除权限
     *
     * @param permissionId
     * @return
     */
    @RequestMapping(value="/to_delete_permission")
    @RequiresPermissions("permission:delete")
    public String toDeletePermission(int permissionId) {
        permissionService.deletePermission(permissionId);
        return "redirect:/permission/to_permission";
    }
}
