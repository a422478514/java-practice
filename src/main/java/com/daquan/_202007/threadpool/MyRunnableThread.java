package com.daquan._202007.threadpool;

/**
 * 测试实现Runnable实现多线程抛异常方式
 */
public class MyRunnableThread implements Runnable{
    @Override
    public void run() {
        System.out.println("MyRunnableThread");
        //throw new RuntimeException();
    }
}
