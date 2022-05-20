package view;

import service.UserClientService;

import java.util.Scanner;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/18 22:36
 * 菜单登录界面
 */
public class QQView {
    private boolean loop = true;
    private String key;
    private UserClientService userClientService = new UserClientService();

    public static void main(String[] args) {
        new QQView().mainMenu();
    }

    private void mainMenu() {
        while (loop) {
            System.out.println("==========欢迎登录==========");
            System.out.println("\t1、登录");
            System.out.println("\t9、退出");
            Scanner scanner = new Scanner(System.in);
            System.out.print("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "1":
                    System.out.print("请输入用户名：");
                    String userId = scanner.next();
                    System.out.print("请输密码：");
                    String password = scanner.next();
                    if (userClientService.checkUser(userId, password)) {
                        System.out.println("==========欢迎" + userId + "登录==========");
                        while (loop) {
                            System.out.println("\n==========二级菜单（用户" + userId + "）==========");
                            System.out.println("\t1、显示在线用户列表");
                            System.out.println("\t2、群发消息");
                            System.out.println("\t3、私聊消息");
                            System.out.println("\t4、发送文件");
                            System.out.println("\t9、退出系统");
                            System.out.println("请输入你的选择：");
                            key = scanner.next();
                            switch (key) {
                                case "1":
                                    userClientService.onlineFriendList();
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    System.out.print("请输入要私聊的用户名称：");
                                    userClientService.privateChat(scanner.next());
                                    break;
                                case "4":
                                    break;
                                case "9":
                                    userClientService.logout();
                                    break;
                            }
                        }
                    } else {
                        System.out.println("==========登录失败==========");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
                default:
                    System.out.println("请重新输入");
            }
        }
    }
}
