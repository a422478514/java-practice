package com.daquan._202007.spring.beanlifecycle;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyBeanLifecycle {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        MyBean myBean = (MyBean) classPathXmlApplicationContext.getBean("myBean");
        //执行下优雅关机，否则bean的destroy方法不会被调用
        classPathXmlApplicationContext.registerShutdownHook();
        String s = null;
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        System.out.println(sb);
        String.valueOf(null);
    }
}
