package tank;

import jdk.management.resource.internal.inst.ThreadRMHooks;

public class TankMove implements Runnable{
    OtherTank otherTank;

    public TankMove(OtherTank otherTank){
        this.otherTank=otherTank;
    }
    @Override
    public void run() {
        while (true){
            if (TankPanel.Tanks.contains(otherTank)){
                int move=(int)(Math.random()*20+1);
                switch ((int)(Math.random()*4)) {
                    case 0:
                        for (int i = 0; i < 5; i++) {
                            otherTank.setDirect(0);
                            if ((otherTank.getY() - move) < 0) {
                                otherTank.setY(0);
                                break;
                            } else {
                                otherTank.setY(otherTank.getY() - move);
                            }
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 1:
                        for (int i = 0; i < 5; i++) {
                            otherTank.setDirect(1);
                            if ((otherTank.getY() + move) > 800) {
                                otherTank.setY(800);
                                break;
                            } else {
                                otherTank.setY(otherTank.getY() + move);
                            }
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 2:
                        for (int i = 0; i < 5; i++) {


                        otherTank.setDirect(2);
                        if ((otherTank.getX() - move) < 0) {
                            otherTank.setX(0);
                            break;
                        } else {
                            otherTank.setX(otherTank.getX() -move);
                        }
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                    case 3:
                        for (int i = 0; i < 5; i++) {
                            otherTank.setDirect(3);
                            if ((otherTank.getX() + move) > 1000) {
                                otherTank.setX(1000);
                                break;
                            } else {
                                otherTank.setX(otherTank.getX() + move);
                            }
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        break;
                }

            }else {
                break;
            }
        }
    }
}

