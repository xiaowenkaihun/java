package class1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class jdbc_Statement {
    public static void main(String[] args)  throws  Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 定义sql语句
        String sql = "UPDATE account set money = 2000 WHERE id = 1;";

        // 获取执行sql的对象

        Statement stmt = connect.createStatement();

        // 执行sql；
         int count = stmt.executeUpdate(sql); //受影响的行数  DDL and DML

       // 处理结果
        if(count > 0){
            System.out.println("修改成功");
        }else {
            System.out.println("修改失败");
        }

        // 释放资源
        stmt.close();
        connect.close();

    }
}
