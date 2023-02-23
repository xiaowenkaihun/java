package com.itwen.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet("/bServlet")
public class bServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取所有的cookie
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie:
             cookies) {
            String name = cookie.getName();
            if ("username".equals(cookie.getName())){
                String value = cookie.getValue();
                value = URLDecoder.decode(value, String.valueOf(StandardCharsets.UTF_8));
                System.out.println(name+":"+value);
            }

        }
        /*for (int i = 0; i < cookies.length; i++) {
            cookies[i].getName();
            cookies[i].getValue();
        }*/
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
