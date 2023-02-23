package class1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc_Connection {
    public static void main(String[] args) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 定义sql语句
        String sql1 = "UPDATE account set money = 3000 WHERE name = '李四';";
        String sql2 = "UPDATE account set money = 3000 WHERE name = '张三';";

        // 获取执行sql的对象

        Statement stmt = connect.createStatement();


        // 执行sql；
        try {
            // 开启事务
            connect.setAutoCommit(false);

            int count1 = stmt.executeUpdate(sql1); //受影响的行数
            System.out.println(count1);
            int i = 3 / 0;// 制造异常
            int count2 = stmt.executeUpdate(sql2); //受影响的行数
            System.out.println(count2);
            // 提交事务
            connect.commit();
        } catch (Exception e) {
            // 回滚事务
            connect.rollback();
            e.printStackTrace();
        }
        // 释放资源
        stmt.close();
        connect.close();

    }
}
