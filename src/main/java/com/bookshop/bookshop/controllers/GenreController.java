package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Genre;
import com.bookshop.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GenreController {
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
    }

    @GetMapping("/catalog/genre/{id}")
    public String getGenre(@PathVariable("id") long id, Model model){
        Genre genre = genreService.getById(id);
        model.addAttribute("genre", genre);
        return "genres-page";
    }
}
