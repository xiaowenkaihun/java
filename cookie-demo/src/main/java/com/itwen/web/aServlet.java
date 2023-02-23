package com.itwen.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/aServlet")
public class aServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 发送cookie
        // 1.创建cookie对象

        String value = "张三";
        value = URLEncoder.encode(value, String.valueOf(StandardCharsets.UTF_8));
        Cookie cookie = new Cookie("username", value);
        // 设置cookie的存活时间 7天

        cookie.setMaxAge(60*60*24*7);

        // 2.发送cookie
        response.addCookie(cookie);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
