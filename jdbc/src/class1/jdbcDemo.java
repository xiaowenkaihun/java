package class1;

import com.mysql.jdbc.Driver;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbcDemo {
    public static void main(String[] args)  throws  Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 定义sql语句
        String sql = "UPDATE account set money = 2000 WHERE name = '李四';";

        // 获取执行sql的对象

        Statement stmt = connect.createStatement();

        // 执行sql；
         int count = stmt.executeUpdate(sql); //受影响的行数

       // 处理结果
        System.out.println(count);

        // 释放资源
        stmt.close();
        connect.close();

    }
}
