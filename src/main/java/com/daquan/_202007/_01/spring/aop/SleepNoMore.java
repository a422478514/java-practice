package com.daquan._202007._01.spring.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@EnableAspectJAutoProxy
@Component
public class SleepNoMore implements Performance{
    @Override
    public void perform() {
        System.out.println("戏剧《不眠之夜Sleep No More》");
    }
}
