package tangTest.service.hashMapTest;

import java.util.HashMap;
import java.util.Map;

public class ForEachEntrySetDemo {
    public static void main(String[] args) {
        // 创建并赋值 HashMap
        Map<Integer, String> map = new HashMap();
        map.put(1, "Java");
        map.put(2, "JDK");
        map.put(3, "Spring Framework");
        map.put(4, "MyBatis framework");
        map.put(5, "Java中文社群");
        // 遍历
        map.keySet().forEach(integer -> {
            System.out.println(integer);
            System.out.println(map.get(integer));
        });
        System.out.println("11111111111111");
        map.entrySet().forEach(o -> {
            System.out.println(o.getKey());
            System.out.println(o.getValue());
        });
        for (Map.Entry<Integer, String> entry : map.entrySet()) {

            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
        System.out.println("22222222222222");
        map.forEach((key,value) -> {
            System.out.println(key);
            System.out.println(value);
        });
        System.out.println("3333333333");
        //not safe
//        for (Map.Entry<Integer, String> entry : map.entrySet()) {
//            if (entry.getKey() == 1) {
//                // 删除
//                System.out.println("del:" + entry.getKey());
//                map.remove(entry.getKey());
//            } else {
//                System.out.println("show:" + entry.getKey());
//            }
//        }

//        map.forEach((key, value) -> {
//            if (key == 1) {
//                System.out.println("del:" + key);
//                map.remove(key);
//            } else {
//                System.out.println("show:" + key);
//            }
//        });

        // 根据 map 中的 key 去判断删除
        //可以看出，可以先使用 Lambda 的 removeIf 删除多余的数据，再进行循环是一种正确操作集合的方式。
        map.keySet().removeIf(key -> key == 1);
        map.forEach((key, value) -> {
            System.out.println("show:" + key);
        });

        System.out.println("444444444");
        //not safe
//        map.entrySet().stream().forEach((entry) -> {
//            if (entry.getKey() == 2) {
//                System.out.println("del:" + entry.getKey());
//                map.remove(entry.getKey());
//            } else {
//                System.out.println("show:" + entry.getKey());
//            }
//        });

        map.entrySet().stream().filter(key -> 3 != key.getKey()).forEach(integerStringEntry -> {
            System.out.println(integerStringEntry.getKey());
            System.out.println(integerStringEntry.getValue());
        });


        //我们不能在遍历中使用集合 map.remove() 来删除数据，这是非安全的操作方式，但我们可以使用迭代器的 iterator.remove() 的方法来删除数据，这是安全的删除集合的方式。同样的我们也可以使用 Lambda 中的 removeIf 来提前删除数据，或者是使用 Stream 中的 filter 过滤掉要删除的数据进行循环，这样都是安全的，当然我们也可以在 for 循环前删除数据在遍历也是线程安全的


    }
}
