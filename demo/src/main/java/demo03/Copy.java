package demo03;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.zip.ZipInputStream;

public class Copy {
    public static void main(String[] args) throws IOException {
        /**
         * 复制文件内容到另一个文件
         */
        try(InputStream inputStream=new FileInputStream(args[0])){
            OutputStream outputStream=new FileOutputStream(args[1]);
            int n;
            StringBuffer stringBuffer=new StringBuffer();
            while ((n=inputStream.read())!=-1){
                stringBuffer.append((char)n);
            }
            outputStream.write(stringBuffer.toString().getBytes(StandardCharsets.UTF_8));
        }
    }
}
