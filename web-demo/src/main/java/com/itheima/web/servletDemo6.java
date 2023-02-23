package com.itheima.web;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class servletDemo6 implements Servlet {
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        //根据请求方式的不同。进行分别处理
        /**
         * 1，获取请求方式
         * 2，判断
         */

        // 获取请求方式
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        //判断

        String method = request.getMethod();
        if("GET".equals(method)){
            //get
        }else if("POST".equals(method)){
            //post
        }



    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
