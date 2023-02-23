package com.itwen;

import com.itwen.mapper.UserMapper;
import com.itwen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/14 10:38
 * 文件描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestSpringboot {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testSpringBoot(){
        List<User> users = this.userMapper.selectList(null);
        users.forEach(System.out::println);
        System.out.println("====================================================");
    }
}
