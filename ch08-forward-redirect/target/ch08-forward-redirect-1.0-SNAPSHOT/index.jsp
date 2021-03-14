<%--
  Created by IntelliJ IDEA.
  User: z-y-l
  Date: 2020/11/6
  Time: 20:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        String basePath = request.getScheme() + "://" +
                request.getServerName() + ":" + request.getServerPort() +
                request.getContextPath() + "/";
    %>
    <base href="<%=basePath%>">
</head>
<body>
  <p>当处理器方法返回ModelAndView实现forward</p>
<form action="doForward.do" method="post">
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交请求">
</form>


  <p>当处理器方法返回ModelAndView实现redirect</p>
<form action="doRedirect.do" method="post">
    姓名:<input type="text" name="name"><br>
    年龄:<input type="text" name="age"><br>
    <input type="submit" value="提交请求">
</form>

</body>
</html>
