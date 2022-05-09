package tank;

import java.awt.*;

public class DrawTank {
    public static void drawtank(int x, int y, Graphics g, int direct, int type){
        switch (type) {
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.orange);
                break;

        }
        switch (direct){
            case 0://方向向上
                g.fill3DRect(x+10, y-25, 10, 50,false);//左轮
                g.fill3DRect(x-20, y-25, 10, 50,false);//右轮
                g.fill3DRect(x-10, y-15, 20, 30,false);//中心一层
                g.fillOval(x-10, y-10, 20, 20);//中心二层
                g.drawLine(x, y, x, y-25);//枪管
                break;
            case 1:
                g.fill3DRect(x+10, y-25, 10, 50,false);//左轮
                g.fill3DRect(x-20, y-25, 10, 50,false);//右轮
                g.fill3DRect(x-10, y-15, 20, 30,false);//中心一层
                g.fillOval(x-10, y-10, 20, 20);//中心二层
                g.drawLine(x, y, x, y+25);//枪管
                break;
            case 2:
                g.fill3DRect(x-25, y+10, 50, 10,false);//左轮
                g.fill3DRect(x-25, y-20, 50, 10,false);//右轮
                g.fill3DRect(x-15, y-10, 30, 20,false);//中心一层
                g.fillOval(x-10, y-10, 20, 20);//中心二层
                g.drawLine(x, y, x-25, y);//枪管
                break;
            case 3:
                g.fill3DRect(x-25, y+10, 50, 10,false);//左轮
                g.fill3DRect(x-25, y-20, 50, 10,false);//右轮
                g.fill3DRect(x-15, y-10, 30, 20,false);//中心一层
                g.fillOval(x-10, y-10, 20, 20);//中心二层
                g.drawLine(x, y, x+25, y);//枪管
                break;
        }

    }
}
