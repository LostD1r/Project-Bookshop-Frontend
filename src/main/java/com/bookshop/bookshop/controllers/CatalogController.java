package com.bookshop.bookshop.controllers;

import com.bookshop.bookshop.models.Author;
import com.bookshop.bookshop.models.Book;
import com.bookshop.bookshop.models.Genre;
import com.bookshop.bookshop.models.Publishing;
import com.bookshop.bookshop.service.AuthorService;
import com.bookshop.bookshop.service.BookService;
import com.bookshop.bookshop.service.GenreService;
import com.bookshop.bookshop.service.PublishingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping({"", "/"})
public class CatalogController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublishingService publishingService;
    private final GenreService genreService;

    public CatalogController(BookService bookService, AuthorService authorService, PublishingService publishingService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publishingService = publishingService;
        this.genreService = genreService;
    }

    @GetMapping("/catalog")
    private String catalog(Model model,
                           @RequestParam(value = "search", required = false) String search){
        List<Author> authorList = authorService.getAll();
        List<Publishing> pubsList = publishingService.getAll();
        List<Genre> genreList = genreService.getAll();
        model.addAttribute("authors", authorList);
        model.addAttribute("pubs", pubsList);
        model.addAttribute("genres", genreList);

        if (search == null)
        {
            List<Book> list = bookService.getAll();
            model.addAttribute("books", list);
            return "catalog";
        }

        List<Book> list = bookService.search(search);
        model.addAttribute("books", list);
        return "catalog";
    }
}
