package jdbc.utils;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/29 22:44
 * jdbc工具类
 */
public class JDBCUtils {
    private static final String user;
    private static final String password;
    private static final String url;

    static {//初始化数据库信息
        Properties properties = new Properties();
        try {
            properties.load(new FileReader("src/mysql.properties"));
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            url = properties.getProperty("url");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() {//获取数据库连接
        try {
            return DriverManager.getConnection(url, user, password);
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
