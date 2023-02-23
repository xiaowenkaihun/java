package com.itwen.web.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录验证过滤器
 *
 */
@WebFilter("/*")
public class AFilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 强转为Http的servlet
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        // 判断访问的路径是不是和登录注册相关
        // 包含下面的资源都应该被放行
        String[] urls = {"/login.jsp", "/imgs/", "/css/", "/loginServlet", "/register,jsp", "/registerServlet", "/checkCodeServlet"};

        String url = request.getRequestURI().toString();

        for (String u :
                urls) {
            if(url.contains(u)){
                // 找到了无条件放行
                filterChain.doFilter(request, servletResponse);

                return;
            }
        }
        // 判断session里面是不是有user对象
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");

        if(user!=null){
            // user对象存在，说明登录过了
            filterChain.doFilter(servletRequest, servletResponse); // 执行请求访问资源
        }else {
            // 没有登录。存储提示信息
            request.setAttribute("login_msg", "您尚未登录");
            request.getRequestDispatcher("login.jsp").forward(request, servletResponse );
        }
    }

    @Override
    public void destroy() {

    }
}
