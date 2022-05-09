package tank;

public class OtherTankShot implements Runnable {
    OtherTank otherTank = null;

    public OtherTankShot(OtherTank otherTank) {
        this.otherTank = otherTank;
    }

    @Override
    public void run() {
        while (TankPanel.loop) {
            try {
                Thread.sleep((long) (Math.random() * 3000 + 1));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
                Shot shot = new Shot(otherTank.getX(), otherTank.getY(), otherTank.getDirect(), otherTank.getType());

                otherTank.shots.add(shot);
                if (TankPanel.Tanks.contains(otherTank)){
                    new Thread(shot).start();}
            }

    }
}
