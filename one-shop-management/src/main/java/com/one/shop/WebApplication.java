package com.one.shop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pein on 2015/10/27.
 */
@SpringBootApplication
public class WebApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


    //添加静态资源配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源配置路径
        registry.addResourceHandler("/static/**").addResourceLocations("file:d:/static/");
//        registry.addResourceHandler("/static/image/user/**").addResourceLocations("file:d:/static/image/user/");
    }

}
