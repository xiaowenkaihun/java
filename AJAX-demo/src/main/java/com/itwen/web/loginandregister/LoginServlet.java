package com.itwen.web.loginandregister;

import com.itwen.mapper.UserMapper;
import com.itwen.pojo.User;
import com.itwen.service.UserService;
import com.itwen.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // 获取复选框数据
        String remember = request.getParameter("remember");

        UserService userService = new UserService();

        User user = userService.login(username, password);
        response.setContentType("text/html;charset=UTF-8");

        // 判断user是否为null
        if(user!=null){
            // 判断是否记住密码
            if("1".equals(remember)){
                // 用户勾选
                // 创建两个cookie
                Cookie c_username = new Cookie("username", username);
                Cookie c_password = new Cookie("password", password);
                // 设置存活时间
                c_username.setMaxAge(60*60*24*7);
                c_password.setMaxAge(60*60*24*7);
                // 发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            request.getRequestDispatcher("/selectAllServlet").forward(request, response);
        }else {
            // 跳转回login.jsp
            request.setAttribute("login_msg", "用户名或密码错误");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
