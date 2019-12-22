<%--
  Created by IntelliJ IDEA.
  User: xiaoer
  Date: 2019/12/21
  Time: 20:52
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
    <link type="text/css" href="<%=bashPath%>assets/css/register.css" rel="stylesheet">
    <title>注册页面</title>
</head>
<body>
<div id="context">
    图书管理系统注册页面
</div>
<div id="container">
    <div id="admin">
        <form action="login_admin.jsp" method="post">
            <div id="login_admin">
                <input type="submit" value="后台登录" class="login_admin" style="cursor: pointer">
            </div>
        </form>
    </div>
    <div id="box">
        <form action="login.jsp" method="post">
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
            </div>
        </form>
        <form action="regsiter.jsp" method="post">
            <div id="registerdiv">
                <input type="submit" value="注册" class="register" style="cursor: pointer;" />
            </div>
        </form>
    </div>
</div>
</body>
</html>
