package com.itwen.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itwen.pojo.User;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/10 16:55
 * 文件描述：
 */
public interface UserMapper extends BaseMapper<User>{
    List<User> findAll();
}
