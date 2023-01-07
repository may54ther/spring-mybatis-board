package io.ahakim.crud.config.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class ServiceLoggingAspect {

    @Pointcut("within(io.ahakim.crud.service.*)")
    public void onService() {
    }

    @Before("onService()")
    public void beforeLogging(JoinPoint joinPoint) {
        log.info("[beforeService] {}, args={}", joinPoint.getSignature(), joinPoint.getArgs());
    }

    @Around("onService()")
    public Object doLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        long beforeTimeMills = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long afterTimeMills = System.currentTimeMillis();

        log.info("[Service] {}  ({}ms)",
                joinPoint.getSignature(), (afterTimeMills - beforeTimeMills));
        return result;
    }
}