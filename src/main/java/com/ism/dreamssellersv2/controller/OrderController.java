package com.ism.dreamssellersv2.controller;

import com.ism.api.OrderApi;
import com.ism.dreamssellersv2.service.OrderService;
import com.ism.model.OrderCreateDTO;
import com.ism.model.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderApi {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderDTO> createOrder(OrderCreateDTO orderCreateDTO) {
        return ResponseEntity.ok(orderService.createOrder(orderCreateDTO));
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Integer orderId) {
        orderService.deleteOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(Integer orderId) {
        return ResponseEntity.ok(orderService.getOrderById(orderId));
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return ResponseEntity.ok(orderService.getOrders());
    }
}