package server;

import common.Message;
import common.MessageType;
import common.User;
import dao.UserInformationDao;
import domain.UserInformation;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 10:59
 */
public class Service {
    private ServerSocket serverSocket = null;

    public boolean checkUser(String userId, String password) {
        String sql = "select * from userinformation where username=? and password=?";
        UserInformationDao userInformationDao = new UserInformationDao();
        UserInformation userInformation = userInformationDao.querySingle(sql, UserInformation.class, userId, password);
        //验证用户的userId和password
        return userInformation.getusername().equals(userId) && userInformation.getPassword().equals(password);
    }

    public Service() {
        try {
            System.out.println("服务端在9999监听....");
            serverSocket = new ServerSocket(9999);
            new Thread(new SendNewsToAllServer()).start();
            while (true) {//当和某个客户端建立连接后会继续监听
                Socket socket = serverSocket.accept();//如果没有客户端连接，就会阻塞
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                User user = (User) objectInputStream.readObject();//读取客户端的User对象
                Message message = new Message();//创建一个Message对象回复客户端
                if (checkUser(user.getUserId(), user.getPassword())) {//userId和password正确
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);//设置登录状态为成功
                    ObjectOutputStream objectOnputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOnputStream.writeObject(message);//回复客户端Message
                    //创建一个线程，和客户端保持通讯
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(user.getUserId(), socket);
                    serverConnectClientThread.start();//启动线程
                    ManageClientThreads.addClientThread(user.getUserId(), serverConnectClientThread);//将线程放入集合
                    //发送离线消息和文件（如果有离线消息和文件）
                    ManageClientThreads.sendOfflineMessagesAndFiles(user.getUserId());
                } else {
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);//设置登录状态为失败
                    ObjectOutputStream objectOnputStream = new ObjectOutputStream(socket.getOutputStream());
                    objectOnputStream.writeObject(message);//回复客户端Message
                    socket.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //如果服务端关闭，退出serverSocket
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
