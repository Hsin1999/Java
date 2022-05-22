package service;

import common.Message;
import common.MessageType;
import javafx.scene.effect.Blend;

import java.io.*;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/22 13:33
 * 向其他用户传输文件
 */
public class FileService {
    public static void sendfile(String sender,String getter,String src,String dest){
        Message message = new Message();
        byte[] bytes=getfilebytes(src);//获取文件字节流
        message.setFilebytes(bytes);
        message.setFilelen(bytes.length);
        message.setSrc(src);
        message.setDest(dest);
        message.setMesType(MessageType.MESSAGE_COMM_FILE_MES);
        message.setSender(sender);
        message.setGetter(getter);
        try {
            ObjectOutputStream outputStream=new ObjectOutputStream(ManageClientConncetServerThread.getClientConncetServerThread(sender).getSocket().getOutputStream());
            outputStream.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static byte[] getfilebytes(String url){
        byte[] bytes=new byte[1024];
        int len;
        ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
        try {
            InputStream inputStream=new FileInputStream(url);
            while ((len=inputStream.read(bytes))!=-1){
                outputStream.write(bytes,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return outputStream.toByteArray();
    }
    public static void savefile(String url,byte[] bytes){
        System.out.println("文件保存在："+url);
        try {
            OutputStream outputStream=new FileOutputStream(url);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
