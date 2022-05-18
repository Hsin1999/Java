package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 13:35
 */
public class receive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket=new DatagramSocket(19999);
        byte[] bytes = new byte[1024];
        System.out.println(bytes.length);
        DatagramPacket packet=new DatagramPacket(bytes,bytes.length);
        socket.receive(packet);
        int length = packet.getLength();
        System.out.println(new String(packet.getData(),0,length));
        System.out.println(new String(packet.getData(),0,length));
    }
}
