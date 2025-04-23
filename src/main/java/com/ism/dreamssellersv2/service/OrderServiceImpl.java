package com.ism.dreamssellersv2.service;

import com.ism.dreamssellersv2.mapper.OrderMapper;
import com.ism.dreamssellersv2.model.OrderEntity;
import com.ism.dreamssellersv2.repository.OrderRepository;
import com.ism.model.OrderCreateDTO;
import com.ism.model.OrderDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
    }

    @Override
    public List<OrderDTO> getOrders() {
        return orderRepository.findAll()
                .stream()
                .map(orderMapper::orderEntityToOrderDTO)
                .collect(Collectors.toList());
    }

    @Override
    public OrderDTO getOrderById(Integer orderId) {
        OrderEntity orderEntity = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return orderMapper.orderEntityToOrderDTO(orderEntity);
    }

    @Override
    public OrderDTO createOrder(OrderCreateDTO orderCreateDTO) {
        OrderEntity orderEntity = orderMapper.orderCreateDTOToOrderEntity(orderCreateDTO);
        orderEntity.setStatus("PENDING");
        return orderMapper.orderEntityToOrderDTO(orderRepository.save(orderEntity));
    }

    @Override
    public void deleteOrder(Integer orderId) {
        if (!orderRepository.existsById(orderId)) {
            throw new RuntimeException("Order not found");
        }
        orderRepository.deleteById(orderId);
    }
}