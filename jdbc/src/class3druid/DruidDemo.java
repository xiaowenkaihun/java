package class3druid;


import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

/**
 * Druid�������ӳ�
 */
public class DruidDemo {
    public static void main(String[] args) throws Exception {
        //����jar��
        //���������ļ�
        //���������ļ�
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/class3druid/druid.properties"));
        //��ȡ���Ӷ���
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        // ��ȡ���ݿ�����
        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        System.out.println(System.getProperty("user.dir"));

        String name  = "zhangsan";
        String pwd = "123";

        String sql = "select * from tb_user where username = ? and password = ? ";

        //��ȡpstmt����
        PreparedStatement pstm = connection.prepareStatement(sql);

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
        connection.close();

    }
}
