package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.BookDto;
import com.bookshop.bookshop.dto.NewDto;
import com.bookshop.bookshop.models.New;
import com.bookshop.bookshop.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/news")
public class AdminNewsController {
    private final NewsService newsService;

    public AdminNewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("")
    public String getAll(Model model){
        List<New> news = newsService.getNews();
        model.addAttribute("news", news);
        return "admin";
    }

    @GetMapping("/new")
    public String getNewsForm(Model model){
        model.addAttribute("new", new NewDto());
        return "admin";
    }

    @PostMapping("/new")
    public String addNew(@PathVariable("new") NewDto newDto){
        newsService.addNew(newDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id,Model model){
        model.addAttribute("book", new BookDto());
        return "admin";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model){
        NewDto newDto = (NewDto) model.getAttribute("new");
        newsService.updateNew(newDto, id);
        return "redirect:/admin/book";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") long id){
        newsService.delete(id);
        return "redirect:/admin/book";
    }
}
