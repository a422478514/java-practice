package com.daquan._202007.spring.event;

import java.io.Serializable;

/**
 * 用来描述事件源的实体类
 */
public class MyEventSource implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;

    public MyEventSource(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyEventSource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
