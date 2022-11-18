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


    @GetMapping("/new")
    public String getNewsForm(Model model){
        model.addAttribute("feed", new NewDto());
        return "admin/add-news-list";
    }

    @PostMapping("/new")
    public String addNew(@ModelAttribute("feed") NewDto newDto){
        newsService.addNew(newDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        New feed = newsService.getById(id);
        NewDto newDto = NewDto.builder()
                .title(feed.getTitle())
                .message(feed.getMessage())
                .image(feed.getImage())
                .build();
        model.addAttribute("id", id);
        model.addAttribute("feed", newDto);
        return "admin/change-news-list";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("feed") NewDto newDto){
        newsService.updateNew(newDto, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String deleteBook(@PathVariable("id") long id){
        newsService.delete(id);
        return "redirect:/admin";
    }
}
