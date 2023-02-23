package com.itheima.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet(urlPatterns = "/demo2", loadOnStartup = 1)
public class ServletDemo2 implements Servlet {

    /*
    * 初始化方法
    * 1，调用时机：默认情况下,servlet被第一次访问时，调用
    * 2，调用次数：1次
    * */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 调用次数:每一次servlet被访问的时候，被调用
     * 调用次数： 多次
     *
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service~~~");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 调用时机：内存释放，或者服务器关闭的时候。servlet对象被销毁
     * 调用次数：一次
     *
     */
    @Override
    public void destroy() {
        System.out.println("destroy~~~");
    }
}
