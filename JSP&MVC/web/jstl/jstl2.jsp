<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>choose标签</title>
</head>
<body>
    <%--
        完成数字编号对应星期几案例
            1. 域中存储一数字
            2. 使用choose标签取出数字        相当于switch声明
            3. 使用when标签做数字判断        相当于case
            4. otherwise标签做其他情况的声明 相当于default
    --%>
    <%
        request.setAttribute("number",5);
    %>
    <c:choose>
        <c:when test="${number == 1}"><h1>星期一</h1></c:when>
        <c:when test="${number == 2}"><h1>星期二</h1></c:when>
        <c:when test="${number == 3}"><h1>星期三</h1></c:when>
        <c:when test="${number == 4}"><h1>星期四</h1></c:when>
        <c:when test="${number == 5}"><h1>星期五</h1></c:when>
        <c:when test="${number == 6}"><h1>星期六</h1></c:when>
        <c:when test="${number == 7}"><h1>星期天</h1></c:when>
        <c:otherwise><h1>数字输入有误</h1></c:otherwise>

    </c:choose>

</body>
</html>
