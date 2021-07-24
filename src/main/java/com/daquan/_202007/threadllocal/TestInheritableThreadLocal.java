package com.daquan._202007.threadllocal;

/**
 * 使用InheritableThreadLocal可以实现多个线程访问ThreadLocal的值，
 * 我们在主线程中创建一个InheritableThreadLocal的实例，
 * 然后在子线程中得到这个InheritableThreadLocal实例设置的值。
 * 但是子线程不可以修改主线程的线程局部变量
 */
public class TestInheritableThreadLocal {

    static InheritableThreadLocal<Integer> threadLocal = new InheritableThreadLocal();
    static {
        threadLocal.set(1);
        Integer integer = threadLocal.get();
        System.out.println(Thread.currentThread().getId()+":"+integer);
    }

    public static void main(String[] args) throws InterruptedException {
        //子线程1
        new Thread(()->{
            Integer integer = threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":"+integer);
            threadLocal.set(2);
            integer = threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":"+integer);
        }).start();
        Thread.sleep(100);
        Integer integer = threadLocal.get();
        System.out.println(Thread.currentThread().getId()+":"+integer);
        threadLocal.set(3);
        //子线程2
        new Thread(()->{
            Integer i = threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":"+i);
            threadLocal.set(4);
            i = threadLocal.get();
            System.out.println(Thread.currentThread().getId()+":"+i);
        }).start();
        Thread.sleep(100);
        integer = threadLocal.get();
        System.out.println(Thread.currentThread().getId()+":"+integer);
        threadLocal.set(3);
    }
}
