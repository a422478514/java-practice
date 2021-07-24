package com.daquan._202007.spring.transational;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional//默认对本类所有方法加注释
public class ServiceA {
    @Transactional(value = "",transactionManager = "",
            propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT,
            timeout = 1, readOnly = true, rollbackFor = RuntimeException.class,noRollbackFor = RuntimeException.class)
    public void methodA(){
        //op some dml
    }
    public void methodAA(){
        //op some dml
    }
}
