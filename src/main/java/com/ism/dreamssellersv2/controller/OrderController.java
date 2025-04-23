package com.ism.dreamssellersv2.controller;

import com.ism.api.OrderApi;
import com.ism.model.OrderCreateDTO;
import com.ism.model.OrderDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController implements OrderApi {
    @Override
    public ResponseEntity<OrderDTO> createOrder(OrderCreateDTO orderCreateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteOrder(Integer orderId) {
        return null;
    }

    @Override
    public ResponseEntity<OrderDTO> getOrderById(Integer orderId) {
        return null;
    }

    @Override
    public ResponseEntity<List<OrderDTO>> getOrders() {
        return null;
    }
}
