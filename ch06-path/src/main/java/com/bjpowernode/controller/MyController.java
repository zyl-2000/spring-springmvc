package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Controller: 创建处理器对象,对象放在springmvc容器中.
 * 位置:类的上面
 * 和spring中讲的@Service,@Component
 *
 * 能处理请求的都是控制器(处理器):MyController能处理请求,叫做后端控制器(back controller),DispatcheServlet叫前端控制器（front controller）
 *
 *
 * @RequestMapping:
 *      value:所有请求地址公共部分，叫做模块名称
 *      位置：放在类上面
 */
@Controller
//@RequestMapping("/user")
public class MyController {

    //指定other.do是post请求方式
    @RequestMapping(value = "/user/some.do")
    public ModelAndView doSome(){//doGet()
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","======欢迎使用springmvc做web开发======");
        mv.addObject("fun","执行的是doOther方法");

        mv.setViewName("/index.jsp");
        return mv;

    }


}
