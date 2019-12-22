<%--
  Created by IntelliJ IDEA.
  User: xiaoer
  Date: 2019/12/21
  Time: 23:07
  To change this template use File | Settings | File Templates.
--%>
<%request.setCharacterEncoding("UTF-8"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"
         import="java.util.*,java.sql.*,java.net.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <title>后台管理登录页面</title>
</head>
<body>
<%
    // 接收用户名和密码
    String user = new String(request.getParameter("username").getBytes("ISO-8859-1"), "UTF-8");
    String passwd = request.getParameter("password");

    String driverClass = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=UTF-8";
    String username = "yangqi";
    String password = "xiaoer";
    // 加载驱动
    Class.forName(driverClass);
    Connection conn = DriverManager.getConnection(url, username, password);
    String sql = "select * from manager where manager_id = ? and manager_password = ?";
    PreparedStatement prep = conn.prepareStatement(sql);
    prep.setString(1, user);
    prep.setString(2, passwd);
    ResultSet rs = prep.executeQuery();
    if (rs.next()) {
        // 解决乱码
        response.sendRedirect("login_admin_success.jsp?username=" + URLEncoder.encode(user));
    } else {
        // 密码不对，返回到登录
        response.sendRedirect("login_admin.jsp?errNo");
    }
    rs.close();
    prep.close();
    conn.close();
%>
</body>
</html>
