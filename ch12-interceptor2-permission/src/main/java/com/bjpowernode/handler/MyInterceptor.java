package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


//拦截器类:拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {

    //验证用户的登录信息,正确return true,其它return false
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("111111-拦截器MyInterceptor的proHandler()方法");
        String loginName = "";
        //从session获取name
        Object name = request.getSession().getAttribute("name");
        if (name != null){
            loginName = (String)name;
        }
        //判断登陆的账户是否符合要求
        if(!"zs".equals(loginName)){
            //不能访问
            request.getRequestDispatcher("/tips.jsp").forward(request,response);
            return false;
        }

        //zs登录
        return true;
    }


}
