package com.daquan._202007._01.spring.event;

import org.springframework.context.ApplicationEvent;

/**
 * 使用spring事件框架自定义的事件
 */
public class MySpringApplicationEvent extends ApplicationEvent {
    public MySpringApplicationEvent(MyEventSource eventSource) {
        super(eventSource);
    }
}
