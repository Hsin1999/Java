package demo07;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Replace {
    /**
     * m.appendReplacement(sb, replacement)sb是为一个StringBuffer,replacement是等于替换进去sb的内容
     * 并且将上次匹配到的内容到此次匹配到的内容之间的所有字符全部append到sb中
     * 假如是第一次匹配的内容，则是开头到此次匹配到的
     * m.appendTail（sb）作用将匹配到的内容之后所有的字符全部append到sb当中
     */
    public static String replaceTemplate(Map<String,String> map,String template){
        StringBuffer stringBuffer=new StringBuffer();
        Pattern pattern=Pattern.compile("\\{(\\w+)}");
        Matcher matcher=pattern.matcher(template);
        while (matcher.find()){
            matcher.appendReplacement(stringBuffer,map.get(matcher.group(1)));
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}
