package server;

import common.Message;
import common.MessageType;
import common.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 10:59
 */
public class service {
    private ServerSocket serverSocket=null;

    private static HashMap<String,User> validUsers=new HashMap<>();
    static {
        validUsers.put("100",new User("100","123456"));
        validUsers.put("200",new User("200","123456"));
        validUsers.put("300",new User("300","123456"));
        validUsers.put("400",new User("400","123456"));
        validUsers.put("500",new User("500","123456"));
    }
    public boolean checkUser(String userId,String password){
        //验证用户的userId和password
        User user = validUsers.get(userId);
        if(user==null){
            return false;
        }
        if (user.getPassword().equals(password)){
            return true;
        }
        else {
            return false;
        }
    }
    public service(){
        try {
            System.out.println("服务端在9999监听....");
            serverSocket=new ServerSocket(9999);
            while (true){//当和某个客户端建立连接后会继续监听
            Socket socket = serverSocket.accept();//如果没有客户端连接，就会阻塞
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objectInputStream.readObject();//读取客户端的User对象
                Message message = new Message();//创建一个Message对象回复客户端
                if (checkUser(user.getUserId(), user.getPassword())){//userId和password正确
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);//设置登录状态为成功
                    ObjectOutputStream objectOnputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOnputStream.writeObject(message);//回复客户端Message
                    //创建一个线程，和客户端保持通讯
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(user.getUserId(),socket);
                    serverConnectClientThread.start();//启动线程
                    ManageClientThreads.addClientThread(user.getUserId(), serverConnectClientThread);//将线程放入集合
                }else{
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);//设置登录状态为失败
                    ObjectOutputStream objectOnputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOnputStream.writeObject(message);//回复客户端Message
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //如果服务端关闭，退出serverSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
