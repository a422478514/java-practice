package com.daquan._202007._01.string;

/**
 * 通过断点可以看出temp和str是都指向了字符串常量池
 */
public class TestStringPos {
    public static void main(String[] args) {
        String temp = "hello";  // 在常量池中
        String str = new String(temp); // 在堆上
        System.out.println(123);
    }
}
