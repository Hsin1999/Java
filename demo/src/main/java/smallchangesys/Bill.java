package smallchangesys;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Bill {
    LocalDateTime time;
    DateTimeFormatter f=DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm");
    String details;
    String sign;
    BigDecimal money;
    static BigDecimal overage=new BigDecimal(10000);
    public void earningsAreBooked(int money){
        time=LocalDateTime.now();
        details="收益入账";
        sign="+";
        this.money=new BigDecimal(money).setScale(1, RoundingMode.HALF_DOWN);
        overage=overage.add(this.money);
        System.out.println(this);

    }
    public void consume(int money,String details){
        time=LocalDateTime.now();
        this.details=details;
        sign="-";
        this.money=new BigDecimal(money).setScale(1, RoundingMode.HALF_DOWN);
        overage=overage.subtract(this.money);
        System.out.println(this);
    }
    @Override
    public String toString() {
        return details+"\t"+sign+money+"\t"+f.format(time)+"\t余额："+overage+"\n";

    }
}
