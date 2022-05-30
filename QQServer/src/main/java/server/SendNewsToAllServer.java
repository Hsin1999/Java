package server;

import common.Message;
import common.MessageType;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/23 00:57
 */
public class SendNewsToAllServer extends Thread {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        while (true) {
            System.out.print("输入服务器要推送的信和或消息：");
            String next = scanner.next();
            Message message = new Message();
            message.setMesType(MessageType.MESSAGE_COMM_MES_ALL);
            message.setSender("服务器");
            message.setContent(next);
            message.setSendTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
            String onlineUser = ManageClientThreads.getOnlineUser();
            if (!onlineUser.equals("")) {//判断是否有人在线
                String[] all = onlineUser.split(" ");
                for (int i = 0; i < all.length; i++) {
                    try {
                        ObjectOutputStream outputStream = new ObjectOutputStream(ManageClientThreads.getClientThread(all[i]).getSocket().getOutputStream());
                        outputStream.writeObject(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            } else {
                System.out.println("当前无人在线");
            }
        }
    }
}
