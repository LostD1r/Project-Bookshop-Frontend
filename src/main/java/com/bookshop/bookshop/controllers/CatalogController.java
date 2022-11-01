package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.Publishing;
import com.bookshop.bookshop.service.AuthorService;
import com.bookshop.bookshop.service.BookService;
import com.bookshop.bookshop.service.PublishingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class CatalogController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublishingService publishingService;

    public CatalogController(BookService bookService, AuthorService authorService, PublishingService publishingService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publishingService = publishingService;
    }

    @GetMapping("/catalog")
    private String catalog(Model model){
        List<Book> list = bookService.getAll();
        List<Author> authorList = authorService.getAll();
        List<Publishing> pubsList = publishingService.getAll();
        model.addAttribute("books", list);
        model.addAttribute("authors", authorList);
        model.addAttribute("pubs", pubsList);
        return "catalog";
    }
}
