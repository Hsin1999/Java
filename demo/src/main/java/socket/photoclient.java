package socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Paths;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/17 22:32
 * 复制图片客户端
 */
public class photoclient {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket(InetAddress.getLocalHost(),8888);
        OutputStream outputStream = socket.getOutputStream();
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        InputStream inputStream= new FileInputStream("copy.png");
        byte[] bytes=new byte[1024];
        int len;
        while ((len=inputStream.read(bytes))!=-1){
            byteArrayOutputStream.write(bytes,0,len);
        }
        inputStream.close();
        byte[] bytes1 = byteArrayOutputStream.toByteArray();
        outputStream.write(bytes1);
        System.out.println("正在传输图片");
        socket.shutdownOutput();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();
        inputStream.close();
        outputStream.close();
        byteArrayOutputStream.close();
        socket.close();
    }
}
