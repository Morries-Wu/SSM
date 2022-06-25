<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/12/18
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%String basePath=request.getScheme()+"://"+
        request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>添加</title>
</head>
<body>
    <div align="center">
        <p>注册学生</p>
        <form action="student/addStudent.do" method="post">
            <table>
                <tr>
                    <td>姓名:</td>
                    <td><input type="text"name="name"></td>
                </tr>
                <tr>
                    <td>年龄:</td>
                    <td><input type="text"name="age"></td>
                </tr>
                <tr>
                    <td>操作</td>
                    <td><input type="submit"value="注册"></td>
                </tr>


            </table>
        </form>
        



    </div>

</body>
</html>
