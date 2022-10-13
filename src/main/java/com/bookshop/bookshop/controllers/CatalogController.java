package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class CatalogController {
    private final BookService bookService;

    public CatalogController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/catalog")
    private String catalog(Model model){
        List<BookDTO> list = bookService.getAll();
        model.addAttribute("books", list);
        for(var book : list){
            System.out.println(book.getId());
            System.out.println(book.getName());
            System.out.println(book.getPrice());
        }
        return "catalog";
    }
}
