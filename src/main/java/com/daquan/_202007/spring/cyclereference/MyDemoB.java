package com.daquan._202007.spring.cyclereference;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MyDemoB implements BeanPostProcessor, InstantiationAwareBeanPostProcessor, BeanNameAware, BeanFactoryAware, InitializingBean, DisposableBean {
    //@Autowired
    private MyDemoA demoA;

    public MyDemoB(MyDemoA demoA){
        this.demoA = demoA;
        System.out.println("MyDemoB");
    }

    @PostConstruct
    public void init(){
        System.out.println("MyDemoB init");
    }

    public void sayHello(){
        System.out.println("sayHello B");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("MyDemoB setBeanFactory");
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("MyDemoB setBeanName");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("MyDemoB destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyDemoB afterPropertiesSet");
    }
}
