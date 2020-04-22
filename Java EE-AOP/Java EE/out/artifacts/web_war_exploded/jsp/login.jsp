<%--
  Created by IntelliJ IDEA.
  User: mazhe
  Date: 2020/3/13
  Time: 1:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<div style="height: 300px;">
</div>
<div style="text-align:center;">
    <form action="<%=request.getContextPath()%>/login" method="post" class="log" >
        <div id="type">
            <label>用户类：</label>&emsp;
            <input type="radio" name="type" value="2">教师&emsp;&emsp;
            <input type="radio" name="type" value="1">学生
        </div>
        <br>
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
            <button type="submit"style="height: 30px;width: 90px;">注册</button>
        </div>
    </form>
</div>
</body>
</html>
