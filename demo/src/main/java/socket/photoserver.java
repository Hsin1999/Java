package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/17 22:32
 * 复制图片服务器，从客户端复制图片到服务器
 */
public class photoserver {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8888);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        int len;
        byte[] bytes=new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        OutputStream outputStream=new FileOutputStream("copy1.png");
        outputStream.write(bytes1);
        System.out.println("保存成功");
        outputStream.close();
        inputStream.close();
        byteArrayOutputStream.close();
        socket.shutdownInput();
        socket.close();
    }

}
