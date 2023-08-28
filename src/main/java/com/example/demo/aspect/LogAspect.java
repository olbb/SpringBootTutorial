package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @author JuanLv created at 2023/8/28
 */
@Aspect
public class LogAspect {

    @Around("execution(* com.example.demo.service.*.*(..))")
    public Object businessService(ProceedingJoinPoint point) throws Throwable {

        Method method = ((MethodSignature)point.getSignature()).getMethod();
        String name = method.getName();
        System.out.println("execute method start: " + name);
        Object obj = point.proceed();
        System.out.println("execute method end: " + name);
        return obj;
    }

}
