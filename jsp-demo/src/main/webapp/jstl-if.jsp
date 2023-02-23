<%--
  Created by IntelliJ IDEA.
  User: 小温
  Date: 2022/9/19
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--引入jstl的标签--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>jstl-if</title>
</head>
<body>
    <%--完成java里面的判断功能--%>
    <%--<c:if test="true">
      <h1>true</h1>
    </c:if>

    <c:if test="false">
        <h1>false</h1>
    </c:if>--%>

    <c:if test="${status==1}">
        <center><h1>启用</h1></center>
    </c:if>
    <c:if test="${status==0}">
        <center><h1>禁用</h1></center>
    </c:if>

</body>
</html>
