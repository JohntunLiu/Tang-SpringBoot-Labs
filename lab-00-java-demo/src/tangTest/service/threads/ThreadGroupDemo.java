package tangTest.service.threads;

public class ThreadGroupDemo {
    //线程组是一个树状的结构，每个线程组下面可以有多个线程或者线程组。线程组可以起到统一控制线程的优先级和检查线程的权限的作用
    public static void main(String[] args) {
        //线程组统一异常处理
        ThreadGroup threadGroup1 = new ThreadGroup("group1") {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getName()+":"+e.getMessage());
            }
        };

        Thread test_exception = new Thread(threadGroup1, new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("test exception");
            }
        });
        test_exception.start();
        //java.lang.IllegalThreadStateException
//        test_exception.start();
    }

    static void demo() {
        Thread thread = new Thread(() -> {
            System.out.println("testThread group name:" + Thread.currentThread().getThreadGroup().getName());
            System.out.println("testThread name:" + Thread.currentThread().getName());
        });
        //ThreadGroup管理着它下面的Thread，ThreadGroup是一个标准的向下引用的树状结构，这样设计的原因是防止"上级"线程被"下级"线程引用而无法有效地被GC回收
        thread.start();
        System.out.println("main thread name : " + Thread.currentThread().getThreadGroup().getName());
        System.out.println("main thread name : " + Thread.currentThread().getName());
    }
}
