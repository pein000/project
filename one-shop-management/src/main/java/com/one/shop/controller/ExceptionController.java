package com.one.shop.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pein on 2015/11/1.
 */
@Controller
public class ExceptionController implements ErrorController {

    private final static String PATH = "/error/error";
    @Override
    public String getErrorPath() {
        return PATH;
    }

    @RequestMapping(value = "/error")
    public String error(){
        return PATH;
    }


}
