<%--
  Created by IntelliJ IDEA.
  User: xiaoer
  Date: 2019/12/21
  Time: 22:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String bashPath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="keyword" content="LibraryManager">
    <link rel="shortuct icon" href="<%=bashPath%>assets/images/logo.ico">
    <link type="text/css" href="<%=bashPath%>assets/css/login_admin.css" rel="stylesheet">
    <title>图书管理系统后台登录</title>

    <style type="text/css">
        body {
            background-image: url("<%=bashPath%>assets/images/backgroundAdmin.jpg");
            background-size: cover;
        }
    </style>
</head>
<body>
<div id="context">
    图书管理系统
</div>
<div id="container">
    <div id="box">
        <form action="login_admin_check.jsp" method="post">
            <div id="namediv">
                <label id="name">用户名：</label>
                <input id="nameinput" name="username" value="" placeholder="请输入用户名"/>
            </div>
            <div id="passwddiv">
                <label id="passwd">密&nbsp;&nbsp;&nbsp;码：</label>
                <input id="passwdinput" type="password" name="password" value="" placeholder="请输入密码"/>
            </div>
            <div id="logindiv">
                <input type="submit" value="登录" class="login" style="cursor: pointer;"/>
                <input type="reset" value="清空" class="register" style="cursor: pointer"/>
            </div>
        </form>
    </div>
</div>
</body>
</html>
