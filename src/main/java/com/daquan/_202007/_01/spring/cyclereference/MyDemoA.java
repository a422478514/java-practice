package com.daquan._202007._01.spring.cyclereference;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyDemoA implements BeanPostProcessor, InstantiationAwareBeanPostProcessor, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    @Autowired
    private MyDemoB demoB;

    /*public MyDemoA(MyDemoB demoB){
        this.demoB = demoB;
    }*/

    public void sayHello(){
        System.out.println("sayHello A");
    }

    public MyDemoA(){
        System.out.println("MyDemoA");
    }

    @PostConstruct
    public void init(){
        System.out.println("MyDemoB init");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyDemoA setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("MyDemoA setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyDemoA destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyDemoA afterPropertiesSet");
    }
}
