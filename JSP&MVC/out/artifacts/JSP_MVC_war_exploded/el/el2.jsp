<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取域中数据</title>
</head>
<body>
<%
    //在域中存储数据
    request.setAttribute("name","张三");
    session.setAttribute("age","24");
    session.setAttribute("name","李四");


%>
${requestScope.name}
${sessionScope.age}
${sessionScope.name}
</body>
</html>
