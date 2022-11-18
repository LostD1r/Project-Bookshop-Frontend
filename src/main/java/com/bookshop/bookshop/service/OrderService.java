package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.OrderRepository;
import com.bookshop.bookshop.models.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }
}
