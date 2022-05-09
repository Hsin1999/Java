package tank;

import java.util.Vector;

/**
 * 自己的坦克
 */
public class HERO extends Tank{

    private final int type=0;
    public HERO(int x,int y) {
        super(x, y);
    }
    public void fire(){
            switch (getDirect()) {
                case 0:
                    this.shot = new Shot(getX(), getY() - 25, getDirect(),getType());
                    break;
                case 1:
                    this.shot = new Shot(getX(), getY() + 25, getDirect(),getType());
                    break;
                case 2:
                    this.shot = new Shot(getX() - 25, getY(), getDirect(),getType());
                    break;
                case 3:
                    this.shot = new Shot(getX() + 25, getY(), getDirect(),getType());
                    break;
            }
        shots.add(shot);
        Thread thread=new Thread(shot);
        thread.start();

    }
    public int getType() {
        return this.type;
    }
}
