package com.ism.dreamssellersv2.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class StatisticAspect {

    private final StatisticService statisticService;

    public StatisticAspect(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Before("execution(* com.ism.dreamssellersv2.controller..*(..))")
    public void countEndpointCalls(JoinPoint joinPoint) {
        String className = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String methodName = joinPoint.getSignature().getName();
        String endpoint = className + "." + methodName;

        statisticService.recordRequest(endpoint, null);
        statisticService.updateLastCalledEndpoint(endpoint);
    }

}
