package tank;

public class OtherTankShot implements Runnable{
    OtherTank otherTank=null;
    public OtherTankShot(OtherTank otherTank){
        this.otherTank=otherTank;
    }
    @Override
    public void run() {
        while (true) {
                        Shot shot = new Shot(otherTank.getX(), otherTank.getY(), otherTank.getDirect());
                        otherTank.shots.add(shot);
                        try {
                            Thread.sleep((long)(Math.random()*3000+1));
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        new Thread(shot).start();

        }


    }
}
