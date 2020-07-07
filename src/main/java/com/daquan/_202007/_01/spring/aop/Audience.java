package com.daquan._202007._01.spring.aop;

import org.aspectj.lang.annotation.*;

@Aspect
public class Audience {
    /**
     * 表演之前,观众就座
     */
    @Before("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    /**
     * 表演之前,将手机调至静音
     */
    @Before("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    /**
     * 表演结束,不管表演成功或者失败
     */
    @After("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")
    public void finish() {
        System.out.println("perform finish");
    }

    /**
     * 表演之后,鼓掌
     */
    @AfterReturning("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    /**
     * 表演失败之后,观众要求退款
     */
    @AfterThrowing("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }
}
