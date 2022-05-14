package demo12;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/12 19:59
 * ReentrantLock和Condition代替synchronized和wait/notify
 */
class TaskQueue {
    Queue<String> queue = new LinkedList<>();
    private final Lock lock=new ReentrantLock();
    private final Condition condition=lock.newCondition();
    public void addTask(String s) {
        lock.lock();
        try {
            this.queue.add(s);
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String getTask() {
        lock.lock();
        try {
            while (queue.isEmpty()){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return queue.remove();
        }finally {
            lock.unlock();
        }

    }
}