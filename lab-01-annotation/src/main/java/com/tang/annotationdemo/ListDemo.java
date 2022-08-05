package com.tang.annotationdemo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//不要随便在 foreach增加/删除元素
public class ListDemo {
    public static void main(String[] args) {
        String[] arrays =  {"1","2","3","4"};
        List<String> strings = new ArrayList<>(Arrays.asList(arrays));

        strings.add("wwer");
        System.out.println(strings);


        //推荐使用 Guava 不可变集合代替
//        ImmutableList.copyof(strings);

        //报错，计数变量使用，迭代器报错，
//        for (String s : strings) {
//            if (s.equals("1")) {
//                strings.remove(s);
//            }
//        }
        strings.removeIf(str -> str.equals("1"));
        System.out.println(strings);
    }
}
