package class1;

import java.sql.*;

public class jdbc_ResultSet {

    public static void main(String[] args)  throws  Exception {
        // 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 定义sql语句
        String sql = "select * from account;";

        // 获取执行sql的对象

        Statement stmt = connect.createStatement();

        // 执行sql；
        ResultSet res = stmt.executeQuery(sql);

       // 处理结果
        while (res.next()){
            // 光标向下移动一行，数据是否有效
            int id = res.getInt(1);
            String name = res.getString(2);
            double money = res.getDouble(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(money);

            System.out.println("-------------------");
        }

        // 释放资源
        res.close();
        stmt.close();
        connect.close();

    }
}
