package com.daquan._202007.threadpool;

import java.util.concurrent.Callable;

/**
 * 测试实现Callable实现多线程抛异常方式
 */
public class MyCallableTask implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        //显示当前执行线程
        System.out.println("MyCallableTask:"+Thread.currentThread().getId());
        int i = 1;
        if(i==1) throw new RuntimeException();
        return 1;
    }
}
