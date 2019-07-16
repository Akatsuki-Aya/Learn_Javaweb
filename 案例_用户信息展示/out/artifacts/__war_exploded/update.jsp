<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
    <head>
<%--    	<base href="<%=basePath%>"/>--%>
        <!-- 指定字符集 -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>修改用户</title>

        <link href="css/bootstrap.min.css" rel="stylesheet">
        <script src="js/jquery-2.1.0.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script>
            function update(user) {
                if(confirm("您确定要修改吗?")){
                    location.href = "${pageContext.request.contextPath}/updateServlet";
                }
            }
        </script>
    </head>
    <body>
        <div class="container" style="width: 400px;">
        <h3 style="text-align: center;">修改联系人</h3>
        <form action="${pageContext.request.contextPath}/updateServlet" method="post">

            <input type="hidden" name="id" value="${update_user.id}">
          <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name"  readonly="readonly" placeholder="请输入姓名" value="${update_user.name}" />
          </div>

          <div class="form-group">
            <label>性别：</label>
              <c:if test="${update_user.gender == '男'}">
                  <input type="radio" name="sex" value="男" checked="checked"  />男
                  <input type="radio" name="sex" value="女"  />女
              </c:if>
              <c:if test="${update_user.gender == '女'}">
                  <input type="radio" name="sex" value="男"   />男
                  <input type="radio" name="sex" value="女" checked="checked" />女
              </c:if>
          </div>

          <div class="form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" id="age"  name="age" placeholder="请输入年龄" value="${update_user.age}" />
          </div>

          <div class="form-group">
            <label for="address">籍贯：</label>
             <select name="address" class="form-control" id="address" >
                <option value="广东">广东</option>
                <option value="广西">广西</option>
                <option value="湖南">湖南</option>
            </select>
          </div>

          <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" class="form-control" id="qq" name="qq" placeholder="请输入QQ号码" value="${update_user.qq}" />
          </div>

          <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" class="form-control" id="email" name="email" placeholder="请输入邮箱地址" value="${update_user.email}" />
          </div>

             <div class="form-group" style="text-align: center">
                <input class="btn btn-primary" type="submit" value="提交" />
                <input class="btn btn-default" type="reset" value="重置" />
                 <a class="btn btn-default" href="${pageContext.request.contextPath}/findUserByPageServlet" role="button">返回</a>             </div>
        </form>
        </div>
    </body>
</html>