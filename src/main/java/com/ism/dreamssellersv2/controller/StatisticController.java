package com.ism.dreamssellersv2.controller;

import com.ism.dreamssellersv2.aspect.StatisticDTO;
import com.ism.dreamssellersv2.aspect.StatisticService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatisticController {

    private final StatisticService statisticService;

    public StatisticController(StatisticService statisticService) {
        this.statisticService = statisticService;
    }

    @GetMapping("/statistics")
    public Map<String, Integer> getEndpointStatistics() {
        return statisticService.getEndpointCallCount();
    }

    @GetMapping("/statistics/highest-price")
    public double getHighestPrice() {
        return statisticService.getHighestPrice();
    }

    @GetMapping("/statistics/total-requests")
    public int getTotalRequests() {
        return statisticService.getTotalRequests();
    }

    @GetMapping("/statistics/most-popular-endpoint")
    public String getMostPopularEndpoint() {
        return statisticService.getMostCalledEndpoint();
    }

    @GetMapping("/statistics/average-price")
    public double getAveragePrice() {
        return statisticService.getAveragePrice();
    }

    @GetMapping("/statistics/total-items")
    public int getTotalItems() {
        return statisticService.getTotalItems();
    }

    @GetMapping("/statistics/last-endpoint")
    public String getLastEndpoint() {
        return statisticService.getLastCalledEndpoint();
    }

    @GetMapping("/statistics/all")
    public StatisticDTO getFullStatistics() {
        return new StatisticDTO(
                statisticService.getHighestPrice(),
                statisticService.getAveragePrice(),
                statisticService.getTotalItems(),
                statisticService.getMostCalledEndpoint(),
                statisticService.getLastCalledEndpoint(),
                statisticService.getTotalRequests(),
                statisticService.getEndpointCallCount()
        );
    }
}
