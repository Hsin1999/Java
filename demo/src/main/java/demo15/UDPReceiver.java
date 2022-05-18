package demo15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 14:48
 */
public class UDPReceiver {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9999);
        byte[] bytes = new byte[1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        datagramSocket.receive(packet);
        int length = packet.getLength();
        byte[] data = packet.getData();
        System.out.println(new String(data, 0, length));
        if (new String(data, 0, length).equals("四大名著")) {
            packet = new DatagramPacket("西游记，红楼梦，水浒传，三国演义".getBytes(), "西游记，红楼梦，水浒传，三国演义".getBytes().length, InetAddress.getLocalHost(), 9998);
            datagramSocket.send(packet);
        }
    }
}
