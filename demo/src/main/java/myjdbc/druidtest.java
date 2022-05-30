package myjdbc;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/30 16:18
 */
public class druidtest {
    @Test
    public void testdruid() throws Exception {
        Properties properties=new Properties();
        properties.load(druidtest.class.getResourceAsStream("/druid.properties"));
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = dataSource.getConnection();
        System.out.println("连接成功");
        connection.close();
    }
}
