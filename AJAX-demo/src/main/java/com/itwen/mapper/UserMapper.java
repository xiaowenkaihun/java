package com.itwen.mapper;

import com.itwen.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     *
     * 通过注解的方式查询
     * 用户名和密码
     * @param username
     * @param password
     * @return
     */

    User  select(@Param("username") String username, @Param("password") String password);

    User selectByUsername(@Param("username") String username);

    @Insert("insert into tb_user (username, password) values (#{username}, #{password})")
    void addUser(@Param("username") String username ,@Param("password") String password);
}
