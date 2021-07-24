package com.daquan._202007.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyAop {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        Performance sleep = (Performance) classPathXmlApplicationContext.getBean("sleepNoMore");
        sleep.perform();
    }
}
