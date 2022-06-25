package com.Items.Item01.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数(办事的材料)
        String username = req.getParameter("username");
        System.out.println("在Servlet01(柜台1)中查看参数(材料):" + username);

        //給材料 盖一個章, 并传递到Servlet02(柜台2)去查看
        req.setAttribute("key","柜台01的章");

        //问路:Servlet(柜台2)怎么走
        //请求转发必须要以斜杠打头,斜杠表示地址为:http://ip:port/工程名/  映射到IDEA代码的Web目录
        RequestDispatcher patcher = req.getRequestDispatcher("/servlet02");

        //走向Servlet02(柜台2)
        patcher.forward(req,resp);
    }
}
