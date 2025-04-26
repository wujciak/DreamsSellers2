package com.ism.dreamssellersv2.aspect;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticService {

    private double highestPrice = 0.0;
    private int totalRequests = 0;
    private final Map<String, Integer> endpointCallCount = new HashMap<>();
    private final Map<String, Integer> userCallCount = new HashMap<>();

    public synchronized void recordRequest(String endpoint, String username) {
        totalRequests++;

        endpointCallCount.put(endpoint, endpointCallCount.getOrDefault(endpoint, 0) + 1);

        if (username != null) {
            userCallCount.put(username, userCallCount.getOrDefault(username, 0) + 1);
        }
    }

    public synchronized void checkHighestPrice(Double price) {
        if (price != null && price > highestPrice) {
            highestPrice = price;
        }
    }

    public synchronized double getHighestPrice() {
        return highestPrice;
    }

    public synchronized int getTotalRequests() {
        return totalRequests;
    }

    public synchronized Map<String, Integer> getEndpointCallCount() {
        return endpointCallCount;
    }

    public synchronized Map<String, Integer> getUserCallCount() {
        return userCallCount;
    }

    public synchronized String getMostCalledEndpoint() {
        return endpointCallCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No data");
    }
}
