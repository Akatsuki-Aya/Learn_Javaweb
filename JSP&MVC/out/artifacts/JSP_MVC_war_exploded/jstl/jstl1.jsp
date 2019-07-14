<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>if标签</title>
</head>
<body>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
    request.setAttribute("number",3);
%>
<%--
   c:if标签
    * test必须属性, 接受boolean表达式
        * 如果表达式为true, 则显示if标签体内容, 如果为false, 则不显示标签体内容
        * 一般情况下, test 属性会结合el表达式一起使用
    * 注意: c:if标签没有else情况, 想要else情况, 则可以在定义一个c:if标签
--%>
    <c:if test="${not empty list}">
<%--        <c:forEach begin="0" end="">

        </c:forEach>--%>
        <h1>遍历集合...</h1>
    </c:if>
    <c:if test="${number mod 2 != 0}">
        <h1>${number}是奇数</h1>
    </c:if>
</body>
</html>
