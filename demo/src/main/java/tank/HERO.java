package tank;

import java.util.Vector;

/**
 * 自己的坦克
 */
public class HERO extends Tank{
    Shot shot=null;
    Vector<Shot> vector=new Vector<>();
    public HERO(int x,int y) {
        super(x, y);
    }
    public void fire(){
            switch (getDirect()) {
                case 0:
                    this.shot = new Shot(getX(), getY() - 25, getDirect());
                    break;
                case 1:
                    this.shot = new Shot(getX(), getY() + 25, getDirect());
                    break;
                case 2:
                    this.shot = new Shot(getX() - 25, getY(), getDirect());
                    break;
                case 3:
                    this.shot = new Shot(getX() + 25, getY(), getDirect());
                    break;
            }
        vector.add(shot);
        Thread thread=new Thread(shot);
        thread.start();

    }
}
