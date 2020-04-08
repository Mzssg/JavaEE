<%--
  Created by IntelliJ IDEA.
  User: mazhe
  Date: 2020/3/13
  Time: 14:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page import="main.java.model.applymodel" %>
<%@ page import="main.java.model.user" %>
<%@ page import="main.java.jdbc.jdbc" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>教师</title>
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
<div >
    <div style="position:absolute;width:300px;height:1000px;background-color:#f0f0f0;">
        <div id="mz"style="position:absolute;width:300px;top:40px;">
            <ul style="list-style-type:none;margin: 0;padding: 0;text-align:left;"><br />
                <li><a style="font-size:25px;text-decoration:none;color:#005bac;width:300px;display:inline-block;padding:0.5em 0 0.5em 0;" href="<%=request.getContextPath()%>/main/webapp/jsp/addhomework.jsp"> &emsp;&emsp;&emsp;&emsp;添加作业 </a></li>
                <li><a style="font-size:25px;text-decoration:none;color:#005bac;width:300px;display:inline-block;padding:0.5em 0 0.5em 0;" href="<%=request.getContextPath()%>/main/webapp/jsp/addstudent.jsp"> &emsp;&emsp;&emsp;&emsp;添加学生 </a></li>
                <li><a style="font-size:25px;text-decoration:none;color:#005bac;width:300px;display:inline-block;padding:0.5em 0 0.5em 0;" href="<%=request.getContextPath()%>/main/webapp/jsp/checkhomework.jsp"> &emsp;&emsp;&emsp;&emsp;查看学生作业 </a></li>
            </ul>
        </div>
    </div>
    <div style="position:absolute;left:300px;width:1120px;height:1000px;text-align:center;">
        <%
            List<applymodel> list = jdbc.teacherhomework(user.username);
            if (list == null || list.isEmpty()) {
        %>
        <h2 style="text-align: center;">
            作业列表为空
        </h2>
        <%
        } else {
        %>
        <form  method="get" action="<%=request.getContextPath()%>/checkhomework"  style="left: 50px;">
            <table border="1" cellspacing="0"  style="text-align: center; ">
                <tr>
                    <th>作业名</th>
                    <th>作业回答</th>
                    <th>学生</th>
                </tr>
                <%
                    for (applymodel li : list) {
                %>
                <tr>
                    <td>
                        <%=li.gethomeworkname()%>
                    </td>
                    <td>
                        <%=li.getanswer()%>
                    </td>
                    <td>
                        <%=li.getstudent()%>
                    </td>

                </tr>
                <%
                        }
                    }
                %>
            </table>
        </form>
    </div>
</div>
</body>
</html>
