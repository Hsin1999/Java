package demo04;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void main(String[] args) throws IOException {
        /**
         * 写入文件到zip
         */
        try(ZipOutputStream zipOutputStream=new ZipOutputStream(new FileOutputStream("readme.zip"))){
            zipOutputStream.putNextEntry(new ZipEntry("testzip/readme1.txt"));
            zipOutputStream.write(Files.readAllBytes(Paths.get("readme.txt")));
            zipOutputStream.closeEntry();
            zipOutputStream.putNextEntry(new ZipEntry("testzip/readme.txt"));
            zipOutputStream.write(Files.readAllBytes(Paths.get("readme.txt")));
            zipOutputStream.closeEntry();
        }
        /**
         * 读取zip文件流，获取ZipEntry才能读文件流
         */
        try(ZipInputStream zipInputStream=new ZipInputStream(new FileInputStream("readme.zip"))){
            ZipEntry Entry=null;
//            Entry为null则表示没有文件
            while ((Entry=zipInputStream.getNextEntry())!=null){
                if(!Entry.isDirectory()){
                    StringBuffer stringBuffer=new StringBuffer();
                    int n;
                    while ((n=zipInputStream.read())!=-1){
                        stringBuffer.append((char)n);
                    }
                    System.out.println(Entry.getName());
                    System.out.println(stringBuffer);
                }

            }
        }
    }
}
