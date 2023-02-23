package com.itwen.web;

import com.itwen.mapper.BrandMapper;
import com.itwen.pojo.Brand;
import com.itwen.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@WebServlet("/demo1")
public class ServletDemo1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 准备数据
        SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSqlSessionFactory();

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        ArrayList<Brand> brands = mapper.selectAll();

        // 存储到request的域当中
        request.setAttribute("brands", brands);
        request.setAttribute("status",1);

        // 转发到el-demo.jsp
        /*request.getRequestDispatcher("/el-demo.jsp").forward(request, response);*/
        /*request.getRequestDispatcher("/jstl-if.jsp").forward(request, response);*/
        request.getRequestDispatcher("/jstl-forEach.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
