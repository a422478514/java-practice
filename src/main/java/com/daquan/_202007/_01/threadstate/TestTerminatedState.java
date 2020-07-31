package com.daquan._202007._01.threadstate;

public class TestTerminatedState {

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
        MyThread myThread = new MyThread();
        System.out.println(myThread.getState());
        myThread.start();
        System.out.println(myThread.getState());
        myThread.stop();
        System.out.println(myThread.getState());
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(myThread.getState());
    }
}
