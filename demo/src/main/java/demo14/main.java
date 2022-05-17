package demo14;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/17 16:38
 */
public class main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress localhost=InetAddress.getLocalHost();
        System.out.println(localhost);
        System.out.println(InetAddress.getByName("www.baidu.com").getHostAddress());
    }
}
