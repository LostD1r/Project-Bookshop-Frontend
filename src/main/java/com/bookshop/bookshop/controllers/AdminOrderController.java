package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.OrderStatusDto;
import com.bookshop.bookshop.models.Order;
import com.bookshop.bookshop.service.OrderService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/order")
public class AdminOrderController {

    private final OrderService orderService;

    public AdminOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}/edit")
    public String editOrderStatus(@PathVariable("id") long id, Model model){
        Order order = orderService.getById(id);
        OrderStatusDto orderStatusDto = OrderStatusDto.builder()
                .status(order.getOrderStatus().name().toString())
                .build();
        model.addAttribute("order", orderStatusDto);
        return "admin/change-orders-list";
    }

    @PatchMapping("/{id}")
    public String edit(@ModelAttribute("order") OrderStatusDto order, @PathVariable("id") long id){
        orderService.editeStatusOrder(order, id);
        return "redirect:/admin";
    }
}
