package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name,Integer age) {//doGet()
        System.out.println("=======执行doSome方法=====");
        ModelAndView mv = new ModelAndView();

        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //显示转发
        mv.setViewName("show");
        return mv;

    }




}
