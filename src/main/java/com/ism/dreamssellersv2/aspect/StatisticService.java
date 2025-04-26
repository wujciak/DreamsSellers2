package com.ism.dreamssellersv2.aspect;

import com.ism.dreamssellersv2.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StatisticService {

    private final ItemRepository itemRepository;
    private double highestPrice = 0.0;
    private int totalRequests = 0;
    private final Map<String, Integer> endpointCallCount = new HashMap<>();
    private final Map<String, Integer> userCallCount = new HashMap<>();
    private double totalPrice = 0.0;
    private int totalItems = 0;
    private String lastCalledEndpoint = "None";

    public StatisticService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

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

    public synchronized String getMostCalledEndpoint() {
        return endpointCallCount.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No data");
    }

    public synchronized void addItemPrice(double price) {
        if (price > 0) {
            totalPrice += price;
            totalItems++;
        }
    }

    public synchronized double getAveragePrice() {
        if (totalItems == 0) {
            return 0.0;
        }
        return totalPrice / totalItems;
    }

    public synchronized int getTotalItems() {
        return (int) itemRepository.count();
    }

    public synchronized void updateLastCalledEndpoint(String endpoint) {
        this.lastCalledEndpoint = endpoint;
    }

    public synchronized String getLastCalledEndpoint() {
        return lastCalledEndpoint;
    }

}
