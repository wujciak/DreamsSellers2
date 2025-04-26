package com.ism.dreamssellersv2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Aspect
@Component
public class StatisticAspect {

    private final Map<String, Integer> endpointCalls = new ConcurrentHashMap<>();

    @Before("execution(* com.ism.dreamssellersv2.controller..*(..))")
    public void countEndpointCalls(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String key = className + "." + methodName;

        endpointCalls.merge(key, 1, Integer::sum);
    }

    public Map<String, Integer> getStatistics() {
        return endpointCalls;
    }
}
