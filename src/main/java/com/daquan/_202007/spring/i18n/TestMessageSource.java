package com.daquan._202007.spring.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class TestMessageSource {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        //从容器上下文获取bean（也可以通过实现MessageSourceAware接口来注入该bean）
        MessageSource messageResource = (MessageSource)classPathXmlApplicationContext.getBean("messageSource");
        String errorCh = messageResource.getMessage("welcome", null, Locale.SIMPLIFIED_CHINESE);
        System.out.println(errorCh);
    }
}
