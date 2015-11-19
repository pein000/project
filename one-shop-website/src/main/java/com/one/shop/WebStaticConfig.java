package com.one.shop;

import com.one.shop.interceptor.UserLoginInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by pein on 2015/10/20.
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.one.shop"})
public class WebStaticConfig extends WebMvcConfigurerAdapter {

    //要以类似于web.xml文件配置的方式来启动Spring应用上下文，此时我们需要声明这样
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // return super.configure(builder);
        return builder.sources(WebStaticConfig.class);
    }

    //添加静态资源配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //静态资源配置路径
//        registry.addResourceHandler("/static/**").addResourceLocations("file:d:/static/");
        registry.addResourceHandler("/static/image/user/**","/static/image/detail/**").addResourceLocations("file:d:/static/image/user/","file:d:/static/image/detail/");
        //super.addResourceHandlers(registry);
    }

    /**
     * 配置拦截器
     * @author lance
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/settings/**","/cash/**","/point/**","/car/**","/pay/**");
    }



    public static void main(String[] args) {
        SpringApplication.run(WebStaticConfig.class, args);
    }
}
