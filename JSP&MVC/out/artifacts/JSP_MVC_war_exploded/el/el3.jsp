<%@ page import="domain.User" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/13
  Time: 19:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取对象数据</title>
</head>
<body>
<%
    User user = new User();
    user.setName("张三");
    user.setAge(24);
    user.setBirthday(new Date());
    request.setAttribute("u",user);


    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    list.add(user);
    request.setAttribute("list",list);
    Map map =new HashMap();
    map.put("sname","李四");
    map.put("gender","男");
    request.setAttribute("map",map);
%>
<h1>获取对象中的值</h1>
${requestScope.u}

<%--
    通过的是对象的属性来获取
        * setter或getter方法, 去掉set或get,在将剩余部分, 首字母变为小写
        * setName-->Name-->name
--%>
${requestScope.u.name}<br>
${u.age}<br>
${u.bitStr}<br>
${requestScope.list}<br>
${list[0]}<br>
${list[1]}<br>
${list[10]}<br>
${list[3].name}<br>
${map}<br>
${map["sname"]}<br>
${map.gender}<br>
<h1>empty运算符</h1>
<%
    String str = null;
    request.setAttribute("str",str);
%>
${empty str}
</body>
</html>
