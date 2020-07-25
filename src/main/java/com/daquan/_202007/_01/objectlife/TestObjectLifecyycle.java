package com.daquan._202007._01.objectlife;

public class TestObjectLifecyycle {
    public static void main(String[] args) {
        try {
            //Class.forName("com.daquan._202007._01.objectlife.Objectlifecycle");
            Class<?> aClass = ClassLoader.getSystemClassLoader().loadClass("com.daquan._202007._01.objectlife.Objectlifecycle");
            Object o = aClass.newInstance();

            System.out.println(aClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
