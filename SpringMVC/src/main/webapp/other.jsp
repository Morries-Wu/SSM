<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/1
  Time: 17:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    other.jsp,显示request作用域中的数据<br>
    <%--param代表参数的集合--%>
    <h3>msg数据:${param.msg}</h3>
    <h3>msg数据:${param.fun}</h3>
    <h3>获取get请求中的参数 <%=request.getParameter("myname")%>  </h3>






</body>
</html>
