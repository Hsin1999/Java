package tank;

public class Shot implements Runnable{
    int x;
    int y;
    int direct=0;
    int speed=10;
    boolean isLive=true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    @Override
    public void run() {
        while (true){
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

            if(x<0 || y<0 || x>1000 || y>800){
                isLive=false;
                break;
            }
        }
    }
}
