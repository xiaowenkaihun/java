package class3druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Druid数据连接池
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //导入jar包
        //定义配置文件
        //加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/class3druid/druid.properties"));
        //获取连接对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // 获取数据库链接
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        System.out.println(System.getProperty("user.dir"));

        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = ? and password = ? ";

        //获取pstmt对象
        PreparedStatement pstm = connection.prepareStatement(sql);

        // 设置？的值
        pstm.setString(1, name);
        pstm.setString(2, pwd);

        // 执行sql
        ResultSet rs  = pstm.executeQuery();

        if(rs.next()){
            System.out.println("登录成功");
        }else {
            System.out.println("登录失败");
        }

        rs.close();
        pstm.close();
        connection.close();

    }
}
