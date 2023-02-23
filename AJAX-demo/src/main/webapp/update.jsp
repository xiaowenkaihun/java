<%--
  Created by IntelliJ IDEA.
  User: 小温
  Date: 2022/9/24
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>

<style>
    body{
        background-image: url("imgs/1.png");
        width: 100%;
    }

    div.div1{
        margin: auto;
        background: gray;
        opacity: 50%;
        width: 50%;
    }

    input[type=submit] {
        width: 100%;
        background-color: #4CAF50;
        color: white;
        padding: 14px 20px;
        margin: 8px 0;
        border: none;
        border-radius: 4px;
        cursor: pointer;
    }

    input[type=submit]{
        background: chartreuse;
    }
    input[type=text]  {
        width: 90%;
        padding: 12px 20px;
        margin: 10px;
        display: inline-block;
        border: 1px solid #ccc;
        border-radius: 4px;
        box-sizing: border-box;
    }
    textarea{
        width: 80%;
        margin: auto;
    }
</style>

<body>
<center>
    <h1>请根据表格内容进行添加</h1>
</center>
<hr color="gray" size="2">
<div class="div1">
    <div class="div2">
        <form action="/MVC-demo/ServletUpdate" method="post">

            <input type="hidden" name="id" value="${brand.id}">
            <label for="品牌">品牌</label>
            <input type="text" id="品牌" name="brandName" placeholder="${brand.brandName}"><br>

            <label for="公司">公司</label>
            <input type="text" id="公司" name="companyName" placeholder="${brand.companyName}"><br>

            <label for="订单数量">订单数量</label>
            <input type="text" id="订单数量" name="ordered" placeholder="${brand.ordered}"><br>
            
            状态
            <c:if test="${brand.status==1}">
                <label for="启用">启用</label>
                <input type="radio" id="启用" name="status" value="1" checked>
                <label for="禁用">禁用</label>
                <input type="radio" id="禁用" name="status" value="0" ><br>
            </c:if>

            <c:if test="${brand.status==0}">
                <label for="启用">启用</label>
                <input type="radio" id="启用" name="status" value="1" >
                <label for="禁用">禁用</label>
                <input type="radio" id="禁用" name="status" value="0"checked><br>
            </c:if>

            <label for="描述">描述</label><br>
            <textarea id="描述" cols="20" rows="10" name="description">${brand.description}</textarea><br>

            <input type="submit" value="Submit"><br>
        </form>
    </div>
</div>
</body>
</html>