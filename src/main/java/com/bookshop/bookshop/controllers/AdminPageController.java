package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.*;
import com.bookshop.bookshop.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminPageController {
    private final AuthorService authorService;
    private final BookService bookService;
    private final EventService eventService;
    private final GenreService genreService;
    private final NewsService newsService;
    private final PersonDetailsService personDetailsService;
    private final PublishingService publishingService;

    public AdminPageController(AuthorService authorService, BookService bookService,
                               EventService eventService, GenreService genreService,
                               NewsService newsService, PersonDetailsService personDetailsService, PublishingService publishingService) {
        this.authorService = authorService;
        this.bookService = bookService;
        this.eventService = eventService;
        this.genreService = genreService;
        this.newsService = newsService;
        this.personDetailsService = personDetailsService;
        this.publishingService = publishingService;
    }

    @GetMapping("/admin")
    public String admin(Model model){
        List<Author> authors = authorService.getAll();
        model.addAttribute("authors", authors);
        List<Book> books = bookService.getAll();
        model.addAttribute("books", books);
        List<Event> eventList = eventService.getAll();
        model.addAttribute("events", eventList);
        List<Genre> genreList = genreService.getAll();
        model.addAttribute("genres", genreList);
        List<New> news = newsService.getNews();
        model.addAttribute("news", news);
        List<User> users = personDetailsService.getAll();
        model.addAttribute("users", users);
        List<Publishing> pubs = publishingService.getAll();
        model.addAttribute("pubs", pubs);
        return "admin-page";
    }
}
