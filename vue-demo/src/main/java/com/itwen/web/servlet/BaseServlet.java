package com.itwen.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    // 根据请求的最后一段路径进行方法分发
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取请求路径
        String requestURI = request.getRequestURI();
        /*System.out.println(requestURI);*/
        // 获取最后一段路径
        int index = requestURI.lastIndexOf("/");
        String methodName = requestURI.substring(index+1);
        /*System.out.println(methodName);*/


        // 执行方法
        // 2.1 获取BrandServlet和UsrServlet的字节码对象 Class
        // this 谁调用我(含有this的方法)，我(this)就代表谁(子类)，指向子类...
        Class<? extends BaseServlet> aClass = this.getClass();
        // 2.2 获取Method对象
        try {
            Method method = aClass.getMethod(methodName,HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, request, response);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
           e.printStackTrace();
        }
        // 2.3 执行对象


    }
}
