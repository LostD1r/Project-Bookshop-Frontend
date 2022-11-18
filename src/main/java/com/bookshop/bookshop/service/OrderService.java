package com.bookshop.bookshop.service;

import com.bookshop.bookshop.dao.OrderRepository;
import com.bookshop.bookshop.dto.OrderStatusDto;
import com.bookshop.bookshop.models.Order;
import com.bookshop.bookshop.models.OrderStatus;
import com.bookshop.bookshop.models.Role;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void saveOrder(Order order) {
        orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(long id) {
        return orderRepository.getById(id);
    }

    public void editeStatusOrder(OrderStatusDto order, long id) {
        Order newOrder = orderRepository.getById(id);
        newOrder.setOrderStatus(OrderStatus.valueOf(order.getStatus()));
        orderRepository.save(newOrder);
    }
}
