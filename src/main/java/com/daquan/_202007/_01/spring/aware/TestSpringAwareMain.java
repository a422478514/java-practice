package com.daquan._202007._01.spring.aware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

public class TestSpringAwareMain {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        TestSpringAware testSpringAware = (TestSpringAware)classPathXmlApplicationContext.getBean("testSpringAware");

        ApplicationContext applicationContext = testSpringAware.getApplicationContext();
        System.out.println(applicationContext.getId());
        BeanFactory beanFactory = testSpringAware.getBeanFactory();
        System.out.println(beanFactory.containsBean("testSpringAware"));
        String s = testSpringAware.getS();
        System.out.println(s);
        ApplicationEventPublisher applicationEventPublisher = testSpringAware.getApplicationEventPublisher();
        applicationEventPublisher.publishEvent(new ApplicationEvent(new String("hello")) {
            @Override
            public Object getSource() {
                return super.getSource();
            }
        });
        MessageSource messageSource = testSpringAware.getMessageSource();
        System.out.println(messageSource.toString());
        ResourceLoader resourceLoader = testSpringAware.getResourceLoader();
        System.out.println(resourceLoader.getClass());

    }
}
