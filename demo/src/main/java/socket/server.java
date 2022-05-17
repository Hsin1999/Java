package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/17 21:07
 */
public class server {
    public static void main(String[] args) throws IOException {
        //ServerSocket可以通过appect方法返回多个socket【多个客户端连接服务器的并发】
        ServerSocket socket = new ServerSocket(9999);//要求端口没有被其他服务占用
        System.out.println("服务端在9999端口监听，等待连接。。");
        Socket accept = socket.accept();//如果有客户端链接，则会返回Socket对象，程序继续
        System.out.println("连接成功");
        InputStream inputStream = accept.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        System.out.println(reader.readLine());
        socket.close();//关闭socket
    }
}
