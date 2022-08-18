package tangTest.service.interview;

import lombok.Data;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class TenExam {
    public static void main(String[] args) {
        demo();
    }

    static void  demo1() {
        //0.0
        //Double. MIN_VALUE 和 Double. MAX_VALUE 一样，都是正数，Double. MIN_VALUE 的值是 2^(-1074)，直接打印 Double. MIN_VALUE 的话，输出结果为 4.9E-324
        System.out.println(Math.min(Double.MIN_VALUE, 0.0d));
        System.out.println(Double.MIN_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    //第二题，在 try 块或者 catch 语句中执行 return 语句或者 System.exit() 会发生什么，finally 语句还会执行吗？
    static void  demo2() {

        Test1 test1 = new Test1();
        test1.returnCatchExec();
        test1.returnTryExec();
        test1.exitTryExec();
        test1.exitCatchExec();


    }
    /*第三题，私有方法或者静态方法能被重写（override）吗？
    而私有方法对子类是不可见的，它仅在当前声明的类中可见，private 关键字满足了封装的最高级别要求。另外，Java 中的私有方法是通过编译期的静态绑定的方式绑定的，不依赖于特定引用变量所持有的对象类型。
    方法重写适用于动态绑定，因此私有方法无法被重写
    在父类的构造方法中，分别调用了 write() 和 read() 方法，write()方法是 public 的，可以被重写，因此执行了子类的 write() 方法，read() 方法是私有的，无法被重写，因此执行的仍然是父类的 read() 方法。
    和私有方法类似，静态方法在编译期也是通过静态绑定的方式绑定的，不依赖于特定引用变量所持有的对象类型。方法重写适用于动态绑定，因此静态方法无法被重写*/
    static void  demo3() {
        LaoWang wang = new XiaoWang();
        //和私有方法类似，静态方法在编译期也是通过静态绑定的方式绑定的，不依赖于特定引用变量所持有的对象类型。方法重写适用于动态绑定，因此静态方法无法被重写
        Laozi zi = new Xiaozi();
        zi.write();
        //引用变量 zi 的类型为 Laozi，所以 zi.write() 执行的是父类中的 write() 方法。
        //
        //静态方法也叫类方法，直接通过类名就可以调用，通过对象调用的时候，IDE 会发出警告。
    }
    /*
    * 第四题，1.0/0.0 得到的结果是什么？会抛出异常吗，还是会出现编译错误？
    *
    * */
    static void  demo4() {
        System.out.println(1.0 / 0.0); // Infinity
        System.out.println(0.0 / 0.0); // NaN
        System.out.println(0 / 0.0); // NaN
        System.out.println(0.0 / 0); // NaN
//        System.out.println(0 / 0); // / by zero

    }
    /*
    *第五题，Java 支持多重继承吗？单继承
    *
    * 第六题，当在 HashMap 中放入一个已经存在的 key 时，会发生什么？
    *
    * */

    /*
    * 第七题，下面这段代码将会打印出什么？
    * 这道面试题考察的核心并不是最终的打印结果（结果是不确定的），而是字符编码。通常情况下，我们在调用 getBytes() 方法时，要指定编码，比如说 str.getBytes(StandardCharsets.UTF_8)。

当我们没有指定编码的时候，JDK 会调用平台默认的字符编码，而不同的操作系统，编码不尽相同的，bytes 的结果也就会不同。

当使用 UTF_8 时，结果为 -62, -105，当使用 GB2312 时，结果为 63
    * */
    static void  demo7() {

        char[] chars = new char[]{'\u0097'};
        String str = new String(chars);
        byte[] bytes = str.getBytes();
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));
        System.out.println(Arrays.toString(bytes2));
    }
/*
*第八题 当方法在父类中抛出 NullPointerException 时，是否可以使用抛出 RuntimeException 的方法来重写它？
* RuntimeException 和 NullPointerException 属于不检查异常，所以本题的答案是可以的。如果是可检查异常的话，IDE 就会发出警告
* */

    /*
    * 第九题，下面这段代码使用了 compareTo() 方法，有问题吗？
    * */
    class Employee implements Comparable {
        private int id;

        @Override
        public int compareTo(Object o) {
            Employee emp = (Employee) o;
            return this.id - emp.id;
        }
    }
    static void  demo() {

        /*
        * 当我们需要按照一定的规则进行排序的时候，通常要实现 Comparable 接口，并实现 compareTo 方法，规则如下：
            1）如果当前对象小于另外一个对象，则 compareTo 方法必须返回负数；如果当前对象大于另外一个对象，则必须返回正数；如果两个对象相等，则返回零。
            2）通常来说，compareTo 方法必须和 equals 方法一致，如果两个对象通过 equals 方法判断的结果为 true，那么 compareTo 必须返回零。
            不过，JDK 中有一个反例，就是 BigDecimal。
            3）不能使用减法来比较整数值，因为减法的结果可能溢出。应该使用 Integer.compareTo() 来进行比较。如果你想通过减法操作来提高性能，必须得确保两个操作数是正整数，或者确保两者相差的值小于 Integer.MAX_VALUE。
        * */
        BigDecimal bd1 = new BigDecimal("2.0");
        BigDecimal bd2 = new BigDecimal("2.00");

        System.out.println("equals: " + bd1.equals(bd2));
        System.out.println("compareTo: " + bd1.compareTo(bd2));
    }

    @Data
    static
    class Test1 {
        public  int returnTryExec() {
            try {
                return 0;
            } catch (Exception e) {
            } finally {
                System.out.println("finally returnTryExec");
                return -1;
            }
        }

        public  int returnCatchExec() {
            try { } catch (Exception e) {
                return 0;
            } finally {
                System.out.println("finally returnCatchExec");
                return -1;
            }
        }

        public  void exitTryExec() {
            try {
                System.exit(0);
            } catch (Exception e) {
            } finally {
                System.out.println("finally exitTryExec");
            }
        }

        public  void exitCatchExec() {
            try { } catch (Exception e) {
                System.exit(0);
            } finally {
                System.out.println("finally exitCatchExec");
            }
        }
    }

    static class LaoWang{
        public LaoWang() {
            write();
            read();
        }
        public void write() {
            System.out.println("老王写了一本《基督山伯爵》");
        }

        private void read() {
            System.out.println("老王在读《哈姆雷特》");
        }
    }
    static class XiaoWang extends LaoWang {
        @Override
        public void write() {
            System.out.println("小王写了一本《茶花女》");
        }

        private void read() {
            System.out.println("小王在读《威尼斯商人》");
        }
    }

    static class Laozi{
        public static void write() {
            System.out.println("老子写了一本《基督山伯爵》");
        }
    }
    static class Xiaozi extends Laozi {
        public static void write() {
            System.out.println("小子写了一本《茶花女》");
        }
    }

}
