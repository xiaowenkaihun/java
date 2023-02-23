<%--
  Created by IntelliJ IDEA.
  User: 小温
  Date: 2022/9/19
  Time: 21:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl-forEach</title>
</head>

<body>
<h1>"${username}",欢迎您</h1>
<table border="1" cellspacing="0" width="100%" >
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>品牌介绍</th>
        <th>订单数量</th>
        <th>状态</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="centor">
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.description}</td>
            <td>${brand.ordered}</td>
            <c:if test="${brand.status==1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status==0}">
                <td>禁用</td>
            </c:if>
            <td>
                <a href="ServletDeleteBrand?id=${brand.id}">删除</a>
                <a href="ServletSelectById?id=${brand.id}">修改</a>
            </td>
        </tr>
    </c:forEach>
</table>
<hr>
<center>
    <input type="button" size="10" value="添加" id="add">
</center>

<script>
    document.getElementById("add").onclick = function (){
        location.href = "add.jsp"
    }

</script>
</body>
</html>

