import demo09.Person;
import demo09.Week;
import org.junit.jupiter.api.Test;

import java.util.*;

public class EnumTest {
    @Test
    void testenum() {
//        EnumMap
        Map<Week, String> map = new EnumMap<Week, String>(Week.class);
        map.put(Week.MONDAY, "星期一");
        map.put(Week.TUESDAY, "星期二");
        map.put(Week.WEDNESDAY, "星期三");
        map.put(Week.THURSDAY, "星期四");
        map.put(Week.FRIDAY, "星期五");
        map.put(Week.SATURDAY, "星期六");
        map.put(Week.SUNDAY, "星期日");
        System.out.println(map.get(Week.SUNDAY));
        Map<Person, Integer> map1 = new TreeMap<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        map1.put(new Person("a", "21"), 1);
        map1.put(new Person("c", "21"), 3);
        map1.put(new Person("b", "21"), 2);
        for (Person p : map1.keySet()
        ) {
            System.out.println(p.getName());
        }
        Set<String> set = new TreeSet<>();
        set.add("banana");
        set.add("apple");

        System.out.println(set);
    }

    }

