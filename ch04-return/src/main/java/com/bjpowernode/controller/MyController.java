package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
     * 处理器方法返回String--表示逻辑视图(路径）名称，需要配置视图解析器
     * @param name
     * @param age
     * @return
     */
    @RequestMapping(value = "/returnString-view.do")
    public String doReturnView(HttpServletRequest request,String name,Integer age){
        //处理doSome请求,此处相当于service调用完成了.
        System.out.println("doReturnView,name="+name+"  age="+ age);
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);
        //show : 逻辑视图名称，项目中配置了视图解析器
        //框架对视图执行forward转发操作
        return "show";

    }
    @RequestMapping(value = "/returnString-view2.do")
    public String doReturnView2(HttpServletRequest request,String name,Integer age){
        //处理doSome请求,此处相当于service调用完成了.
        System.out.println("doReturnView,name="+name+"  age="+ age);
        request.setAttribute("myName",name);
        request.setAttribute("myAge",age);
        //show : 完整视图名称，项目中不能配置视图解析器
        //框架对视图执行forward转发操作
        return "/WEB-INF/view/show.jsp";

    }

    //处理器方法返回void响应ajax请求
    //手工实现ajax，json数据：代码有重复的 1.java对象转为json，2.通过HttpServletRequest输出json数据
    @RequestMapping(value = "/returnVoid-ajax.do")
    public void doReturnView3(HttpServletResponse resp,String name,Integer age) throws IOException {
        //处理doSome请求,此处相当于service调用完成了.
        System.out.println("returnVoid-ajax,name="+name+"  age="+ age);
        //处理ajax，使用json做数据格式
        //service调用完成了，使用Student表示处理结果
        Student student = new Student(name,age);

        String json = "";
        //把结果对象转为json格式的数据
        if (student != null){
            ObjectMapper om = new ObjectMapper();
            json = om.writeValueAsString(student);
            System.out.println("student转换的json=====" + json);
        }

        //输出数据，响应ajax请求
        resp.setContentType("application/json;charset=utf-8");//此处表示告诉浏览器我用的是json
        PrintWriter pw = resp.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();

    }

    /**
     *
     * 处理器方法返回一个Student,通过框架转为json,响应ajax请求
     * @ResponseBody :
     *      作用:把处理器方法返回对象转为json后,通过HttpServletResponse输出给浏览器.
     *      位置:方法定义上面,和其他注解没有顺序关系
     *  返回值对象框架处理流程:
     *    1.框架会把返回Student类型,调用框架中的ArrayList存放的<HttpMessageConverter>中每个类的
     *    canWrite()方法检查哪个HttpMessageConverter接口的实现类能处理Student类型的数据--MappingJackson2HttpMessageConverter
     *    2.框架会调用实现类的write(),MappingJackson2HttpMessageConverter的writer()方法
     *    把李四同学的student对象转为json,调用jackson的objectMapper实现转为json
     *
     *    3.框架会调用@ResponseBody把2的结果数据输出到浏览器,ajax请求处理完成
     */
    @RequestMapping(value = "/returnStudentJson.do")
    @ResponseBody
    public Student doStudentJsonObject(HttpServletResponse resp,String name,Integer age) {
        //调用service,获取请求结果数据,Student对象表示数据结果
        Student student = new Student("李四同学",20);
        return student;
    }


    /**
     *
     * 处理器方法返回一个List<Student>,通过框架转为json,响应ajax请求
     * @ResponseBody :
     *      作用:把处理器方法返回对象转为json后,通过HttpServletResponse输出给浏览器.
     *      位置:方法定义上面,和其他注解没有顺序关系
     *  返回值对象框架处理流程:
     *    1.框架会把返回List<Student>类型,调用框架中的ArrayList存放的<HttpMessageConverter>中每个类的
     *    canWrite()方法检查哪个HttpMessageConverter接口的实现类能处理List<Student>类型的数据--MappingJackson2HttpMessageConverter
     *    2.框架会调用实现类的write(),MappingJackson2HttpMessageConverter的writer()方法
     *    把李四同学的student对象转为json,调用jackson的objectMapper实现转为json
     *
     *    3.框架会调用@ResponseBody把2的结果数据输出到浏览器,ajax请求处理完成
     */
    @RequestMapping(value = "/returnStudentJsonArray.do")
    @ResponseBody
    public List<Student> doStudentJsonObjectArray(HttpServletResponse resp, String name, Integer age) {
        List<Student> list = new ArrayList<>();
        //调用service,获取请求结果数据,Student对象表示数据结果
        Student student = new Student("李四同学", 20);
        Student student2 = new Student("张三同学", 20);
        Student student3 = new Student("赵六同学", 20);
        list.add(student);
        list.add(student2);
        list.add(student3);

        return list;
    }

    /**
     *
     * 处理器方法返回一个String,通过框架转为json,响应ajax请求
     * @ResponseBody :
     *      作用:把处理器方法返回对象转为json后,通过HttpServletResponse输出给浏览器.
     *      位置:方法定义上面,和其他注解没有顺序关系
     *  返回值对象框架处理流程:
     *    1.框架会把返回String类型,调用框架中的ArrayList存放的<HttpMessageConverter>中每个类的
     *    canWrite()方法检查哪个HttpMessageConverter接口的实现类能处理String类型的数据--StringHttpMessageConverter
     *    2.框架会调用实现类的write(),StringHttpMessageConverter的writer()方法
     *    把字符串按照指定的编码来处理
     *
     *    3.框架会调用@ResponseBody把2的结果数据输出到浏览器,ajax请求处理完成
     */

    /**
     * 处理器方法返回的是String，String表示数据的，不是视图
     * 区分返回值String是数据还是视图，看有没有@ResponseBody注解
     * 有：表示数据，反之表示视图
     *
     * 默认使用text/plain;charset=ISO-8859-1作为ContentType，导致中文乱码
     * 解决方案：给RequestMapping增加一个属性produces，使用这个属性指定新的contentType
     */
    @RequestMapping(value = "/returnStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        return "Hello SpringMVC 返回对象，表示数据";
    }



}
