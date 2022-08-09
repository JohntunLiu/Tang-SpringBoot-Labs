package com.tang.annotationdemo;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

//多线程不安全
public class ConcurrentHashMapDemo {

    public static void main(String[] args) throws InterruptedException {

        ConcurrentHashMap<String, Integer> map= new ConcurrentHashMap<>();
        map.put("key", 1);
        ExecutorService pool = Executors.newFixedThreadPool(100);
        for (int i = 0; i < 1000; i++) {
            pool.execute(()->{
                int value = map.get("key") + 1;
                map.put("key", value);
            });
        }
        //ConcurrentHashMap 只能保证这两步单的操作是个原子操作，线程安全。但是并不能保证两个组合逻辑线程安全，很有可能 A 线程刚通过 get 方法取到值，还未来得及加 1，线程发生了切换，B 线程也进来取到同样的值。
        TimeUnit.SECONDS.sleep(5L);
        System.out.println("---------"+map.get("key")); //期望1001，输出结果小于这个数
/*
* 使用 AtomicInteger 解决以上的问题
* */
        ConcurrentHashMap<String, AtomicInteger> map2= new ConcurrentHashMap<>();

        for (int i = 0; i < 1000; i++) {
            pool.execute(()->{
                map2.computeIfAbsent("key", s -> new AtomicInteger(1)).incrementAndGet();
            });
        }
        //ConcurrentHashMap 只能保证这两步单的操作是个原子操作，线程安全。但是并不能保证两个组合逻辑线程安全，很有可能 A 线程刚通过 get 方法取到值，还未来得及加 1，线程发生了切换，B 线程也进来取到同样的值。
        TimeUnit.SECONDS.sleep(5L);
        pool.shutdown();
        System.out.println("---------"+map2.get("key")); //期望1001，输出结果小于这个数


    }


}


