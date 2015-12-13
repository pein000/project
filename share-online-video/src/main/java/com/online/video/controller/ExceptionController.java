package com.online.video.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by pein on 2015/11/1.
 */
@Controller
public class ExceptionController implements ErrorController {

    private final static String APPLICATION_ERROR_PATH = "/error/error";
    private final static String AUTHORITY_ERROR_PATH = "/error/authority_error";

    @Override
    public String getErrorPath() {
        return APPLICATION_ERROR_PATH;
    }

    @RequestMapping(value = "/error")
    public String error() {
        return APPLICATION_ERROR_PATH;
    }

    /**
     * 没有权限
     *
     * @return
     */
    @RequestMapping(value = "/authority_error")
    public String authorityError() {
        return AUTHORITY_ERROR_PATH;
    }
}
