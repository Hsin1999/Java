import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Billtest {
    @Test
    public void test(){
        int i=10000;
        System.out.println(new BigDecimal(i).setScale(2, RoundingMode.HALF_UP));
        System.out.println(new Date());
    }
}
