package com.daquan._202007._01.threadpool;

public class TestMyThread {
    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        //测试是否新开线程
        System.out.println("main:"+Thread.currentThread().getId());
    }
}
