package com.itwen.web.storehouse;

import com.itwen.pojo.Brand;
import com.itwen.service.BrandService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet("/ServletAddBrand")
public class ServletAddBrand extends HttpServlet {
    BrandService brandService = new BrandService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String brandName = request.getParameter("brandName");
        String companyName = request.getParameter("companyName");
        String ordered = request.getParameter("ordered");
        String description = request.getParameter("description");
        String status = request.getParameter("status");

        // tomcat的格式是ISO_8859_1
        // 所以需要转换
        brandName = new String(brandName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        companyName = new String(companyName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        description = new String(description.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        // 封装brand对象

        Brand brand = new Brand();

        brand.setBrandName(brandName);
        brand.setCompanyName(companyName);
        brand.setOrdered(Integer.parseInt(ordered));
        brand.setStatus(Integer.parseInt(status));
        brand.setDescription(description);

        // 调用service完成添加
        brandService.addBrand(brand);

        // 转发到查询所有
        request.getRequestDispatcher("/selectAllServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
