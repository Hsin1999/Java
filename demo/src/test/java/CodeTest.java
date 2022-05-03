import demo07.Replace;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

class CodeTest {

    @BeforeEach
    void setUp(){
        System.out.println("测试开始");
    }
    @AfterEach
    void tearDown(){
        System.out.println("测试结束");
    }
    @Test
    void ReplaceTest(){
        Map<String,String> map=new HashMap<>();
        map.put("name","zhangzhongxin");
        map.put("age","23");
        String result=Replace.replaceTemplate(map,"大家好我叫{name},我今年{age}岁了");
        System.out.println(result);
    }
}
