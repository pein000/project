package com.one.shop.authority;

import com.one.shop.entity.Role;
import com.one.shop.entity.User;
import com.one.shop.service.AuthenticationService;
import com.one.shop.util.JSONUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by pein on 2015/11/17.
 */
@Component
public class ShiroRealm extends AuthorizingRealm{

    private Logger LOGGER = LoggerFactory.getLogger(ShiroRealm.class);

    @Autowired
    private AuthenticationService authenticationService;

    /**
     *权限认证--认证
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获取登录时用户名
        String loginName = (String) principals.fromRealm(getName()).iterator().next();
        //从数据库根据用户名查询用户。
        User user = authenticationService.findUserByName(loginName);
        if(user != null) {
            //AuthorizationInfo用户存放用户的所有role和permission
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            //用户的角色（Role）集合
            List<Role> roleList = authenticationService.findRolesByUser(user);
            if(roleList == null || roleList.isEmpty()){
                LOGGER.warn("user has no role. user = {}", JSONUtils.toJson(user));
                return null;
            }
            //jdk8 -- Set<String> roleNames = roleList.stream().map(Role::getName).collect(Collectors.toSet());
            Set<String> roleNames = new HashSet<String>();
            for(Role role : roleList) {
                roleNames.add(role.getName());
            }
            //用户的所有角色添加到authorizationInfo中
            authorizationInfo.setRoles(roleNames);
            Set<String> permissionSet =  authenticationService.findPermissionByRole(roleList);
            //用户所有的权限
            authorizationInfo.setStringPermissions(permissionSet);
            return authorizationInfo;

        }
        return null;
    }

    /**
     * 登录认证 --授权
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //usernamePasswordToken用于存放提交的登录信息
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken)token;
        //根据登录的用户名，从数据库查询用户
        User user = authenticationService.findUserByName(usernamePasswordToken.getUsername());
        if (user != null) {
            //如果存在，将用户信息存放到登录认证authenticationInfo中
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPassword(), getName());
            return authenticationInfo;
        }
        return null;
    }
}
