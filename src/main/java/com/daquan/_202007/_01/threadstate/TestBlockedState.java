package com.daquan._202007._01.threadstate;

/**
 * 测试线程block
 */
public class TestBlockedState {

    static class MyThread extends Thread{
        @Override
        public void run() {
            synchronized (TestBlockedState.class){
                int sum = 0;
                for (int i = 0; i < Integer.MAX_VALUE; i++) {
                    sum = i;
                }
                System.out.println(sum);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        t1.start();
        t2.start();
        System.out.println(t1.getState());
        System.out.println(t2.getState());
    }
}
