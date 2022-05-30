package myjdbc;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/28 19:48
 */
public class jdbc01 {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
        Properties properties = new Properties();
        properties.load(jdbc01.class.getResourceAsStream("/src/mysql.properties"));//读取数据库配置
        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String url = properties.getProperty("url");
        Connection connection = DriverManager.getConnection(url,user,password);
        String sql="select * from `user`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){//循环获取每行的内容，为空的话退出循环
            int id=resultSet.getInt(1);//获取该行第一列数据
            String name =resultSet.getString(2);
            System.out.println("id="+"\t"+id+","+name);
        }
        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}
