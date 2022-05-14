package demo12;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/12 20:10
 */
public class Main {
    public static void main(String[] args) {
        stampedlock stampedlock=new stampedlock();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                stampedlock.move(2,2);
            }).start();
            new Thread(()->{
                stampedlock.move(5,5);
            }).start();
            new Thread(()->{
                System.out.println(stampedlock.distanceFromOrigin());
            }).start();
        }
        ExecutorService executor= Executors.newFixedThreadPool(4);
        Task task=new Task();
        for (int i = 0; i < 10; i++) {
            executor.submit(task);
        }
        executor.shutdown();
        ScheduledExecutorService ses=Executors.newScheduledThreadPool(4);
        ses.scheduleWithFixedDelay(task,2,1, TimeUnit.SECONDS);

    }
}
class Task implements Runnable{
    AtomicInteger atomicInteger=new AtomicInteger();
    @Override
    public void run() {
        System.out.println(atomicInteger.incrementAndGet());

    }
}
