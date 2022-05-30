package demo09;

import java.util.*;

public class main {
    public static void main(String[] args) {
        List<Message> received = new ArrayList<>();
        List<Message> displayMessages = process(received);
        for (Message message : displayMessages) {
            System.out.println(message.text);
        }
        Queue<String> queue=new LinkedList<>();
        Queue<Person> queue1=new PriorityQueue<>((o1,o2)-> {
                if (o1.getName().equals("张忠信") && o2.getName().equals("张忠信"))  {
                    return -1;
                }else {
                    return o1.getAge().compareTo(o2.getAge());
                }
        });
        queue1.offer(new Person("zzx","21"));
        queue1.offer(new Person("zzxx","22"));
        queue1.offer(new Person("张忠信","1"));
        System.out.println(queue1.poll().getName());
        System.out.println(queue1.poll().getName());
        Deque<String> deque=new LinkedList<>();
        deque.push("第一个");
        deque.push("第二个");
        deque.push("第三个");
        System.out.println(deque.pop());
        System.out.println(deque.pop());
        System.out.println(deque.pop());


    }

    static List<Message> process(List<Message> received) {
        Set<Message> set = new TreeSet<>((o1, o2) -> {
            if (o1.sequence==o2.sequence){
                return 0;
            }
            return o1.sequence>o2.sequence?1:-1;
        });
        set.addAll(received);
        return new ArrayList<>(set);
    }
}

class Message {
    public final int sequence;
    public final String text;
    public Message(int sequence, String text) {
        this.sequence = sequence;
        this.text = text;
    }
}
