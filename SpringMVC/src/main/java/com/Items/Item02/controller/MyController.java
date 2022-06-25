package com.Items.Item02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping(value = "/some")
    public ModelAndView doReturnStringView01(String name, Integer age) {
        System.out.println("执行了MyController的doReturnStringView01方法name=" + name + "age=" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }


    /**
     * 控制器方法返回的是ModelAndView实现转发forwar
     * 语法:mv.setViewName("forward:视图完整路径“)
     * forward特点:不和视图解析器一同工作的,就当项目中没有视图解析器
     */
    @RequestMapping(value = "/forward.do")
    public ModelAndView doForward() {
        System.out.println("执行了MyController的forward.do方法");
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了forward.do请求");
        mv.addObject("fun", "执行了forward.do方法");
        //显示使用forward指定转发操作
        mv.setViewName("forward:/WEB-INF/View/show.jsp");
        return mv;
    }


    /**
     * 当控制器方法返回ModelAndView实现重定向
     * 语法:mv.setViewName("redirect:视图完整路径")
     * redirect特点:不和视图解析器一同工作,就当项目中没有视图解析器
     *1、框架可以实现两次请求之间的数据传递,把第一个请求中的Model里面
     *   简单类型的数据,转为字符串,附加到目标页面的后面,做get参数传递
     *   可以在目标页面中获取参数值使用
     *
     * 2、在目标页面中,可以使用${param.参数名}获取参数的值
     *
     */

    @RequestMapping("/redirect.do")
    public ModelAndView doRedirect(String name, Integer age) {
        System.out.println("doRedirect,name:" + name + ",age:" + age);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("redirect:/other.jsp");
        //http://localhost:8008/SpringMVC/ohter.jsp?myname=春哥&myage=22
        return mv;
    }


}
