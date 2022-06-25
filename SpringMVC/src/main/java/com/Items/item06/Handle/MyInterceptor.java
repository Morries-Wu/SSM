package com.Items.item06.Handle;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor01拦截器的preHandle");
        //获取登录的账号信息
        String username = "";
        Object attr = request.getSession().getAttribute("username");
        if (attr != null) {
            username = (String) attr;
        }
        System.out.println(username);
        //判断账号
        if ("Morries_Wu".equals(username)) {
            return true;
        } else {
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }

    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor01拦截器的postHandle");

    }


    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor01拦截器的afterCompletion");
    }
}
