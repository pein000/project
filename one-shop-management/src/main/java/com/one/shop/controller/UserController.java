package com.one.shop.controller;

import com.one.shop.domain.FullUser;
import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.service.RoleService;
import com.one.shop.service.UserService;
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
@RequestMapping("/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 用户管理首页
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/to_user")
    public ModelAndView toUser(ModelMap modelMap) {
        List<FullUser> fullUserList = userService.findAll();
        modelMap.put("fullUserList", fullUserList);
        return new ModelAndView("/user/user_profile", modelMap);
    }

    @RequestMapping(value = "/to_add_user")
    public String toAddUser() {

        return "/user/user_add";
    }

    @RequestMapping(value="/add_user",method = RequestMethod.POST)
    public String addUser(User user) {
        userService.saveUser(user);
        return "redirect:/user/to_user";
    }

    @RequestMapping(value="/to_edit_user")
    public ModelAndView to_edit_user(int userId, ModelMap modelMap) {
        User user = userService.findUserById(userId);
        if(user == null){
            LOGGER.error("no user found! userId = {}",userId);
            return new ModelAndView("/error/error");
        }
        List<Role> userRoleList = roleService.findRoleByUser(user);
        List<Role> allRoleList =  roleService.findAllRole();

        modelMap.put("user", user);
        modelMap.put("userRoleList",userRoleList);
        modelMap.put("allRoleList",allRoleList);

        return new ModelAndView("/user/user_edit", modelMap);
    }

    @RequestMapping(value="/to_delete_user")
    public String toDeleteUser(int userId) {
        userService.deleteUser(userId);
        return "redirect:/user/to_user";
    }
}
