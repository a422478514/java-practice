package com.daquan._202007.threadstate;

import java.util.concurrent.locks.LockSupport;

public class TestWatingState {

    private static Integer LOCK = 1;

    static class MyThreadA extends Thread{
        @Override
        public void run() {
            try {
                LockSupport.park();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int sum = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sum = i;
            }
            System.out.println(sum);
        }
    }

    static class MyThreadB extends Thread{
        @Override
        public void run() {
            LockSupport.unpark(Thread.currentThread());
            int sum = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sum = i;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestBlockedState.MyThread t1 = new TestBlockedState.MyThread();
        TestBlockedState.MyThread t2 = new TestBlockedState.MyThread();
        t1.start();
        t2.start();
        t2.join();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
