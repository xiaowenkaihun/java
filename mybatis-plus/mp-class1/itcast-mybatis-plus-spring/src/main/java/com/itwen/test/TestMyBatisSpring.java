package com.itwen.test;

import com.itwen.mapper.UserMapper;
import com.itwen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/12 20:55
 * 文件描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestMyBatisSpring {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void TestSelectList(){
        List<User> users = this.userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
