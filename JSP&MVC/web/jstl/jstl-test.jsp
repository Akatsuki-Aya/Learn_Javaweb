<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.User" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 22:26
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <style>
        table{
            border: black solid 1px;
            width: 500px;
            align: center;
            text-align: center;
        }
        td{
            border: black solid 1px;
        }
        th{
            border: black solid 1px;
        }
    </style>
</head>
<body>
<%
    List list = new ArrayList();
    list.add(new User("张三",24,new Date()));
    list.add(new User("李四",22,new Date()));
    list.add(new User("王五",23,new Date()));
    request.setAttribute("list",list);
%>
<table align = "center">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>年龄</th>
        <th>生日</th>
    </tr>
<%--
    数据行
--%>
    <c:forEach items="${list}" var="user" varStatus="i">
        <c:if test="${i.index mod 2 ==0 }">
            <tr bgcolor="red">
                <td>${i.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.bitStr}</td>
            </tr>
        </c:if>
        <c:if test="${i.index mod 2 !=0 }">
            <tr bgcolor="green">
                <td>${i.count}</td>
                <td>${user.name}</td>
                <td>${user.age}</td>
                <td>${user.bitStr}</td>
            </tr>
        </c:if>

    </c:forEach>
</table>
</body>
</html>
