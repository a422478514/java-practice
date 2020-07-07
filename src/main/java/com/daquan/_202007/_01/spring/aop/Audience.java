package com.daquan._202007._01.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
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

    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")
    public void watchPerform(ProceedingJoinPoint joinPoint) {
        try {
            System.out.println("watchPerform Taking seats");
            System.out.println("watchPerform Silencing cell phones");

            joinPoint.proceed();

            System.out.println("watchPerform CLAP CLAP CLAP!!!");
        } catch (Throwable throwable) {
            System.out.println("watchPerform Demanding a refund");
        } finally {
            System.out.println("watchPerform perform finish");
        }
    }
}
