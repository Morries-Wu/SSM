package com.Items.item03.Handle;

import com.Items.item03.exception.AgeException;
import com.Items.item03.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice:表示当前类是异常处理类,给Controller增加功能的 位置:在类的上面
 */

@ControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 定义处理异常的方法,当异常发生后,执行这个方法
     * 方法定义和Controller类中方法的定义
     * 处理NameException类型的异常
     * Exception:用来表示Controller抛出来的异常对象
     *
     * @ExceptionHandler:表示此方法处理异常 属性:value异常类的类型
     * 位置:方法的上面
     */

    @ExceptionHandler(value = NameException.class)
    public ModelAndView doNameException(Exception e) {
        /**
         * 1、发生异常,记录到日志文件
         * 2、发送通知,邮件,短信等等
         * 3、给用户友好的提示
         */
        System.out.println("doNameException" + e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips", "姓名只能是zs");
        mv.setViewName("nameError");
        return mv;
    }


    //处理AgeException
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView doAgeException(Exception e) {
        /**
         * 1、发生异常,记录到日志文件
         * 2、发送通知,邮件,短信等等
         * 3、给用户友好的提示
         */
        System.out.println("doAgeException" + e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips", "年龄不能大于80");
        mv.setViewName("AgeError");
        return mv;
    }


    //处理其他异常
    @ExceptionHandler()
    public ModelAndView doOtherException(Exception e) {
        /**
         * 1、发生异常,记录到日志文件
         * 2、发送通知,邮件,短信等等
         * 3、给用户友好的提示
         */
        System.out.println("doOtherException" + e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("tips", "请稍后尝试");
        mv.setViewName("defaultError");
        return mv;
    }


}
