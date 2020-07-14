package com.daquan._202007._01.spring.annontation;

import org.springframework.stereotype.Component;

/**
 * 普通bean
 */
@Component
public class MyMethod {
    //带自定义注解的方法
    @MyLog("这是日志内容")
    public void invoke(){
        System.out.println("invode");
    }
}
