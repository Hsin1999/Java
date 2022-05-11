package smallchangesys;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static Scanner scanner=new Scanner(System.in);
    static List<Bill> billList=new ArrayList<>();
    public static void main(String[] args) {
        while (true){
            if (!main_menu()){
                break;
            }
        }

    }
    public static boolean main_menu(){
        while (true){
            System.out.println("---------------零钱通---------------");
            System.out.println("          1、零钱通明细");
            System.out.println("          2、收益入账");
            System.out.println("          3、消费");
            System.out.println("          4、退     出");
            System.out.println("-----------------------------------");
            String num = scanner.next();
            switch (num){
                case "1":
                    if (!billList.isEmpty()){
                        for(Bill bill:billList){
                            System.out.println(bill);
                        }
                    }else {
                        System.out.println("你还没有任何收入支出");
                    }
                    break;
                case "2":
                    System.out.println("请输入收益的金额：");
                    Bill bill=new Bill();
                    bill.earningsAreBooked(Integer.parseInt(scanner.next()));
                    billList.add(bill);
                    break;
                case "3":
                    System.out.println("请输入消费的金额：");
                    String money=scanner.next();
                    System.out.println(money);
                    System.out.println("请输入消费商品名称：");
                    String details= scanner.next();
                    System.out.println(details);
                    Bill bill1=new Bill();
                    bill1.consume(Integer.parseInt(money),details);
                    billList.add(bill1);
                    break;
                case "4":
                    return false;
                default:
                    System.out.println("输入错误，请重新输入");
            }

        }
    }
}
