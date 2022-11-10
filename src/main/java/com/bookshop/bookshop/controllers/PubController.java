package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.models.Publishing;
import com.bookshop.bookshop.service.AuthorService;
import com.bookshop.bookshop.service.PublishingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PubController {
    private final PublishingService publishingService;

    public PubController(PublishingService publishingService) {
        this.publishingService = publishingService;
    }

    @GetMapping("/catalog/pub/{id}")
    public String getAuthor(@PathVariable("id") long id, Model model){
        Publishing publishing = publishingService.getById(id);
        model.addAttribute("item", publishing);
        return "publishing-page";
    }
}
