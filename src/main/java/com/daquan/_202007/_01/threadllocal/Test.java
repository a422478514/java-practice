package com.daquan._202007._01.threadllocal;

/**
 * 不同线程中维护不同的 Map ThreadLocalMap
 * ThreadLocalMap中用ThreadLocal作为Key
 */
public class Test {
    public static void main(String[] args) {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
        threadLocal.set(1);
    }
}
