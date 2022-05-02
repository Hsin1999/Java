package demo02;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class file {
    public static void main(String[] args) throws IOException {
        int n;
        StringBuffer stringBuffer=new StringBuffer();
        try(InputStream inputStream=new FileInputStream("readme.txt")){
            while ((n=inputStream.read())!=-1){
                stringBuffer.append((char)n);
            }
        }
        System.out.println(stringBuffer);


    }

    /**
     * 读取字符流
     * @param inputStream 字符流
     * @return 转换为String
     * @throws IOException
     */
    public static String ReadFile(InputStream inputStream) throws IOException {
        int n;
        StringBuffer stringBuffer = new StringBuffer();
        while ((n= inputStream.read())!=-1){
            stringBuffer.append((char)n);
        }
        return stringBuffer.toString();
    }

}
