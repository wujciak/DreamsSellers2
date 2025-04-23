package com.ism.dreamssellersv2.service;

import com.ism.model.OrderCreateDTO;
import com.ism.model.OrderDTO;

import java.util.List;

public interface OrderService {
    OrderDTO createOrder(OrderCreateDTO orderCreateDTO);
    void deleteOrder(Integer orderId);
    OrderDTO getOrderById(Integer orderId);
    List<OrderDTO> getOrders();
}