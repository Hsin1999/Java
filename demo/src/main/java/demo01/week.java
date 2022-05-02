package demo01;

public enum week {
    A("0","零"),
    B("1","一");
    final private  String code;
    final private String desc;

    week(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "code='" + code + '\'' +
                ", desc='" + desc + '\'' ;
    }

    public static week getenum(String src) {
        week[] items=week.values();
        for (week item:items
             ) {
            if(item.getCode().equals(src)){
                return item;
            }
        }
        return null;
    }
}
