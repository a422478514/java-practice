package com.daquan._202007.threadstate;

/**
 * 线程处于new状态
 */
public class TestThreadNewState {
    public static void main(String[] args) {
        Thread t = new Thread();
        System.out.println(t.getState());
    }
}
