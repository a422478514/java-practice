package com.daquan._202007.spring.cyclereference;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试循环引用，默认是开启支持循环引用的
 */
public class TestMyCycleReferenceStarter {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"application.xml"},false,null);
        classPathXmlApplicationContext.setAllowCircularReferences(true);
        classPathXmlApplicationContext.refresh();
        //xml方式
        MyDemoA myDemoA = (MyDemoA) classPathXmlApplicationContext.getBean("myDemoA");
        myDemoA.sayHello();
        MyDemoB myDemoB = (MyDemoB) classPathXmlApplicationContext.getBean("myDemoB");
        myDemoB.sayHello();
    }
}
