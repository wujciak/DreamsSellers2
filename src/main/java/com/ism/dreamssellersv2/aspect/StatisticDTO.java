package com.ism.dreamssellersv2.aspect;

import java.util.Map;

public class StatisticDTO {
    private final double highestPrice;
    private final double averagePrice;
    private final int totalItems;
    private final String mostPopularEndpoint;
    private final String lastCalledEndpoint;
    private final int totalRequests;
    private final Map<String, Integer> endpointCallCounts;

    public StatisticDTO(double highestPrice, double averagePrice, int totalItems,
                        String mostPopularEndpoint, String lastCalledEndpoint,
                        int totalRequests, Map<String, Integer> endpointCallCounts) {
        this.highestPrice = highestPrice;
        this.averagePrice = averagePrice;
        this.totalItems = totalItems;
        this.mostPopularEndpoint = mostPopularEndpoint;
        this.lastCalledEndpoint = lastCalledEndpoint;
        this.totalRequests = totalRequests;
        this.endpointCallCounts = endpointCallCounts;
    }

    public double getHighestPrice() {
        return highestPrice;
    }

    public double getAveragePrice() {
        return averagePrice;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public String getMostPopularEndpoint() {
        return mostPopularEndpoint;
    }

    public String getLastCalledEndpoint() {
        return lastCalledEndpoint;
    }

    public int getTotalRequests() {
        return totalRequests;
    }

    public Map<String, Integer> getEndpointCallCounts() {
        return endpointCallCounts;
    }
}
