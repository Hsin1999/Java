package demo09;

public enum Week {
    MONDAY("星期一","1"),
    TUESDAY("星期二","2"),
    WEDNESDAY("星期三","3"),
    THURSDAY("星期四","4"),
    FRIDAY("星期五","5"),
    SATURDAY("星期六","6"),
    SUNDAY("星期日","7");
    private final String weekname;
    private final String weekcode;

    Week(String weekname, String weekcode) {
        this.weekname = weekname;
        this.weekcode = weekcode;
    }

    public String getWeekname() {
        return weekname;
    }

    public String getWeekcode() {
        return weekcode;
    }

}
