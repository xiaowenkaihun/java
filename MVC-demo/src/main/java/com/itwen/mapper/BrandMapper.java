package com.itwen.mapper;

import com.itwen.pojo.Brand;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;

public interface BrandMapper {
    ArrayList<Brand> selectAll();

    void addBrand(Brand brand);

    void deleteBrand(int id);

    @ResultMap("brandResultMap")
    @Select("select * from tb_brand where id = #{id}")
    Brand selectById(int id);

    @Update("update tb_brand set brand_name=#{brandName},company_name=#{companyName},ordered=#{ordered},description=#{description}," +
            "status=#{status} where id =#{id}")
    void update(Brand brand);
}
