package demo12;

import java.io.*;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/11 19:12
 * 读取文件，并给其每一行加上行号
 */
public class Homework02 {
    public static void main(String[] args) throws IOException {
        try{
            BufferedReader f=new BufferedReader(new FileReader("/Users/zhangzhongxin/Documents/python文件模版的副本.md"));
            BufferedWriter w=new BufferedWriter(new FileWriter("/Users/zhangzhongxin/Documents/python文件模版的副本.txt"));
            String n;
            int count=1;
            while ((n=f.readLine())!=null){
                System.out.println(n);
                w.write(count+n);
                w.newLine();
                count+=1;
            }
            w.flush();
            w.close();

        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
