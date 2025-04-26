package com.ism.dreamssellersv2.controller;

import com.ism.dreamssellersv2.aspect.StatisticAspect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatisticController {

    private final StatisticAspect statisticAspect;

    public StatisticController(StatisticAspect statisticAspect) {
        this.statisticAspect = statisticAspect;
    }

    @GetMapping("/statistics")
    public Map<String, Integer> getStatistics() {
        return statisticAspect.getStatistics();
    }
}