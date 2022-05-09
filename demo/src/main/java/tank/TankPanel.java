package tank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class TankPanel extends JPanel implements KeyListener,Runnable {//KeyListener:监听键盘
    static HERO hero=null;
    static Graphics g;
    public static boolean loop=true;
    public static Vector<Tank> Tanks=new Vector<>();//所有坦克


    public TankPanel(){
        hero=new HERO(800,100);
        Tanks.add(hero);
        int i=3;
        for (int j = 0; j < i; j++) {
            OtherTank otherTank = new OtherTank(100 * (j + 2), 200);
            Tanks.add(otherTank);
            new Thread(new OtherTankShot(otherTank)).start();
            new Thread(new TankMove(otherTank)).start();
        }
    }
    @Override
    public void paint(Graphics g) {//图像显示层
        TankPanel.g =g;
        super.paint(g);
        if (!loop){
            g.setColor(Color.red);
            g.fillRect(0, 0, 1000, 800);
            g.setColor(Color.black);
            g.setFont(new Font("微软雅黑",Font.BOLD,36));
            g.drawString("Game Over",390,390);
        }else {
            g.setColor(Color.black);
            g.fillRect(0, 0, 1000, 800);
            paintTAllTank();
            Tanksshot();
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyChar()=='q'){
            loop=false;
        }
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


    public static boolean attack(Shot shot,Tank tank) {
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

    /**
     * 坦克绘制方法
     */
    public void paintTAllTank() {
        for (int i = 0; i < Tanks.size(); i++) {
            if (Tanks.get(i).getType() == 0) {
                DrawTank.drawtank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);//绘制自己的坦克
            } else {
                DrawTank.drawtank(Tanks.get(i).getX(), Tanks.get(i).getY(), g, Tanks.get(i).getDirect(), Tanks.get(i).getType());//绘制敌人坦克

            }
        }
    }


    /**
     * 坦克射击
     */
    public void Tanksshot() {
        for (int i = 0; i < Tanks.size(); i++) {
            for (int j = 0; j < Tanks.get(i).shots.size(); j++) {
                if (Tanks.get(i).shots.get(j).isLive) {
                    g.setColor(Color.red);
                    g.fill3DRect(Tanks.get(i).shots.get(j).x - 3, Tanks.get(i).shots.get(j).y - 3, 6, 6, false);
                } else {
                    Tanks.get(i).shots.remove(Tanks.get(i).shots.get(j));
                }
            }
        }
    }
    @Override
    public void run() {
        while (loop) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.repaint();
        }
    }
}