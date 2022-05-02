package demo05;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Collections;
import java.util.List;

public class Reader {
    public static void main(String[] args) throws IOException {
        StringBuffer stringBuffer=new StringBuffer();
        int n;
        try(InputStreamReader reader=new InputStreamReader(new FileInputStream("readme.txt"),StandardCharsets.UTF_8)){
            while((n=reader.read())!=-1) {
                stringBuffer.append((char)n);
            }
        }
        StringWriter stringWriter=new StringWriter();
        try(PrintWriter printWriter=new PrintWriter(stringWriter)){
            printWriter.println("你好");
            printWriter.println("hello,world");
        }
        System.out.println(stringWriter);
        Files.write(Paths.get("readme.txt"), Collections.singleton("你好"),StandardCharsets.UTF_8);
        List<String> strings = Files.readAllLines(Paths.get("readme.txt"));
        System.out.println(strings);
        Files.write(Paths.get("readme.txt"),"你好呀".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }
}
