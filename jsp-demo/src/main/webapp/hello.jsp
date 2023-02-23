<%--
  Created by IntelliJ IDEA.
  User: 小温
  Date: 2022/9/16
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hello jsp</title>
</head>
<body>

<h1>hello jsp</h1>
<%
    /**
     * jsp本身就是一个servlet
     */
    System.out.println("hello jsp~~~");

    int a = 3 ;
%>

<%=
"<h1>wo shi ni die</h1>"
%>


<%!
    void show(){};
    String name = "zhangsan";
%>
</body>
</html>
