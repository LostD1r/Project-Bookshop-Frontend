package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.AuthorDto;
import com.bookshop.bookshop.dto.GenreDto;
import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.models.Genre;
import com.bookshop.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/genre")
public class AdminGenreController {
    private final GenreService genreService;

    public AdminGenreController(GenreService genreService) {
        this.genreService = genreService;
    }


    @GetMapping("/new")
    public String getGenreForm(Model model){
        model.addAttribute("genre", new GenreDto());
        return "admin/add-genres-list";
    }

    @PostMapping("/new")
    public String addNewGenre(@ModelAttribute("genre") GenreDto genreDto){
        genreService.addGenre(genreDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        Genre genre = genreService.getById(id);
        GenreDto genreDto = GenreDto.builder()
                .name(genre.getName())
                .build();
        model.addAttribute("genre", genreDto);
        model.addAttribute("id", id);
        return "admin/change-genres-list";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("genre") GenreDto genreDto){
        genreService.updateGenre(genreDto, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        genreService.delete(id);
        return "redirect:/admin";
    }
}
