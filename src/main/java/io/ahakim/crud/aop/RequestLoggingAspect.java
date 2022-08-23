package io.ahakim.crud.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Aspect
@Component
public class RequestLoggingAspect {

    @Pointcut("within(io.ahakim.crud.controller.*)")
    public void onRequest() {
    }

    @Around("onRequest()")
    public Object doLogging(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Map<String, String[]> paramMap = request.getParameterMap();

        String params = "";
        if (!paramMap.isEmpty()) {
            params = " [" + paramMapToString(paramMap) + "]";
        }

        long beforeTimeMills = System.currentTimeMillis();
        try {
            return joinPoint.proceed(joinPoint.getArgs());
        } finally {
            long afterTimeMills = System.currentTimeMillis();
            log.info("[Request] {} {}{} < {} ({}ms)", request.getMethod(), request.getRequestURI(),
                    params, request.getRemoteHost(), afterTimeMills - beforeTimeMills);
        }
    }

    private String paramMapToString(Map<String, String[]> paramMap) {
        return paramMap.entrySet().stream()
                .map(entry -> String.format("%s : %s", entry.getKey(),
                        Arrays.toString(entry.getValue()))).collect(Collectors.joining(", "));
    }
}



