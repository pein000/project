package com.one.shop;

import com.one.shop.authority.ShiroRealm;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.DispatcherType;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by pein on 2015/11/17.
 */
@Configuration
public class WebConfig {

    @Autowired
    private ShiroRealm shiroRealm;

    /**
     * shiro缓存
     *
     * @return
     */
    @Bean
    public MemoryConstrainedCacheManager cacheManager() {
        MemoryConstrainedCacheManager memoryConstrainedCacheManager = new MemoryConstrainedCacheManager();
        return memoryConstrainedCacheManager;
    }

    @Bean(name = "shiroRealm")
    @DependsOn("lifecycleBeanPostProcessor")
    public ShiroRealm realm() {
        final ShiroRealm realm = new ShiroRealm();
        return realm;
    }

    /**
     * shiro安全管理器 securityManager
     *
     * @return
     */
    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm());
        defaultWebSecurityManager.setCacheManager(cacheManager());
        return defaultWebSecurityManager;
    }


    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //配置安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager());
        //配置登录请求地址
        shiroFilterFactoryBean.setLoginUrl("/login");
        //配置登录成功后，进入的页面地址
        shiroFilterFactoryBean.setSuccessUrl("/user");
        //配置如果你请求的资源不再您的权限范围内，跳转到的地址
        shiroFilterFactoryBean.setUnauthorizedUrl("/error/authority_error");
        Map<String, String> authorityMap = new HashMap<String, String>();
        //表示此地址，不需要任何权限
        authorityMap.put("/static/**", "anon");
        authorityMap.put("/login/**", "anon");
        authorityMap.put("/aserts/**", "anon");
        //表示访问此地址，需要用户的权限为user:query
        authorityMap.put("/user", "perms[user:query]");
        //表示访问此地址，需要用户的角色为manage
        authorityMap.put("/user/add", "roles[manager]");
        //表示访问此地址，需要用户的角色为admin
        authorityMap.put("/user/del/**", "roles[admin]");
        //表示访问此地址，需要用户的角色为manage
        authorityMap.put("/user/update/**", "roles[manager]");
        //表示所有的请求除去静态资源和标记为anon的地址，都要经过登录验证
        authorityMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(authorityMap);

        return shiroFilterFactoryBean;
    }

    /**
     * shiro生命周期处理器
     *
     * @return
     */
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    /**
     * shiro拦截器
     *
     * @return
     */
    @Bean
    public FilterRegistrationBean shiroFilter() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(constructShiroFilter());
        filterRegistrationBean.setDispatcherTypes(DispatcherType.REQUEST);
        filterRegistrationBean.setEnabled(true);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }

    private DelegatingFilterProxy constructShiroFilter() {
        DelegatingFilterProxy delegatingFilterProxy = new DelegatingFilterProxy();
        delegatingFilterProxy.setTargetFilterLifecycle(true);
        //配置shiro拦截器工厂类
        delegatingFilterProxy.setTargetBeanName("shiroFilterFactoryBean");
        return delegatingFilterProxy;
    }
}
