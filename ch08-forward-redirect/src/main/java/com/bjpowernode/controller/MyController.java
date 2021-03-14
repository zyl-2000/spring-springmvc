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

    /**
     * 处理器方法返回ModelAndView,实现转发forward
     * 语法:setViewName("forward:视图完整路径")
     * forward特点:不和视图解析器一同使用,就当项目中没有视图解析器
     *
     * @return
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doSome(){//doGet()
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","======欢迎使用springmvc做web开发======");
        mv.addObject("fun","执行的是doOther方法");
        //显示转发
        mv.setViewName("forward:/WEB-INF/view/show.jsp");
        return mv;

    }

    /**
     * 处理器返回的是ModelAndView,实现重定向redirect
     * 语法:setViewName("redirect:完整试图路径")
     * redirect特点:不和视图解析器一同使用,就当项目中没有视图解析器
     *
     * 框架对重定向的操作
     * 1.框架会把Model中的简单类型的数据,转为字符串使用,作为hello.jsp的get请求参数使用
     *
     *   目的是:doRedirect.do和hello.jsp 两次请求之间传递数据
     *
     * 2.重定向不能访问WEB-INF下的资源
     *
     * @return
     */
    @RequestMapping(value = "/doRedirect.do")
    public ModelAndView doWithRedirect(String name,Integer age){//doGet()
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //显示转发
        mv.setViewName("redirect:/hello.jsp");

        //http://localhost:8080/ch08_forward_redirect/hello.jsp?myname=%E6%97%B6%E9%97%B4%E7%AE%80%E5%8F%B22&myage=12
        return mv;

    }


}
