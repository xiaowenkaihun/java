package com.itwen.service.impl;

import com.itwen.mapper.BrandMapper;
import com.itwen.pojo.Brand;
import com.itwen.pojo.PageBean;
import com.itwen.service.BrandService;
import com.itwen.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandServiceImpl implements BrandService {
    // 创建SqlSessionFactory
    SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Brand> selectAll() {
        // 获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取mapper
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        // 执行sql
        List<Brand> brands = mapper.searchAll();
        // 释放资源
        sqlSession.close();
        return brands;
    }

    @Override
    public void addBrand(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.addBrand(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delete(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    public void update(Brand brand){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.update(brand);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public List<Brand> selectByCondition(Integer status, String brandName, String companyName) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(status, brandName, companyName);
        sqlSession.close();
        return brands;
    }

    @Override
    public void batchDelete(int[] ids) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        mapper.batchDelete(ids);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Brand> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);

        // sql所需要的参数
        int begin = (currentPage - 1)*pageSize;
        int size = pageSize;

        // 获得当前页的所有数据
        List<Brand> rows = mapper.selectByPage(begin, size);

        // 数据的总条数
        int totalCount = mapper.selectTotalCount();
        PageBean<Brand> brandPageBean = new PageBean<>();

        // 封装PageBean
        brandPageBean.setRows(rows);
        brandPageBean.setTotalCount(totalCount);
        sqlSession.close();
        return brandPageBean;
    }
}
