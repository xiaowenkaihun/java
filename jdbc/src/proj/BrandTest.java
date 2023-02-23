package proj;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 *
 * Ʒ�����ݵ���ɾ�Ĳ����
 *
 * ��ѯ��������
 */
public class BrandTest {
    @Test
    public void testSelectAll() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // ��������
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // ��ȡ����
        Connection connection = dataSource.getConnection();

        String sql = "Select * from tb_brand;";
        // ����prepareStatement����
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeQuery(sql);

        ResultSet resultSet = preparedStatement.getResultSet();

        Brand brand = null;

        List<Brand> brandList = new ArrayList<>();
        while (resultSet.next()){
            // ��ȡ�������
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            // ��װΪBrand����
            brand = new Brand();
            brand.setId(id);
            brand.setBrandName(brandName);
            brand.setCompanyName(companyName);
            brand.setOrdered(ordered);
            brand.setDescription(description);
            brand.setStatus(status);

            brandList.add(brand);
        }

        System.out.println(brandList);
        resultSet.close();
        preparedStatement.close();
        connection.close();

    }

    /**
     *���
     *SQL: insert into tb_brand(bran_name, company_name, ordered, description, status) values (?,?,?,?,?);
     *
     * ����id����Ҫ
     *
     * ����Boolean ��ʾ�ύ�Ƿ�ɹ�
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {

        String brandName = "��ƮƮ";
        String companyName = "��ƮƮ";
        int ordered = 1;
        String description = "�Ƶ���һȦ";
        int status = 0;

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // ��������
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // ��ȡ����
        Connection connection = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values (?,?,?,?,?);";


        // ����prepareStatement����
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, brandName);
        preparedStatement.setString(2, companyName);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);


        // ����޸ĵ�����
        int count = preparedStatement.executeUpdate();
        // ��ʵ������
        System.out.println(count > 0 );

        preparedStatement.close();
        connection.close();

    }

    /**
     *
     * �޸�
     *SQL: update tb_brand set brand_name = ?, company_name = ?, ordered = ?, description = ? where id = ?;
     *
     * ����Ҫ
     *
     * ����Boolean ��ʾ�ύ�Ƿ�ɹ�
     *
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {


        int id = 4;
        String brandName = "��ƮƮ";
        String companyName = "��ƮƮ";
        int ordered = 30000000;
        String description = "�Ƶ���һȦ";
        int status = 0;

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // ��������
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // ��ȡ����
        Connection connection = dataSource.getConnection();

        String sql = "update tb_brand set brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? where id = ?;";


        // ����prepareStatement����
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brandName);
        preparedStatement.setString(2, companyName);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);
        preparedStatement.setInt(6, id);


        // ����޸ĵ�����
        int count = preparedStatement.executeUpdate();
        // ��ʵ������
        System.out.println(count > 0 );

        preparedStatement.close();
        connection.close();

    }

    /**
     *ɾ��
     *
     *SQL: delete from tb_brand where id = ?;
     *
     * ����Ҫ
     *
     * ����Boolean ��ʾ�ύ�Ƿ�ɹ�
     *
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {


        int id = 4;


        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // ��������
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // ��ȡ����
        Connection connection = dataSource.getConnection();

        String sql = "delete from tb_brand where id = ?";


        // ����prepareStatement����
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);


        // ����޸ĵ�����
        int count = preparedStatement.executeUpdate();
        // ��ʵ������
        System.out.println(count > 0 );

        preparedStatement.close();
        connection.close();

    }

}
