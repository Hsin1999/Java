package common;

import java.io.Serializable;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 22:21
 * 客户端和服务器通信时消息对象
 */
public class Message implements Serializable {
    private static final long serialVersionUID=1L;
    private String sender;
    private String getter;
    private String content;
    private String mesType;
    private String sendTime;
    private byte[] filebytes;
    private int filelen=0;
    private String dest;

    public byte[] getFilebytes() {
        return filebytes;
    }

    public void setFilebytes(byte[] filebytes) {
        this.filebytes = filebytes;
    }

    public int getFilelen() {
        return filelen;
    }

    public void setFilelen(int filelen) {
        this.filelen = filelen;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    private String src;
    public Message(String sender, String getter, String content, String mesType, String sendTime) {
        this.sender = sender;
        this.getter = getter;
        this.content = content;
        this.mesType = mesType;
        this.sendTime = sendTime;
    }
    public Message() {
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getGetter() {
        return getter;
    }

    public void setGetter(String getter) {
        this.getter = getter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
