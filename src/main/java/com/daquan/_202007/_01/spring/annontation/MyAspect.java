package com.daquan._202007._01.spring.annontation;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * 自定义一个切面，专门处理 @MyLog的自定义注解
 */
@EnableAspectJAutoProxy
@Aspect
@Component
public class MyAspect {
    /**
     * 自定义一个切点
     */
    @Pointcut("@annotation(com.daquan._202007._01.spring.annontation.MyLog)")
    public void pointcut(){}

    /**
     * before通知
     * @param logger 即 @annotation(logger)中的Logger
     */
    @Before("pointcut() && @annotation(logger)")
    public void before(MyLog logger){
        System.out.println(logger.value());
    }
}
