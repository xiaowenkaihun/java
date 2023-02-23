package com.itwen.service;

import com.itwen.mapper.UserMapper;
import com.itwen.pojo.User;
import com.itwen.util.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.nio.charset.StandardCharsets;

public class UserService {
    SqlSessionFactory sqlSessionFactory = SqlSessionUtils.getSqlSessionFactory();
    public User login(String username, String password){
        // 调用mybatis完成查询
        // 1获取SqlSessionFactory对象
        // 2获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3获取mapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        // 4调用方法
        User user = mapper.select(username, password);

        return user;
    }

    public User register(String username){
        // 创建SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 连接mapper class
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 执行sql函数
        username = new String(username.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);

        User user = mapper.selectByUsername(username);

        return user;
    }

    public void addUser(String username, String password){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(username, password);
        sqlSession.commit();
        sqlSession.close();
    }
}
