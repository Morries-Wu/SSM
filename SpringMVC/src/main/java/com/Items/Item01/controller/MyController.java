package com.Items.Item01.controller;

import com.Items.Item01.Bean.Student;
import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.List;

/**
 * @Controller 创建控制器(处理器)对象
 * 控制器:叫做后端控制器(back controller),自定义的类处理请求的
 * 位置:在类的上面,表示创建此类的对象,对象放在springmvc的容器中
 * @RequestMapping放在类的上面 属性 value:表示所有请求地址的公共前缀,相当于是模块名称
 * 位置 在类的上面
 */
@Controller
//@RequestMapping("/test")
public class MyController {
    //定义方法,处理请求 public void doGet(){}

    /**
     * springmvc框架,使用控制器类中的方法,处理请求
     * 方法的特点:
     * 1、方法的形参,表示请求中的参数
     * 2、方法的返回值,表示本次请求的处理结果
     *
     * @RequestMapping:请求映射 属性:value  请求中的uri地址,唯一值,以 "/"开头
     * method 请求方式,使用RequestMehtod.GET
     * 是一个数组
     * 位置:1、在方法的上面(必须的)   2、在类定义的上面(可选)
     * 作用:把指定的请求,交给指定的方法处理,等同于url-pattern
     * ModelAndView
     * Model:表示数据
     * View:表示视图
     */

    //指定some.do使用get请求方式
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome(HttpServletResponse response, HttpServletRequest request, HttpSession session) {//doGet()
        //使用这个方法处理请求,能处理请求的方法叫做控制器方法
        //调用service对象,处理请求,返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了Some.do请求");
        mv.addObject("fun", "处理了dosome方法");

        /**
         指定视图,setViewName("视图完整路径")
         mv.setViewName("/WEB-INF/View/show.jsp");
         mv.setViewName("/WEB-INF/View/other.jsp");
         当配置了事务解析器,使用文件的名称作为视图名使用,叫做视图逻辑名称
         使用了逻辑名称,框架使用配置文件视图解析器的前缀和后缀,拼接为完整的视图路径
         /WEB-INF/View/+show+.jsp
         */
        mv.setViewName("show");
        //返回结果
        return mv;
    }

    /**
     * 当框架调用完dosome()方法之后,得到返回中ModelAndView
     * 框架会在后续的处理逻辑值,处理mv对象里面的数据和视图
     * 对数据执行request.setAttribute("msg", "处理了Some.do请求");把数据放入到request作用域
     * 对视图执行forward转发操作,等同于request.getRequestDispatcher("/show.jsp").forward.....;
     */

    //指定使用post
    @RequestMapping(value = {"/other.do", "/second.do"}, method = RequestMethod.POST)
    public ModelAndView doOther() {//doGet()
        System.out.println("执行了MyController的doOther方法");
        //使用这个方法处理请求,能处理请求的方法叫做控制器方法
        //调用service对象,处理请求,返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了other.do请求");
        mv.addObject("fun", "处理了doOther方法");
        mv.setViewName("show");
        //返回结果
        return mv;
    }


    //不指定method属性,请求方式没有限制
    @RequestMapping(value = "/doFirst")
    public ModelAndView doFirst() {//doGet()
        System.out.println("执行了MyController的doFirst 方法");
        //使用这个方法处理请求,能处理请求的方法叫做控制器方法
        //调用service对象,处理请求,返回数据
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg", "处理了other.do请求");
        mv.addObject("fun", "处理了doOther方法");
        mv.setViewName("show");
        //返回结果
        return mv;
    }


    /**
     * 逐个接收请求参数
     * 要求:请求中的参数名和控制器方法的形参名一样,按名称对象接收请求参数
     * <p>
     * 参数接收:
     * 1、框架使用request对象,接收参数
     * String name=request.getParameter("name");
     * String age=request.getParameter("age");
     * <p>
     * 2、在中央调度器的内部调用 doPropertyParam方法时,按名称对象传递参数
     * doPropertyParam(name,Intger.valuof(age))
     * 400:http status,表示客户端异常,主要是发生在用户提交参数过程中
     */
    @RequestMapping(value = "/receive-property.do")
    public ModelAndView doPropertyParam(String name, int age) {
        System.out.println("执行了MyController的doPropertyParam方法name:" + name + "age:" + age);

        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        //返回结果
        return mv;
    }


    /**
     * 逐个接收请求参数:请求中参数名和形参名不一样
     *
     * @RequestParam:解决名称不一样的问题 属性:value 请求中的参数名
     * required:boolean类型,默认是一个
     * true:请求中必须有此参数,没有报错
     * faslse:请求中可以没有此参数
     * 位置:在形参定义的前面
     */
    @RequestMapping(value = "/receive-param.do")
    public ModelAndView doReceiveParam(@RequestParam(value = "rname", required = false) String name,
                                       @RequestParam(value = "rage", required = false) int age) {

        System.out.println("执行了MyController的doReceiveParam方法name:" + name + "age:" + age);
        ModelAndView mv = new ModelAndView();
        //添加数据
        mv.addObject("myname", name);
        mv.addObject("myage", age);
        mv.setViewName("show");
        //返回结果
        return mv;
    }

