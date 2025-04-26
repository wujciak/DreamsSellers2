package com.ism.dreamssellersv2.aspect;

import com.ism.model.ItemDTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class PriceMonitoringAspect {

    private final StatisticService statisticService;

    public PriceMonitoringAspect(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @Pointcut("execution(public java.util.List com.ism.dreamssellersv2.service.ItemService.getItems(..))")
    public void findAllItemsMethods() {}

    @Around("findAllItemsMethods()")
    public Object monitorHighestPrice(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = joinPoint.proceed();
        if (result instanceof List<?> itemList) {
            for (Object obj : itemList) {
                if (obj instanceof ItemDTO itemDto) {
                    statisticService.checkHighestPrice(itemDto.getPrice());
                    statisticService.addItemPrice(itemDto.getPrice());
                }
            }
        }

        return result;
    }

}
