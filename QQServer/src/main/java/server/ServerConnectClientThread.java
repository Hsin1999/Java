package server;

import common.Message;
import common.MessageTpye;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 11:16
 */
public class ServerConnectClientThread extends Thread{
    private Socket socket;
    private String userId;
    public ServerConnectClientThread(String userId,Socket socket){
        this.socket=socket;
        this.userId=userId;
    }
    @Override
    public void run() {
        System.out.println("服务端在和"+userId+"连接");
        while (true){
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                if(message.getMesType().equals(MessageTpye.MESSAGE_GET_ONLINE_FRIEND)){
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    System.out.println(message.getSender()+"正在获取在线用户列表");
                    Message message1=new Message();
                    message1.setContent(onlineUser);
                    message1.setMesType(MessageTpye.MESSAGE_RETURN_ONLINE_FRIEND);
                    message1.setGetter(message.getSender());
                    ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(message1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
