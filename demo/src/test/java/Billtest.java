import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

public class Billtest {
    @Test
    public void test(){
        System.out.println(BigDecimal.valueOf(100000L, 4).divide(BigDecimal.valueOf(4),RoundingMode.HALF_UP).setScale(2));
    }
}
