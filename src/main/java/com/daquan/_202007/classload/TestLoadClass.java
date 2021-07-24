package com.daquan._202007.classload;


public class TestLoadClass {
    public static void main(String[] args) {
        try {
            ClassLoader.getSystemClassLoader().loadClass("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
