package com.daquan._202007._01.spring.exception;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@ControllerAdvice
public class MyExceptionHandler implements InitializingBean {

    @ExceptionHandler(NullPointerException.class)
    public void handleNull(NullPointerException e){
        System.out.println("error:"+e.getMessage());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void exception(){
        Integer i = null;
        i.byteValue();
    }

}
