package demo12;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/11 19:26
 * 读取properties数据
 */
public class Homework03 {
    public static void main(String[] args) {
        Properties properties=new Properties();
        try {
            properties.load(Homework03.class.getResourceAsStream("/dog.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
