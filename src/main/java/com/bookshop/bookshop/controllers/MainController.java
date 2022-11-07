package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.service.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class MainController {
    private final BookService bookService;

    public MainController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public String index(Model model){
        List<Book> topSales = bookService.getTopBySales();
        List<Book> lastAddedList = bookService.getLastAdded();
        model.addAttribute("topSales", topSales);
        model.addAttribute("lastAddedList", lastAddedList);
        return "index";
    }

    @GetMapping("/about")
    public String about(){
        return "about-page";
    }
}
