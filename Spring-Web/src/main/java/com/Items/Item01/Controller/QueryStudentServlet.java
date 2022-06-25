package com.Items.Item01.Controller;

import com.Items.Item01.Bean.Student;
import com.Items.Item01.Service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;

public class QueryStudentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        String config = "com/Items/Item01/item01.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        */

        String stuId = request.getParameter("stuid");
        WebApplicationContext ctx = null;
        //使用了监听器已经创建好了容器对象,从ServletContext作用域获取容器对象
        String key = WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE;
        ServletContext servletContext = getServletContext();//ServletContext,servlet中的方法
        //ServletContext servletContext = request.getServletContext();
        // HttpServletRequest对象的方法
        Object attr = servletContext.getAttribute(key);
        if (attr != null) {
            ctx = (WebApplicationContext) attr;
        }
        System.out.println("在servlet中创建的对象容器:" + ctx);

        StudentService service = (StudentService) ctx.getBean("studentService");
        Student stu = service.findStudentById(Integer.valueOf(stuId));
        System.out.println("Student对象:" + stu);
        request.setAttribute("stu", stu);
        request.getRequestDispatcher("/show.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
