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
                //接收来自用户的私聊消息
                if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    System.out.println(message.getSendTime()+message.getSender()+"对我说："+message.getContent());
                }else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_ALL)){
                    System.out.println(message.getSendTime()+message.getSender()+"对大家说："+message.getContent());
                }
                if(message.getMesType().equals(MessageType.MESSAGE_COMM_FILE_MES)){
                    System.out.println("正在接收来自"+message.getSender()+"发送的文件,"+"大小为"+message.getFilelen()+"字节");
                    FileService.savefile(message.getDest(),message.getFilebytes());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
