package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.AuthorDto;
import com.bookshop.bookshop.dto.BookDto;
import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.service.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/author")
public class AdminAuthorController {
    private final AuthorService authorService;

    public AdminAuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping("/new")
    public String getAuthorForm(Model model){
        model.addAttribute("authorNew", new AuthorDto());
        return "admin/add-author-list";
    }

    @PostMapping("/add")
    public String addNewAuthor(@ModelAttribute("authorNew") AuthorDto authorDto){
        authorService.addAuthor(authorDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        Author author = authorService.getById(id);
        AuthorDto authorDto = AuthorDto.builder()
                .name(author.getName())
                .description(author.getDescription())
                .image(author.getImage())
                .build();
        model.addAttribute("author", authorDto);
        model.addAttribute("id", id);
        return "admin/change-author-list";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("author") AuthorDto authorDto){
        authorService.updateAuthor(authorDto, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        authorService.delete(id);
        return "redirect:/admin";
    }
}
