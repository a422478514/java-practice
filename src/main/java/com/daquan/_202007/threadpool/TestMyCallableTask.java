package com.daquan._202007.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 1、直接执行MyCallableTask的call方法会直接抛出异常
 * 2、执行FutureTask的run方法则会捕捉异常，get的时候可以捕捉到
 */
public class TestMyCallableTask {
    public static void main(String[] args) {
        MyCallableTask task = new MyCallableTask();
//        try {
//            Integer call = task.call();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        System.out.println("main:"+Thread.currentThread().getId());
        new Thread(futureTask).start();
        try {
            Integer integer = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
