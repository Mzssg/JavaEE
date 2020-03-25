<%--
  Created by IntelliJ IDEA.
  User: mazhe
  Date: 2020/3/13
  Time: 1:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="model.addhomeworkmodel" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="jdbc.jdbc" %>
<%@ page import="model.user" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生</title>
    <style>
        #mz a:hover {
            color: aliceblue !Important;
            background-color: #005bac;
        }
    </style>
</head>
<body>
<div style="height:100px;background-color:#005bac;"><br>
<h2 style="color: #f0f0f0;">&emsp;&emsp;作业管理系统</h2>
</div>
<div>
    <div style="position:absolute;width:300px;height:1000px;background-color:#f0f0f0;">
        <div id="mz"style="position:absolute;width:300px;top:40px;">
            <ul style="list-style-type:none;margin: 0;padding: 0;text-align:left;"><br />
                <li><a style="font-size:25px;text-decoration:none;color:#005bac;width:300px;display:inline-block;padding:0.5em 0 0.5em 0;" href="<%=request.getContextPath()%>/main/web/jsp/student.jsp"> &emsp;&emsp;&emsp;&emsp;查看作业 </a></li>
            </ul>
        </div>
    </div>
    <div style="position:absolute;left:300px;width:1120px;height:1000px;">
        <%
            List<addhomeworkmodel> list = jdbc.studenthomework(user.username);

            if (list == null || list.isEmpty()) {
                System.out.println(list);
        %>
        <h2 style="text-align: center;">
            作业列表为空
        </h2>
        <%
        } else {
        %>
        <form  method="get" action="<%=request.getContextPath()%>/apply"  style="left: 50px;">
            <table  border="1" cellspacing="0"  style="text-align: center; ">
                <tr>
                    <th>作业名</th>
                    <th>作业内容</th>
                    <th>教师</th>
                    <th>回答</th>
                    <th>操作</th>
                </tr>
                <%
                    for (addhomeworkmodel li : list) {
                %>
                <tr>
                    <td>
                        <%=li.gethomeworkname()%>
                    </td>
                    <td>
                        <%=li.gethomework()%>
                    </td>
                    <td>
                        <%=li.getteachername()%>
                    </td>
                    <td>
                        <input type="text" style="width:160px;height:160px;" id="answer" name="answer" placeholder="输入回答"/>
                    </td>
                    <td>
                        <input id="homework" name="homework" type="hidden" value=" <%=li.gethomeworkname()%>">
                        <button type="submit"style="height: 30px;width: 90px;">提交</button>&emsp;
                    </td>
                </tr>
                    <%}%>
            </table>
        </form>
       <%
            }
        %>
    </div>
</div>
</body>
</html>
