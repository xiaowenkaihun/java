package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@WebServlet("/demo5")
public class servletDemo5 extends MyHttpServlet {
    @Override
    protected void doPost(ServletRequest servletRequest, ServletResponse servletResponse) {
        super.doPost(servletRequest, servletResponse);
        System.out.println("post");
    }

    @Override
    protected void doGet(ServletRequest request, ServletResponse response) {
        super.doGet(request, response);
        System.out.println("get");
    }
}
