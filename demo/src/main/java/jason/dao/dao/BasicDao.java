package jason.dao.dao;

import jdbc.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/31 01:06
 */
public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    public int update(String sql, Object... parameters) {
        Connection connection = null;
        try {
            connection = jason.dao.utils.JDBCUtilsByDruid.getConnection();
            int update = queryRunner.update(connection, sql, parameters);
            return update;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jason.dao.utils.JDBCUtilsByDruid.close(null, null, connection);
        }
    }
    public List<T> queryMulti(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = jason.dao.utils.JDBCUtilsByDruid.getConnection();
            List<T> query = queryRunner.query(connection, sql,new BeanListHandler<>(clazz),parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jason.dao.utils.JDBCUtilsByDruid.close(null, null, connection);
        }
    }
    public T querySingle(String sql,Class<T> clazz,Object... parameters){
        Connection connection = null;
        try {
            connection = jason.dao.utils.JDBCUtilsByDruid.getConnection();
            T query = queryRunner.query(connection, sql,new BeanHandler<>(clazz),parameters);
            return query;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jason.dao.utils.JDBCUtilsByDruid.close(null, null, connection);
        }
    }
    public Object queryScalar(String sql,Object... parameters){
        Connection connection = null;
        try {
            connection = jason.dao.utils.JDBCUtilsByDruid.getConnection();
            return queryRunner.query(connection, sql,new ScalarHandler<>(),parameters);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            jason.dao.utils.JDBCUtilsByDruid.close(null, null, connection);
        }
    }
}
