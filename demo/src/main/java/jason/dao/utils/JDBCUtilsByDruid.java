package jason.dao.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import jdbc.utils.Actor;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
    @Test
    public void test() throws SQLException {
        Connection connection = getConnection();
        String sql="select * from `user`";
        QueryRunner queryRunner = new QueryRunner();
//        List<Actor> query = queryRunner.query(connection, sql, new BeanListHandler<>(Actor.class));
//        for (Actor a :query) {
//            System.out.println(a);
//        }
        Actor query1 = queryRunner.query(connection, sql, new BeanHandler<>(Actor.class));
        System.out.println(query1);
        connection.close();

//        try {
//            PreparedStatement preparedStatement = connection.prepareStatement(sql);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                System.out.println(resultSet.getInt("id")+"\t"+resultSet.getString("name")+"\t"+resultSet.getTimestamp("createtime"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }

    }
}
