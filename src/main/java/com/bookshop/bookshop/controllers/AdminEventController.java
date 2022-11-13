package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.dto.AuthorDto;
import com.bookshop.bookshop.dto.EventDto;
import com.bookshop.bookshop.dto.GenreDto;
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

    @GetMapping("")
    public String getAll(Model model){
        List<Event> eventList = eventService.getAll();
        model.addAttribute("events", eventList);
        return "admin";
    }

    @GetMapping("/new")
    public String getEventForm(Model model){
        model.addAttribute("event", new EventDto());
        return "admin";
    }

    @PostMapping("/new")
    public String addNewEvent(@PathVariable("event") EventDto eventDto){
        eventService.addEvent(eventDto);
        return "redirect:/admin";
    }

    @GetMapping("/{id}/edit")
    public String edite(@PathVariable("id") long id, Model model){
        model.addAttribute("event", new EventDto());
        return "admin";
    }

    @PatchMapping("/{id}")
    public String update(@PathVariable("id") long id, Model model){
        EventDto eventDto = (EventDto) model.getAttribute("event");
        eventService.updateEvent(eventDto, id);
        return "redirect:/admin/author";
    }

    @DeleteMapping("/{id}/delete")
    public String delete(@PathVariable("id") long id){
        eventService.delete(id);
        return "redirect:/admin/author";
    }
}
