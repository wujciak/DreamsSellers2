package com.ism.dreamssellersv2.service;

import com.ism.model.OrderCreateDTO;
import com.ism.model.OrderDTO;

import java.util.List;

public interface OrderService {
    List<OrderDTO> getOrders();
    OrderDTO getOrderById(Integer orderId);
    OrderDTO createOrder(OrderCreateDTO orderCreateDTO);
    void deleteOrder(Integer orderId);
}