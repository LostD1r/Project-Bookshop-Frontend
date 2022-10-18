package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.AuthorDTO;
import com.bookshop.bookshop.dto.BookDTO;
import com.bookshop.bookshop.dto.PublishingDTO;
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
        List<BookDTO> list = bookService.getAll();
        List<AuthorDTO> authorList = authorService.getAll();
        List<PublishingDTO> pubsList = publishingService.getAll();
        model.addAttribute("books", list);
        model.addAttribute("authors", authorList);
        model.addAttribute("pubs", pubsList);
        return "catalog";
    }
}
