<%--
  Created by IntelliJ IDEA.
  User: 19511
  Date: 2023/6/25
  Time: 14:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body>
<div style="text-align: center">
  <form action="${pageContext.request.contextPath}/user/login" method="post">
    账号: <input type="text" name="username" style="color: aqua"><br>
    密码: <input type="password" name="password"><br>
    <input type="checkbox" name="f" value="1">十天内免登录<br>
    <input type="submit" value="login">
  </form>


</div>
</body>



</html>
