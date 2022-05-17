package socket;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/17 21:07
 */
public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);//连接本机9999端口，如果连接成功，返回socket对象
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello,server".getBytes());
        outputStream.close();
        socket.getInputStream();
        socket.close();//关闭socket
        System.out.println("客户端退出");


    }
}
