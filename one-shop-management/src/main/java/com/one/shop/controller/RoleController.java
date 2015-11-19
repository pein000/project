package com.one.shop.controller;

import com.one.shop.domain.FullRole;
import com.one.shop.service.RoleService;
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
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "to_role")
    public ModelAndView toRole(ModelMap modelMap) {
        List<FullRole> fullRoleList = roleService.findAll();
        modelMap.put("fullRoleList", fullRoleList);
        return new ModelAndView("/role/role_profile", modelMap);
    }

}
