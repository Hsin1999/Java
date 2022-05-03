package demo07;
import java.util.regex.*;
public class Regex {
    /**
     * Pattern：创建匹配规则
     * Matcher：使用规则匹配字符串
     * matcher.matches()：匹配符合的字符串
     * matcher.group()：匹配整个字符串
     * matcher.group(x)：匹配第x个子串
     * (\d??)(9*):\d?表示匹配0个或1个数字，后面第二个?表示非贪婪匹配
     */
    public static void main(String[] args) {
        Pattern p=Pattern.compile("\\wo");
        Matcher matcher=p.matcher("hello，world");
//        if(matcher.matches()){
//            System.out.println(matcher.group(1));
//            System.out.println(matcher.group(2));
//        }
//        find()：搜索字符串 matcher.start(),matcher.end()：搜索到的字符串开始index和结束index
        while (matcher.find()){
            System.out.println("hello，world".substring(matcher.start(),matcher.end()));
        }
//        使用replaceAll()的时候，我们传入的第二个参数可以使用$1、$2来反向引用匹配到的子串
        String s = "the quick brown fox jumps over the lazy dog.";
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);

    }
}
