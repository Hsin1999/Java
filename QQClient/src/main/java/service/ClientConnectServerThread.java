package service;

import common.Message;
import common.MessageType;

import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 10:05
 */
public class ClientConnectServerThread extends Thread{
    private Socket socket;
    public ClientConnectServerThread(Socket socket){
        this.socket=socket;
    }
    public Socket getSocket() {
        return socket;
    }
    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run(){
        while (true){
            try {
                ObjectInputStream objectInputStream=new ObjectInputStream(this.socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();//服务器没有发送数据的时候，线程会阻塞在这里
                //显示在线用户列表
                if(message.getMesType().equals(MessageType.MESSAGE_RETURN_ONLINE_FRIEND)){
                    String[] s = message.getContent().split(" ");
                    System.out.println("==========当前用户在线列表==========");
                    for (int i = 0; i < s.length; i++) {
                        System.out.println("用户："+s[i]);
                    }
                }
                if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    System.out.println(message.getSender()+":"+message.getContent());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
