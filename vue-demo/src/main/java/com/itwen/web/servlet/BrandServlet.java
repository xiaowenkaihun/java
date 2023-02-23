package com.itwen.web.servlet;

import com.alibaba.fastjson.JSON;
import com.itwen.pojo.Brand;
import com.itwen.pojo.PageBean;
import com.itwen.service.BrandService;
import com.itwen.service.impl.BrandServiceImpl;
import com.sun.org.apache.bcel.internal.generic.IMPDEP1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Introspector;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/brand/*")
public class BrandServlet extends BaseServlet {
    BrandService brandService = new BrandServiceImpl();

    public void selectAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Brand> brands = brandService.selectAll();
        String jsonString = JSON.toJSONString(brands);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }

    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String param = reader.readLine();

        Brand brand = JSON.parseObject(param, Brand.class);
        brandService.addBrand(brand);

        response.getWriter().write("success");
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        brandService.delete(Integer.parseInt(id));
        response.getWriter().write("success");
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        Brand brand = JSON.parseObject(params, Brand.class);
        brandService.update(brand);
        response.getWriter().write("success");
    }

    public void selectByCondition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String companyName = request.getParameter("companyName");
        String brandName = request.getParameter("brandName");

        brandName = new String(brandName.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        companyName =new String(companyName.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        if(companyName.equals("")){companyName=null;}else {companyName="%"+companyName+"%";}
        if(brandName.equals("")){brandName=null;}else {brandName="%"+brandName+"%";}

        List<Brand> brands = brandService.selectByCondition(Integer.parseInt(status), brandName, companyName);
        System.out.println(brands);
        if (brands.isEmpty()) {
            System.out.println("没有数据");
            response.getWriter().write("empty");
        } else {
            String jsonString = JSON.toJSONString(brands);
            System.out.println(jsonString);
            response.setContentType("text/json;charset=utf-8");
            response.getWriter().write(jsonString);
        }

    }


    public void batchDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = request.getReader();
        String params = reader.readLine();
        System.out.println(params);
        String[] res = params.split(",");
        int[] ids = new int[res.length];
        for (int i = 0; i < res.length; i++) {
            ids[i] = Integer.parseInt(res[i]);
        }
        brandService.batchDelete(ids);
        response.getWriter().write("success");
    }

    public void selectByPage (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 接收当前的页码
        String currentPage = request.getParameter("currentPage");
        String pageSize = request.getParameter("pageSize");

        System.out.println(currentPage);
        System.out.println(pageSize);

        PageBean<Brand> brandPageBean = brandService.selectByPage(Integer.parseInt(currentPage), Integer.parseInt(pageSize));

        String jsonString = JSON.toJSONString(brandPageBean);
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(jsonString);
    }
}
