package com.daquan._202007.spring.factory;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyCarFactory {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        Car carStatic = (Car) classPathXmlApplicationContext.getBean("car");
        System.out.println(carStatic.getBrand());
    }
}
