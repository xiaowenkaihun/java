package com.itwen;

import com.itwen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/20 16:43
 * 文件描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserMapper2 {
    @Test
    public void testSelectById(){
        User user = new User();
        user.setId(2L);
        User user1 = user.selectById();
        System.out.println(user1);
    }

    @Test
    public void updateAll(){
        User user = new User();
        user.setAge(23);
        // 全表更新就会阻断
        boolean update = user.update(null);
        System.out.println(update);
    }
    @Test
    public void updateById(){
        User user = new User();
        user.setId(2L);
        user.setAge(23);
        // 全表更新就会阻断
        boolean update = user.updateById();
        System.out.println(update);
    }
}
