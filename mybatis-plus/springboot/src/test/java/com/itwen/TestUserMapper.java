package com.itwen;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itwen.mapper.UserMapper;
import com.itwen.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/14 10:38
 * 文件描述：
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestUserMapper {
    @Autowired
    private UserMapper userMapper;
    @Test
    public void testInsert(){
        User user = new User();
        user.setAge(24);
        user.setUserName("lisisisisi");
        // user.setEmail("123471098@qq.com");
        user.setMail("0843y50384@gmail.com");
        user.setPassword("23423");
        user.setName("李四");
        user.setAddress("beijing");
        int insert = this.userMapper.insert(user);
        System.out.println("数据库受影响的行数result==>"+insert);
        // 获取自增长后的id，自增长的id会回填到user对象当中
        System.out.println("id==>"+user.getId());
    }

    @Test
    public void selectById(){
        User user = this.userMapper.selectById(2);
        System.out.println(user);
    }
    @Test
    public void testUpdateById(){
        User user = new User();
        user.setId(2L);// 更新的条件id
        user.setUserName("wangwu");// 更新的字段
        user.setAge(34);
        user.setName("王五");
        user.setPassword("345234");
        user.setMail("34092y890@qq.com");
        int result = this.userMapper.updateById(user);
        System.out.println("result==>"+result);
    }
    @Test
    public void testUpdate(){
        User user = new User();
        user.setAge(35);// 更新的字段
        user.setName("王五11111111");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "wangwu"); // 匹配user_name=wangwu的条件
        int result = this.userMapper.update(user, wrapper);
        System.out.println("result==>"+result);
    }
    @Test
    public void testUpdate2(){
        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.set("age", 21).set("password","99999999999").eq("user_name","zhaoliu");// 更新的条件
        int result = this.userMapper.update(null, wrapper);
        System.out.println("result==>"+result);
    }

    @Test
    public void testDeleteById(){
        int result = this.userMapper.deleteById(9L);
        System.out.println("result==>"+result);
    }

    @Test
    public void testDeleteByMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("user_name", "wangwu");
        map.put("age", 24);
        // 根据map删除数据，条件之间是and的关系
        int result = this.userMapper.deleteByMap(map);
        System.out.println("result==>"+result);
    }

    @Test
    public void testDelete1(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 根据包装的条件进行删除 and
        wrapper.eq("user_name", "wangwu").eq("password","123456");

        int result = this.userMapper.delete(wrapper);
        System.out.println("result==>"+result);
    }

    @Test
    public void testDelete2(){
        User user = new User();
        user.setUserName("sunqi");
        user.setPassword("123456");
        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
        // 根据包装的条件进行删除 and
        int result = this.userMapper.delete(wrapper);
        System.out.println("result==>"+result);
    }

    @Test
    public void testDeleteBatchIds(){
        // 根据id进行批量删除
        int result = this.userMapper.deleteBatchIds(Arrays.asList(10L, 11L, 12L, 13L));
        System.out.println("result==>"+result);
    }
    @Test
    public void testSelectByIds(){
        // 根据id进行批量查询
        List<User> users = this.userMapper.selectBatchIds(Arrays.asList(2L, 4L));
        users.forEach(System.out::println);
    }
    @Test
    public void testSelectByWrapper(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("user_name", "lisi");
        User user = this.userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void testSelectCount(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.gt("age", 20);
        Integer result = this.userMapper.selectCount(wrapper);
        System.out.println("result==>"+result);
    }

    @Test
    public void testSelectList(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "qq");
        List<User> users = this.userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectPage(){
        // 查询第一页两条数据
        Page<User> page = new Page<>(1, 2);
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "qq");
        IPage<User> userIPage = this.userMapper.selectPage(page, wrapper);
        System.out.println("数据的总条数："+userIPage.getTotal());
        System.out.println("当前的页数："+userIPage.getCurrent());
        System.out.println("数据的总页数："+userIPage.getPages());
        List<User> records = userIPage.getRecords();
        records.forEach(System.out::println);
    }
    @Test
    /*测试自定义的方法*/
    public void testFindById(){
        User user = this.userMapper.FindById(2L);
        System.out.println(user);
    }

    @Test
    /*测试自定义的方法*/
    public void testFAllEq(){
        Map<String, Object> map = new HashMap<>();
        map.put("name", "李四");
        map.put("age", 23);
        map.put("user_name", null);
        // and关系
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // SELECT id,user_name,name,age,email AS mail FROM tb_user WHERE user_name IS NULL AND name = ? AND age = ?
        // wrapper.allEq(map);
        //  SELECT id,user_name,name,age,email AS mail FROM tb_user WHERE name = ? AND age = ?
        // wrapper.allEq(map, false);
        // SELECT id,user_name,name,age,email AS mail FROM tb_user WHERE age = ?
        wrapper.allEq((k, v)->(k.equals("age")||k.equals("id")), map);
        List<User> users = this.userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    /*测试自定义的方法*/
    public void testSelect(){
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.like("email", "qq").select("name");
        List<User> users = this.userMapper.selectList(wrapper);
        users.forEach(System.out::println);

    }

}
