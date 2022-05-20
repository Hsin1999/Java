package service;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 00:00
 */
public class UserClientService {
    private User u=new User();

    public boolean checkUser(String userId,String password){
        boolean b=false;
        //创建User对象
        u.setUserId(userId);
        u.setPassword(password);
        //连接到服务端，发送u对象
        try {
            Socket socket=new Socket(InetAddress.getByName("127.0.0.1"),9999);
            ObjectOutputStream outputStream=new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(u);

            ObjectInputStream inputStream=new ObjectInputStream(socket.getInputStream());
            Message o = (Message) inputStream.readObject();
            if(o.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){//如果登录成功
                //创建线程
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                //将线程添加到hashmap里
                ManageClientConncetServerThread.addClientConncetServerThread(userId,clientConnectServerThread);
                b=true;
            }else{
                socket.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }
    public void onlineFriendList(){
        //发送一个Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        ObjectOutputStream outputStream = null;
        try {
            //通过线程管理获取当前用户的线程对象，通过线程对象获取绑定的socket，调用socket.getOutputStream方法获取输出流
            outputStream = new ObjectOutputStream(ManageClientConncetServerThread.getClientConncetServerThread(u.getUserId()).getSocket().getOutputStream());
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void logout(){//退出系统方法
        //发送Message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream outputStream =new ObjectOutputStream( ManageClientConncetServerThread.getClientConncetServerThread(u.getUserId()).getSocket().getOutputStream());
            outputStream.writeObject(message);
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void privateChat(String userId){
        Scanner scanner = new Scanner(System.in);
        Message message = new Message();
        message.setGetter(userId);
        message.setSender(u.getUserId());
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        try {
            while (true){
                String next = scanner.next();
                if (next.equals("exit")){
                    break;
                }
                message.setContent(next);
                ObjectOutputStream outputStream =new ObjectOutputStream( ManageClientConncetServerThread.getClientConncetServerThread(u.getUserId()).getSocket().getOutputStream());
                outputStream.writeObject(message);
                System.out.println("我"+":"+next);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
