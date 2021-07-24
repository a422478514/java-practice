package com.daquan._202007.threadpool;

/**
 * 测试继承Thread实现多线程抛异常方式
 */
public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId()+":run");
        throw new RuntimeException();
    }
}
