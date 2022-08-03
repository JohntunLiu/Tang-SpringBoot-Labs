package tangTest.service;

import tangTest.bo.Major;
import tangTest.bo.Student;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/*
*  函数式编程
* */
public class FunctionalPrograming {
    public static void main(String[] args) {

        List<String> list = Arrays.asList(new String[]{
                "1"
                ,

                "2"
                ,

                "bilibili"
                ,

                "of"
                ,

                "codesheep"
                ,

                "5"
                ,

                "at"
                ,

                "BILIBILI"
                ,

                "codesheep"
                ,

                "23"
                ,

                "CHEERS"
                ,

                "6"
        });



        System.out.println(list);

        String result = list.stream()
                .filter(i -> !isNum(i))
                .filter(i -> i.length() >= 5)
                .map(i -> i.toLowerCase())
                .distinct()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.joining("@"));

        System.out.println(result);
//“消费者的含义”，接受参数而不返回值
        Consumer c = System.out::println;
        c.accept("123");
        c.accept("123");
        c.accept("12334");

        c.andThen(c).andThen(c).accept("hello");

        Function<Integer,Integer> f1 = integer -> integer + integer;
        Function<Integer,Integer> f2 = integer -> integer * integer;

        System.out.println(f1.andThen(f2).apply(3));

//        Student student = new Student("marry", 123L, new Major("math", 1234L));
        Student student = new Student("marry", 123L, new Major());
        Long score = getMajorId(student);
        System.out.println(score);


    }

    public static Long getMajorId(Student student) {
        return Optional.ofNullable(student)
                .map(Student::getMajor)
                .map(Major::getMajorId)
                .orElse(null);
    }


    public static boolean isNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
