package com.daquan._202007._01.spring.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * 基于Spring事件框架自定义的事件监听器，注意泛型用来确定要监听的事件
 */
@Service
public class MySpringApplicationListener implements ApplicationListener<MySpringApplicationEvent> {
    @Override
    public void onApplicationEvent(MySpringApplicationEvent mySpringApplicationEvent) {
        System.out.println("监听到事件："+mySpringApplicationEvent.getSource().toString());
    }
}
