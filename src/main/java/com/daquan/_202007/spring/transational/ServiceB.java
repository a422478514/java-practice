package com.daquan._202007.spring.transational;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ServiceB {
    public void methodB(){
        //op some dml
    }
    public void methodBB(){
        //op some dml
    }
}
