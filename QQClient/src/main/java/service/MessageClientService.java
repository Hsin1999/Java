package service;

import common.Message;
import common.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/20 23:21
 */
public class MessageClientService {
    public void sendMessageToOne(String content,String sender,String getter){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(sender);
        message.setGetter(getter);
        message.setContent(content);
        message.setSendTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(ManageClientConncetServerThread.getClientConncetServerThread(sender).getSocket().getOutputStream());
            outputStream.writeObject(message);
            System.out.println(message.getSendTime()+sender+"对"+getter+"说："+message.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendMessageToAll(String content,String sender){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES_ALL);
        message.setSender(sender);
        message.setContent(content);
        message.setSendTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(ManageClientConncetServerThread.getClientConncetServerThread(sender).getSocket().getOutputStream());
            outputStream.writeObject(message);
            System.out.println(message.getSendTime()+sender+"对"+"大家"+"说："+message.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
