package com.itwen;

import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.extension.parsers.BlockAttackSqlParser;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.SqlExplainInterceptor;
import com.itwen.plugings.MyInterceptor;
import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：小温小温今天开荤
 * 日期：2022/11/14 16:40
 * 文件描述：
 */
@MapperScan("com.itwen.mapper")
@Configuration
public class MybatisPlusConfig {
    // 配置我们的分页插件
   // @Bean
   // public PaginationInterceptor paginationInterceptor(){
   //     return new PaginationInterceptor();
   // }
    // sql分析插件
    @Bean// 注入自定义的拦截器
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }

    @Bean
    public SqlExplainInterceptor sqlExplainInterceptor(){
        SqlExplainInterceptor sqlExplainInterceptor = new SqlExplainInterceptor();
        List<ISqlParser> list = new ArrayList<>();
        list.add(new BlockAttackSqlParser()); // 全表更新和删除的阻断器
        sqlExplainInterceptor.setSqlParserList(list);
        return sqlExplainInterceptor;
    }

}

