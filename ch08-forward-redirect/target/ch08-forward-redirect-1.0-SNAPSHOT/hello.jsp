<%--
  Created by IntelliJ IDEA.
  User: z-y-l
  Date: 2020/11/20
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>hello JSP</h3>

<h3>msg数据:${param.myname}</h3>
<h3>fun数据:${param.myage}</h3>
<h3>取参数数据:<%=request.getParameter("myname")%></h3>
</body>
</html>
