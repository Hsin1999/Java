
import demo09.Person;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class PersonTest {
    @Disabled
    @Test
    void classTest() throws IOException {
        InputStream resourceAsStream = getClass().getResourceAsStream("/default.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("a"));
        PrintStream printStream=new PrintStream("readme.txt");
        printStream.println("你好！！！！");
        printStream.printf("nihao%s","zhangzhongxin");
    }

    @Disabled
    @Test
    void eq(){
        Person zhangzhongxin = new Person("zhangzhongxin", "21");
        System.out.println(zhangzhongxin.equals(new Person("zhangzhongxin", "21")));
    }
    @Disabled
    @Test
    void write() throws IOException {
        List<String> list=new ArrayList<>();
        list.add("加一行");
        list.add("加二行");
        list.add("加三行");
//        Files.write(Paths.get("readme.txt"),list,StandardCharsets.UTF_8,StandardOpenOption.APPEND);
//        byte[] bytes = Files.readAllBytes(Paths.get("readme.txt"));
        Writer writer=new OutputStreamWriter(Files.newOutputStream(Paths.get("readme.txt")),StandardCharsets.UTF_8);
        writer.write("你好\n");
        writer.append("你也好");
        writer.close();

//        System.out.println(new String(bytes, StandardCharsets.UTF_8));
        try(ZipOutputStream zipOutputStream=new ZipOutputStream(new FileOutputStream("zzx.zip"))){
            zipOutputStream.putNextEntry(new ZipEntry("zzx/readme.txt"));
            zipOutputStream.write(Files.readAllBytes(Paths.get("readme.txt")));
            zipOutputStream.closeEntry();
        }
        try (ZipInputStream zipInputStream=new ZipInputStream(new FileInputStream("zzx.zip"))){
            ZipEntry nextEntry;
            while ((nextEntry =zipInputStream.getNextEntry())!=null){
                if(!(nextEntry.isDirectory())){
                    Reader reader = new InputStreamReader(zipInputStream);
                    String line;
                    BufferedReader bufferedReader=new BufferedReader(reader);
                    while ((line=bufferedReader.readLine())!=null){
                        System.out.println(line);
                    }
                }
            }

        }

    }
    @Test
    void t(){
        File file =new File("./","copy1.png");
        System.out.println(file.isFile());
//        System.out.println(Arrays.toString(file.list()));
    }
}
