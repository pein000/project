package com.one.shop.controller;

import com.one.shop.entity.Permission;
import com.one.shop.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by pein on 2015/11/18.
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping(value = "to_permission")
    public ModelAndView toRole(ModelMap modelMap) {
        List<Permission> permissionList = permissionService.findAll();
        modelMap.put("permissionList", permissionList);
        return new ModelAndView("/permission/permission_profile", modelMap);
    }

}
