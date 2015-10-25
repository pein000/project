package com.one.shop.controller;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.User;
import com.one.shop.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by pein on 2015/10/18.
 */
@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/toLogin",method = RequestMethod.GET)
    public String login() {

        return "/login/login";
    }

    @RequestMapping(value = "/toCompleteLogin", method = RequestMethod.POST)
    public String toCompleteLogin(String phone,String password,String code, HttpSession session,ModelMap modelMap) {
        String sessionCode = String.valueOf(session.getAttribute("code"));
        if (!code.equalsIgnoreCase(sessionCode)) {
            logger.info("idenfity not equal. session Code ={}, input Code = {}",sessionCode,code);
            return "/login/login";
        }
        User user = loginService.findByPhoneOrNameOrEmail(phone, password);
        if(user == null){
            logger.info("cannot to login .not find user by resources {} and {}",phone,password);
            return "/login/login";
        }

        session.setAttribute(SystemVariable.SESSION_KEY_USER,user);
        return "redirect:index";

    }

    @RequestMapping(value = "/login/loginOut")
    public String loginOut(HttpSession session) {
        session.removeAttribute(SystemVariable.SESSION_KEY_USER);
        session.invalidate();
        return "redirect:/index";

    }
}
