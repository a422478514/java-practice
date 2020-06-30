package com.daquan._202006;

import java.util.concurrent.Executors;

/**
 * 演示放置钩子实现优雅关机
 */
public class TestShutdownHook {

    private static int STOP = 0;//0 ：未关闭 1：已关闭

    /**
     * 模拟正在运行着的业务
     */
    static class Task extends Thread{
        @Override
        public void run() {
            int i = 100;
            while(true){
                if(STOP == 1) break;//如果jvm正在关闭，则停止执行业务
                for (int j = 0; j < i; j++) {
                    System.out.println("正在执行业务"+j);
                }
                /*try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
            }
        }
    }

    /**
     * 添加关机钩子
     */
    public static void addShutDownHook(){
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                //先把关机状态置为1
                STOP = 1;
                int i = 10;
                while(i-- > 0){
                    System.out.println(i+"秒后停机");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("程序运行");
        //注册钩子
        addShutDownHook();
        //执行task任务、
        Executors.newFixedThreadPool(1).submit(new Task());
        //jdk8写法
        Executors.newFixedThreadPool(1).submit(()->{
                int i = 100;
                while(true){
                    if(STOP == 1) break;//如果jvm正在关闭，则停止执行业务
                    for (int j = 0; j < i; j++) {
                        System.out.println("正在执行业务"+j);
                    }
                }
        });
        System.out.println("程序关闭");
    }
}
