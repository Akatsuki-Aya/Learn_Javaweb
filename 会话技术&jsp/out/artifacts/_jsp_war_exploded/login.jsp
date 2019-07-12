<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/12
  Time: 12:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <script>
        window.onload = function () {
            var img = document.getElementById("img");
            img.onclick = function () {
                this.src = "/Cookie/CheckCodeServlet?time="+new Date().getTime();
            }

        }
    </script>
    <style>
        div{
            color: red;
        }
    </style>
</head>
<body>
    <form action="/Cookie/loginServlet" method="post">
        <table>
            <tr>
                <td> 用户名 </td>
                <td> <input type="text" name="username"> </td>
            </tr>
            <tr>
                <td> 密码 </td>
                <td> <input type="password" name="password"> </td>
            </tr>
            <tr>
                <td> 验证码 </td>
                <td> <input type="text" name="checkCode"> </td>
            </tr>
            <tr>
                <td colspan="2"> <img src="/Cookie/CheckCodeServlet" id="img"> </td>
                
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="登录"> </td>
            </tr>
        </table>
    </form>
    <div><%=request.getAttribute("cc_error") == null ? "": request.getAttribute("cc_error")%></div>
    <div><%=request.getAttribute("login_error")== null ? "": request.getAttribute("login_error")%></div>
</body>
</html>
