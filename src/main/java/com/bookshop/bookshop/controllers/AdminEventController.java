package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.AuthorDto;
import com.bookshop.bookshop.dto.EventDto;
import com.bookshop.bookshop.dto.GenreDto;
import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.models.Event;
import com.bookshop.bookshop.models.Genre;
import com.bookshop.bookshop.service.EventService;
import com.bookshop.bookshop.service.GenreService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin/event")
public class AdminEventController {
    private final EventService eventService;

    public AdminEventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/new")
    public String getEventForm(Model model){
        model.addAttribute("event", new EventDto());
        return "admin/add-events-list";
    }

    @PostMapping("/new")
    public String addNewEvent(@ModelAttribute("event") EventDto eventDto){
        eventService.addEvent(eventDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        Event event = eventService.getById(id);
        EventDto eventDto = EventDto.builder()
                .title(event.getTitle())
                .message(event.getMessage())
                .build();
        model.addAttribute("id", id);
        model.addAttribute("event", eventDto);
        return "admin/change-events-list";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("event") EventDto eventDto){
        eventService.updateEvent(eventDto, id);
        return "redirect:/admin";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        eventService.delete(id);
        return "redirect:/admin/author";
    }
}
