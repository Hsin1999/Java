package service;

import java.util.HashMap;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/19 10:22
 */
public class ManageClientConncetServerThread {
    private static HashMap<String,ClientConnectServerThread> hashMap=new HashMap<>();

    public static ClientConnectServerThread getClientConncetServerThread(String userId) {
        return hashMap.get(userId);
    }
    public static void addClientConncetServerThread(String userId,ClientConnectServerThread clientConnectServerThread){
        hashMap.put(userId,clientConnectServerThread);
    }
}
