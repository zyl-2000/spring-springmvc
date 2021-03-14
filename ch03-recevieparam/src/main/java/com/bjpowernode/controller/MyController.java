package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

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

public class MyController {
    /*
       处理用户提交的请求,springmvc中是使用方法类处理的,
       方法是自定义的,可以有多种返回值,多种参数,方法名称自定义
     */



    /**
     *   逐个接收请求参数:
     *      要求:处理器(控制器)方法的形参名和请求中参数名必须一致.
     *        同名的请求参数赋值给同名形参
     *   框架接收请求的参数
     *    1.使用request对象接收请求参数
     *     String strName = request.getParameter("name")
     *     String strAge = request.getParameter("age")
     *    2.springmvc框架通过DispatcherServlet 调用MyController的doSome方法
     *      调用方法时,按名称对应,把接收的参数赋值给形参
     *      doSome(strName,Integer.valueOf(strAge))
     *      框架会提供类型转换的功能,能把String转换为int,lang,float,double类型
     *
     *    400状态码:表示客户端错误,表示提交请求参数的过程中,发生了问题

     */
    //指定some.do是GET请求
    @RequestMapping(value = "/receiveproperty.do")
    public ModelAndView doSome(String name,Integer age){
        //处理doSome请求,此处相当于service调用完成了.
        ModelAndView mv = new ModelAndView();
        //添加数据,框架在请求的最后把数据放入到request作用域.
        //request.setAttribute("msg","欢迎使用springmvc做web开发")
        mv.addObject("myName",name);
        mv.addObject("myAge",age);


        mv.setViewName("show");
        //返回mv
        return mv;

    }

    /**
     * 请求中参数名和处理器方法的形参名不一样
     * @RequestParam :在逐个接收请求参数中，解决参数名形参名不一样的问题
     *     属性：1.value 请求中的参数名称
     *          2.required 是一个boolean，默认是true
     *                     true：表示请求中必须包含此参数。
     *     位置： 在处理器方法的形参定义的前面
     */
    @RequestMapping(value = "/receiveparam.do")
    public ModelAndView receiveParam(@RequestParam(value = "rname",required = false) String name,@RequestParam(value = "rage",required = false) Integer age){
        System.out.println("receiveParam, name="+ name + ",age=" + age);
        //处理doSome请求,此处相当于service调用完成了.
        ModelAndView mv = new ModelAndView();
        //添加数据,框架在请求的最后把数据放入到request作用域.
        //request.setAttribute("msg","欢迎使用springmvc做web开发")
        mv.addObject("myName",name);
        mv.addObject("myAge",age);


        mv.setViewName("show");
        //返回mv
        return mv;

    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/receiveobject.do")
    public ModelAndView receiveParam(Student myStudent){
        System.out.println("receiveParam, name="+ myStudent.getName() + ",age=" + myStudent.getAge());
        //处理doSome请求,此处相当于service调用完成了.
        ModelAndView mv = new ModelAndView();
        //添加数据,框架在请求的最后把数据放入到request作用域.
        //request.setAttribute("msg","欢迎使用springmvc做web开发")
        mv.addObject("myName",myStudent.getName());
        mv.addObject("myAge",myStudent.getAge());
        mv.addObject("myStudent",myStudent);

        mv.setViewName("show");
        //返回mv
        return mv;

    }

    @RequestMapping(value = "/receiveList.do")
    public ModelAndView receiveParam(List list){
        System.out.println("receiveParam, name="+ list.get(0) + ",age=" + list.get(1));
        //处理doSome请求,此处相当于service调用完成了.
        ModelAndView mv = new ModelAndView();
        //添加数据,框架在请求的最后把数据放入到request作用域.
        //request.setAttribute("msg","欢迎使用springmvc做web开发")

        mv.setViewName("show");
        //返回mv
        return mv;

    }

}
