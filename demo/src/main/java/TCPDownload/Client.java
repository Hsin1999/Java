package TCPDownload;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 15:07
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(InetAddress.getLocalHost(),18888);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入要下载的文件名：");
        String next = scanner.next();
        writer.write(next);
        writer.newLine();
        writer.flush();
        InputStream inputStream = socket.getInputStream();
        byte[] bytes=toByte.tobyte(inputStream);
        OutputStream outputStream1=new FileOutputStream("/Users/zhangzhongxin/Documents/"+next);
        outputStream1.write(bytes);
        outputStream1.flush();
        outputStream1.close();
        socket.close();
    }
}
