package com.daquan._202007.spring.aware;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public class TestSpringAwareMain {
    public static void main(String[] args) throws IOException {
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
        String errorCh = messageSource.getMessage("welcome", null,"empty", Locale.SIMPLIFIED_CHINESE);
        System.out.println(errorCh);
        ResourceLoader resourceLoader = testSpringAware.getResourceLoader();
        Resource resource = resourceLoader.getResource("1.txt");
        File file = resource.getFile();
        System.out.println(resourceLoader.getClass());
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

    }
}
