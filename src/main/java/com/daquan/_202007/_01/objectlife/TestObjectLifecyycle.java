package com.daquan._202007._01.objectlife;

public class TestObjectLifecyycle {
    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.daquan._202007._01.objectlife.Objectlifecycle");
//            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.daquan._202007._01.objectlife.Objectlifecycle");
//            Object o = aClass.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
