package com.daquan._202007.spring.propertyplaceholder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

/**
 * 注解注入属性值，通过注解注入bean和属性
 */
@Service
@PropertySource(value = "classpath:placeholder.properties",ignoreResourceNotFound = true)
public class AnnotationMyPropertyServiceBean {
    @Value("${id}")
    private int id;
    @Value("${name}")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
