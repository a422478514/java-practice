package com.daquan._202007._01.spring.exception;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyExceptionHandler {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        //从容器上下文获取bean（也可以通过实现MessageSourceAware接口来注入该bean）
        MyExceptionHandler myExceptionHandler = (MyExceptionHandler) classPathXmlApplicationContext.getBean("myExceptionHandler");
        myExceptionHandler.exception();
        System.out.println(123);
    }
}
