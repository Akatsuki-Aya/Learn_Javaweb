<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>foreach标签</title>
</head>
<body>
<%--
    foreach: 相当于Java代码的for语句
        1. 完成重复的操作
            for(int i =0;i<10;i++){

            }
            * 属性:
                begin: 开始值
                end:   结束值
                var:   临时变量
                step:  步长
                varstatus: 循环状态对象
                    index: 容器中元素的索引,从0开始
                    count: 循环次数,从1开始
        2. 遍历容器
            List<User> list;
            foreach(User user : list){

            }
--%>
<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    request.setAttribute("list",list);
%>
<%--    <c:forEach begin="1" end="10" step="2" var="i" varStatus="s">
        <h1>${i}--${s.index}--${s.count}</h1>
    </c:forEach>--%>
    <c:forEach items="${list}" var="str" varStatus="s" >
        <h1>${s.index}--${s.count}--${str}</h1>
    </c:forEach>
</body>
</html>
