package com.one.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pein on 2015/10/27.
 */
@Controller
public class VelocityController {

    @RequestMapping(value = "/index")
    public String toIndex() {
        return "/main/index";
    }

}
