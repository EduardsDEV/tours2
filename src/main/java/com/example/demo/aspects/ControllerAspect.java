package com.example.demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ControllerAspect {

    protected final Logger log = LoggerFactory.getLogger(this.getClass());

    int beforeCount = 0;
    int afterCount = 0;

    @Before("execution(public * com.example.demo.controllers.*Controller.*(..))")
    public void logBeforeControllerCall(JoinPoint pjp) throws Throwable {
        beforeCount++;
        log.info(":::::AOP BEFORE CONTROLLER call::::: #"+ beforeCount + pjp);
    }

    @After("execution(public * com.example.demo.controllers.*Controller.*(..))")
    public void logAfterControllerCall(JoinPoint pjp) throws Throwable {
        afterCount++;
        log.info(":::::AOP AFTER CONTROLLER call::::: #"+ afterCount + pjp);
    }
}
