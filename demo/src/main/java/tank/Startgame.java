package tank;
import javax.swing.*;

public class Startgame extends JFrame{
    public static void main(String[] args) {
        new Startgame();
    }
    public Startgame() {
        TankPanel mp = new TankPanel();
        this.add(mp);
        this.setSize(1000,800);
        //JFrame.addKeyListener可以监听到面板发生到键盘事件
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        new Thread(mp).start();
    }
}
