package tangTest.service.threads;

import java.io.InputStream;
import java.util.stream.IntStream;

public class PriorityDemo {
    public static void main(String[] args) {
        demo();
    }

    static class T1 extends Thread {
        @Override
        public void run(){
            super.run();
            System.out.println(String.format("now thread:%s, priority: %d",Thread.currentThread().getName(),Thread.currentThread().getPriority()));

        }
    }
    public static void demo() {

        //所以，如果某个线程优先级大于线程所在线程组的最大优先级，那么该线程的优先级将会失效，取而代之的是线程组的最大优先级
        ThreadGroup threadGroup = new ThreadGroup("t1");
        threadGroup.setMaxPriority(6);
        Thread thread = new Thread(threadGroup,"thread");
        thread.setPriority(9);
        System.out.println("我是线程组的优先级"+threadGroup.getMaxPriority()+thread.getThreadGroup().getName());
        System.out.println("我是线程的优先级"+thread.getPriority()+thread.getName());
    }
    public static void demo02() {
        //Java提供一个线程调度器来监视和控制处于RUNNABLE状态的线程。线程的调度策略采用抢占式，优先级高的线程比优先级低的线程会有更大的几率优先执行。在优先级相同的情况下，按照“先到先得”的原则。每个Java程序都有一个默认的主线程，就是通过JVM启动的第一个线程main线程。
        IntStream.range(1,10).forEach(i->{
            Thread thread = new Thread(new T1());
            thread.setPriority(i);
            thread.start();
        });
    }

    public static void demo01() {
        Thread a = new Thread();
        Thread b = new Thread();
        System.out.println("a:" + a.getPriority());
        b.setPriority(10);
        System.out.println("b:" + b.getPriority());
    }
}
