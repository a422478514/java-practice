package com.daquan._202007._01.spring.event;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 测试SpringEvent的启动器
 */
public class TestSpringEventMain {
    public static void main(String[] args) {
        System.out.println("1、加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        System.out.println("2、从容器中获取事件发布器");
        MySpringEventPublisherContext publisherContext = classPathXmlApplicationContext.getBean(MySpringEventPublisherContext.class);
        System.out.println("3、发布事件");
        publisherContext.getApplicationEventPublisher().publishEvent(new MySpringApplicationEvent(new MyEventSource(1,"daquan")));

    }
}
