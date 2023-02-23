package com.itwen.mapper;

import com.itwen.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface BrandMapper {

    ArrayList<Brand> selectAll();

    void  addBrand();
}
