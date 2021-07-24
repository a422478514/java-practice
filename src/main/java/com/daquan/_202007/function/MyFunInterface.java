package com.daquan._202007.function;

@FunctionalInterface//做编译检查用的，判断当前接口是否符合函数式编程-lambda表达式
interface MyFunInterface<K,V> {
    int i = 1;
    V doubleNum(K i);
    String toString(); //same to Object.toString
    int hashCode(); //same to Object.hashCode
    boolean equals(Object obj); //same to Object.equals

    default void doSomeMoreWork1()
    {
        // Method body
        System.out.println("doSomeMoreWork1");
    }

    default int doSomeMoreWork2()
    {
        // Method body
        return 1;
    }
}
