<%--
  Created by IntelliJ IDEA.
  User: 小温
  Date: 2022/9/19
  Time: 19:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl-forEach</title>
</head>
<body>
<table border="1" cellspacing="0" width="100%" >
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>品牌介绍</th>
    </tr>
    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="centor">
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.description}</td>
        </tr>
    </c:forEach>
</table>

<hr size="2" color="gray">

<%--可以做分页查询连接--%>
<c:forEach begin="0" end="10" var="i">
    <a href="#">${i}</a>
</c:forEach>


<hr size="2" color="gray">
<table border="1" cellspacing="0" width="100%" >
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>品牌介绍</th>
    </tr>
    <c:forEach begin="0" end="2" step="1" var="i" varStatus="status">
        <tr align="centor">
            <td>${status.count}</td>
            <td>${brands.get(i).brandName}</td>
            <td>${brands.get(i).companyName}</td>
            <td>${brands.get(i).description}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
