package class1;

import class1_1.Account;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class jdbc_ResultSet2 {
    @Test
    public void testResult() throws Exception{
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

        List<Account> list = new ArrayList<>();
        // 处理结果
        while (res.next()){
            Account account = new Account();
            // 光标向下移动一行，数据是否有效
            int id = res.getInt(1);
            String name = res.getString(2);
            double money = res.getDouble(3);

            account.setId(id);
            account.setName(name);
            account.setMoney(money);

            list.add(account);
        }
        System.out.println(list);

        // 释放资源
        res.close();
        stmt.close();
        connect.close();
    }

}

