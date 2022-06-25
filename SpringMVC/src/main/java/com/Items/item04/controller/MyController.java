package com.Items.item04.controller;

import com.Items.item03.exception.MyUserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(HttpSession session,String name, Integer age) throws MyUserException {
        System.out.println("执行了MyController的doSome方法");
        //添加一个临时数据
        session.setAttribute("attr","在MyController中增加的临时数据");


        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

}
