package com.daquan._202007._01.objectlife;

public class Objectlifecycle {

    public static int i = 1;
    static {
        System.out.println(i++);
    }

}
