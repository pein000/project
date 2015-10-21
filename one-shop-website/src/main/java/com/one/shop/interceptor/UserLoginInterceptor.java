package com.one.shop.interceptor;

import com.one.shop.consts.SystemVariable;
import com.one.shop.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by pein on 2015/10/20.
 */
public class UserLoginInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       logger.info("Interceptor: check login user.");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(SystemVariable.SESSION_KEY_USER);

        if(user == null){
            logger.info("Interceptor: forward to login.jsp!");
            //转发到登录页面
            response.sendRedirect(request.getContextPath()+"/toLogin");
            //request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
            //request.getRequestDispatcher("/toLogin").forward(request, response);
            return false;
        }else
            return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
