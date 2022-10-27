package com.example.demo.aspect;

import com.example.demo.controller.TestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private final Logger logger = LogManager.getLogger(LogAspect.class);

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void controllerPointCut() {
    }

    @AfterReturning("controllerPointCut()")
    public void afterReturning(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature() + " : afterReturning");
    }

    @AfterThrowing("controllerPointCut()")
    public void afterThrowing(JoinPoint joinPoint) {
        logger.info(joinPoint.getSignature() + " : afterThrowing");
    }

    @Around("controllerPointCut()")
    public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
        Object obj = joinPoint.proceed();
        logger.info(joinPoint.getSignature() + " : logging");
        return obj;
    }

}
