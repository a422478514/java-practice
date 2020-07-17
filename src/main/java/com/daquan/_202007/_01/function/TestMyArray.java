package com.daquan._202007._01.function;

import org.junit.Test;

import java.util.stream.IntStream;

public class TestMyArray {

    @Test
    public void testIntArr(){
        int [] arr = {1,2,3};
        double asDouble = IntStream.of(arr).average().getAsDouble();
        System.out.println(asDouble);
    }

    @Test
    public void testLambda(){
        Runnable target = (Runnable) () -> System.out.println("新建一个线程");
        System.out.println("start");
        new Thread(target).start();
    }


}
