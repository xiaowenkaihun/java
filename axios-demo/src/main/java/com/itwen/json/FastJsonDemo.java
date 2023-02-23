package com.itwen.json;

import com.alibaba.fastjson.JSON;

public class FastJsonDemo {
    // 将Java的对象转化为JSON字符串
    public static void main(String[] args) {
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("sdfiwu");

        String jsonString = JSON.toJSONString(user);

        System.out.println(jsonString);

        User user1 = JSON.parseObject("{\"id\":1,\"password\":\"sdfiwu\",\"username\":\"zhangsan\"}", User.class);
        System.out.println(user1);
    }
    //
}
