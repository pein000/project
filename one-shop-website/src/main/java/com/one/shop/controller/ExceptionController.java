package com.one.shop.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pein on 2015/10/13.
 */
@Controller
public class ExceptionController implements ErrorController{

    private static final String PATH = "/error";

    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping("/serverError")
    public String serverError() {
        return "500";
    }

    @RequestMapping("/pageNotFound")
    public String pageNotFount() {
        return "404";
    }

    @RequestMapping(value = PATH)
    public String error() {
        return "500";
    }
}
