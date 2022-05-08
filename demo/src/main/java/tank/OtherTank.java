package tank;

import java.util.Vector;

public class OtherTank extends Tank{
    private int type=1;
    Vector<Shot> shots=new Vector<>();

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public OtherTank(int x,int y) {
        super(x,y);
        setDirect(1);

    }
}
