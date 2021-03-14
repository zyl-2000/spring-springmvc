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
</head>
<body>
   <p>提交参数给Controller</p>
   <form method="post" action="receiveproperty.do">
       姓名：<input type="text" name="name" /><br>
       年龄: <input type="text" name="age" /><br>
       <input type="submit" value="提交参数">
   </form>
   <p>请求参数名和处理器方法的形参名不一样</p>
   <form method="post" action="receiveparam.do">
       姓名：<input type="text" name="rname" /><br>
       年龄: <input type="text" name="rage" /><br>
       <input type="submit" value="提交参数">
   </form>

   <p>使用java对象接收请求参数</p>
   <form method="post" action="receiveobject.do">
       姓名：<input type="text" name="name" /><br>
       年龄: <input type="text" name="age" /><br>
       <input type="submit" value="提交参数">
   </form>
</body>
</html>
