<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/12/19
  Time: 11:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>退出操作</title>
</head>
<body>
    退出系统<%session.removeAttribute("username");%>

</body>
</html>
