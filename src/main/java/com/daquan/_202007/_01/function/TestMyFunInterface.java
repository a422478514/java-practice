package com.daquan._202007._01.function;

import org.junit.Test;

public class TestMyFunInterface {
    @Test
    public void test(){
        MyFunInterface<Integer,Double> d = (i)->{return i.doubleValue();};
        System.out.println(d.doubleNum(10));
    }
}
