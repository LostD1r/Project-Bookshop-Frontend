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


    @GetMapping("/new")
    public String getPublishingForm(Model model){
        model.addAttribute("pub", new PublishingDto());
        return "admin/add-publishing-list";
    }

    @PostMapping("/new")
    public String addNewPublishing(@ModelAttribute("pub") PublishingDto publishingDto){
        publishingService.addPublishing(publishingDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        Publishing publishing = publishingService.getById(id);
        PublishingDto publishingDto = PublishingDto.builder()
                .name(publishing.getName())
                .description(publishing.getDescription())
                .image(publishing.getImage())
                .build();
        model.addAttribute("pub", publishing);
        model.addAttribute("id", id);
        return "admin/change-publishing-list";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("pub") PublishingDto publishingDto){
        publishingService.updatePublishing(publishingDto, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        publishingService.delete(id);
        return "redirect:/admin";
    }
}
