<%--
  Created by IntelliJ IDEA.
  User: z-y-l
  Date: 2020/11/15
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String basePath = request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/";
    %>
    <title>功能入口</title>
    <base href="<%=basePath%>">
</head>
<body>
    <div align="center">
        <p>SSM整合例子</p>
        <img src="images/img2.jpg">
        <table>
            <tr>
                <td><a href="addStudent.jsp"> 注册学生</a></td>
            </tr>
            <tr>
                <td><a href="listStudent.jsp">浏览学生</a></td>
            </tr>
        </table>
    </div>

</body>
</html>
