package com.daquan._202007._01.spring.annontation;

import java.lang.annotation.*;

@Documented//是否出现在java文档中
@Retention(RetentionPolicy.RUNTIME)//注解保留到什么时候
@Target(ElementType.METHOD)
public @interface MyLog {
    String value() default "";
}
