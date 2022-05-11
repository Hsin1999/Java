package demo12;

import java.io.File;
import java.io.IOException;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/11 19:09
 * 查找一个文件是否存在，如果不存在新建一个文件
 */
public class Homework01 {
    public static void main(String[] args) {
        File file=new File("/Users/zhangzhongxin/Documents/loggging2.md");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
