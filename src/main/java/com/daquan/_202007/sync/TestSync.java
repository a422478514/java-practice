package com.daquan._202007.sync;

/**
 * @Desc TODO
 * @Author zhangdaquan
 * @Date 2021/1/15
 */
public class TestSync {
    public static synchronized void test(){
        System.out.println(123);
        test();
    }

    public static void main(String[] args) {
        test();
    }

}
