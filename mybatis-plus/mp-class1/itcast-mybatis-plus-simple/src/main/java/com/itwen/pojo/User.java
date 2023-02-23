package com.itwen.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/10 16:51
 * 文件描述：
 */
@Data // get，set
@NoArgsConstructor //无参构造
@AllArgsConstructor //全参构造
@TableName("tb_user")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String name;
    private Integer age;
    private String email;
}
