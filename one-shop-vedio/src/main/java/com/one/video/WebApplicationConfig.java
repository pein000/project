package com.one.video;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pein on 2015/10/20.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.one.video"})
public class WebApplicationConfig extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(WebApplicationConfig.class, args);
    }
}
