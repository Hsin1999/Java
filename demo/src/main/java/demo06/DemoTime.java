package demo06;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
public class DemoTime {
    public static void main(String[] args) {
        Date date=new Date();
        System.out.println(date);
//        格式化输出Date
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(date));
        Calendar calendar=Calendar.getInstance();
//        转换成Date
        System.out.println(calendar.getTime());
//        设置时区的时间
        TimeZone tzDefault = TimeZone.getDefault();
        System.out.println(tzDefault);
        Calendar calendar1=Calendar.getInstance();
        Date date1=calendar1.getTime();
        SimpleDateFormat simpleDateFormat1=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        simpleDateFormat1.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println(simpleDateFormat1.format(date1));

//        LocalDate:显示本地时间
        LocalDate localDate=LocalDate.of(1999,1,27);
        System.out.println(localDate);
        LocalTime localTime=LocalTime.now();
        System.out.println(localTime);
        LocalDateTime localDateTime=LocalDateTime.now();
        System.out.println(localDateTime);
        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy MM dd HH:mm:ss", Locale.CHINA);
        System.out.println(dateTimeFormatter.format(localDateTime));
//        ZonedDateTime：显示本地日期时间  plus：增加时间 minus：减少时间
        ZonedDateTime zonedDateTime=ZonedDateTime.now();
        System.out.println(zonedDateTime);
        ZonedDateTime zonedDateTime1=ZonedDateTime.now(ZoneId.of("America/New_York"));
        ZonedDateTime zonedDateTime2=ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(dateTimeFormatter.format(zonedDateTime1));
//        Instant.toEpochMilli()：转换成毫秒级时间戳   instant.atZone()：转换成ZoneDateTime
        Instant instant=Instant.now();
        System.out.println(instant.toEpochMilli());
        System.out.println(instant.atZone(ZoneId.of("America/New_York")));
        System.out.println(localDateTime.atZone(ZoneId.of("America/New_York")));
        DateTimeFormatter f = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
        System.out.println(f.format(ZonedDateTime.ofInstant(instant,ZoneId.of("America/New_York"))));

    }
}
