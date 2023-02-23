package com.itwen.mapper;

import com.itwen.pojo.Brand;
import com.itwen.pojo.PageBean;
import org.apache.ibatis.annotations.*;

import java.util.Base64;
import java.util.List;

public interface BrandMapper {

    /**
     * 查询所有
     * @return
     */
    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> searchAll();

    /**
     * 添加
     * @param brand
     */
    @Insert("insert into tb_brand (brand_name, company_name, ordered, description, status) VALUES (#{brandName}, #{companyName}," +
            "#{ordered}, #{description}, #{status})")
    void addBrand(Brand brand);

    /**
     * 删除
     * @param id
     */
    @Delete("delete from tb_brand where id = #{id}")
    void deleteById(int id);

    /**
     * 修改
     * @param brand
     */
    @Update("update tb_brand set brand_name=#{brandName}, company_name=#{companyName}, ordered=#{ordered}, " +
            "description=#{description}, status=#{status} where id=#{id}")
    void update(Brand brand);
    List<Brand> selectByCondition(@Param("status") Integer status,
                                         @Param("brandName") String brandName,
                                         @Param("companyName") String companyName);

    void batchDelete(@Param("ids") int[] ids);
    List<Brand> selectByPage(@Param("startPage") int startPage, @Param("pageSize") int pageSize);


    @Select("select count(*) from tb_brand;")
    int selectTotalCount();
}
