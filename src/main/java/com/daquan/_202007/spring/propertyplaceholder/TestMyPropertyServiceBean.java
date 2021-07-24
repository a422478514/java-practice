package com.daquan._202007.spring.propertyplaceholder;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMyPropertyServiceBean {
    public static void main(String[] args) {
        System.out.println("加载spring容器");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("application.xml");
        //xml方式
        XmlMyPropertyServiceBean myPropertyServiceBean = (XmlMyPropertyServiceBean) classPathXmlApplicationContext.getBean("myPropertyServiceBean");
        System.out.println(myPropertyServiceBean.getId());
        System.out.println(myPropertyServiceBean.getName());
        //注解方式
        AnnotationMyPropertyServiceBean annotationMyPropertyServiceBean = (AnnotationMyPropertyServiceBean) classPathXmlApplicationContext.getBean("annotationMyPropertyServiceBean");
        System.out.println(annotationMyPropertyServiceBean.getId());
    }
}
