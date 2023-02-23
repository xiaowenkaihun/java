package com.itwen.controller;

import com.itwen.mapper.UserMapper;
import com.itwen.pojo.User;
import com.itwen.utils.MyBatisPlusSqSessionFactoryUtil;
import com.itwen.utils.SqSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/10 16:59
 * 文件描述：
 */
public class TestController {

    @Test
    public void TestMybatis(){
        SqlSessionFactory sqlSessionFactory = SqSessionFactoryUtil.getSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.findAll();
        users.forEach(System.out::println);
    }

    @Test
    public void TestMybatisPlus(){
        SqlSessionFactory sqlSessionFactory = MyBatisPlusSqSessionFactoryUtil.getSqlSessionFactory();
        System.out.println("============");
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
