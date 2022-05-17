package demo13;

import java.util.concurrent.CompletableFuture;

/**
 * @author: zhangzhongxin
 * @Date: 2022/5/14 23:27
 */
public class Main {
    public static void main(String[] args) {

        CompletableFuture<String> future=CompletableFuture.supplyAsync(Main::query);
        CompletableFuture<String> future2=CompletableFuture.supplyAsync(Main::query);
        //anyOf:两个future中有一个成功
        CompletableFuture<Object> all=CompletableFuture.anyOf(future,future2);
        CompletableFuture<String> stringCompletableFuture = all.thenApplyAsync(((result)->{
            return query1((String) result);
        }));
        stringCompletableFuture.thenAccept(System.out::println);
        stringCompletableFuture.exceptionally((e)->{
            e.printStackTrace();
            return null;
        });
    }
    static String query(){
        return "nihao";
    }
    static String query1(String s){
        return "zhangzhongxin,"+s;
    }
}
