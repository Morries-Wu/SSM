package com.Items.Item01.Controller;

import com.Items.Item01.Bean.Student;
import com.Items.Item01.Service.StudentService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class AddStudentServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strName = request.getParameter("name");
        String strAge = request.getParameter("age");

       /*
       调用Service
       创建容器,获取service
       String config = "com/Items/Item01/item01.xml";
       ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        */

        //使用spring提供的工具方法,获取容器对象
        ServletContext servletContext = getServletContext();
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        StudentService service = (StudentService) ctx.getBean("studentService");
        System.out.println("在servlet中创建的对象容器:" + ctx);
        Student stu = new Student();
        stu.setStuname(strName);
        stu.setStuage(Integer.valueOf(strAge));
        service.addStudent(stu);

        //给用户显示请求的处理结果
        request.getRequestDispatcher("/show.jsp").forward(request, response);
    }
}
