package tank;

import java.util.Vector;

public class OtherTank extends Tank{
    private final int type=1;
    public int getType() {
        return this.type;
    }

    public OtherTank(int x,int y) {
        super(x,y);
        setDirect(1);

    }
}
