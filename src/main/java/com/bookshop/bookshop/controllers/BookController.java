package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/catalog/{id}")
    public String getBookById(@PathVariable("id") Long id, Model model){
        BookDTO book = bookService.getById(id);
        model.addAttribute("book", book);
        return "product-page";
    }
}
