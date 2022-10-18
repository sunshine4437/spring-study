package com.spring.spring.Aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Aspect
@Component
public class Aop {
    @Pointcut("execution(* com.spring.spring.controller.*.*(..))")
    public void testAOP() {

    }

    @Around("testAOP()")
    public Object aroudAOP(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        try {
            result = joinPoint.proceed();
            System.out.println("around : " + joinPoint.getSignature());
            Arrays.asList(joinPoint.getArgs()).forEach(e -> {
                if (e instanceof HttpServletRequest) {
                    System.out.println("HttpServletRequest");
                }
                if (e instanceof Map) {
                    System.out.println("Map");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
