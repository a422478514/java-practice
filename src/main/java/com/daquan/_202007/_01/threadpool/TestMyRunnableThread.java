package com.daquan._202007._01.threadpool;

public class TestMyRunnableThread {
    public static void main(String[] args) {
        MyRunnableThread thread = new MyRunnableThread();
        Thread t = new Thread(thread);
        t.start();
    }
}
