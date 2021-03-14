package com.bjpowernode.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


//拦截器类:拦截用户的请求
public class MyInterceptor implements HandlerInterceptor {
    private long btime = 0;
    /**
     *preHandle叫做预处理方法
     *   重要:是整个项目的入口,门户.当你的preHandler返回true,请求可以被处理
     *      preHandler返回false,请求到此方法就截至
     * 参数:
     * Object handler:被拦截的控制器对象
     * 返回值boolean
     *   true:表示请求通过了拦截器的验证,可以执行处理器方法
     *      拦截器MyInterceptor的proHandler()方法
     *      =======执行doSome方法=====
     *      拦截器MyInterceptor的postHandle()方法
     *      拦截器MyInterceptor的afterCompletion()方法
     *   false:请求没有通过拦截器的验证,请求达到拦截器就截止了.请求没有被处理
     *      拦截器MyInterceptor的proHandler()方法
     *
     *
     *   特点:
     *     1.方法在控制器方法(MyController的doSome方法)之前先执行的
     *       用户的请求首先到达此方法
     *
     *     2.在这个方法中可以获取请求的信息,验证请求是否符合要求.
     *       可以验证用户是否登录,验证用户是否有权限访问某个链接地址(url).
     *       如果验证失败,可以截断请求,请求不能被处理
     *       如果验证成功,可以放行请求,此时控制器方法才能执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        btime = System.currentTimeMillis();
        System.out.println("拦截器MyInterceptor的proHandler()方法");

        //给浏览器一个返回结果
       // request.getRequestDispatcher("/tips.jsp").forward(request,response);
        return true;
    }


    /*
       postHandle:后处理方法
       参数:
       Object handler:被拦截的处理器对象MyController
       ModelAndView modelAndView:处理器方法的返回值

       特点:
       1.在处理器方法之后执行的(MyController.doSome())
       2.能够获取到处理器方法的返回值ModelAndView,可以修改ModelAndView中的
       数据和视图,可以影响到最后的执行结果
       3.主要是对原来的执行结果做二次到的修正,

     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView mv) throws Exception {
        System.out.println("拦截器MyInterceptor的postHandle()方法");
        //对原来的doSome执行结果,需要调整
        if(mv != null){
            //修改数据
            mv.addObject("mydate",new Date());
            //修改视图
            mv.setViewName("other");
        }
    }


    /*
       afterCompletion:最后执行的方法
       参数:
         Object handler:被拦截的处理器对象
         Exception ex:程序中发送的异常
        特点:
          1.在请求处理完成后执行的.框架中规定:当你的视图处理完成后,对视图执行了forward.就认为请求处理完成了
          2.一般是做资源回收工作的,程序请求过程中创建了一些对象,在这里可以删除,把占用的内存回收
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        System.out.println("拦截器MyInterceptor的afterCompletion()方法");
        long etime = System.currentTimeMillis();
        System.out.println("计算从preHandler到请求处理完成时间:" + (etime-btime) + "毫秒");
    }
}