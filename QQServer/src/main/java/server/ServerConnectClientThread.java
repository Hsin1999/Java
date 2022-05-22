package server;

import common.Message;
import common.MessageType;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 11:16
 * 服务器与客户端通讯线程
 */
public class ServerConnectClientThread extends Thread {
    private Socket socket;
    private String userId;

    public ServerConnectClientThread(String userId, Socket socket) {
        this.socket = socket;
        this.userId = userId;
    }

    @Override
    public void run() {
        System.out.println(userId + "已连接");
        while (true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) objectInputStream.readObject();
                //获取在线用户列表
                if (message.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_FRIEND)) {
                    String onlineUser = ManageClientThreads.getOnlineUser();
                    System.out.println(message.getSender() + "正在获取在线用户列表");
                    Message message1 = new Message();
                    message1.setContent(onlineUser);
                    message1.setMesType(MessageType.MESSAGE_RETURN_ONLINE_FRIEND);
                    message1.setGetter(message.getSender());
                    ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                    outputStream.writeObject(message1);
                    //退出系统
                } else if (message.getMesType().equals(MessageType.MESSAGE_CLIENT_EXIT)) {
                    //线程集合中删除当前线程
                    ManageClientThreads.removeServerConnectClientThread(message.getSender());
                    //关闭socket
                    this.socket.close();
                    System.out.println("用户" + message.getSender() + "已下机");
                    break;
                    //转发用户私聊消息或发送文件
                } else if ((message.getMesType().equals(MessageType.MESSAGE_COMM_MES)) || (message.getMesType().equals(MessageType.MESSAGE_COMM_FILE_MES))) {
                    ServerConnectClientThread clientThread = ManageClientThreads.getClientThread(message.getGetter());
                    if (clientThread != null) {
                        ObjectOutputStream outputStream = new ObjectOutputStream(clientThread.socket.getOutputStream());
                        outputStream.writeObject(message);
                    }

                } else if (message.getMesType().equals(MessageType.MESSAGE_COMM_MES_ALL)) {//群发消息
                    String[] s = ManageClientThreads.getOnlineUser().split(" ");
                    for (int i = 0; i < s.length; i++) {
                        if (s[i] != message.getSender()) {
                            ServerConnectClientThread clientThread = ManageClientThreads.getClientThread(s[i]);
                            ObjectOutputStream outputStream = new ObjectOutputStream(clientThread.socket.getOutputStream());
                            outputStream.writeObject(message);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
