package com.itwen.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/14 10:28
 * 文件描述：
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
// @TableName("tb_user")
public class User extends Model<User> {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    // 查询时不返回字段的值
    @TableField(select = false)
    private String password;
    private String name;
    private Integer age;
    @TableField(value = "email") // 指定数据库中的字段名
    private String mail;
    // 在数据库当中是不存在的
    @TableField(exist = false)
    private String address;
}

