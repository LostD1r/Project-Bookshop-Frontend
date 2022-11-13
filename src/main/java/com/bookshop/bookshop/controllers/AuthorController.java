package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/catalog/author/{id}")
    public String getAuthor(@PathVariable("id") long id, Model model){
        Author author = authorService.getById(id);
        model.addAttribute("item", author);
        return "author-page";
    }
}
