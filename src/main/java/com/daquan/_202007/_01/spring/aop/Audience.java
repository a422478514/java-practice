package com.daquan._202007._01.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

//切面
//切面由切点和增强/通知组成，它既包括了横切逻辑的定义、也包括了连接点的定义。
@Aspect
public class Audience {
    //切点(Poincut)：
    //具体定位的连接点：上面也说了，每个方法都可以称之为连接点，我们具体定位到某一个方法就成为切点。
    //增强/通知(Advice)：
    //表示添加到切点的一段逻辑代码，并定位连接点的方位信息。
    //简单来说就定义了是干什么的，具体是在哪干
    //Spring AOP提供了5种Advice类型给我们：前置、后置、返回、异常、环绕给我们使用！
    //织入(Weaving)：
    //将增强/通知添加到目标类的具体连接点上的过程。
    /**
     * 表演之前,观众就座
     */
    @Before("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")//切点+通知 Pointcut+Advice
    public void takeSeats() {
        System.out.println("Taking seats");
    }

    /**
     * 表演之前,将手机调至静音
     */
    @Before("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")//切点+通知 Pointcut+Advice
    public void silenceCellPhones() {
        System.out.println("Silencing cell phones");
    }

    /**
     * 表演结束,不管表演成功或者失败
     */
    @After("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")//切点+通知 Pointcut+Advice
    public void finish() {
        System.out.println("perform finish");
    }

    /**
     * 表演之后,鼓掌
     */
    @AfterReturning("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")//切点+通知 Pointcut+Advice
    public void applause() {
        System.out.println("CLAP CLAP CLAP!!!");
    }

    /**
     * 表演失败之后,观众要求退款
     */
    @AfterThrowing("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")//切点+通知 Pointcut+Advice
    public void demandRefund() {
        System.out.println("Demanding a refund");
    }

    /**
     * 环绕通知
     * @param joinPoint
     */
    @Around("execution(* com.daquan._202007._01.spring.aop.Performance.perform(..))")//切点+环绕通知
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
