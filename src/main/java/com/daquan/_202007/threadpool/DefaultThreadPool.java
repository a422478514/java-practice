package com.daquan._202007.threadpool;

import java.util.LinkedHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/1/15
 */
public class DefaultThreadPool {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);
        new LinkedHashMap<String,Integer>();
        new SynchronousQueue();
    }
}
