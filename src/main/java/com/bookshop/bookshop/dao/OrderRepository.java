package com.bookshop.bookshop.dao;

import com.bookshop.bookshop.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
