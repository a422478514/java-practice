package com.daquan._202007._01.threadstate;

/**
 * 线程处于Runnable状态
 */
public class TestRunnableState {

    static class MyThread extends Thread{
        @Override
        public void run() {
            int sum = 0;
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sum = i;
            }
            System.out.println(sum);
        }
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
        System.out.println(t.getState());
    }
}
