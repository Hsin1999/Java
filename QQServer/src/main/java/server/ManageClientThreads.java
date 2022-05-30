package server;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 11:26
 * 用于管理和客户端通讯的线程
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hashMap=new HashMap<>();
    private static ConcurrentHashMap<String, ArrayList<Message>> db=new ConcurrentHashMap<>();
    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hashMap.put(userId,serverConnectClientThread);
    }

    public static ServerConnectClientThread getClientThread(String userId){
        return hashMap.get(userId);
    }

    public static ConcurrentHashMap<String, ArrayList<Message>> getDb() {
        return db;
    }

    public static void addOfflineMessage(String getter, Message message) {
        ArrayList<Message> allOfflineMessage = db.get(getter);
        if(allOfflineMessage==null){//如果之前没有离线消息，则新建离线消息
            ArrayList<Message> messages=new ArrayList<>();
            messages.add(message);
            db.put(getter,messages);
        }else{
            allOfflineMessage.add(message);
        }
    }
    public static void sendOfflineMessagesAndFiles(String userId){
        ArrayList<Message> messages = db.get(userId);
        if (messages!=null){
            for (int i = 0; i < messages.size(); i++) {
                try {
                    ObjectOutputStream outputStream=new ObjectOutputStream(ManageClientThreads.getClientThread(userId).getSocket().getOutputStream());
                    outputStream.writeObject(messages.get(i));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static String getOnlineUser(){
        String userList="";
        for (String s:
        hashMap.keySet()) {
            userList+=s+" ";
        }
        return userList;
    }
    public static void removeServerConnectClientThread(String userId){
        hashMap.remove(userId);
    }
}
