<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 9:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello, Time</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    boolean flag=false;
    if (cookies != null){
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            if ("lastTime".equals(name)){
                flag=true;
                String value = cookie.getValue();
                value = URLDecoder.decode(value,"utf-8");
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                String str_date = sdf.format(date);
                str_date = URLEncoder.encode(str_date, "utf-8");
                cookie.setValue(str_date);
                cookie.setMaxAge(60*60*24*30);//1M
                response.addCookie(cookie);
%>
    <h1>欢迎回来, 您上次访问的时间为:<%=value%></h1>
<%
                break;
            }
        }

    }
    if (cookies == null || cookies.length == 0 || flag==false){
        //没有
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String str_date = sdf.format(date);
        str_date = URLEncoder.encode(str_date, "utf-8");
        out.write(
                "<h1>您好, 欢迎您首次访问</h1>");
        Cookie cookie = new Cookie("lastTime",str_date);
        cookie.setMaxAge(60*60*24*30);//1M
        response.addCookie(cookie);
    }
%>
</body>
</html>
