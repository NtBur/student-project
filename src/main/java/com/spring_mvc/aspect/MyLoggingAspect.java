package com.spring_mvc.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

@Component
@Aspect
public class MyLoggingAspect {
    @Around("execution(* com.spring_mvc.repository.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature = (MethodSignature)proceedingJoinPoint.getSignature();
        String methodName = methodSignature.getName();
        log.println("begin of " + methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        log.println("end of " + methodName);
        return targetMethodResult;
    }
}
