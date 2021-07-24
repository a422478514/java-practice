package com.daquan._202007.async;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/7/14
 */
public class TestAsync {
    public static void main(String[] args) {



        long start = System.currentTimeMillis();

        List<Thread> list = new ArrayList<Thread>();
        for(int i = 0; i < 5; i++)
        {
            Thread thread = new TestThread();
            thread.start();
            list.add(thread);
        }

        try
        {
            int i = 0;
            for(Thread thread : list)
            {
                System.out.println("before:"+i++);
                thread.join();
                System.out.println("after");
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
    }
}
