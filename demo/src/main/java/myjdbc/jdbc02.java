package myjdbc;
import jdbc.utils.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/29 22:58
 */
public class jdbc02 {
    public static void main(String[] args) {
        Connection connection= JDBCUtils.getConnection();
        String sql="select * from `user`";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println(id+"\t"+name);
            }
            JDBCUtils.close(resultSet,preparedStatement,connection);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


}
