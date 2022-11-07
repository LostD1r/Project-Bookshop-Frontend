package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Event;
import com.bookshop.bookshop.models.New;
import com.bookshop.bookshop.service.EventService;
import com.bookshop.bookshop.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NewsController {

    private final NewsService newsService;
    private final EventService eventService;

    public NewsController(NewsService newsService, EventService eventService) {
        this.newsService = newsService;
        this.eventService = eventService;
    }


    @GetMapping("/news")
    public String news(Model model){
        List<New> listNews = newsService.getNews();
        List<Event> listEvents = eventService.getAll();
        model.addAttribute("news", listNews);
        model.addAttribute("events", listEvents);
        return "news-page";
    }
}
