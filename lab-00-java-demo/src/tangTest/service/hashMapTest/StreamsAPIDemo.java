package tangTest.service.hashMapTest;

import java.util.HashMap;
import java.util.Map;


public class StreamsAPIDemo {
    public static void main(String[] args) {
        /*
         * Streams API 单线程遍历
         * */
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        map.entrySet().stream().forEach(entry -> {
            System.out.print(entry.getKey());
            System.out.print(entry.getValue());
        });

       // Streams API 多线程
        map.entrySet().parallelStream().forEach(integerStringEntry -> {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
        });
    }
}
