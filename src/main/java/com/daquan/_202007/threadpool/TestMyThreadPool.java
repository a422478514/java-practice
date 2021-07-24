package com.daquan._202007.threadpool;

import java.util.concurrent.*;

public class TestMyThreadPool {
    public static void main(String[] args) {
        BlockingQueue blockingQueue = new LinkedBlockingQueue(10);
        MyThreadPoolExecutor myThreadPoolExecutor = new MyThreadPoolExecutor(5,100,1000l, TimeUnit.MILLISECONDS,blockingQueue);
        for (int i = 0; i < 10; i++) {
            myThreadPoolExecutor.submit(() -> {
                for (int j = 0; j < 10; j++) {
                    System.out.println(Thread.currentThread().getId() + ":" + j);
                    if (j == 5) {
                        System.out.println(Thread.currentThread() + ":error");
                        throw new RuntimeException();
                    }
                }
            });
        }

    }
}
