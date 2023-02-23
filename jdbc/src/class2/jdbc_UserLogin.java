package class2;

import class1_1.Account;
import org.junit.Test;

import java.net.SocketTimeoutException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class jdbc_UserLogin {
    @Test
    public void testLogin() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 用户输入  接收用户名和密码
        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = '"+ name+"' and password = '"+pwd+"' ";

        // 获取stmt对象
        Statement stmt = connect.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录成功与否
        if(rs.next()){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }




        // 释放资源
        rs.close();
        stmt.close();
        connect.close();
    }

    /**
     *  login_inject
     * @throws Exception
     */
    @Test
    public void testLogin_inject() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 用户输入  接收用户名和密码
        String name  = "zhangsan";
        String pwd = "'or'1'='1";

        String sql = "select * from tb_user where username = '"+ name+"' and password = '"+pwd+"' ";

        // 获取stmt对象
        Statement stmt = connect.createStatement();

        // 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        // 判断登录成功与否
        if(rs.next()){
            System.out.println(rs);
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

        // 释放资源
        rs.close();
        stmt.close();
        connect.close();
    }



    /**
     *  login_inject_solve
     * @throws Exception
     */
    @Test
    public void testLogin_inject_solve () throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 用户输入  接收用户名和密码
        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = ? and password = ? ";

        //获取pstmt对象
        PreparedStatement pstm = connect.prepareStatement(sql);

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
        connect.close();

    }

    /**
     * preparestatement原理
     * @throws Exception
     */

    @Test
    public void testPrepareStatement () throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        // 获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // 用户输入  接收用户名和密码
        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = ? and password = ? ";

        //获取pstmt对象
        PreparedStatement pstm = connect.prepareStatement(sql);

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
        connect.close();



    }

}

