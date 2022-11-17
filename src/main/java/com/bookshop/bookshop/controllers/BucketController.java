package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dto.BucketDTO;
import com.bookshop.bookshop.dto.OrderDto;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BucketService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
public class BucketController {
    private final BucketService bucketService;
    private final BookRepository bookRepository;

    public BucketController(BucketService bucketService, BookRepository bookRepository) {
        this.bucketService = bucketService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/bucket")
    public String aboutBucket(Model model, Principal principal){
        if(principal == null){
            model.addAttribute("bucket", new BucketDTO());
        }
        else {
            BucketDTO bucketDto = bucketService.getBucketByUser(principal.getName());
            model.addAttribute("bucket", bucketDto);
        }

        return "cart-page";
    }

    @DeleteMapping("/bucket/{id}")
    public String removeFromBucket(@PathVariable("id") long id, Principal principal){
        bucketService.removeBook(id, principal.getName());
        return "redirect:/bucket";
    }

    @GetMapping("/bucket/createorder")
    public String createOrder(Model model, Principal principal){
        BucketDTO bucketDTO = bucketService.getBucketByUser(principal.getName());
        model.addAttribute("bucket", bucketDTO);
        model.addAttribute("orderinfo", new OrderDto());
        return "order-page";
    }

    @PostMapping("/bucket/createorder")
    public String commitOrder(@ModelAttribute("orderinfo") OrderDto orderDto, Principal principal){
        bucketService.commitBucketToOrder(principal.getName(), orderDto);
        return "redirect:/bucket";
    }
}
