package server;

import java.util.HashMap;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 11:26
 * 用于管理和客户端通讯的线程
 */
public class ManageClientThreads {
    private static HashMap<String,ServerConnectClientThread> hashMap=new HashMap<>();


    public static void addClientThread(String userId,ServerConnectClientThread serverConnectClientThread){
        hashMap.put(userId,serverConnectClientThread);
    }

    public static ServerConnectClientThread getClientThread(String userId){
        return hashMap.get(userId);
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
