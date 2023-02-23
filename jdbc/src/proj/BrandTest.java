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
 * 品牌数据的增删改查操作
 *
 * 查询所有数据
 */
public class BrandTest {
    @Test
    public void testSelectAll() throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // 创建对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接
        Connection connection = dataSource.getConnection();

        String sql = "Select * from tb_brand;";
        // 创建prepareStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.executeQuery(sql);

        ResultSet resultSet = preparedStatement.getResultSet();

        Brand brand = null;

        List<Brand> brandList = new ArrayList<>();
        while (resultSet.next()){
            // 获取检索结果
            int id = resultSet.getInt("id");
            String brandName = resultSet.getString("brand_name");
            String companyName = resultSet.getString("company_name");
            int ordered = resultSet.getInt("ordered");
            String description = resultSet.getString("description");
            int status = resultSet.getInt("status");

            // 封装为Brand对象
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
     *添加
     *SQL: insert into tb_brand(bran_name, company_name, ordered, description, status) values (?,?,?,?,?);
     *
     * 除了id都需要
     *
     * 返回Boolean 提示提交是否成功
     *
     * @throws Exception
     */
    @Test
    public void testAdd() throws Exception {

        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 1;
        String description = "绕地球一圈";
        int status = 0;

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // 创建对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接
        Connection connection = dataSource.getConnection();

        String sql = "insert into tb_brand(brand_name, company_name, ordered, description, status) values (?,?,?,?,?);";


        // 创建prepareStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setString(1, brandName);
        preparedStatement.setString(2, companyName);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);


        // 获得修改的行数
        int count = preparedStatement.executeUpdate();
        // 现实处理结果
        System.out.println(count > 0 );

        preparedStatement.close();
        connection.close();

    }

    /**
     *
     * 修改
     *SQL: update tb_brand set brand_name = ?, company_name = ?, ordered = ?, description = ? where id = ?;
     *
     * 都需要
     *
     * 返回Boolean 提示提交是否成功
     *
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {


        int id = 4;
        String brandName = "香飘飘";
        String companyName = "香飘飘";
        int ordered = 30000000;
        String description = "绕地球一圈";
        int status = 0;

        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // 创建对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接
        Connection connection = dataSource.getConnection();

        String sql = "update tb_brand set brand_name = ?, company_name = ?, ordered = ?, description = ?, status = ? where id = ?;";


        // 创建prepareStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, brandName);
        preparedStatement.setString(2, companyName);
        preparedStatement.setInt(3, ordered);
        preparedStatement.setString(4, description);
        preparedStatement.setInt(5, status);
        preparedStatement.setInt(6, id);


        // 获得修改的行数
        int count = preparedStatement.executeUpdate();
        // 现实处理结果
        System.out.println(count > 0 );

        preparedStatement.close();
        connection.close();

    }

    /**
     *删除
     *
     *SQL: delete from tb_brand where id = ?;
     *
     * 都需要
     *
     * 返回Boolean 提示提交是否成功
     *
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {


        int id = 4;


        Properties properties = new Properties();
        properties.load(new FileInputStream("src/class3druid/druid.properties"));
        // 创建对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        // 获取连接
        Connection connection = dataSource.getConnection();

        String sql = "delete from tb_brand where id = ?";


        // 创建prepareStatement对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        preparedStatement.setInt(1, id);


        // 获得修改的行数
        int count = preparedStatement.executeUpdate();
        // 现实处理结果
        System.out.println(count > 0 );

        preparedStatement.close();
        connection.close();

    }

}
