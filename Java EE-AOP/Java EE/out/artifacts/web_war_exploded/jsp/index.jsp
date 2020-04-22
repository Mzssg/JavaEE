<%--
  Created by IntelliJ IDEA.
  User: mazhe
  Date: 2020/3/13
  Time: 1:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div style="height: 300px;">
</div>
<div style="text-align:center;">
    <form action="<%=request.getContextPath()%>/index" method="post" >
        <div id="username">
            <label>用户名：</label>
            <input type="text" style="width:160px;height: 30px;" id="name" name="username" placeholder="输入用户名"/>
        </div>
        <br>
        <div id="password">
            <label>密&emsp;码：</label>
            <input type="password" style="width:160px;height: 30px;" id="word" name="password" placeholder="输入密码"/>
        </div>
        <br>
        <div id="login">
            <button type="submit"style="height: 30px;width: 90px;">登录</button>&emsp;
            <button type="button"style="height: 30px;width: 90px;"onclick="window.location.href='jsp/login.jsp'">注册</button>
        </div>
    </form>
</div>

</body>
</html>