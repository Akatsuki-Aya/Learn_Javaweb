<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
</head>
<body>
<h1><%=((User)request.getSession().getAttribute("user")).getUsername()%>,欢迎你</h1>
</body>
</html>
