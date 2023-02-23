package com.itwen.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 放行前一般会对request的数据进行处理， 编码
        // 资源访问之前只有request的数据
        // response是不携带数据的

        System.out.println("1. FilterDemo..");
        // 放行
        filterChain.doFilter(servletRequest, servletResponse); // 执行请求访问资源
        // 获得response
        // 此时response含有数据
        // 对response的数据进行处理
        System.out.println("3. FilterDemo..");
    }

    @Override
    public void destroy() {

    }
}
