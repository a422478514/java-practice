package com.daquan._202007._01.function;

import org.junit.Test;

public class TestMyFunInterface {
    @Test
    public void test(){
        MyFunInterface<Integer,Double> d = (i)->{return Double.valueOf(i.toString());};
        System.out.println(d.doubleNum(10));
        System.out.println(MyFunInterface.i);
        int i = d.doSomeMoreWork2();
        System.out.println(i);
        d.doSomeMoreWork1();
    }
}
