<%@ page import="com.itwen.pojo.Brand" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.itwen.util.SqlSessionUtils" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.itwen.mapper.BrandMapper" %><%--
  Created by IntelliJ IDEA.
  User: 小温
  Date: 2022/9/16
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSqlSessionFactory();

    SqlSession sqlSession = sqlSessionFactory.openSession();

    BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

    ArrayList<Brand> brands = mapper.selectAll();

    System.out.println(brands);


%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<input type="button" value="新增"><br>
<hr>
<table border="1" cellspacing="0" width="800">

    <%
        for (int i = 0; i < brands.size(); i++) {
            Brand brand = brands.get(i);
    %>
    </tr>
    <tr align="center">
        <td><%=brand.getId()%></td>
        <td><%=brand.getBrandName()%></td>
        <td><%=brand.getCompanyName()%></td>
        <td><%=brand.getOrdered()%></td>
        <td><%=brand.getDescription()%></td>
        <%
            if(brand.getStatus()==0){
        %>

        <td><%="禁用"%></td>
        <%
            } else{
        %>
        <td><%="启用"%></td>
        <%
            }
        %>
        <td><a href="#">修改</a> <a href="#">删除</a></td>

    </tr>


    <%
        }
    %>


</table>

</body>
</html>
