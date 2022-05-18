package udp;

import java.io.IOException;
import java.net.*;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 13:35
 */
public class send {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(9998);
        DatagramPacket packet=new DatagramPacket("hello".getBytes(),"hello".getBytes().length,InetAddress.getByName("192.168.0.107"),19999);
        socket.send(packet);
    }
}
