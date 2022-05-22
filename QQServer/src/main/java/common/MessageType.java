package common;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 22:32
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED="1";//登录成功
    String MESSAGE_LOGIN_FAIL="2";//登录失败
    String MESSAGE_COMM_MES="3";//聊天消息
    String MESSAGE_COMM_MES_ALL="4";//群发消息
    String MESSAGE_COMM_FILE_MES="5";//发送文件
    String MESSAGE_GET_ONLINE_FRIEND="6";//请求在线用户列表
    String MESSAGE_RETURN_ONLINE_FRIEND="7";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT="8";//客户端请求退出

}
