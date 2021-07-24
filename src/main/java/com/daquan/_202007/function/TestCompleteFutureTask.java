package com.daquan._202007.function;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CompleteFutureTask测试
 */
public class TestCompleteFutureTask {
    ExecutorService executorService = Executors.newFixedThreadPool(10);
    /**
     * 这些方法的输入是上一个阶段计算后的结果，返回值是经过转化后结果
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void test1() throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getId()+":test1");
        String result = CompletableFuture.supplyAsync(()->{
            print("hellp");
            return "Hello ";}).thenApply(v -> {
            print("world");
                return v + "world";}).get();
        print(result);
    }

    /**
     * 这些方法只是针对结果进行消费，入参是Consumer，没有返回值
     */
    @Test
    public void test2(){
        System.out.println(Thread.currentThread().getId());
        CompletableFuture.supplyAsync(()->{
                print("hello");
            return "Hello ";}).thenAcceptAsync(v -> {
                print("consumer:"+v);
            },executorService);
    }

    /**
     * 需要上一阶段的返回值，并且other代表的CompletionStage也要返回值之后，把这两个返回值，进行转换后返回指定类型的值。
     *
     * 说明：同样，也存在对两个CompletionStage结果进行消耗的一组方法，例如thenAcceptBoth，这里不再进行示例。
     */
    @Test
    public void test3(){
        String result = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("hello");
            return "Hello";
        },executorService).thenCombine(CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            print("world");
            return "world";
        },executorService),(s1,s2)->{
            print(s1 + " " + s2);
            return s1 + " " + s2;
        }).join();
        print(result);
    }

    /**
     * 两个CompletionStage，谁计算的快，就用那个CompletionStage的结果进行下一步的处理
     */
    @Test
    public void test4(){
        String result = CompletableFuture.supplyAsync(()->{
            print("Hi Boy");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hi Boy";
        },executorService).applyToEither(CompletableFuture.supplyAsync(()->{
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            print("Hi Girl");
            //if(1==1) throw new RuntimeException();
            return "Hi Girl";
        },executorService),(s)->{
            print(s);
            return s;}).exceptionally(e->{
            System.out.println(e.getMessage());
            return "Hello world!";
        }).join();
        print(result);
    }


    /**
     * 运行时出现了异常，可以通过exceptionally进行补偿
     */
    @Test
    public void test5(){
        String result = CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(true) {
                throw new RuntimeException("exception test!");
            }

            return "Hi Boy";
        }).exceptionally(e->{
            System.out.println(e.getMessage());
            return "Hello world!";
        }).join();
        System.out.println(result);
    }

    public void print(String s){
        long id = Thread.currentThread().getId();
        System.out.println(id+":"+s);
    }
}
