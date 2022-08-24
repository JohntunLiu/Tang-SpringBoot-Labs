package tangTest.service.threads;

import java.util.concurrent.*;

public class Task implements Callable {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        //在很多高并发的环境下，有可能Callable和FutureTask会创建多次。FutureTask能够在高并发环境下确保任务只执行一次。
        FutureTask<Integer> futureTask = new FutureTask<>(new Task());
        executorService.submit(futureTask);
        System.out.println(futureTask.get());
    }

    static void demo01() throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> submit = executorService.submit(task);
        // 注意调用get方法会阻塞当前线程，直到得到结果。
        // 所以实际编码中建议使用可以设置超时时间的重载get方法。
        System.out.println(submit.get());
    }
}
