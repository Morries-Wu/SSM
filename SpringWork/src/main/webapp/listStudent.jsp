<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/12/18
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath=request.getScheme()+"://"+
            request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/";
%>
<html>
<head>
    <base href="<%=basePath%>">
    <title>浏览学生</title>
    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            //在页面加载后,执行Ajax,获取数据
            getStudentInfo();
            $("#doAjax").click(function (){
                getStudentInfo();
            });
        });

        function  getStudentInfo(){
            $.ajax({
                url:"student/queryStudent.do",
                dataType:"json",
                success:function(resp){
                    $.each(resp,function (i,n){
                        $("#stuinfo").append("<tr><td>"+n.id+"</td><td>"+n.name+"</td><td>"+n.age+"</td></tr>");
                    });
                }
            });
        }


    </script>






</head>
<body>
        <div align="center">
            <p>浏览学生 <button id="doAjax">获取学生数据</button></p>
            <table>
                <%--代表表头的意思thread--%>
                <thread>
                    <tr>
                        <td>id</td>
                        <td>姓名</td>
                        <td>年龄</td>
                    </tr>
                </thread>
                <tbody id="stuinfo">
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </tbody>



            </table>


        </div>

</body>

</html>
