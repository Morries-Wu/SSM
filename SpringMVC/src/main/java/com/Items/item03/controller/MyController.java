package com.Items.item03.controller;

import com.Items.item03.exception.AgeException;
import com.Items.item03.exception.MyUserException;
import com.Items.item03.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException {
        System.out.println("执行了MyController的doSome方法name=" + name + "age=" + age);
        //抛出异常
        System.out.println(name);
        if (!"zs".equals(name)) {
            throw new NameException("姓名不正确");
        }
        if (age == null || age.intValue() > 80) {
            throw new AgeException("年龄太大了");
        }

        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        return mv;
    }

}
