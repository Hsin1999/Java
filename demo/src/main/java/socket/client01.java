package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/17 21:07
 */
public class client01 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//连接本机9999端口，如果连接成功，返回socket对象
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(outputStream));
        writer.write("你好服务器！！！");
        writer.newLine();//等同于输出结束，对方要用readline()方法读取
        writer.flush();
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(reader.readLine());
        writer.close();
        reader.close();
        socket.close();//关闭socket
        System.out.println("客户端退出");
    }
}
