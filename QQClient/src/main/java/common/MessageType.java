package common;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 22:32
 * 消息类型
 */
public interface MessageType {
    String MESSAGE_LOGIN_SUCCEED="1";//登录成功
    String MESSAGE_LOGIN_FAIL="2";//登录失败
    String MESSAGE_COMM_MES="3";//聊天消息
    String MESSAGE_GET_ONLINE_FRIEND="4";//请求在线用户列表
    String MESSAGE_RETURN_ONLINE_FRIEND="5";//返回在线用户列表
    String MESSAGE_CLIENT_EXIT="6";//客户端请求退出
}
