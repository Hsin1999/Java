package demo12;
import java.util.concurrent.locks.StampedLock;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/14 13:58
 */
public class stampedlock {
    private final StampedLock stampedLock=new StampedLock();
    private int x;
    private int y;
    public void move(int x,int y){
        long stamp = stampedLock.writeLock();
        try{
            this.x+=x;
            this.y+=y;
        }finally {
            stampedLock.unlockWrite(stamp);
        }
    }
    public int distanceFromOrigin(){
        long stamp = stampedLock.tryOptimisticRead();
        int currentx=x;
        int currenty=y;
        if(!stampedLock.validate(stamp)){
            stamp = stampedLock.readLock();
            try{
                currentx=x;
                currenty=y;
            }finally {
                stampedLock.unlockRead(stamp);
            }
        }
        return currentx+currenty;
    }
}
