package tank;

import java.awt.*;
import java.util.Vector;

public class Shot implements Runnable{
    int x;
    int y;
    int direct=0;
    int speed=10;
    int type;
    boolean loop=true;
    boolean isLive=true;

    public Shot(int x, int y, int direct,int type) {
        this.x = x;
        this.y = y;
        this.direct = direct;
        this.type=type;
    }

    @Override
    public void run() {
        while (loop){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct){
                case 0:
                    y-=speed;
                    break;
                case 1:
                    y+=speed;
                    break;
                case 2:
                    x-=speed;
                    break;
                case 3:
                    x+=speed;
                    break;
            }
            for (Tank t:TankPanel.Tanks) {
                if (t.getType()!=this.type && this.isLive) {
                    if (TankPanel.attack(this, t)) {
                        TankPanel.Tanks.remove(t);//从Tanks集合中删除被击中的tank
                        this.isLive=false;
                        this.loop=false;
                        System.out.println(this.x);
                        System.out.println(this.y);
                        System.out.println(t.getX());
                        System.out.println(t.getY());
                        System.out.println(t.getType());
                        if (t.getType()==0){
                            TankPanel.loop=false;
                        }
                        break;


                    }
                }
            }

            if(x<0 || y<0 || x>1000 || y>800){
                isLive=false;
                loop=false;
            }
        }
    }
}
