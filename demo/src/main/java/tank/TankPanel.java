package tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

public class TankPanel extends JPanel implements KeyListener,Runnable {//KeyListener:监听键盘
    HERO hero=null;
    boolean game=true;
    public static Vector<OtherTank> otherTanks=new Vector<>();
    public TankPanel(){
        this.hero=new HERO(800,100);
        int i=3;
        for (int j = 0; j < i; j++) {
            OtherTank otherTank = new OtherTank(100 * (j + 1), 100);
            otherTanks.add(otherTank);
            new Thread(new OtherTankShot(otherTank)).start();
        }
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (!game){
            g.setColor(Color.black);
            g.fillRect(0, 0, 1000, 1000);
        }else{
        g.setColor(Color.black);
        g.fillRect(0, 0, 1000, 1000);
        drawtank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);//绘制自己的坦克
        for(int i = 0; i <otherTanks.size(); i++) {//绘制敌方tank和子弹
            drawtank(otherTanks.get(i).getX(), otherTanks.get(i).getY(), g, otherTanks.get(i).getDirect(), otherTanks.get(i).getType());
            for (int j=0;j<otherTanks.get(i).shots.size();j++){
                if(otherTanks.get(i).shots.get(j).isLive){
                    g.setColor(Color.red);
                    g.fill3DRect(otherTanks.get(i).shots.get(j).x-3,otherTanks.get(i).shots.get(j).y-3,6,6,false);
                    if(attack(otherTanks.get(i).shots.get(j),hero)){//校验是否打到我方坦克
                        game=false;
                    }
                }else{
                    otherTanks.get(i).shots.remove(otherTanks.get(i).shots.get(j));
                }
            }
        }
        if (hero.shot!=null){//自己坦克shot
            for (int i = 0; i < hero.vector.size(); i++) {
                if (hero.vector.get(i).isLive) {
                    g.setColor(Color.red);
                    g.fill3DRect(hero.vector.get(i).x - 3, hero.vector.get(i).y - 3, 6, 6, false);
                        for (int j = 0; j < otherTanks.size(); j++) {
                            if(attack(hero.vector.get(i),otherTanks.get(j))){//校验是否打到敌军坦克
                                otherTanks.remove(otherTanks.get(j));

                            }
                        }
                }else {
                    hero.vector.remove(hero.vector.get(i));
                }
            }
        }

    }}

    public void drawtank(int x,int y,Graphics g,int direct,int type){
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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar()=='s'){
            hero.setDirect(1);
            int y=hero.getY();
            hero.setY(y+=15);
        }
        if (e.getKeyChar()=='w'){
            hero.setDirect(0);
            int y=hero.getY();
            hero.setY(y-=15);
        }
        if (e.getKeyChar()=='a'){

            hero.setDirect(2);
            int x=hero.getX();
            hero.setX(x-=15);

        }
        if (e.getKeyChar()=='d'){
            hero.setDirect(3);
            int x=hero.getX();
            hero.setX(x+=15);
        }
        if (e.getKeyChar()=='j'){
                hero.fire();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    public boolean attack(Shot shot,Tank tank) {
        switch (tank.getDirect()) {
            case 0:
                if (shot.x > tank.getX() - 20 && shot.x < tank.getX() + 20 && shot.y > tank.getY() - 25 && shot.y < tank.getY() + 25) {
                    return true;
                }
                break;
            case 1:
                if (shot.x > tank.getX() - 20 && shot.x < tank.getX() + 20 && shot.y > tank.getY() - 25 && shot.y < tank.getY() + 25) {
                    return true;
                }
                break;
            case 2:
                if (shot.x > tank.getX() - 25 && shot.x < tank.getX() + 25 && shot.y > tank.getY() - 20 && shot.y < tank.getY() + 20) {
                    return true;
                }
                break;
            case 3:
                if (shot.x > tank.getX() - 25 && shot.x < tank.getX() + 25 && shot.y > tank.getY() - 20 && shot.y < tank.getY() + 20) {
                    return true;
                }
                break;
        }
        return false;
    }
    @Override
    public void run() {
        while (true){
            this.repaint();
        }
    }
}