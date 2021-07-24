package com.daquan._202007.spring.annontation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyAnnotation {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        MyMethod myMethod = (MyMethod)classPathXmlApplicationContext.getBean("myMethod");
        myMethod.invoke();
    }
}
