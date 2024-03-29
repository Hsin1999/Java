package jdbc.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import myjdbc.druidtest;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Properties;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/30 16:49
 * Druid数据库连接池
 */
public class JDBCUtilsByDruid {
    private static final DataSource ds;
    static {
        try {
            Properties properties=new Properties();
            properties.load(JDBCUtilsByDruid.class.getResourceAsStream("/druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void close(ResultSet set, Statement statement, Connection connection) {//关闭数据库连接
        try {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
