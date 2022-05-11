package demo03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Copy {
    public static void main(String[] args) throws IOException {
        /**
         * 复制文件内容到另一个文件
         */
//        try {
//            InputStream inputStream = new FileInputStream("/Users/zhangzhongxin/Documents/loggging.md");
//            OutputStream outputStream = new FileOutputStream("/Users/zhangzhongxin/Documents/loggging1.md");
//            byte[] bytes = new byte[200];
//            int n;
//            while ((n = inputStream.read(bytes)) != -1) {
//                outputStream.write(bytes,0,n);
//            }
//        }catch (IOException e) {
//            e.printStackTrace();
//        }
        try{
            FileReader fileReader=new FileReader("/Users/zhangzhongxin/Documents/loggging.md");
            int n;
            while ((n=fileReader.read())!=-1){
                System.out.print((char)n);
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
