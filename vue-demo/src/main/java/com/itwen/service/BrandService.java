package com.itwen.service;

import com.itwen.pojo.Brand;
import com.itwen.pojo.PageBean;

import java.util.List;

public interface BrandService {
    /**
     * 查询所有
     * @return
     */
    List<Brand> selectAll();

    /**
     * 添加品牌
     * @param brand
     */
    void addBrand(Brand brand);

    /**
     * 删除信息
     * @param id
     */
    void delete(int id);

    /**
     * 修改
     * @param brand
     */
    void update(Brand brand);

    List<Brand> selectByCondition(Integer status, String brandName, String companyName);

    void batchDelete(int[] ids);

    /**
     * 分页查询
     * @param currentPage 当前页码
     * @param pageSize 每页的条数
     * @return
     */
    PageBean<Brand> selectByPage(int currentPage, int pageSize);
}
