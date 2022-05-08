package demo11;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DemoThread {
    public static void main(String[] args) throws InterruptedException {
//        a a=new a();
//        b b=new b(a);
//        new Thread(a).start();
//        new Thread(b).start();
        money money=new money();
        new Thread(money).start();
        new Thread(money).start();

    }
}
class Ticketsale extends Thread{
    public static int count=100;
    public synchronized void sale(){
        if ((count>0)) {
            System.out.println(Thread.currentThread().getName() + "还剩" + --count + "张票");
        }

    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (!(count<=0)){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                sale();
            }else {
                System.out.println(Thread.currentThread().getName()+"票已售空");
                break;
            }

        }

    }
}
class a extends Thread{
    private boolean loop=true;

    @Override
    public void run() {
        while(loop){
            System.out.println((int)(Math.random()*100+1));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}
class b extends Thread{
    private Scanner scanner=new Scanner(System.in);
    private a a;
    b(a a){
        this.a=a;
    }
    @Override
    public void run() {
        while (true){
            System.out.println("输入Q退出程序");
            char s=scanner.next().toUpperCase().charAt(0);
            if(s=='Q'){
                a.setLoop(false);
            }

        }
    }
}
class money extends Thread{
    private boolean loop=true;
    private int money=10000;
    @Override
    public void run() {
                while (loop) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (this) {
                        if (money>=1000){
                            money -= 1000;
                            System.out.println(Thread.currentThread().getName() + "取了1000," + "还剩" + money);
                        }else {
                            setLoop(false);
                            break;
                        }
                    }
                }
                    System.out.println("卡里还剩" + money);
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}