package com.one.shop.controller;

import com.one.shop.entity.User;
import com.one.shop.service.LoginService;
import com.one.shop.util.JSONUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pein on 2015/11/16.
 */
@Controller
public class LoginController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String toLogin() {

        return "/login/login";
    }

    @RequestMapping(value = "login/user_login")
    public ModelAndView userLogin(String name,String password,ModelMap modelMap){
        LOGGER.info("begin to login . name = {},password={}",name,password);
        User result = loginService.findUser(generateUser(name, password));
        if (result == null) {
            LOGGER.warn("loggin error. no user found!");
            return new ModelAndView("/login/login");
        }
        SecurityUtils.getSubject().login(new UsernamePasswordToken(result.getName(),result.getPassword()));
        modelMap.put("user", result);
        LOGGER.info("success to login . user = {}", JSONUtils.toJson(result));
//        return new ModelAndView("/login/user",modelMap);
        return new ModelAndView("/main/index",modelMap);
    }

    public ModelAndView user(User user, ModelMap modelMap) {
        modelMap.put("userList", user);
        return new ModelAndView("/login/user", modelMap);
    }

    private User generateUser(String name, String password) {
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        return user;
    }

}
