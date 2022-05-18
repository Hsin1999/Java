package demo15;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 14:48
 */
public class UDPSeed {
    public static void main(String[] args) throws IOException {
        DatagramSocket datagramSocket=new DatagramSocket(9998);
        DatagramPacket packet=new DatagramPacket("四大名著".getBytes(),"四大名著".getBytes().length, InetAddress.getLocalHost(),9999);
        datagramSocket.send(packet);
        byte[] bytes=new byte[1024];
        packet=new DatagramPacket(bytes,bytes.length,InetAddress.getLocalHost(),9999);
        datagramSocket.receive(packet);
        int length = packet.getLength();
        byte[] data = packet.getData();
        System.out.println(new String(data,0,length));

    }
}
