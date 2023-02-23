package com.itwen.web.storehouse;

import com.itwen.pojo.Brand;
import com.itwen.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/selectAllServlet")
public class SelectAllServlet extends HttpServlet {
    BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 调用BrandService完成查询
        ArrayList<Brand> brands = brandService.selectAll();

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie :
                cookies) {
            if("username".equals(cookie.getName())){
                request.setAttribute("username", cookie.getValue());
            }
        }
        // 存入到request的域当中
        request.setAttribute("brands", brands);
        // 转发到brand.jsp当中
        request.getRequestDispatcher("/brand.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
