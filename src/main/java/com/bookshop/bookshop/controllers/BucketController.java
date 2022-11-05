package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dao.BookRepository;
import com.bookshop.bookshop.dto.BucketDTO;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BucketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    public String removeFromBucket(@PathVariable("id") Long id, Principal principal){
        bucketService.removeBook(id, principal.getName());
        Book book = bookRepository.getById(id);
        System.out.println(book.getId() + book.getName());
        return "redirect:/bucket";
    }
}
