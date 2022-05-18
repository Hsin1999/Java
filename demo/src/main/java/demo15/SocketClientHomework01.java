package demo15;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 14:10
 */
public class SocketClientHomework01 {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(InetAddress.getLocalHost(),9999);
        System.out.println("正在准备发送数据....");
        Scanner scanner=new Scanner(System.in);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
        System.out.println("请输入命令：");
        writer.write(scanner.next());
        writer.newLine();
        writer.flush();
        socket.shutdownOutput();
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(reader.readLine());
        socket.close();
    }
}
