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

    @GetMapping("")
    public String getAll(Model model){
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        return "admin";
    }

    @GetMapping("/new")
    public String getAuthorForm(Model model){
        model.addAttribute("author", new AuthorDto());
        return "admin";
    }

    @PostMapping("/new")
    public String addNewAuthor(@PathVariable("author") AuthorDto authorDto){
        authorService.addAuthor(authorDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        model.addAttribute("author", new AuthorDto());
        return "admin";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model){
        AuthorDto authorDto = (AuthorDto) model.getAttribute("author");
        authorService.updateAuthor(authorDto, id);
        return "redirect:/admin/author";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        authorService.delete(id);
        return "redirect:/admin/author";
    }
}
