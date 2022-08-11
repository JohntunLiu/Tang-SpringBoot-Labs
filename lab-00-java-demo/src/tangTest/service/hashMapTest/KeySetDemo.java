package tangTest.service.hashMapTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
* 迭代器 KeySet
 * */
public class KeySetDemo {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
            System.out.println(map.get(next));
        }

    }
}
