package com.itwen.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itwen.pojo.User;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/14 10:32
 * 文件描述：
 */
public interface UserMapper extends BaseMapper<User> {
    /*int update(User user, QueryWrapper<Object> wrapper);*/

    User FindById(Long id);
}
