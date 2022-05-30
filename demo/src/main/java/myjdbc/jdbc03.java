package myjdbc;

import jdbc.utils.JDBCUtils;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/29 23:56
 * 数据库批处理数据，数据库url里要加参数：rewriteBatchStatements=true
 */
public class jdbc03 {
    public static void main(String[] args) {
        Connection connection = JDBCUtils.getConnection();
        String sql="insert into user(id,name) values(null,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            long start = System.currentTimeMillis();
            for (int i = 0; i < 5000; i++) {
                preparedStatement.setString(1,"jason"+i);
                preparedStatement.addBatch();
                if ((i+1)%1000==0){
                    preparedStatement.executeBatch();
                    preparedStatement.clearBatch();
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("耗时："+BigDecimal.valueOf(end-start,4));
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}
