package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/catalog/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model){
        Book book = bookService.getById(id);
        model.addAttribute("book", book);
        return "product-page";
    }

    @GetMapping("/catalog/{id}/bucket")
    public String addBucket(@PathVariable Long id, Principal principal){
        if(principal == null){
            return "redirect:/products";
        }
        bookService.addToUserBucket(id, principal.getName());
        return "redirect:/catalog/{id}";
    }
}
