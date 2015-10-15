package com.one.shop.controller;


import com.one.shop.domain.User;
import com.one.shop.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by pein on 2015/10/13.
 */
@Controller
public class TestController {

    @Autowired
    private LoginService loginService;

    private Logger logger = LoggerFactory.getLogger(getClass());


    @RequestMapping(value = "/login/{name}",method = RequestMethod.GET)
    public ModelAndView login(@PathVariable String name ,ModelMap modelMap) {

        logger.info("begin to login");
//        String name = "qiuwei";
        User user = loginService.login(name);
        modelMap.put("user", user);
        return new ModelAndView("/login/welcome",modelMap);
    }


}
