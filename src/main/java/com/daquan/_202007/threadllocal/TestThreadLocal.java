package com.daquan._202007.threadllocal;

/**
 * 不同线程中维护不同的 Map ThreadLocalMap
 * ThreadLocalMap中用ThreadLocal作为Key
 */
public class TestThreadLocal {
    static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
    static {
        threadLocal.set(1);
        Integer integer = threadLocal.get();
        System.out.println(Thread.currentThread().getId()+":"+integer);
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            Integer integer = threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":"+integer);
            threadLocal.set(2);
            integer = threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":"+integer);
        }).start();
        Thread.sleep(100);
        Integer integer = threadLocal.get();
        System.out.println(Thread.currentThread().getId()+":"+integer);
    }
}
