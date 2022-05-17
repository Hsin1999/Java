package demo12;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

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
        Future<Integer> future=executor.submit(task);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executor.shutdown();
    }
}
class Task implements Callable<Integer>{
    AtomicInteger atomicInteger=new AtomicInteger();
    @Override
    public Integer call() throws Exception {
        return atomicInteger.incrementAndGet();
    }
}