    /**
     * 使用对象接收请求中的参数
     * 要求:参数名和Java对象属性名一样
     * Java类需要有一个无参构造方法,属性有set方法
     * <p>
     * 框架的处理:
     * 1、调用Student的无参构造方法,创造对象
     * 2、调用对象set方法,同名的参数,调用对应的set方法
     * 参数是name,调用setName(参数值)
     */

    @RequestMapping("/receive-object.do")
    public ModelAndView doReceiveObject(Student student) {
        System.out.println("MyController的方法doReceiveObject:" + student);
        ModelAndView mv = new ModelAndView();
        mv.addObject("myname", student.getName());
        mv.addObject("myage", student.getAge());
        mv.setViewName("show");
        return mv;
    }


    /**
     * 控制器方法返回String,表示逻辑名称,需要项目中配置视图解析器
     */
    @RequestMapping(value = "/return-String-view01.do")
    public String doReturnStringView01(HttpServletRequest request, String name, Integer age) {
        System.out.println("MyController的方法doReturnStringView:" + name + age);
        //返回结果,forward,转发到show.jsp
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        return "show";
    }

    /**
     * 控制器方法返回String,表示完整视图路径,项目中不能配置视图解析器
     */
    @RequestMapping(value = "/return-String-view02.do")
    public String doReturnStringView02(HttpServletRequest request, String name, Integer age) {
        System.out.println("MyController的方法doReturnStringView:" + name + age);
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        //返回结果,forward,转发到show.jsp
        return "/WEB-INF/View/show.jsp";
    }


    /**
     * 控制器方法是返回是void,响应Ajax请求,使用httpServletRequest输出数据
     */
    @RequestMapping(value = "/return-void-ajax.do")
    public void returnvoidAjax(HttpServletResponse response, String name, Integer age) throws IOException {
        System.out.println("MyController的方法doReturnStringView:" + name + age);
        //调用service得到结果对象
        Student stu = new Student();
        stu.setName(name + "同学");
        stu.setAge(age);

        //把对象转为json
        Gson gson = new Gson();
        String json = gson.toJson(stu);
        System.out.println("服务器端对象转化为json" + json);
        //输出json,响应Ajax
        response.getWriter().write(json);


        /**
         *把对象转为json
         * ObjectMapper om=new ObjectMapper();
         *         String json=om.writeValueAsString(stu);
         *         System.out.println("服务器端对象转为的json"+json);
         *         输出json,响应AJAX
         *         response.setContentType("application/json;charset=utf-8");
         *         PrintWriter pw=response.getWriter();
         *         pw.println(json);
         *         pw.flush();
         *         pw.close();
         *
         */
    }

    /**
     * 控制器方法返回Student--json
     * application/json;charset-utf-8
     * <p>
     * 框架处理模式:
     * 1、框架根据控制器方法的返回值类型,找到HttpMessageConverter接口的实现类
     * 最后找到的是MappingJackson2HttpMessageConverter
     * <p>
     * 2、使用实现类MappingJackson2HttpMessageConverter执行它的write()方法
     * 把Student对象转为了json格式的数据
     * 3、框架使用@ResponseBody注解,把2中的json输出给浏览器
     * 设置的Content-type:application/json;charset-utf-8
     */
    @RequestMapping("/doStudentJson.do")
    @ResponseBody
    public Student doAjaxJson(String name, Integer age) {
        System.out.println("控制器方法返回自定义对象Student,转为json" + name + age);
        Student stu = new Student();
        stu.setName("同学" + name);
        stu.setAge(age);
        return stu;
    }


    /**
     * 控制器方法返回是List<Student>--json array
     * 框架的处理模式:
     * 1、框架根据控制器方法的返回值类型,找到HttpMessageConverter接口的实现类
     *      最后找到的是MappingJackson2HttpMessageConverter
     * 2、使用实现类MappingJackson2HttpMessageConverter执行他的write()方法,把student对象转为json格式的数据
     * 3、框架使用@ResponseBody注解,把2中的json输出给浏览器
     */
    @RequestMapping("/doListJsonArray.do")
    @ResponseBody
    public List<Student> doAjaxJsonArray(String name, Integer age) {
        System.out.println("控制器方法返回List<Student>,转为JsonArray" + name + age);
        Student stu01 = new Student();
        stu01.setName("张三同学");
        stu01.setAge(20);

        Student stu02 = new Student();
        stu02.setName("李四同学");
        stu02.setAge(26);

        List<Student> stulist = new ArrayList<>();
        stulist.add(stu01);
        stulist.add(stu02);
        return stulist;
    }

    /**
     * 控制器方法返回String--数据
     *区分返回值String是数据还是视图
     *1、方法上面有@ReponseBody注解就是数据
     *2、方法上面没有@ResponseBody注解就是视图
     *
     * Content-Type:text/plain;charset=ISO-8859-1
     *解决中文,需要使用@RequestMapping的produce属性
     * produce属性:指定content-Type的值
     *
     * 框架处理String返回值
     * 1、框架使用的StringHttpMessageConverter
     * 2、
     *
     */
    @RequestMapping(value = "/doStringData.do",produces = "text/plain;charset=UTF-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        System.out.println("控制器方法返回String,是数据");
        return"Hello SpringMVC注解式开发";
    }


}
