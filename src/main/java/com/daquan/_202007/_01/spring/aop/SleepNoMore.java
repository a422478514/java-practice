package com.daquan._202007._01.spring.aop;

import org.springframework.stereotype.Component;

/**
 * 目标对象
 */
@Component
public class SleepNoMore implements Performance{
    //连接点 Join point ，能够被拦截的地方：Spring AOP是基于动态代理的，所以是方法拦截的。每个成员方法都可以称之为连接点~
    @Override
    public void perform() {
        System.out.println("戏剧《不眠之夜Sleep No More》");
    }
}
