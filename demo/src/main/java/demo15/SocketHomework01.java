package demo15;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 14:10
 */
public class SocketHomework01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Socket socket = serverSocket.accept();
        System.out.println("正在接收消息....");
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
        System.out.println("接收到输入字符："+s);
        if (s.equals("张忠信")) {
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
            writer.write("张忠信在学java");
            writer.newLine();
            writer.flush();
            }
        socket.shutdownInput();
        socket.shutdownOutput();
        socket.close();
        }

    }
