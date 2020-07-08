package com.daquan._202007._01.spring.cyclereference;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyDemoB {
    @Autowired
    private MyDemoA demoA;

    public void sayHello(){
        System.out.println("sayHello");
    }
}
