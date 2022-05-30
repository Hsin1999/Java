package myjdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;

import java.beans.PropertyVetoException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/30 10:58
 */
public class c3p0test {
    public void c3p0test() throws Exception {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        Properties properties = new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        String driver = properties.getProperty("driver");
        //连接是由comboPooledDataSource管理
        comboPooledDataSource.setDriverClass(driver);
        comboPooledDataSource.setJdbcUrl(url);
        comboPooledDataSource.setUser(user);
        comboPooledDataSource.setPassword(password);
        //初始化连接数
        comboPooledDataSource.setInitialPoolSize(10);
        //最大连接数
        comboPooledDataSource.setMaxPoolSize(50);
        long l = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            Connection connection = comboPooledDataSource.getConnection();
            connection.close();
        }
        long l1 = System.currentTimeMillis();
        System.out.println(l1-l);
    }
    @Test
    public void c3p0test_02() throws Exception {
        ComboPooledDataSource comboPooledDataSource=new ComboPooledDataSource("jasonconnect");
        Connection connection = comboPooledDataSource.getConnection();
        connection.close();
    }
}
