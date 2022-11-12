package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.AuthorDto;
import com.bookshop.bookshop.dto.BookDto;
import com.bookshop.bookshop.dto.PublishingDto;
import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.models.Publishing;
import com.bookshop.bookshop.service.AuthorService;
import com.bookshop.bookshop.service.PublishingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/publishing")
public class PublishingController {
    private final PublishingService publishingService;

    public PublishingController(PublishingService publishingService) {
        this.publishingService = publishingService;
    }

    @GetMapping("")
    public String getAll(Model model){
        List<Publishing> pubs = publishingService.getAll();
        model.addAttribute("pubs", pubs);
        return "admin";
    }

    @GetMapping("/new")
    public String getPublishingForm(Model model){
        model.addAttribute("pub", new PublishingDto());
        return "admin";
    }

    @PostMapping("/new")
    public String addNewPublishing(@PathVariable("pub") PublishingDto publishingDto){
        publishingService.addPublishing(publishingDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        model.addAttribute("pub", new PublishingDto());
        return "admin";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model){
        PublishingDto publishingDto = (PublishingDto) model.getAttribute("pub");
        publishingService.updatePublishing(publishingDto, id);
        return "redirect:/admin/author";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        publishingService.delete(id);
        return "redirect:/admin/author";
    }
}
