package TCPDownload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 15:07
 * 通过TCP下载文件
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(18888);
        System.out.println("等待连接");
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String s = reader.readLine();
        System.out.println("要下载的文件为："+s);
        File file = new File("./");
        byte[] bytes = null;
        String[] list = file.list();
        for (int i = 0; i < list.length; i++) {
            if(s.equals("quit")){
                break;
            }
            if (s.equals(list[i])) {
                bytes = toByte.tobyte(new FileInputStream(new File("./", s)));
                break;
            }
        }
        System.out.println("正在下载");
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(bytes);
        outputStream.flush();
        socket.close();

    }
}
