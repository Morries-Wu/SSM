<%--
  Created by IntelliJ IDEA.
  User: Morries
  Date: 2021/11/1
  Time: 18:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        $(function (){
            //绑定事件
            $("#btnAjax").click(function (){
                $.ajax({
                    //url:"return-void-ajax.do",
                    //url:"doStudentJson.do",
                    url:"doListJsonArray.do",
                    data:{
                        name:"Morries_Wu",
                        age:21,
                    },
                    dataType:"json",
                    //dataType:"text",
                    //resp指的是服务器返回的数据是个形参自定义
                    success:function (resp){
                        //responsedata=XMLHttpRequest.responseText;
                        //alert("responsedata---"+responsedata.name);
                       /* $.each(responsedata,function (i,n){
                           //n{"name":"李四同学","age":26}
                            alert("n.name="+n.name+"\t age="+n.age);
                        })*/
                        alert("responsedata"+resp);
                    }
                });
            });
        });
    </script>


</head>
<body>
    <a href="some.do">发起一个some.do的GET请求</a><br>
    <a href="add.do">发起了Student/add.do的请求</a><br>

    <form action="other.do" method="post">
        <input type="submit" value="post请求">
    </form>

    <p>发起一个some.do的GET请求</p>
    <form action="some.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>



    <p>逐个接收请求</p>
    <form action="receive-property.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>


    <p>逐个接收请求:请求中参数名和形参名不一样</p>
    <form action="receive-param.do" method="post">
        姓名:<input type="text" name="rname"><br>
        年龄:<input type="text" name="rage">
        <input type="submit" value="提交参数">
    </form>

    <p>对象接收参数:请求中参数名和对象属性名一样</p>
    <form action="receive-object.do" method="post">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>

    <p>控制器方法返回String,逻辑名称</p>
    <form action="return-String-view01.do">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>

    <p>控制器方法返回String,完整视图路径</p>
    <form action="return-String-view02.do">
        姓名:<input type="text" name="name"><br>
        年龄:<input type="text" name="age">
        <input type="submit" value="提交参数">
    </form>


    <br/>
    <br/>
    <br/>

    <a href="forward.do">发起forward.do</a>
    <p>重定向Redirect</p>
    <form action="redirect.do" method="post">
        姓名: <input type="text" name="name"> <br>
        年龄: <input type="text" name="age">
             <input type="submit" value="提交"> <br>
    </form>

    <button id="btnAjax">发起Ajax请求</button>





</body>
</html>
