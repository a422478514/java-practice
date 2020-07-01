package com.daquan._202007._01.spring.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

@Service
public class TestSpringAware implements ApplicationContextAware, BeanNameAware, BeanFactoryAware, MessageSourceAware, ApplicationEventPublisherAware, ResourceLoaderAware {

    private ApplicationContext applicationContext;

    private BeanFactory beanFactory;

    private String s;

    private ApplicationEventPublisher applicationEventPublisher;

    private MessageSource messageSource;

    private ResourceLoader resourceLoader;

    //在Bean中得到Bean所在的应用上下文
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    //在Bean中得到Bean所在的IOC容器
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    //在Bean中得到它在IOC容器中的Bean的实例的名字
    @Override
    public void setBeanName(String s) {
        this.s = s;
    }

    //在bean中可以得到应用上下文的事件发布器
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    //在Bean中可以得到消息源
    @Override
    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //在Bean中可以得到ResourceLoader，从而加载外部对应的Resource资源。
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public ApplicationEventPublisher getApplicationEventPublisher() {
        return applicationEventPublisher;
    }

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public ResourceLoader getResourceLoader() {
        return resourceLoader;
    }
}
