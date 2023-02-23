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
        // ��ȡ����
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // �û�����  �����û���������
        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = '"+ name+"' and password = '"+pwd+"' ";

        // ��ȡstmt����
        Statement stmt = connect.createStatement();

        // ִ��sql
        ResultSet rs = stmt.executeQuery(sql);

        // �жϵ�¼�ɹ����
        if(rs.next()){
            System.out.println("��¼�ɹ�");
        }else{
            System.out.println("��¼ʧ��");
        }




        // �ͷ���Դ
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
        // ��ȡ����
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // �û�����  �����û���������
        String name  = "zhangsan";
        String pwd = "'or'1'='1";

        String sql = "select * from tb_user where username = '"+ name+"' and password = '"+pwd+"' ";

        // ��ȡstmt����
        Statement stmt = connect.createStatement();

        // ִ��sql
        ResultSet rs = stmt.executeQuery(sql);

        // �жϵ�¼�ɹ����
        if(rs.next()){
            System.out.println(rs);
            System.out.println("��¼�ɹ�");
        }else{
            System.out.println("��¼ʧ��");
        }

        // �ͷ���Դ
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
        // ��ȡ����
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // �û�����  �����û���������
        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = ? and password = ? ";

        //��ȡpstmt����
        PreparedStatement pstm = connect.prepareStatement(sql);

        // ���ã���ֵ
        pstm.setString(1, name);
        pstm.setString(2, pwd);

        // ִ��sql
        ResultSet rs  = pstm.executeQuery();

        if(rs.next()){
            System.out.println("��¼�ɹ�");
        }else {
            System.out.println("��¼ʧ��");
        }

        rs.close();
        pstm.close();
        connect.close();

    }

    /**
     * preparestatementԭ��
     * @throws Exception
     */

    @Test
    public void testPrepareStatement () throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        // ��ȡ����
        String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useSSL=false&useServerPrepStmts=true";
        String username = "root";
        String password = "2410";
        Connection connect = DriverManager.getConnection(url, username, password);
        // �û�����  �����û���������
        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = ? and password = ? ";

        //��ȡpstmt����
        PreparedStatement pstm = connect.prepareStatement(sql);

        // ���ã���ֵ
        pstm.setString(1, name);
        pstm.setString(2, pwd);

        // ִ��sql
        ResultSet rs  = pstm.executeQuery();

        if(rs.next()){
            System.out.println("��¼�ɹ�");
        }else {
            System.out.println("��¼ʧ��");
        }

        rs.close();
        pstm.close();
        connect.close();



    }

}

