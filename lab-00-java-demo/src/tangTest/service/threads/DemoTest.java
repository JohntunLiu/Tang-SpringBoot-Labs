package tangTest.service.threads;

import java.util.Optional;

public class DemoTest {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("my thread!");
        }
    }
    public static class MyThread2 implements Runnable {
        @Override
        public void run() {
            System.out.println("my thread2!");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
//        myThread.start();
        new Thread(new MyThread()).start();

        new Thread(new MyThread2()).start();
        new Thread(() -> System.out.println("no myThread!")).start();

        String s = null;
        String s1 = "345";
//        System.out.println(s.equals(""));
        System.out.println(Optional.ofNullable(s).map(i->i.equals("123")).orElse(false));
    }

}
