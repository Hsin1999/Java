package jason.dao.test;

import jason.dao.dao.ActorDao;
import jason.dao.domain.Actor;
import jason.dao.utils.JDBCUtilsByDruid;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/31 11:09
 */
public class Actordaotest {
    @Test
    public void test() throws IOException, SQLException {
//        ActorDao actorDao=new ActorDao();
//        for (int i = 0; i < 5000; i++) {
//            actorDao.update("insert into `user`(id,name) value(null,?)", "j"+i);
//        }
        Properties properties=new Properties();
        properties.load(new FileReader("src/mysql.properties"));
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        QueryRunner queryRunner=new QueryRunner();
        Connection connection = DriverManager.getConnection(url, user, password);
        Connection connection1 = JDBCUtilsByDruid.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into `user`(id,name) value(null,?)");
        preparedStatement.setString(1,"k");
        for (int i = 0; i < 50000; i++) {
//            queryRunner.update(connection1,"insert into `user`(id,name) value(null,?)", "ja"+i);
            preparedStatement.setString(1,"k"+i);
            preparedStatement.executeUpdate();
//            preparedStatement.addBatch();
//            if ((i+1)%5000==0){
//                preparedStatement.executeBatch();
//                preparedStatement.clearBatch();
//            }
        }
        preparedStatement.close();
        connection.close();
    }
}
