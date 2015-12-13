package com.online.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pein on 2015/10/20.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.online.video"})
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationConfig.class, args);
    }

    //添加静态资源配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源配置路径
        registry.addResourceHandler("/static/video/**").addResourceLocations("file:d:/static/video/");
        registry.addResourceHandler("/static/image/**").addResourceLocations("file:d:/static/image/");
    }
}
