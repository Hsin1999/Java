package demo01;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DDZ {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        ArrayList<String> list=new ArrayList<>();
        list.add("大王");
        list.add("小王");
        String[] colors={"♠️","♥️","♦️","♣️"};
        String[] nums={"2","A","K","Q","J","10","9","8","7","6","5","4","3"};
        for (String color:colors
        ) {
            for (String num:nums
            ) {
                list.add(color+num);
            }
        }
        Collections.shuffle(list);
        List<String> A=new ArrayList<>();
        List<String> B=new ArrayList<>();
        List<String> C = new ArrayList<>();
        List<String> D=new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(i>=51){
                D.add(list.get(i));
            }else {
                boolean b = i % 3 == 0 ? A.add(list.get(i)) : i % 3 == 1 ? B.add(list.get(i)) : C.add(list.get(i));
            }
        }
        System.out.println("玩家A的牌是："+A);
        System.out.println("玩家B的牌是："+B);
        System.out.println("玩家C的牌是："+C);
        System.out.println("底牌是"+D);
    }
}
