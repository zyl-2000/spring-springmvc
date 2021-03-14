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
    <script type="text/javascript" src="js/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function () {
            $("button").click(function () {
              //  alert("button click")
                $.ajax(
                    {
                        //url:"returnVoid-ajax.do",
                       // url:"returnStudentJson.do",
                        //url:"returnStudentJsonArray.do",
                        url:"returnStringData.do",
                        data:{
                            name:"zhangsan",
                            age:20,
                        },
                        type:"post",
                        //dataType:"json",//此处表示我想用json，当服务器端标明返回结果是json时，可以不写，//resp.setContentType("application/json;charset=utf-8");
                        dataType:"text",
                        success:function (resp) {
                            //resp从服务器端返回的是json格式的字符串{"name" : "zhangsan" , "age":20}
                            //jQuery会把字符串转化为json对象，赋值给resp形参
                            //[{"name":"李四同学","age":20},{"name":"张三同学","age":20},{"name":"赵六同学","age":20}]
                     /*       $.each(resp,function (i,n) {
                                alert(n.name + "  " + n.age)
                            })
                            alert(resp[0].name + "," + resp[0].age)*/
                            alert("返回的是文本数据：" + resp);
                        }
                    }
                )
            })
        })

    </script>
</head>
<body>
   <p>处理器方法返回String表示视图名称</p>
   <form method="post" action="returnString-view.do">
       姓名：<input type="text" name="name" /><br>
       年龄: <input type="text" name="age" /><br>
       <input type="submit" value="提交参数">
   </form>

   <p>处理器2方法返回String表示视图名称</p>
   <form method="post" action="returnString-view2.do">
       姓名：<input type="text" name="name" /><br>
       年龄: <input type="text" name="age" /><br>
       <input type="submit" value="提交参数">
   </form>

   <br>
   <button id="btn">发起ajax请求</button>

</body>
</html>
