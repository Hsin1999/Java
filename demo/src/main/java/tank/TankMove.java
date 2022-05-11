package tank;
public class TankMove implements Runnable{
    OtherTank otherTank;

    public TankMove(OtherTank otherTank){
        this.otherTank=otherTank;
    }

    /**
     * 敌方坦克遇到墙壁将自动转向
     * 敌方坦克遇到敌方坦克将自动转向
     */
    @Override
    public void run() {
        while (true){
            if (TankPanel.Tanks.contains(otherTank)){
                int move=10;
                switch ((int)(Math.random()*4)) {
                    case 0:
                        for (int i = 0; i < 5; i++) {
                            otherTank.setDirect(0);
                            if ((otherTank.getY() - move) < 0) {
                                otherTank.setY(0);
                                for (int j = 0; j < 3; j++) {
                                    otherTank.setDirect(1);
                                    otherTank.setY(otherTank.getY()+move);
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                if(overlapping(otherTank)){
                                    otherTank.setDirect(1);
                                    otherTank.setY(otherTank.getY()+10);
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }else {
                                otherTank.setY(otherTank.getY() - move);
                                }
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
                                for (int j = 0; j < 3; j++) {
                                    otherTank.setDirect(0);
                                    otherTank.setY(otherTank.getY()-move);
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                if(overlapping(otherTank)){
                                    otherTank.setDirect(0);
                                    otherTank.setY(otherTank.getY()-10);
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }else {
                                otherTank.setY(otherTank.getY() + move);}
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
                            for (int j = 0; j < 3; j++) {
                                otherTank.setDirect(3);
                                otherTank.setX(otherTank.getX()+move);
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        } else {
                            if(overlapping(otherTank)){
                                otherTank.setDirect(3);
                                otherTank.setX(otherTank.getX()+10);
                                try {
                                    Thread.sleep(200);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }else {
                            otherTank.setX(otherTank.getX() -move);}
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
                                for (int j = 0; j < 3; j++) {
                                    otherTank.setDirect(2);
                                    otherTank.setX(otherTank.getX()-move);
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                if(overlapping(otherTank)){
                                    otherTank.setDirect(2);
                                    otherTank.setX(otherTank.getX()+10);
                                    try {
                                        Thread.sleep(200);
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                    break;
                                }else {
                                otherTank.setX(otherTank.getX() + move);}
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
    public boolean overlapping(Tank tank){
        for (int i = 0; i < TankPanel.Tanks.size(); i++) {
            if(TankPanel.Tanks.get(i)!=tank){
//                switch (TankPanel.Tanks.get(i).getDirect()){
//                    case 0:
//                        if(tank.getX()>TankPanel.Tanks.get(i).getX()-20&& tank.getX()<TankPanel.Tanks.get(i).getX()+20
//                                &&tank.getY()>TankPanel.Tanks.get(i).getY()-25 && tank.getY()<TankPanel.Tanks.get(i).getY()+25){
//                            return true;
//                        }
//                        break;
//                    case 1:
//                        if(tank.getX()>TankPanel.Tanks.get(i).getX()-20&& tank.getX()<TankPanel.Tanks.get(i).getX()+20
//                                &&tank.getY()>TankPanel.Tanks.get(i).getY()-25 && tank.getY()<TankPanel.Tanks.get(i).getY()+25){
//                            return true;
//                        }
//                        break;
//                    case 2:
//                        if(tank.getX()>TankPanel.Tanks.get(i).getX()-25&& tank.getX()<TankPanel.Tanks.get(i).getX()+25
//                                &&tank.getY()>TankPanel.Tanks.get(i).getY()-20 && tank.getY()<TankPanel.Tanks.get(i).getY()+20) {
//                            return true;
//                        }
//                        break;
//                    case 3:
//                        if(tank.getX()>TankPanel.Tanks.get(i).getX()-25&& tank.getX()<TankPanel.Tanks.get(i).getX()+25
//                                &&tank.getY()>TankPanel.Tanks.get(i).getY()-20 && tank.getY()<TankPanel.Tanks.get(i).getY()+20) {
//                            return true;
//                        }
//                        break;
                if(tank.getX()>TankPanel.Tanks.get(i).getX()-25&& tank.getX()<TankPanel.Tanks.get(i).getX()+25
                                &&tank.getY()>TankPanel.Tanks.get(i).getY()-25 && tank.getY()<TankPanel.Tanks.get(i).getY()+25){
                    return true;
                }

            }
        }return false;
    }
}

